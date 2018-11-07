import { Component, OnInit, OnDestroy } from '@angular/core';
import { OrderSummary } from 'src/app/model/order-summary.model';
import { Subscription } from 'rxjs';
import { StateSummaryService } from 'src/app/services/state-summary/state-summary.service';

@Component({
  selector: 'state-summary',
  templateUrl: './state-summary.component.html',
  styleUrls: ['./state-summary.component.css']
})
export class StateSummaryComponent implements OnInit, OnDestroy {

  orderSummaries: OrderSummary[] = [];
  orderSummariesSub: Subscription;

  constructor(private service: StateSummaryService) {
  }

  ngOnInit() {

      this.orderSummariesSub = this.service.getStatesSummary().subscribe(orderSummaries => {
          this.orderSummaries = orderSummaries;
      });
  }

  ngOnDestroy() {
        this.orderSummariesSub.unsubscribe();
  }

}
