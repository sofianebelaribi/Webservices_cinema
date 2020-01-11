import { Component, OnInit } from '@angular/core';
import { FilmsProvider } from '../../providers/filmsProvider';
import { Film } from '../../models/film';
import {FilmNew} from '../../models/film_new';
import {RealisateursProvider} from '../../providers/realisateursProvider';
import {Realisateur} from '../../models/realisateur';
import {Categorie} from '../../models/categorie';
import {CategorieProvider} from '../../providers/categorieProvider';

@Component({
  selector: 'app-films',
  templateUrl: './films.component.html',
  styleUrls: ['./films.component.css']
})
export class FilmsComponent implements OnInit {

  film: FilmNew;
  realisateurs: Realisateur[] = [];
  categories: Categorie[] = [];
  films: Film[] = [];

  validate: boolean;
  failed: boolean;

  constructor(private filmsProvider: FilmsProvider, private realisateursProvider: RealisateursProvider, private categoriesProvider: CategorieProvider) { }

  autoIncrement(): number {
    let inc = 0;
    this.films.forEach( film => {
      if (film.noFilm > inc + 1) {
        return inc + 1;
      }
      inc = film.noFilm;
    });
    return inc + 1;
  }

  init() {
    this.films = [];
    this.filmsProvider.getAll().subscribe(films => {
      this.parseFilms(films);
    });
    this.realisateursProvider.getRealisateurs().subscribe(realisateurs => {
      this.realisateurs = realisateurs;
    });
    this.categoriesProvider.getAll().subscribe(categories => {
      this.categories = categories;
    });
    this.film = new FilmNew(this.autoIncrement(), null, null, null, null, null, null, null);
  }

  ngOnInit() {
    this.init();
  }

  parseFilms(films: any) {
    films.forEach((film) => {
      const noFilm = film.noFilm;
      const titre = film.titre;
      const duree = film.duree;
      const dateSortie = film.dateSortie;
      const budget = film.budget;
      const montantRecette = film.montantRecette;
      this.filmsProvider.getCategorie(film._links.categorieByCodeCat.href).subscribe(categorie => {
        this.films.push(new Film(noFilm, titre, duree, dateSortie, budget, montantRecette, categorie, null));
      });
    });
  }

  delete(id: any) {
    this.filmsProvider.delete(id).subscribe(
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
      });
  }

  add(film: Film) {
    this.filmsProvider.add(film).subscribe(
      () => {
        this.validate = true;
        this.failed = null;

        console.log(this.film);
        console.log('Success');
      },
      () => {
        this.validate = null;
        this.failed = true;

        console.log(this.film);
        console.log('Failed');
      },
      () => {
        this.init();
      }
    );
  }

}
