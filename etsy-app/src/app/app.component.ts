import { Component, OnDestroy, OnInit, ChangeDetectorRef } from '@angular/core';
import { MediaMatcher } from '@angular/cdk/layout';
import { MatIconRegistry } from '@angular/material';
import { DomSanitizer } from '@angular/platform-browser';
import { Subscription } from 'rxjs';
import { AllOrdersSummaryService } from './services/all-orders-summary/all-orders-summary.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnDestroy, OnInit {
  isOpened = false;
  isMin = false;

  mobileQuery: MediaQueryList;
  private _mobileQueryListener: () => void;

  subscription: Subscription;
  latestDate = new Date();

  constructor(
    private service: AllOrdersSummaryService,
    private changeDetectorRef: ChangeDetectorRef,
    private media: MediaMatcher,
    private iconReg: MatIconRegistry,
    private sanitizer: DomSanitizer) { }

    ngOnInit() {
      this.iconReg.addSvgIcon('excel', this.sanitizer.bypassSecurityTrustResourceUrl('./assets/svg/excel.svg'));
      this.iconReg.addSvgIcon('csv', this.sanitizer.bypassSecurityTrustResourceUrl('./assets/svg/csv.svg'));

      this.mobileQuery = this.media.matchMedia('(min-width: 600px)');
      this._mobileQueryListener = () => { this.isMin = false; this.changeDetectorRef.detectChanges(); };
      this.mobileQuery.addListener(this._mobileQueryListener);

      this.subscription = this.service.getLatestDate().subscribe(date => {
        this.latestDate = date;
    });

  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  menuClick() {
    this.isMin = false;
    this.isOpened = !this.isOpened;
}

onMinClick() {
    this.isMin = !this.isMin;
}


}
