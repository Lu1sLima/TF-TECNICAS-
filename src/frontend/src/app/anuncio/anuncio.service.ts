import { catchError } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpErrorResponse, HttpClient } from '@angular/common/http';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnuncioService {

  private apiUrl = 'http://localhost:4200/api';


  constructor(private http: HttpClient) { }

  findAllAnuncios(){
    return this.http.get(this.apiUrl + 'anuncio/findAll/').pipe(catchError(this.handleError));
  }

  findById(id: String){
    return this.http.get(this.apiUrl + 'anuncio/' + `${id}`).pipe(catchError(this.handleError));
  }

  findAllMarcas(){
    return this.http.get(this.apiUrl + 'marcas').pipe(catchError(this.handleError));

  }

  findAllAvaliacoes(id){
    return this.http.get(this.apiUrl + '/anuncio/avaliacoes/' + `${id}`).pipe(catchError(this.handleError));
  }

  createAvaliacao(anuncioId, userId, comentario: string, pontuacao: number){
    return this.http.post(this.apiUrl + '/anuncio/avaliacoes/' + `${anuncioId}` + "/" +  `${userId}` + "/" + `${comentario}` + "/" + `${pontuacao}`, null ).pipe(catchError(this.handleError)).subscribe();
  }



    handleError(error: HttpErrorResponse) {
      let errorMessage = '';
      if (error.error instanceof ErrorEvent) {
        // Erro ocorreu no lado do client
        errorMessage = error.error.message;
      } else {
        // Erro ocorreu no lado do servidor
        errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
      }
      console.log(errorMessage);
      return throwError(errorMessage);
    };


}
