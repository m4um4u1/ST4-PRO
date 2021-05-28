import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { OpViewComponent } from './components/op-view/op-view.component';
import { CreateBatchViewComponent } from './components/create-batch-view/create-batch-view.component';
import { IngViewComponent } from './components/ing-view/ing-view.component';
import { LiveDataViewComponent } from './components/live-data-view/live-data-view.component';
import { ReportViewComponent } from './components/report-view/report-view.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MtBarComponent } from './components/mt-bar/mt-bar.component';
import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import {RouterModule} from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ReportComponent } from './pages/report/report.component';
import {CommonModule} from '@angular/common';
import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    OpViewComponent,
    CreateBatchViewComponent,
    IngViewComponent,
    LiveDataViewComponent,
    ReportViewComponent,
    MtBarComponent,
    DashboardComponent,
    NavbarComponent,
    ReportComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    RouterModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
