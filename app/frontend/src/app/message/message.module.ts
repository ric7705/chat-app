import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChatBoxComponent } from './chat-box/chat-box.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [ChatBoxComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [ChatBoxComponent]
})
export class MessageModule { }
