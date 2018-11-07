import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

import { StateSummaryService } from './state-summary/state-summary.service';
import { AllOrdersSummaryService } from './all-orders-summary/all-orders-summary.service';

@NgModule({
    imports: [
        CommonModule,
        HttpClientModule
    ],
    providers: [
        StateSummaryService,
        AllOrdersSummaryService
    ]
})
export class ServicesModule {}
