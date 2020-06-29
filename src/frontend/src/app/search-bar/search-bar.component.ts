import { AnuncioService } from '../anuncio/anuncio.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {

  anuncios: any;

  constructor(private anuncioService: AnuncioService) { }

  ngOnInit() {
     this.anuncioService.findAllAnuncios().subscribe(
       res => {
       console.log(res);
       this.anuncios = res;
       console.log(this.anuncios);
       }

     );

  }

}
