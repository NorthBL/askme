import { IQuestion } from './question';

export class ICategory{
    public id: number;
    public name: string;
    public questions: Array<IQuestion>;

constructor(){}
}