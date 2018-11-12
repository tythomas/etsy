import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { BehaviorSubject, Observable } from 'rxjs';
import { OrderSummary } from '../../model/order-summary.model';

@Injectable()
export class AllOrdersSummaryService {

  readonly getOrderApi = environment.getAllOrdersSummaryApi;
  readonly getLatestDateApi = environment.getLatestDateApi;

  private orderSummary: BehaviorSubject<OrderSummary>;
  private orderSummary$: Observable<OrderSummary>;

  private latestDate: BehaviorSubject<Date>;
  private latestDate$: Observable<Date>;

  constructor(private http: HttpClient) {
    this.orderSummary = new BehaviorSubject<OrderSummary>({} as OrderSummary);
    this.orderSummary$ = this.orderSummary.asObservable();
    this.latestDate = new BehaviorSubject<Date>(new Date());
    this.latestDate$ = this.latestDate.asObservable();
  }

  getAllOrdersSummary(): Observable<OrderSummary> {

    this.http.get<OrderSummary>(`${this.getOrderApi}`)
    .toPromise().then(messages => {
        this.orderSummary.next(messages);
    });
    return this.orderSummary$;

  }

  getLatestDate(): Observable<Date> {

    this.http.get<Date>(`${this.getLatestDateApi}`)
    .toPromise().then(messages => {
        this.latestDate.next(messages);
    });
    return this.latestDate$;

  }

}

