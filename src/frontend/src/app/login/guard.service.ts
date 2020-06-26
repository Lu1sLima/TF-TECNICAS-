import { LoginService } from './login.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable()
export class GuardService implements CanActivate {

  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }

  canActivate(route: ActivatedRouteSnapshot,
     state: RouterStateSnapshot): Observable<boolean> | boolean{
      if(this.loginService.userAutenticado()){
        return true;
      }

        this.router.navigate(['/login']);
        return false;
      }
  }


