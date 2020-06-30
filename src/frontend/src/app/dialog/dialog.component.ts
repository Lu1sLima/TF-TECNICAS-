import { AnuncioService } from './../anuncio/anuncio.service';
import { LoginService } from './../login/login.service';
import { AnuncioComponent } from './../anuncio/anuncio.component';
import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { stringify } from 'querystring';

export interface DialogData {
  anuncioId: number
  userId: number
}

@Component({
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  comentario: string;
  pontuacao: number;
  userid: any;
  anuncioId: number;
  constructor(private dialogRef: MatDialogRef<DialogComponent>, @Inject(MAT_DIALOG_DATA) public data: DialogData, private loginService: LoginService,
  private anuncioService: AnuncioService){

   }

  ngOnInit() {
    this.userid = this.loginService.userId2;
  }

  avaliar(){
    this.anuncioService.createAvaliacao(this.data.anuncioId,this.userid,this.comentario,this.pontuacao);
    this.dialogRef.close();
  }
}
