
import {Component, OnInit} from '@angular/core';
import {faFilm} from '@fortawesome/free-solid-svg-icons';
import {delay} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {ChatService, Message} from "../services/chat.service";
import {LiferayService} from "../services/liferay.service";
declare const Liferay: any;
declare const notification_audio:HTMLAudioElement;
@Component({
    template:
        `
            <div class="sidebar sidebar-light shadow-sm m-2  liferay-chat-container "  style="width: 100%!important;">
                <nav class="component-tbar tbar">
                    <div class="container-fluid">
                        <ul class="tbar-nav">
                            <li class="tbar-item tbar-item-expand">
                                <div class="tbar-section">
                                    <div class="input-group input-group-sm">
                                        <div class="input-group-item">
                                            <input class="form-control input-group-inset input-group-inset-after" [(ngModel)] ="searchTerm" placeholder="Search for user..." type="text" />
                                            <span class="input-group-inset-item input-group-inset-item-after">
                                    <fa-icon icon="search"  ></fa-icon>
                                </span>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="sidebar-body">
                    <div class="contacts-list">
                        <ul class="list-group">
                            <li class="list-group-header">
                                <h3 class="list-group-header-title">Online Users</h3>
                            </li>
                            <li (click)="openChatRoom(user)" class="list-group-item list-group-item-flex user-list-item" *ngFor="let user of onlineUsers | filter:'fullName':searchTerm">
                                <div class="autofit-col  justify-content-center">
                                    <img class="avatar online-avatar" src="{{user.avatar}}" />
                                </div>
                                <div class="autofit-col autofit-col-expand justify-content-center">
                                    <p class="list-group-title text-truncate">
                                        <label>{{user.fullName}}</label>
                                    </p>
                                </div>
                                <div class="autofit-col  justify-content-center">
                                    <fa-icon icon="envelope" size="2x" ></fa-icon>
                                    <span class="badge badge-primary" style="position: absolute;top: 0;right: 0;">
                                        {{user.badge}}
                                    </span>
                                </div>
                            </li>
                            <li class="list-group-header">
                                <h3 class="list-group-header-title">Offline Users</h3>
                            </li>
                            <li (click)="openChatRoom(user)" class="list-group-item list-group-item-flex user-list-item" *ngFor="let user of offlineUsers | filter:'fullName':searchTerm">
                                <div class="autofit-col  justify-content-center">
                                    <img class="avatar offline-avatar" src="{{user.avatar}}" />
                                </div>
                                <div class="autofit-col autofit-col-expand justify-content-center">
                                    <p class="list-group-title text-truncate">
                                        <label>{{user.fullName}}</label>
                                    </p>
                                </div>
                                <div class="autofit-col  justify-content-center">
                                    <fa-icon icon="envelope" size="2x" ></fa-icon>
                                    <span class="badge badge-primary" style="position: absolute;top: 0;right: 0;">
                                        {{user.badge}}
                                    </span>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        `,
    selector:'active-users'
})
export class activeUsersComponent implements OnInit {
    public msgsLst: Message[]=[];
    public usersList : any[] = [];
    public myUserId : string = Liferay.ThemeDisplay.getUserId();
    public activeUsers: any={};
    public usersGroups : any;

    public isOnline(user:any)
    {
        if(this.activeUsers[user.userId] != null)
            return "online";
        else
            return "offline";
    }
    public getKeys(object:any)
    {
        return Object.keys(object).filter( user => user!=this.myUserId);
    }
    get MyUser()
    {
        if(this.usersList === null || this.usersList.length <= 0)
            return null;
        return (this.usersList.filter((user : any )=> user.userId === this.myUserId))[0];
    }
    get allUsers()
    {
        return this.usersList.filter((user : any )=> user.userId != this.myUserId);
    }
    get onlineUsers()
    {
        var tmp_users : any = [];
        if(!this.usersGroups)
            return tmp_users;
        var users = this.usersGroups.filter( (group : any) => group.key === "online" );
        if(users != null && users.length > 0)
            tmp_users = users[0].value;
        return tmp_users;
    }
    get offlineUsers()
    {
        var tmp_users : any = [];
        if(!this.usersGroups)
            return tmp_users;
        var users = this.usersGroups.filter( (group : any) => group.key === "offline" );
        if(users != null && users.length > 0)
            tmp_users = users[0].value;
        return tmp_users;
    }
    openChatRoom(user:any)
    {
        this.chatService.messages.unsubscribe();
        this.route.navigate(["/chatroom",{toUserID:JSON.stringify(user),
        fromUserId:JSON.stringify(this.activeUsers[Liferay.ThemeDisplay.getUserId()])}]);
    }
    constructor(private chatService: ChatService,
                private actRoute: ActivatedRoute,private route:Router,
                private liferayService:LiferayService) {

    }
    // @ts-ignore
    public requestActiveUser : any={
        toUserId: "system",
        data: "",
        fromUserId:Liferay.ThemeDisplay.getUserId(),
        messageType:"request_active_users",
        messageText:" --- ",
        groupId: "",
        createDate:0
    };
    searchTerm: any = "";
    ngOnInit(): void {
        if(!Liferay.ThemeDisplay.isSignedIn())
            return;
        this.getUsers();
        try {
            this.chatService.messages.subscribe(msg => {
                this.msgsLst.push(msg);
                switch (msg.messageType)
                {
                    case "message":
                        this.updateBadge(msg.fromUserId);
                        notification_audio.play();
                        break;
                    case "activeUsers":
                        this.activeUsers = msg.data;
                        this.setContactsStatus();
                        this.usersGroups = this.groupUsers(this.allUsers,"status");
                        break;
                }
            });
        }
        catch (exp)
        {

        }

    }
    updateBadge(fromUserID:any)
    {
        var user = this.onlineUsers.filter((user : any )=> user.userId === fromUserID);
        if(user.length <= 0 )
        {
            user = this.onlineUsers.filter((user : any )=> user.userId === fromUserID)[0];
            user.badge = parseInt(user.badge) +1;
        }else
        {
            user = user[0];
            user.badge = parseInt(user.badge) +1;
        }
    }
    groupUsers(collection: any[], property: string): any[] {
        // prevents the application from breaking if the array of objects doesn't exist yet
        if(!collection) {
            return [];
        }
        const groupedCollection = collection.reduce((previous, current)=> {
            if(!previous[current[property]]) {
                previous[current[property]] = [current];
            } else {
                previous[current[property]].push(current);
            }

            return previous;
        }, {});
        // this will return an array of objects, each object containing a group of objects
        return Object.keys(groupedCollection).map(key => ({ key, value: groupedCollection[key] }));
    }
    public setContactsStatus()
    {
        for(var index = 0 ; index < this.usersList.length ; index++)
        {
            // @ts-ignore
            this.usersList[index]["status"] = this.isOnline(this.usersList[index]);
        }
    }
    public async getUsers() {
        var data = await this.liferayService.getUsers();
        console.log(data);
        this.usersList = [];
        var users_ids = Object.keys(data);
        for(var index = 0 ; index < users_ids.length ; index++)
        {
            this.usersList.push(data[users_ids[index]]);
        }
        console.log(this.usersList);
        this.chatService.messages.next(this.requestActiveUser);
    }

}