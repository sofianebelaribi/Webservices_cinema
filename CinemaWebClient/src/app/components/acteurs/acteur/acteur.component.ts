import { Component, OnInit } from '@angular/core';
import {ActeursProvider} from '../../../providers/acteursProvider';
import {ActivatedRoute} from '@angular/router';
import {Acteur} from '../../../models/acteur';

@Component({
  selector: 'app-acteur',
  templateUrl: './acteur.component.html',
  styleUrls: ['./acteur.component.css']
})
export class ActeurComponent implements OnInit {
  acteur: Acteur;

  constructor(private route: ActivatedRoute, private acteursProvider: ActeursProvider) { }

  ngOnInit() {
    this.getActeur();
  }

  getActeur() {
    const id = this.route.snapshot.paramMap.get('id');
    this.acteursProvider.getById(id).subscribe(acteur => {
      this.acteur = acteur;
    });
  }
}
