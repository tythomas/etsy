import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { BehaviorSubject, Observable } from 'rxjs';
import { OrderSummary } from '../../model/order-summary.model';

@Injectable()
export class MonthSummaryService {

  readonly getOrderApi = environment.getMonthSummaryApi;

  private orderSummaries: BehaviorSubject<OrderSummary[]>;
  private orderSummaries$: Observable<OrderSummary[]>;

  constructor(private http: HttpClient) {
    this.orderSummaries = new BehaviorSubject<OrderSummary[]>([]);
    this.orderSummaries$ = this.orderSummaries.asObservable();
  }

  getMonthsSummary(): Observable<OrderSummary[]> {

    this.http.get<OrderSummary[]>(`${this.getOrderApi}`)
    .toPromise().then(messages => {
        this.orderSummaries.next(messages);
    });
    return this.orderSummaries$;

  }

}

