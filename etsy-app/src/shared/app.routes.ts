import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from 'src/app/components/dashboard/dashboard.component';
import { NgModule } from '@angular/core';
import { ListingsComponent } from 'src/app/components/listings/listings.component';

export const routes: Routes = [
  { path: '', component: DashboardComponent },
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
