import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';
import { AnuncioService } from './anuncio.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-anuncio',
  templateUrl: './anuncio.component.html',
  styleUrls: ['./anuncio.component.css']
})
export class AnuncioComponent implements OnInit {

  displayedColumns: string[] = ['UserName', 'Comentario', 'Pontuacao'];
  id: string;
  anuncio: any;
  avaliacoes: any;

  dataSource: any;



  constructor(private route: ActivatedRoute,private anuncioService: AnuncioService,
    public dialog: MatDialog) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.anuncioService.findById(this.id).subscribe(
      res => {
        this.anuncio = res;
        console.log(this.anuncio);
      }
    )

    this.anuncioService.findAllAvaliacoes(this.id).subscribe(
      res => {
        this.avaliacoes = res;
        this.dataSource = this.avaliacoes;
        console.log(this.avaliacoes);
      }
    )

  }

  openDialog(){
    const dialogRef = this.dialog.open(DialogComponent, {
    });


  }


}
