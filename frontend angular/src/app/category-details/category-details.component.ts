import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category.service';
import { IQuestion } from '../interface/question';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { ICategory } from '../interface/category';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit {

  categoryId: number;
  category: ICategory
  questions: Array<IQuestion>;

  constructor(private categoryService:CategoryService,private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap)=>{
      let id=parseInt(params.get('id'));
      this.categoryId=id;
      this.refreshData();
    });
  }

  refreshData(){
    this.categoryService.getCategoryQuestions(this.categoryId)
    .subscribe(
      (data) => {this.questions=data},
      (error) => {console.error("error!")}
    )

    this.categoryService.getCategoryById(this.categoryId)
    .subscribe(
      (data) => {this.category=data},
      (error) => {console.error("error!")}
    )
  }


}
