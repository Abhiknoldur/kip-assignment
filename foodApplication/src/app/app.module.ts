import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FoodComponentComponent } from './food-component/food-component.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { MenuComponent } from './menu/menu.component';
import { MypipePipe } from './food-component/mypipe.pipe';

@NgModule({
  declarations: [
    AppComponent,
    FoodComponentComponent,
    MenuComponent,
    MypipePipe
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
