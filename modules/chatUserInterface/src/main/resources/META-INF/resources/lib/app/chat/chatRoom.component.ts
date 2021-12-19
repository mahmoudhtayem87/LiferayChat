import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {ChatService, Message} from "../services/chat.service";
import {ActivatedRoute, Router} from "@angular/router";
import {LiferayService} from "../services/liferay.service";

declare const Liferay: any;
@Component({
    template:
        `
            <div class="sidebar sidebar-light shadow-sm m-2  liferay-chat-container ">
                <div class="sidebar-header chat-room-header">
                    <nav class="component-tbar tbar">
                        <div class="container-fluid">
                            <ul class="tbar-nav">
                                <li class="tbar-item p-0 m-0" style="margin: 0!important;">
                                    <img class="avatar" src="{{chatWithUserAvatar}}">
                                </li>
                                <li class="tbar-item  d-flex" style="align-items: start;">
                                    <div class="tbar-item tbar-item-expand userName" style="align-items: start;">
                                        <div class="tbar-section   " style="align-items: start;">
                                            {{chatWithUserName}}
                                        </div>
                                    </div>
                                    <div class="tbar-item tbar-item-expand count" style="align-items: start;">
                                        <div class="tbar-section   " style="align-items: start;">
                                            {{msgsLst.length}} Message(s) 
                                        </div>
                                    </div>
                                </li>
                                <li class="tbar-item tbar-item-expand" style="align-items: start;">
                                    <div class="tbar-item tbar-item-expand" style="align-items: start;">

                                    </div>
                                </li>
                                <li class="tbar-item">
                                    <button class="btn-unstyled px-2" (click)="closeChatRoom()" > <fa-icon icon="times" class=" middle"></fa-icon></button>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
                <div class="sidebar-body ">
                    <div class="LrChat bg-light">
                        <div class="LrChat__wrapper px-4 mt-4">
                            <div class=" chat_message chat-message {{getDateAlignment(msg)}}" *ngFor="let msg of Messages">
                                <div class="avatar shadow-lg">
                                    <img src="{{getAvatar(msg.fromUserId)}}" class="avatar" />
                                </div>
                                <div class="message">
                                    <small class="part name">
                                        {{getUserFullName(msg)}}
                                    </small>
                                    <div class="message-body part shadow-lg">
                                        {{msg.messageText}}
                                    </div>
                                    <small class="part date">
                                        {{msg.createDate | date:'medium'}}
                                    </small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sidebar-footer">
                    <div class="tbar-section">
                        <div class="input-group input-group">
                            <div class="input-group-item">
                                <input maxlength="200" class="form-control input-group-inset input-group-inset-after" (keyup)="inputKeyup($event)" [(ngModel)]="messageText" placeholder="Search for user..." type="text" />
                                <span class="input-group-inset-item input-group-inset-item-after">
                       <button class="btn-unstyled px-2" (click)="sendMessage()"> <fa-icon icon="paper-plane"  ></fa-icon></button>
                    </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        `,
    selector:'chat-room'
})
export class chatRoomComponent implements OnInit {

    public isOnline()
    {
            return " ";
    }
    get Messages()
    {
        return this.msgsLst.filter(msg => msg.messageType === "message")
    }
    public chatRoomParticipants : any = {};
    public msgsLst: any[]=[];
    public messageText:string = "";
    public fromUserId:any = {};
    public getDateAlignment(msg:Message)
    {
        return this.myUserId == msg.fromUserId ? "left":"right";
    }

    public inputKeyup(event:any)
    {
        if(event.key === "Enter")
            this.sendMessage();
    }
    @Input()
    public myUserId :string= "";
    @Input()
    public chatWithUserId :string ="";
    @Input()
    public chatWithUserName :string = "";
    @Input()
    public chatWithUserAvatar :string = "";

    closeChatRoom()
    {
        this.chatService.messages.unsubscribe();
        this.route.navigate(["/activeUsers"]);
    }
    public getKeys(object:any)
    {
        return Object.keys(object);
    }
    constructor( private liferayService:LiferayService,private chatService: ChatService,private actRoute: ActivatedRoute,private route:Router) {
        chatService.messages.subscribe(msg => {
            if (msg.messageType =="message" )
            {
                console.log(msg);
                if ( msg.toUserId == this.myUserId &&
                    msg.fromUserId == this.chatWithUserId )
                {
                    msg["self"]=false;
                    this.msgsLst.push(msg);
                }
            }
            if (msg.messageType ==="activeUsers" )
            {
               console.log("alert: "+msg.messageType );
            }

        });
    }
    sendMessage()
    {
        if(this.messageText.length <=0)
            return;
        var _message = {
            toUserId: this.chatWithUserId,
            fromUserId:this.fromUserId.userId,
            data: "",
            messageType:"message",
            messageText:this.messageText,
            groupId: Liferay.ThemeDisplay.getScopeGroupId(),
            createDate:Date.now()
        };
        console.log(_message);
        // @ts-ignore
        this.chatService.messages.next(_message);
        // @ts-ignore
        this.msgsLst.push(_message);
        // @ts-ignore
        _message.createDate = Date.now();
        this.messageText = "";
    }
    getAvatar(userId:any) {
        return this.chatRoomParticipants[userId].avatar;
    }

    async getChatHistory() {
        var msgs = await this.liferayService.getChatHistory(
            parseInt(this.myUserId),
            parseInt(this.chatWithUserId)
        );
        if (msgs)
        {
        for(var index = 0 ; index < msgs?.length ; index++)
            this.msgsLst.push(msgs[index]);
        }
        console.log(this.msgsLst);

    }
    get myUser()
    {
        return this.chatRoomParticipants[this.myUserId];
    }
    public getUserFullName(msg:any)
    {
        return this.chatRoomParticipants[msg.fromUserId].fullName;
    }
    ngOnInit(): void {
        var toUserID = JSON.parse(<string>this.actRoute.snapshot.paramMap.get('toUserID'));
        this.fromUserId = JSON.parse(<string>this.actRoute.snapshot.paramMap.get('fromUserId'));
        this.chatRoomParticipants[toUserID.userId] = toUserID;
        this.chatRoomParticipants[this.fromUserId.userId] = this.fromUserId;
        this.chatWithUserId = toUserID.userId;
        this.chatWithUserName = toUserID.fullName;
        this.chatWithUserAvatar  = toUserID.avatar ;
        this.myUserId = this.fromUserId.userId;
        console.log(this.fromUserId);
        console.log(this.chatRoomParticipants);
        this.getChatHistory();
    }

}