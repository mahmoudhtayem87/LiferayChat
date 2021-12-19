import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {activeUsersComponent} from './chat/active.component'
import {chatRoomComponent} from "./chat/chatRoom.component";

const routes: Routes = [
    {path: 'activeUsers', component: activeUsersComponent},
    {path: 'chatroom', component: chatRoomComponent},
    {path: '', component: activeUsersComponent},
    {path: '**', component: activeUsersComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {useHash: true}),],
    exports: [RouterModule]
})
export class AppRoutingModule {

}