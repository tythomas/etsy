import { Component } from "@angular/core";
import { OrderService } from "../services/order.service";
import { OrderSummary } from "../model/order-summary.model";
import { Observable } from "rxjs";

@Component({
    selector: 'order-summary',
    styleUrls: ['./order-summary.component.css'],
    templateUrl: './order-summary.component.html'
})

export class OrderSummaryComponent {

    chatMessages$: Observable<OrderSummary[]>;

    constructor(private service: OrderService) {
    }

    ngOnInit() {

        this.chatMessages$ = this.service.getStatesSummary();
        this.chatMessages$.subscribe();
    }



}