import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

import { OrderService } from '../services/order.service';

@NgModule({
    imports: [
        CommonModule,
        HttpClientModule
    ],
    providers: [
        OrderService
    ]
})
export class ServicesModule {}
