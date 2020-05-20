import { IUser } from './user';
import { IAnswer } from './answer';

export interface IVote{
    id: number,
    user: IUser,
    answer: IAnswer,
    positive: boolean
}