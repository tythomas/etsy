import { Component, OnInit, OnDestroy, ViewChild, AfterViewInit } from '@angular/core';
import { OrderSummary } from 'src/app/model/order-summary.model';
import { Subscription } from 'rxjs';
import { Sort, MatTableDataSource, MatSort } from '@angular/material';
import { MonthSummaryService } from 'src/app/services/month-summary/month-summary.service';

@Component({
  selector: 'month-summary',
  templateUrl: './month-summary.component.html',
  styleUrls: ['./month-summary.component.css']
})
export class MonthSummaryComponent implements OnInit, OnDestroy, AfterViewInit {

  subscription: Subscription;
  dataSource = new MatTableDataSource<OrderSummary>();
  displayedColumns: string[] = ['month', 'numOrders', 'totalAmount', 'totalShipping', 'totalTax'];

  @ViewChild(MatSort) sort: MatSort;
  
  constructor(private service: MonthSummaryService) {
  }

  ngOnInit() {

      this.subscription = this.service.getMonthsSummary().subscribe(orders => {
          this.dataSource.data = orders;
      });
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  ngOnDestroy() {
        this.subscription.unsubscribe();
  }

}
