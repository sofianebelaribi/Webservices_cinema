import {Categorie} from './categorie';
import {Personnage} from './personnage';
import {Acteur} from './acteur';

export class Film {
  constructor(public noFilm: number,
              public titre: string,
              public duree: number,
              public dateSortie: string,
              public budget: number,
              public montantRecette: number,
              public categorie: Categorie,
              public personnages: Personnage[]) { }
}
