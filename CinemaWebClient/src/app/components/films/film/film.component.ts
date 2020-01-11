import { Component, OnInit } from '@angular/core';
import {FilmsProvider} from '../../../providers/filmsProvider';
import { Film } from '../../../models/film';
import {ActivatedRoute} from '@angular/router';
import {PersonnagesProvider} from '../../../providers/personnagesProvider';
import {ActeursProvider} from '../../../providers/acteursProvider';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {

  film: Film;

  constructor(private route: ActivatedRoute, private filmsProvider: FilmsProvider, private personnagesProvider: PersonnagesProvider, private acteursProvider: ActeursProvider) { }

  ngOnInit() {
    this.getFilm();
  }

  getFilm() {
    const id = this.route.snapshot.paramMap.get('id');
    this.filmsProvider.getById(id).subscribe(film => {
      this.parseFilm(film);
    });
  }

  parseFilm(film: any) {
    const noFilm = film.noFilm;
    const titre = film.titre;
    const duree = film.duree;
    const dateSortie = film.dateSortie;
    const budget = film.budget;
    const montantRecette = film.montantRecette;
    const personnages = this.personnagesProvider.getByIdFilm(noFilm);
    this.filmsProvider.getCategorie(film._links.categorieByCodeCat.href).subscribe(categorie => {
      this.film = new Film(noFilm, titre, duree, dateSortie, budget, montantRecette, categorie, personnages);
    });
  }

}
