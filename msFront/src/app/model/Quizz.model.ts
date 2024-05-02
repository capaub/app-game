import {Question} from "./Question.model";
import {Response} from "./Response.model";

export class QuizzModel {

  questionO: Question;
  responses: Response[];

  constructor(question: Question, responses: Response[]) {
    this.questionO = question;
    this.responses = responses;
  }

}
