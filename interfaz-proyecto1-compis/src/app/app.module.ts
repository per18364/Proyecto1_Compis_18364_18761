import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IdeComponent } from './ide/ide.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AnalysisService } from './services/analysis.service';
import { SafeUrlPipe } from './safe-url.pipe';

@NgModule({
  declarations: [AppComponent, IdeComponent, SafeUrlPipe],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [AnalysisService],
  bootstrap: [AppComponent],
})
export class AppModule {}
