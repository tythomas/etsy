import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { StateSummaryService } from './services/state-summary/state-summary.service';
import { ServicesModule } from './services/services.module';
import { MaterialModule } from 'src/shared/material.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { StateSummaryComponent } from './components/state-summary/state-summary.component';
import { AllOrderSummaryComponent } from './components/all-order-summary/all-order-summary.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    StateSummaryComponent,
    AllOrderSummaryComponent
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    ServicesModule
  ],
  providers: [ StateSummaryService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
