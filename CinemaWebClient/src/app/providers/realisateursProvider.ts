import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Rx';
import {Realisateur} from '../models/realisateur';

@Injectable()
export class RealisateursProvider {
  constructor(private http: Http) {}

  getRealisateurs(): Observable<Realisateur[]> {
    const url = `http://localhost:8080/realisateurs`;
    return this.http.get(url).map(response => response.json()._embedded.realisateurs as Realisateur[]);
  }

  getById(id: any): Observable<Realisateur> {
    const url = `http://localhost:8080/realisateurs/${id}`;
    return this.http.get(url).map(response => response.json() as Realisateur);
  }

  delete(id: any): Observable<boolean> {
    const url = `http://localhost:8080/realisateurs/${id}`;
    return this.http.delete(url).map(response => response.ok);
  }

  add(realisateur: Realisateur): Observable<boolean> {
    const url = `http://localhost:8080/realisateurs`;
    return this.http.post(url, realisateur).map(response => response.ok);
  }
}
