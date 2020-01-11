import { NgModule } from '@angular/core';
import {RouterModule, Route, Router} from '@angular/router';
import { FilmsComponent } from './components/films/films.component';
import { RealisateursComponent } from './components/realisateurs/realisateurs.component';
import {PersonnagesComponent} from './components/personnages/personnages.component';
import {FilmComponent} from './components/films/film/film.component';
import {RealisateurComponent} from './components/realisateurs/realisateur/realisateur.component';
import {CategoriesComponent} from './components/categories/categories.component';
import {ActeursComponent} from './components/acteurs/acteurs.component';
import {ActeurComponent} from './components/acteurs/acteur/acteur.component';


const routes: Route[] = [
  {path: 'films', component: FilmsComponent},
  {path: 'film/:id', component: FilmComponent},
  {path: 'realisateurs', component: RealisateursComponent},
  {path: 'realisateur/:id', component: RealisateurComponent},
  {path: 'personnages', component: PersonnagesComponent},
  {path: 'categories', component: CategoriesComponent},
  {path: 'acteurs', component: ActeursComponent},
  {path: 'acteur/:id', component: ActeurComponent}
];


@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class AppRoutingModule { }
