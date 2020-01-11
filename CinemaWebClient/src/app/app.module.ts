import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpModule } from '@angular/http';


import { AppComponent } from './app.component';
import { FilmsComponent } from './components/films/films.component';

import { FilmsProvider } from './providers/filmsProvider';
import { RealisateursComponent } from './components/realisateurs/realisateurs.component';
import {RealisateursProvider} from './providers/realisateursProvider';
import { PersonnagesComponent } from './components/personnages/personnages.component';
import {PersonnagesProvider} from './providers/personnagesProvider';
import { ActeursComponent } from './components/acteurs/acteurs.component';
import { FilmComponent } from './components/films/film/film.component';
import { RealisateurComponent } from './components/realisateurs/realisateur/realisateur.component';
import { CategoriesComponent } from './components/categories/categories.component';
import {CategorieProvider} from './providers/categorieProvider';
import {ActeursProvider} from './providers/acteursProvider';
import { ActeurComponent } from './components/acteurs/acteur/acteur.component';
import {FormsModule} from '@angular/forms';
import {DataTablesModule} from 'angular-datatables';


@NgModule({
  declarations: [
    AppComponent,
    FilmsComponent,
    RealisateursComponent,
    PersonnagesComponent,
    ActeursComponent,
    FilmComponent,
    RealisateurComponent,
    CategoriesComponent,
    ActeurComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    DataTablesModule
  ],
  providers: [
    FilmsProvider,
    RealisateursProvider,
    PersonnagesProvider,
    CategorieProvider,
    ActeursProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
