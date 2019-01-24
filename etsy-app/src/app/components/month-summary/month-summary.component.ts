import { Component, OnInit, OnDestroy, ViewChild, AfterViewInit } from '@angular/core';
import { OrderSummary } from 'src/app/model/order-summary.model';
import { Subscription } from 'rxjs';
import { Sort, MatTableDataSource, MatSort } from '@angular/material';
import { MonthSummaryService } from 'src/app/services/month-summary/month-summary.service';
import { OrderSummaryYearly } from 'src/app/model/order-summary-year-model';

@Component({
  selector: 'month-summary',
  templateUrl: './month-summary.component.html',
  styleUrls: ['./month-summary.component.css']
})
export class MonthSummaryComponent implements OnInit, OnDestroy {

  yearlySummary: OrderSummaryYearly[];
  yearlySummarySub: Subscription;
  
  constructor(private service: MonthSummaryService) {
  }

  ngOnInit() {

      this.yearlySummarySub = this.service.getMonthsSummary().subscribe(orders => {
          this.yearlySummary = orders;
      });
  }

  ngOnDestroy() {
        this.yearlySummarySub.unsubscribe();
  }

}
