import { IUserRole } from './userrole';
import { IQuestion } from './question';
import { IAnswer } from './answer';

export class IUser{
    public id:number;
    public username: string;
    public password: string;
    public userRole: IUserRole;
    public questions: Array<IQuestion>;
    public answers: Array<IAnswer>;
    public firstName: string;
    public lastName: string;
    public profileImgUrl: string;
    public profileDescription: string;

    constructor(){}
}