import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from 'src/app/components/dashboard/dashboard.component';
import { NgModule } from '@angular/core';
import { ListingsComponent } from 'src/app/components/listings/listings.component';
import { AllOrderSummaryComponent } from '../components/all-order-summary/all-order-summary.component';
import { StateSummaryComponent } from '../components/state-summary/state-summary.component';
import { MonthSummaryComponent } from '../components/month-summary/month-summary.component';

export const routes: Routes = [
  { path: '', component: AllOrderSummaryComponent },
  { path: 'summary', component: AllOrderSummaryComponent },
  { path: 'summary-state', component: StateSummaryComponent },
  { path: 'summary-month', component: MonthSummaryComponent },
  { path: 'listings', component: ListingsComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  providers: [
  ]
})
export class AppRoutingModule { }
