import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { AllOrdersSummaryService } from 'src/app/services/all-orders-summary/all-orders-summary.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit, OnDestroy {

  subscription: Subscription;
  latestDate = new Date();

  constructor(private service: AllOrdersSummaryService) {
  }

  ngOnInit() {

      this.subscription = this.service.getLatestDate().subscribe(date => {
          this.latestDate = date;
      });
  }

  ngOnDestroy() {
        this.subscription.unsubscribe();
  }
}
