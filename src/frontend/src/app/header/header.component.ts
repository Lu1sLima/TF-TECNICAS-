import { LoginService } from './../login/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


  mostrarMenu: boolean = false;
  username: string
  userid: string
  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.loginService.mostrarMenu.subscribe(mostrar => this.mostrarMenu = mostrar);
    this.loginService.userName.subscribe(name => this.username = name);
    this.loginService.userId.subscribe(name => this.userid = name);


  }

  // dummyline
  refresh(){
    window.location.reload();
  }


}
