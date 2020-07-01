import { Component, OnInit, ElementRef } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: string;
  password: string;
  validation: boolean;

  constructor(private router: Router,private loginService: LoginService,private elementRef: ElementRef) { }

  ngOnInit() {
    this.elementRef.nativeElement.ownerDocument.body.style.backgroundColor = '#efeff5';

  }

  loginUser() {

    this.loginService.autenticaLogin(this.user, this.password).subscribe(
      res => {
      console.log(res);

        this.loginService.userId2 = res['id'];
        this.loginService.city = res['city'];

        this.loginService.usuarioAutenticado = true;

        this.loginService.mostrarMenu.emit(true);

        this.loginService.userName.emit(res['name']);

        this.loginService.userId.emit(res['id']);

        this.validation = false;


        this.router.navigate(['/']);
      },
      err => {
        this.loginService.usuarioAutenticado = false;
        this.validation = true;
        this.loginService.mostrarMenu.emit(false);
      console.log(err);
      });



 }
}
