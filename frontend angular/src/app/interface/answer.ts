import { IQuestion } from './question';
import { IUser } from './user';
import { IVote } from './vote';

export class IAnswer{
    public id: number;
    public description: string;
    public question: IQuestion;
    public user:IUser;
    public votes: Array<IVote>;
    constructor(){}
}