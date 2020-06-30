import { AnuncioComponent } from './../anuncio/anuncio.component';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';

@Component({
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  comentario: string;
  pontuacao: number;
  constructor(private dialogRef: MatDialogRef<DialogComponent>){

   }

  ngOnInit() {
  }

  avaliar(){
    console.log(this.comentario);
    console.log(this.pontuacao);
    //só chamar a funcao pra criar avaliacao agora
    this.dialogRef.close();
  }
}
