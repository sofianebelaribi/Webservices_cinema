import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Personnage} from '../models/personnage';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class PersonnagesProvider {

  constructor(private http: Http) {  }

  getPersonnages(): Observable<Personnage[]> {
    const url = `http://localhost:8080/personnages`;
    return this.http.get(url).map(response => response.json()._embedded.personnages as Personnage[]);
  }

  getByIdFilm(id: number): Personnage[] {
    const response: Personnage[] = [];
    const allPersonnages = this.getPersonnages();
    allPersonnages.forEach((personnages) => {
      personnages.forEach((personnage) => {
        if (personnage.noFilm === id) {
          response.push(personnage);
        }
      });
    });
    return response;
  }

  add(personnage: Personnage): Observable<boolean> {
    const url = `http://localhost:8080/personnages`;
    return this.http.post(url, personnage).map(response => response.ok);
  }

}
