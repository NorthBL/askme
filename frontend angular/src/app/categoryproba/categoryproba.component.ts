import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category',
  templateUrl: './categoryproba.component.html',
  styleUrls: ['./categoryproba.component.css']
})
export class CategoryprobaComponent implements OnInit {

  public categories=[];

  constructor( private _categoryService: CategoryService,private router: Router) { }

  ngOnInit() {
    this._categoryService.getCat()
    .subscribe(data => this.categories=data);
  }

  onSelect(category){
    this.router.navigate(['category',category.id]);
    
    // this._categoryService.getCategoryQuestions(category.id)
    // .subscribe((data) => data)
}

}
