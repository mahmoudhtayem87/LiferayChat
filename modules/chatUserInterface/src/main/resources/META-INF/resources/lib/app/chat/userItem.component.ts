import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {ChatService, Message} from "../services/chat.service";
import {ActivatedRoute, Router} from "@angular/router";
import {LiferayService} from "../services/liferay.service";

declare const Liferay: any;
@Component({
    template:
        `
            <li class="list-group-item list-group-item-flex user-list-item">
                <div class="autofit-col  justify-content-center">
                    <img class="avatar {{Status}}-avatar" src="{{Avatar}}" />
                </div>
                <div class="autofit-col autofit-col-expand justify-content-center">
                    <p class="list-group-title text-truncate">
                        <label>{{FullName}}</label>
                    </p>
                </div>
                <div class="autofit-col  justify-content-center">
                    <fa-icon icon="envelope" size="2x" ></fa-icon>
                    <span class="badge badge-primary" style="position: absolute;top: 0;right: 0;">
                                        {{Badge}}
                                    </span>
                </div>
            </li>
        `,
    selector:'user-item'
})
export class userItemComponent implements OnInit {

    @Input()
    public Avatar :string ="";
    @Input()
    public FullName :string = "";
    @Input()
    public userId :number= 0;
    @Input()
    public Badge :number= 0;
    @Input()
    public Status :string = "";


    constructor( private liferayService:LiferayService) {

    }
    ngOnInit(): void {

    }
}