import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";
import { QuizzModel } from "./model/Quizz.model";
import { Question } from "./model/Question.model";
import { Response } from "./model/Response.model";
import { Label } from "./model/Label.model";

@Injectable({
  providedIn: 'root'
})

export class QuizzService {
  //TODO change url with variables parameters
  private getQuizzUrl = `http://localhost:8080/callSpRandQuestion`;
  private getLabelsUrl = "http://localhost:8080/getLabels";

  constructor(private http:HttpClient) { }

  getQuizz(themeId: number, levelId: number): Observable<QuizzModel[]> {
    const urlWithParameter = this.getQuizzUrl + `?theme=${themeId}&level=${levelId}`;
    console.log(urlWithParameter)
    return this.http.get<any[]>(urlWithParameter).pipe(
      map(data => this.transformQuizz(data))
    );
  }

  getLabels(): Observable<Label[]> {
    return this.http.get<any[]>(this.getLabelsUrl).pipe(
      map(data=>this.transformLabels(data))
    );
  }

  private transformLabels(data: any[]) {
    let labels:Label[] = [];
    data.forEach(response => {
      if (response.id_theme){
        const type = "theme";
        const label = response.label;
        const Id = response.id_theme;
        labels.push(new Label(Id,label,type));
      } else if(response.id_Level) {
        const type = "level";
        const label = response.label;
        const Id = response.id_Level;
        labels.push(new Label(Id,label,type));
      }
    })
    return labels;
  }

  private transformQuizz(jsonResponse: any[]): QuizzModel[] {
    let quizz: QuizzModel[] = [];

    // for each grouped data from json response => extract and create QuizzModel
    jsonResponse.forEach((data) => {
      const question: Question = new Question(data.id_question,data.question);
      let responseList: Response[] = [];
      const responsesId: number[] = data.id_responses.split(",");
      const responses: string[] = data.responses.split(",");

      for (let i = 0; i < responsesId.length; i++) {
        const isTrue: boolean = data.responseTrue == responsesId[i];
        responseList.push(new Response(responsesId[i], responses[i], isTrue));
      }

      quizz.push(new QuizzModel(question,responseList))
    })
    return quizz;
  }
}
