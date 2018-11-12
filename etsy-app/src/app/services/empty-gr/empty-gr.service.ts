import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { BehaviorSubject, Observable } from 'rxjs';
import { Listing } from 'src/app/model/listing-model';

@Injectable()
export class EmptyGRService {

  readonly getEmptyGRApi = environment.getEmptyGRApi;

  private listings: BehaviorSubject<Listing[]>;
  private listings$: Observable<Listing[]>;

  constructor(private http: HttpClient) {
    this.listings = new BehaviorSubject<Listing[]>([]);
    this.listings$ = this.listings.asObservable();
  }

  getEmptyGR(): Observable<Listing[]> {

    this.http.get<Listing[]>(`${this.getEmptyGRApi}`)
    .toPromise().then(messages => {
        this.listings.next(messages);
    });
    return this.listings$;

  }

}

