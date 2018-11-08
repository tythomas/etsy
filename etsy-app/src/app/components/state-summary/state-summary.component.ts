import { Component, OnInit, OnDestroy, ViewChild, AfterViewInit } from '@angular/core';
import { OrderSummary } from 'src/app/model/order-summary.model';
import { Subscription } from 'rxjs';
import { StateSummaryService } from 'src/app/services/state-summary/state-summary.service';
import { Sort, MatTableDataSource, MatSort } from '@angular/material';

@Component({
  selector: 'state-summary',
  templateUrl: './state-summary.component.html',
  styleUrls: ['./state-summary.component.css']
})
export class StateSummaryComponent implements OnInit, OnDestroy, AfterViewInit {

  subscription: Subscription;
  dataSource = new MatTableDataSource<OrderSummary>();
  displayedColumns: string[] = ['state', 'numOrders', 'totalAmount', 'totalShipping', 'totalTax'];

  @ViewChild(MatSort) sort: MatSort;
  
  constructor(private service: StateSummaryService) {
  }

  ngOnInit() {

      this.subscription = this.service.getStatesSummary().subscribe(orders => {
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
