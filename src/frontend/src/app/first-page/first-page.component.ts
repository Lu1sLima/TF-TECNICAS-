import { LoginService } from './../login/login.service';
import { AnuncioService } from './../anuncio/anuncio.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-first-page',
  templateUrl: './first-page.component.html',
  styleUrls: ['./first-page.component.css']
})
export class FirstPageComponent implements OnInit {
  anuncios: any;
  search: string;
  constructor(private anuncioService: AnuncioService, private loginService: LoginService) { }

  ngOnInit() {
    this.anuncioService.findAllAnunciosRelevantes(this.loginService.city).subscribe(
      res => {       this.anuncios = res;
      });



  }

}
