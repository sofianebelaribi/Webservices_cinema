import { Component, OnInit } from '@angular/core';
import { Realisateur } from '../../models/realisateur';
import { RealisateursProvider } from '../../providers/realisateursProvider';

@Component({
  selector: 'app-realisateurs',
  templateUrl: './realisateurs.component.html',
  styleUrls: ['./realisateurs.component.css']
})
export class RealisateursComponent implements OnInit {

  realisateur: Realisateur;
  realisateurs: Realisateur[];
  validate: boolean;
  failed: boolean;

  constructor(private realisateursProvider: RealisateursProvider) { }

  init() {
    this.realisateur = new Realisateur(null, null, null, null);
    this.realisateursProvider.getRealisateurs().subscribe(realisateurs => this.realisateurs = realisateurs);
  }

  ngOnInit() {
    this.init();
  }

  delete(id: any) {
    this.realisateursProvider.delete(id).subscribe(
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

  add(realisateur: Realisateur) {
    this.realisateursProvider.add(realisateur).subscribe(
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

}
