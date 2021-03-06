import { AnuncioService } from '../anuncio/anuncio.service';
import { Component, OnInit } from '@angular/core';
import { Route, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {

  anuncios: any;
  filteredAnuncios: any;
  marcas: any;
  selectedMarca: string;
  selectedNovo: boolean;
  precoMin: number;
  precoMax: number;
  search: string;

  constructor(private anuncioService: AnuncioService, private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.search = params.get('search');
    });

      if(this.search == null){
     this.anuncioService.findAllAnuncios().subscribe(
       res => {      this.anuncios = res;
          this.filteredAnuncios = res;
       });
      }


       if(this.search != null ){
       this.anuncioService.findAnunciosByKeyword(this.search).subscribe(
         res => {

          this.filteredAnuncios = res;

         }
       );
       }

     this.anuncioService.findAllMarcas().subscribe(   res => {  this.marcas = res;
      });

}


     getAnunciosByFilters() {
       //se só tem o filtro de marca
      if(this.selectedMarca != null){
        this.filteredAnuncios = this.anuncios.filter(anuncio => anuncio.vehicle.marca == this.selectedMarca);
      }
      //se so tem o filtro de novos e usados
      if(this.selectedNovo != null){
        this.filteredAnuncios = this.anuncios.filter(anuncio =>
          anuncio.vehicle.novo == this.selectedNovo);
      }
      // se so tem o filtro de preco
      if( this.precoMax != null && this.precoMin != null  ){
        console.log(this.precoMax);
        this.filteredAnuncios = this.anuncios.filter(anuncio =>
          anuncio.preco >= this.precoMin && anuncio.preco <= this.precoMax);
      }
      //se so tem o filtro de marca e novos e usados
      if(this.selectedMarca != null && this.selectedNovo != null){
        this.filteredAnuncios = this.anuncios.filter(anuncio =>
          anuncio.vehicle.novo == this.selectedNovo &&  anuncio.vehicle.marca == this.selectedMarca);
      }

      // se tem os tres filtros;
      if(this.selectedMarca != null && this.selectedNovo !=null  && (this.precoMax != null && this.precoMin != null)){
        this.filteredAnuncios = this.anuncios.filter(anuncio =>
          anuncio.vehicle.novo == this.selectedNovo &&
            anuncio.vehicle.marca == this.selectedMarca &&
             (anuncio.preco >= this.precoMin && anuncio.preco <= this.precoMax));
      }




    }


}
