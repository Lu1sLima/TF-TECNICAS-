import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {
  MatButtonModule, MatNativeDateModule, MatIconModule, MatSidenavModule,
  MatListModule, MatToolbarModule, MatCardModule, MatFormFieldModule,
  MatInputModule, MatSelectModule, MatCheckboxModule} from '@angular/material';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './login/login.service';
import { HeaderComponent } from './header/header.component';
import { FirstPageComponent } from './first-page/first-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchBarComponent } from './search-bar/search-bar.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FirstPageComponent,
    SearchBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatNativeDateModule, MatIconModule, MatSidenavModule,
    MatListModule, MatCardModule, MatFormFieldModule, MatInputModule,
    MatSelectModule, MatCheckboxModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
