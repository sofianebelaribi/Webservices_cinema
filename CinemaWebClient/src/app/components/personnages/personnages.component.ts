import { Component, OnInit } from '@angular/core';
import {Personnage} from '../../models/personnage';
import {PersonnagesProvider} from '../../providers/personnagesProvider';
import {FilmsProvider} from '../../providers/filmsProvider';
import {ActeursProvider} from '../../providers/acteursProvider';
import {Acteur} from '../../models/acteur';
import {Film} from '../../models/film';

@Component({
  selector: 'app-personnages',
  templateUrl: './personnages.component.html',
  styleUrls: ['./personnages.component.css']
})
export class PersonnagesComponent implements OnInit {

  personnage: Personnage;
  personnages: Personnage[] = [];
  acteurs: Acteur[] = [];
  films: Film[] = [];
  validate: boolean;
  failed: boolean;

  constructor(private personnageProvider: PersonnagesProvider, private filmsProvider: FilmsProvider, private acteursProvider: ActeursProvider) { }

  init() {
    this.personnages = [];
    this.personnage = new Personnage(null, null, null, null);
    this.personnageProvider.getPersonnages().subscribe(personnages => {
      this.parsePersonnages(personnages);
    });
    this.acteursProvider.getAll().subscribe(acteurs => {
      this.acteurs = acteurs;
    });
    this.filmsProvider.getAll().subscribe(films => {
      this.films = films;
    });
  }

  ngOnInit() {
    this.init();
  }

  parsePersonnages(personnages: any) {
    personnages.forEach((personnage) => {
      const noFilm = personnage.noFilm;
      const noAct = personnage.noAct;
      const nomPers = personnage.nomPers;
      this.filmsProvider.getById(noFilm).subscribe(film => {
        this.personnages.push(new Personnage(noFilm, noAct, nomPers, film.titre));
      });
    });
  }

  add(personnage: Personnage) {
    this.personnageProvider.add(personnage).subscribe(
      () => {
        this.validate = true;
        this.failed = null;

        console.log('Success');
      },
      () => {
        this.validate = null;
        this.failed = true;

        console.log('Failed');
      },
      () => {
        this.init();
      }
    );
  }

}
