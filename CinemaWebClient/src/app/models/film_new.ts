import {Categorie} from './categorie';

export class FilmNew {
  constructor(public noFilm: number,
              public titre: string,
              public duree: number,
              public dateSortie: Date,
              public budget: number,
              public montantRecette: number,
              public noRea: number,
              public categorieByCodeCat: Categorie) { }
}
