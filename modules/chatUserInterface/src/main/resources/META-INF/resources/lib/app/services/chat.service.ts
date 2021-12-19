import { Injectable } from "@angular/core";
import {map, Observable, Subject} from "rxjs";
import { WebsocketService } from "./WebsocketService.service";
import {LiferayService} from "./liferay.service";


declare const Liferay: any;
const CHAT_URL = "ws://"+Liferay.ThemeDisplay.getCDNBaseURL().substr(Liferay.ThemeDisplay.getCDNBaseURL().indexOf('//'),Liferay.ThemeDisplay.getCDNBaseURL().length)
    +"/o/lrchat/"+Liferay.ThemeDisplay.getUserId();

export interface Message {
    toUserId: string;
    fromUserId:string;
    data: string;
    messageType:string;
    messageText:string;
    groupId: string;
    createDate:Date;
}


@Injectable()
export class ChatService {
    public messages: Subject<Message>;
    constructor(wsService: WebsocketService) {
        this.messages = <Subject<Message>> wsService.connect(CHAT_URL)
            .pipe(map((response: MessageEvent): Message => {
                let data = JSON.parse(response.data);
                return {
                    toUserId: data.toUserId,
                    data: data.data,
                    messageType:data.messageType,
                    messageText:data.messageText,
                    groupId:data.groupId,
                    fromUserId:data.fromUserId,
                    createDate:new Date(data.createDate)
                };
            }));
    }
}