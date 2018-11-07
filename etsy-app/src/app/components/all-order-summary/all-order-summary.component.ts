import { Component, OnInit, OnDestroy } from '@angular/core';
import { OrderSummary } from 'src/app/model/order-summary.model';
import { Subscription } from 'rxjs';
import { AllOrdersSummaryService } from 'src/app/services/all-orders-summary/all-orders-summary.service';

@Component({
  selector: 'all-order-summary',
  templateUrl: './all-order-summary.component.html',
  styleUrls: ['./all-order-summary.component.css']
})
export class AllOrderSummaryComponent implements OnInit, OnDestroy {

  orderSummary: OrderSummary;
  orderSummariesSub: Subscription;

  constructor(private service: AllOrdersSummaryService) {
  }

  ngOnInit() {

      this.orderSummariesSub = this.service.getAllOrdersSummary().subscribe(orderSummary => {
          this.orderSummary = orderSummary;
      });
  }

  ngOnDestroy() {
        this.orderSummariesSub.unsubscribe();
  }

}
