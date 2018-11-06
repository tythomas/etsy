import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { BehaviorSubject, Observable } from 'rxjs';
import { OrderSummary } from '../model/order-summary.model';

@Injectable()
export class OrderService {

  readonly getOrderApi = environment.getOrderApi;

  private chats: BehaviorSubject<OrderSummary[]>;
  private chats$: Observable<OrderSummary[]>;

  constructor(private http: HttpClient) {
    this.chats = new BehaviorSubject<OrderSummary[]>([]);
    this.chats$ = this.chats.asObservable();
  }

  getStatesSummary(): Observable<OrderSummary[]> {

    this.http.get<OrderSummary[]>(`${this.getOrderApi}/statesummary`)
    .toPromise().then(messages => {
        this.chats.next(messages);
    });
    return this.chats$;

  }

}

