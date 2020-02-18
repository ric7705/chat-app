import { Component, OnInit } from '@angular/core';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-chat-box',
  templateUrl: './chat-box.component.html',
  styleUrls: ['./chat-box.component.css']
})
export class ChatBoxComponent implements OnInit {

  constructor(private messageService: MessageService) { }

  ngOnInit(): void {

    this.messageService.getTest()
      .subscribe(r => {
        console.log(r);
      });

    const sseEndpoint = 'http://localhost:8080/message/all'
    this.messageService.getServerSendEvent(sseEndpoint)
      .subscribe(r => {
        console.log(r);
      })

  }

}
