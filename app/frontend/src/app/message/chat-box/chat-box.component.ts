import { Component, OnInit, Input } from '@angular/core';
import { MessageService } from '../message.service';
import { Content } from '@angular/compiler/src/render3/r3_ast';

declare var $: any;

@Component({
  selector: 'app-chat-box',
  templateUrl: './chat-box.component.html',
  styleUrls: ['./chat-box.component.css']
})
export class ChatBoxComponent implements OnInit {

  constructor(private messageService: MessageService) { }

  msgList = [];
  activeChatList = [];
  activeContact = '';

  msgToBeSend = '';

  currentUser = 'jack';

  contactList = ['john', 'mary', 'lily', 'eric'];
  activeContactList = this.contactList;
  contactFilter = '';

  docHeight: any;

  ngOnInit(): void {

    this.messageService.getTest()
      .subscribe(r => {
        console.log(r);
      });

    // first contact default
    const sseEndpoint = 'http://localhost:8080/message/' + this.currentUser;
    // const sseEndpoint = 'http://localhost:8080/message/' + 'all';
    console.log(sseEndpoint);
    this.messageService.getServerSendEvent(sseEndpoint)
      .subscribe(r => {
        console.log(JSON.parse(r.data));
        this.msgList.push(JSON.parse(r.data));
        console.log(this.msgList);
        this.updateActiveChatList();
      })

    this.docHeight = $(document).height();

  }

  updateContactList(contactName) {
    this.activeContact = contactName;
    this.updateActiveChatList();
    console.log('activeChatList: ' + this.activeChatList);
  }

  private updateActiveChatList() {
    this.activeChatList = this.msgList.filter(
      e => (e.from == this.currentUser && e.to == this.activeContact) ||
        (e.to == this.currentUser && e.from == this.activeContact));

  }

  isContactActive(item) {
    return this.activeContact === item;
  };

  filterContact(kw) {

    if (!kw || kw.length > 0) {
      console.log('kw: ' + kw);
      this.activeContactList = this.contactList.filter(e =>
        e.toLowerCase().indexOf(kw.toLowerCase()) > -1
      );
      console.log('contactList: ' + this.contactList);
    } else {
      this.activeContactList = this.contactList;
    }

  }

  submit_message(msg) {
    console.log(msg);
    // call api
    // append to list
    const msgObj = {
      'from': this.currentUser,
      'to': this.activeContact,
      'date': '2020-10-10',
      'content': msg
    }

    this.messageService.sendMessage(msgObj).subscribe(res => {

      this.updateContactList(this.activeContact);

      this.msgToBeSend = '';

      $(".messages").animate({ scrollTop: this.docHeight += 93 }, "normal");
    });

  }

}
