import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule, HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { MovieModule } from './app.moviemodule';

import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

@NgModule({
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  declarations: [AppComponent, MovieModule],
  providers: [HttpClientModule],
  bootstrap: [AppComponent, HttpClientModule, HttpClient],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {}
