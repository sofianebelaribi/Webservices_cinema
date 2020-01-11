import {Injectable} from '@angular/core';
import {Http, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Rx';
import {Acteur} from '../models/acteur';

@Injectable()
export class ActeursProvider {

  constructor(private http: Http) {
  }

  getAll(): Observable<Acteur[]> {
    const url = `http://localhost:8080/acteurs`;
    return this.http.get(url).map(response => response.json()._embedded.acteurs as Acteur[]);
  }

  getById(id: any): Observable<Acteur> {
    const url = `http://localhost:8080/acteurs/${id}`;
    return this.http.get(url).map(response => response.json() as Acteur);
  }

  delete(id: any): Observable<boolean> {
    const url = `http://localhost:8080/acteurs/${id}`;
    return this.http.delete(url).map(response => response.ok);
  }

  add(acteur: Acteur): Observable<boolean> {
    const url = `http://localhost:8080/acteurs`;
    return this.http.post(url, acteur).map(response => response.ok);
  }

  /*update(acteur: Acteur) {
    const url = `http://localhost:8080/modifier/personnage`;
    return this.http.post(url, CharactersService.buildBody(character).toString(), this.options).map(response => response.ok);
  }*/
}
