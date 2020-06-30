import { GuardService } from './login/guard.service';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FirstPageComponent } from './first-page/first-page.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { AnuncioComponent } from './anuncio/anuncio.component';


const routes: Routes = [
  { path: '', component: FirstPageComponent, canActivate: [GuardService]},
  { path: 'verAnuncios', component: SearchBarComponent , canActivate: [GuardService]},
  { path: 'login', component: LoginComponent },
  { path: 'anuncio/:id', component: AnuncioComponent, canActivate: [GuardService]}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
