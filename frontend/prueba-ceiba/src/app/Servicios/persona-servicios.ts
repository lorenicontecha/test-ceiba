import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PersonaModel } from '../Modelo/persona.model';


@Injectable()
export class PersonaServicio {

  constructor(private httpClient: HttpClient) { }

  public getPersonas(): Observable<any> {
    return this.httpClient.get<any>('/api/getPerson');
  }

  public guardarPersonas(persona:PersonaModel): Observable<any> {
    return this.httpClient.post<any>('/api/addPerson', persona);
  }
}