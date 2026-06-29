import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn:'root'
})
export class AiService {

  private url = "http://localhost:9090/api/ai";

  constructor(private http: HttpClient){}

  generateQcm(sujet: string){

    return this.http.post<any[]>(

      'http://localhost:9090/api/ai/generate',

      {
        sujet: sujet,
        nombreQuestions: 5
      }

    );

  }

  corriger(data:any){

    return this.http.post<any>(
      this.url + "/corriger",
      data
    );

  }

  // =====================
  // LOGIN
  // =====================
  login(data:any){

    return this.http.post(
      'http://localhost:9090/api/auth/login',
      data
    );

  }

}