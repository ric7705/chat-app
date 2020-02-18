import { Injectable, NgZone } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Message } from './message.model';
import { Observable } from 'rxjs';
import { SseService } from '../sse.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(
    private _zone: NgZone,
    private http: HttpClient,
    private sseService: SseService) { }

  private apiRoot = 'http://localhost:8080/message';

  public getTest() {
    return this.http.get<Message[]>(this.apiRoot + '/test');
  }

  getServerSendEvent(url: string) {
    return Observable.create(observer => {
      const eventSource = this.sseService.getEventSource(url);
      eventSource.onmessage = event => {
        this._zone.run(() => {
          observer.next(event);
        })
      };

      eventSource.onerror = error => {
        this._zone.run(() => {
          observer.error(error);

        })
      };
    });
  }
}
