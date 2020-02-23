import { Injectable, NgZone } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Message } from './message.model';
import { Observable, throwError } from 'rxjs';
import { SseService } from '../sse.service';
import { catchError } from 'rxjs/operators';

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

  private apiRoot = 'http://localhost:8080';

  public getTest() {
    return this.http.get<Message[]>(this.apiRoot + '/message/test');
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
          console.log('error');
          observer.error(error);
        })
      };
    });
  }

  sendMessage(payload: any) {
    const url = this.apiRoot + '/message';
    console.log('post: ' + url);
    return this.http.post<any>(url, payload, httpOptions)
      .pipe(
        catchError(err => {
          console.log(err);
          return throwError("Error thrown from catchError");
        })
      );
  }

  getUserContact(username) {
    const url = this.apiRoot + '/contact/' + username;

    // const options = username ? { params: new HttpParams().set('username', username) } : {};
    return this.http.get<any>(url)
      .pipe(
        catchError(err => {
          console.log(err);
          return throwError("Error thrown from catchError");
        })
      );
  }
}
