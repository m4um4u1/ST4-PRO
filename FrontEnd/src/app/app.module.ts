import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { OpViewComponent } from './op-view/op-view.component';
import { CreateBatchViewComponent } from './create-batch-view/create-batch-view.component';
import { IngViewComponent } from './ing-view/ing-view.component';
import { LiveDataViewComponent } from './live-data-view/live-data-view.component';
import { ReportViewComponent } from './report-view/report-view.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MtBarComponent } from './mt-bar/mt-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    OpViewComponent,
    CreateBatchViewComponent,
    IngViewComponent,
    LiveDataViewComponent,
    ReportViewComponent,
    MtBarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
