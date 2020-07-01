
import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { Injectable, EventEmitter } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';




@Injectable()
export class LoginService{
  private apiUrl = 'http://localhost:4200/api';

  usuarioAutenticado: boolean = false;
  mostrarMenu =  new EventEmitter<boolean>();
  userName =  new EventEmitter<string>();
  userId =  new EventEmitter<string>();
  public userId2: string;
  public city: string;



  constructor(private http: HttpClient){

  }

  autenticaLogin(email: string, password: string){
    return this.http.get(this.apiUrl + '/autentica/' + `${email}/${password}`).pipe(catchError(this.handleError));
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

    userAutenticado(){
      return this.usuarioAutenticado;
    }






}
