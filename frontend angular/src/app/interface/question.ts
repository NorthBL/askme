import { logging } from 'protractor';
import { ICategory } from './category';
import { IUser } from './user';
import { IAnswer } from './answer';

export class IQuestion{
    public id: number;
    public user:IUser;
    public answers: Array<IAnswer>;
    public title: string;
    public description: string;
    public category: ICategory;

     constructor(){}

    //  setTitle(title: string){
    //      this.title=title;
    //  }

    //  setDescription(description: string){
    //     this.description=description;
    // }

    // setCatId(catId: number){
    //     this.category.setId(catId);
    // }


}