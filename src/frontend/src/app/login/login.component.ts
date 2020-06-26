import { Component, OnInit } from '@angular/core';
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

  constructor(private router: Router,private loginService: LoginService) { }

  ngOnInit() {
  }

  loginUser() {

    this.loginService.autenticaLogin(this.user, this.password).subscribe(
      res => {
      console.log(res);
        this.loginService.usuarioAutenticado = true;
        this.loginService.mostrarMenu.emit(true);
        this.router.navigate(['/']);
      },
      err => {
        this.loginService.usuarioAutenticado = false;

        this.loginService.mostrarMenu.emit(false);
      console.log(err);
      });

 }
}
