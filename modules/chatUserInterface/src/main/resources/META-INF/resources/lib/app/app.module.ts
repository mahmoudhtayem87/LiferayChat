import {  NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {APP_BASE_HREF, CommonModule} from '@angular/common';
import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import { HttpClientModule } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
// @ts-ignore
import { far } from '@fortawesome/free-regular-svg-icons';
// @ts-ignore
import {FaIconLibrary, FontAwesomeModule} from '@fortawesome/angular-fontawesome';
// @ts-ignore
import {
    fas,
    faCoffee,
    faEdit,
    faExpand,
    faInfo,
    faCheck,
    faCross,
    faSave,
    faSpinner, faReceipt
} from '@fortawesome/free-solid-svg-icons';
import {RouterModule} from "@angular/router";
import { activeUsersComponent } from './chat/active.component';
import {WebsocketService} from "./services/WebsocketService.service";
import {ChatService} from "./services/chat.service";
import {LiferayService} from "./services/liferay.service";
import {chatRoomComponent} from "./chat/chatRoom.component";
import {GroupByPipe} from "./pipe/group-by.pipe";
import {FilterPipe} from "./pipe/filter.pipe";
import {chatMessageComponent} from "./chat/chatMessage.component";

declare const Liferay: any;
@NgModule({
	imports: [
		BrowserModule,
		CommonModule,
		FontAwesomeModule,
		FormsModule,
		ReactiveFormsModule,
		AppRoutingModule,
		HttpClientModule
	], 
	declarations: [
		AppComponent,
		chatRoomComponent,
		activeUsersComponent,
		chatMessageComponent,
		GroupByPipe,
		FilterPipe
	],
	entryComponents: [AppComponent],
	bootstrap: [], // Do not bootstrap anything (see ngDoBootstrap() below)
	providers:[{provide: APP_BASE_HREF, useValue: "/"},WebsocketService, ChatService,LiferayService],
})
export class AppModule{

	// Avoid bootstraping any component statically because we need to attach to
	// the portlet's DOM, which is different for each portlet instance and,
	// thus, cannot be determined until the page is rendered (during runtime).
	constructor(library: FaIconLibrary) {
		library.addIconPacks(fas);
		library.addIconPacks(far);
		library.addIcons(faCoffee);
		library.addIcons(faEdit);
		library.addIcons(faCross);
		library.addIcons(faInfo);
		library.addIcons(faCheck);
		library.addIcons(faSave);
		library.addIcons(faReceipt);
		library.addIcons(faSpinner);
	}
	ngDoBootstrap() {}
}