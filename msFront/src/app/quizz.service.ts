import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {map, Observable} from "rxjs";
import { QuizzModel } from "./model/Quizz.model";
import {Question} from "./model/Question.model";
import {Response} from "./model/Response.model";
@Injectable({
  providedIn: 'root'
})
export class QuizzService {
  //TODO change url with variables parameters
  private apiUrl = "http://localhost:8080/callSpRandQuestion?theme=1&level=1";

  constructor(private http:HttpClient) { }

  getQuizz(): Observable<QuizzModel[]> {
    return this.http.get<any[]>(this.apiUrl).pipe(
      map(data => this.transformQuizz(data))
    );
  }

  private transformQuizz(data: any[]): QuizzModel[] {
    const quizz: QuizzModel[] = [];
    const groupedQuestions = this.groupByQuestionId(data);

    groupedQuestions.forEach((responses) => {
      const groupData = responses[0];
      const question = new Question(groupData.id_question, groupData.question);
      // construction du tableau de Response associe a l'objet Question
      const responseList = responses.map(responseData => {
        return new Response(responseData.id_response, responseData.response, responseData.is_true === 1);
      });
      quizz.push(new QuizzModel(question, responseList));
    });

    return quizz;
  }

  private groupByQuestionId(data: any[]): Map<any, any[]> {
    const groupedData = new Map<any, any[]>();
    data.forEach(response => {
      const questionId = response.id_question;
      if (!groupedData.has(questionId)) {
        groupedData.set(questionId, []);
      }
      const groupedDataQuestionId = groupedData.get(questionId);
      if (Array.isArray(groupedDataQuestionId)) {
        groupedDataQuestionId.push(response);
      } else {
        console.error(`La valeur pour l'ID de question ${questionId} n'est pas un tableau.`);
      }
    });
    return groupedData;
  }

}
