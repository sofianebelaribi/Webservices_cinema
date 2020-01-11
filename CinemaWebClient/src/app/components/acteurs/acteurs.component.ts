import { Component, OnInit } from '@angular/core';
import {ActeursProvider} from '../../providers/acteursProvider';
import {Acteur} from '../../models/acteur';

@Component({
  selector: 'app-acteurs',
  templateUrl: './acteurs.component.html',
  styleUrls: ['./acteurs.component.css']
})
export class ActeursComponent implements OnInit {

  acteurs: Acteur[] = [];
  acteur: Acteur;
  validate: boolean;
  failed: boolean;

  constructor(private acteursProvider: ActeursProvider) { }

  autoIncrement(): number {
    let inc = 0;
    this.acteurs.forEach( acteur => {
       if (acteur.noAct > inc + 1) {
         return inc + 1;
       }
       inc = acteur.noAct;
    });
    return inc + 1;
  }

  init() {
    this.acteursProvider.getAll().subscribe(acteurs => {
      this.acteurs = acteurs;
      this.acteur = new Acteur(this.autoIncrement(), null, null, null, null);
    });
  }

  ngOnInit() {
    this.init();
  }

  delete(id: any) {
    this.acteursProvider.delete(id).subscribe(
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

  add(acteur: Acteur) {
    this.acteursProvider.add(acteur).subscribe(
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
