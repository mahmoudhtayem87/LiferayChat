import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {ChatService, Message} from "../services/chat.service";
import {ActivatedRoute, Router} from "@angular/router";
import {LiferayService} from "../services/liferay.service";

declare const Liferay: any;
@Component({
    template:
        `
            <div class=" chat_message chat-message {{Alignment}}">
                <div class="avatar shadow-lg">
                    <img src="{{Avatar}}" class="avatar" />
                </div>
                <div class="message">
                    <small class="part name">
                        {{FullName}}
                    </small>
                    <div class="message-body part shadow-lg">
                        {{MessageText}}
                    </div>
                    <small class="part date">
                        {{Date | date:'medium'}}
                    </small>
                </div>
            </div>
        `,
    selector:'chat-message'
})
export class chatMessageComponent implements OnInit {

    @Input()
    public MessageId :string= "";
    @Input()
    public From :string= "";
    @Input()
    public To :string= "";
    @Input()
    public Alignment :string= "";
    @Input()
    public Avatar :string ="";
    @Input()
    public FullName :string = "";
    @Input()
    public MessageText :string = "";
    @Input()
    public Date :Date | null = null;
    @Input()
    public Seen :boolean= false;

    constructor( private liferayService:LiferayService) {

    }
    ngOnInit(): void {
        this.setMessageStatus();
    }
    async setMessageStatus()
    {
        console.log(this.Seen);
        if(!this.Seen)
            await this.liferayService.markMessageSeen(this.MessageId);
    }

}