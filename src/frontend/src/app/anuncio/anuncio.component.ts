import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AnuncioService } from './anuncio.service';

@Component({
  selector: 'app-anuncio',
  templateUrl: './anuncio.component.html',
  styleUrls: ['./anuncio.component.css']
})
export class AnuncioComponent implements OnInit {

  id: string;
  anuncio: any;

  constructor(private route: ActivatedRoute,private anuncioService: AnuncioService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.anuncioService.findById(this.id).subscribe(
      res => {
        this.anuncio = res;
        console.log(this.anuncio);
      }
    )


  }

}
