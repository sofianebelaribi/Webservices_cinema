import { Component, OnInit } from '@angular/core';
import {RealisateursProvider} from '../../../providers/realisateursProvider';
import {Realisateur} from '../../../models/realisateur';
import {ActivatedRoute} from '@angular/router';
import {Film} from '../../../models/film';
import {FilmsProvider} from '../../../providers/filmsProvider';

@Component({
  selector: 'app-realisateur',
  templateUrl: './realisateur.component.html',
  styleUrls: ['./realisateur.component.css']
})
export class RealisateurComponent implements OnInit {

  realisateur: Realisateur;

  constructor(private route: ActivatedRoute, private realisateursProvider: RealisateursProvider, private filmsProvider: FilmsProvider) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.realisateursProvider.getById(id).subscribe(realisateur => {
      this.parseRealisateur(realisateur);
    });
  }

  parseRealisateur(realisateur: any) {
    const noRea = realisateur.noRea;
    const nomRea = realisateur.nomRea;
    const prenRea = realisateur.prenRea;
    const films = this.filmsProvider.getByIdRea(noRea);
    this.realisateur = new Realisateur(noRea, nomRea, prenRea, films);
  }

}
