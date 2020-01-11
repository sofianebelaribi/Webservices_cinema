import { Component, OnInit } from '@angular/core';
import {Categorie} from '../../models/categorie';
import {CategorieProvider} from '../../providers/categorieProvider';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories: Categorie[];
  categorie: Categorie;
  validate: boolean;
  failed: boolean;

  constructor(private categorieProvider: CategorieProvider) { }

  init() {
    this.categorieProvider.getAll().subscribe(categories => this.categories = categories);
    this.categorie = new  Categorie(null, null, 'https://medias.unifrance.org/medias/46/242/127534/format_page/media.png');
  }

  ngOnInit() {
    this.init();
  }

  delete(id: any) {
    this.categorieProvider.delete(id).subscribe(
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

  add(categorie: Categorie) {
    this.categorieProvider.add(categorie).subscribe(
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
