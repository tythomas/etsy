import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { OrderSummaryComponent } from './order-summary/order-summary.component';
import { OrderService } from './services/order.service';
import { ServicesModule } from './services/service.module';
import { MaterialModule } from 'src/shared/material.module';


@NgModule({
  declarations: [
    AppComponent,
    OrderSummaryComponent
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    ServicesModule
  ],
  providers: [ OrderService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
