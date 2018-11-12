import { Component, OnInit, OnDestroy } from '@angular/core';
import { Listing } from 'src/app/model/listing-model';
import { Subscription } from 'rxjs';
import { EmptyGRService } from 'src/app/services/empty-gr/empty-gr.service';

@Component({
  selector: 'app-empty-gr',
  templateUrl: './empty-gr.component.html',
  styleUrls: ['./empty-gr.component.css']
})
export class EmptyGrComponent implements OnInit, OnDestroy {

  listings: Listing[];
  listingsSub: Subscription;

  constructor(private service: EmptyGRService) {
  }

  ngOnInit() {

      this.listingsSub = this.service.getEmptyGR().subscribe(listings => {
          this.listings = listings;
      });
  }

  ngOnDestroy() {
        this.listingsSub.unsubscribe();
  }
}
