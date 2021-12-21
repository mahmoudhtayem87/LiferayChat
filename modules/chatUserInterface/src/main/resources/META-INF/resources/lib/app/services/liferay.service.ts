import { Injectable } from '@angular/core';
import {from, map, Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {promise} from "protractor";
declare const document: any;

declare const Liferay: any;

export class Expense
{
    title: string | undefined;
    description: string | undefined;
    createDate:Date | undefined;
    userName:string | undefined

}
@Injectable({
    providedIn: 'root',
})
export class LiferayService {

    constructor(private http: HttpClient) { }
    public getCurrentUser():Promise<any[]>
    {
        const serviceUrl = "/user/get-current-user";
        const serviceObject = {
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    ////
    public getChatHistory(fromUserId: number,toUserId:number):Promise<any[] | undefined>
    {
        const serviceUrl = "/chat.message/get-messages-between";
        const serviceObject = {
                fromUserId: toUserId,
                toUserId:fromUserId
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public getUsers():Promise<any[]>
    {
        const serviceUrl = "/chat.chatuser/get-users";
        const serviceObject = {
            groupId:Liferay.ThemeDisplay.getScopeGroupId()
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    //private helper methods
    generateServicePromise(serviceURL:string,serviceObject:any):Promise<any>
    {
        const prom = new Promise((resolve,reject)=>{
            Liferay.Service(serviceURL,serviceObject,(result:any)=>{
                resolve(result);
            },(error:any)=>{
                reject(error);
            });
        });
        return  prom;
    }
    public getScopedGroupId()
    {
        return Liferay.ThemeDisplay.getScopeGroupId();
    }
    public getCurrentUserId()
    {
        return Liferay.ThemeDisplay.getUserId();
    }
}
