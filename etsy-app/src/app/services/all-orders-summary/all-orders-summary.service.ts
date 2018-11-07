import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { BehaviorSubject, Observable } from 'rxjs';
import { OrderSummary } from '../../model/order-summary.model';

@Injectable()
export class AllOrdersSummaryService {

  readonly getOrderApi = environment.getAllOrdersSummaryApi;

  private orderSummary: BehaviorSubject<OrderSummary>;
  private orderSummary$: Observable<OrderSummary>;

  constructor(private http: HttpClient) {
    this.orderSummary = new BehaviorSubject<OrderSummary>([]);
    this.orderSummary$ = this.orderSummary.asObservable();
  }

  getAllOrdersSummary(): Observable<OrderSummary> {

    this.http.get<OrderSummary>(`${this.getOrderApi}`)
    .toPromise().then(messages => {
        this.orderSummary.next(messages);
    });
    return this.orderSummary$;

  }

}

