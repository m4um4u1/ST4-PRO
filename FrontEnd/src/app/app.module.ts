import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { OpViewComponent } from './op-view/op-view.component';
import { CreateBatchViewComponent } from './create-batch-view/create-batch-view.component';
import { IngViewComponent } from './ing-view/ing-view.component';
import { LiveDataViewComponent } from './live-data-view/live-data-view.component';
import { ReportViewComponent } from './report-view/report-view.component';

@NgModule({
  declarations: [
    AppComponent,
    OpViewComponent,
    CreateBatchViewComponent,
    IngViewComponent,
    LiveDataViewComponent,
    ReportViewComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
