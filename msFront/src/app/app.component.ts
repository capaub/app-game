import { Component, OnInit } from '@angular/core';
import { QuizzModel } from "./model/Quizz.model";
import { QuizzService } from "./quizz.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  quizzModels!: QuizzModel[];
  index= 0;
  resp: { questionId:any; question:any; responseId:any; response:any; } | undefined
  constructor(private quizzService:QuizzService) {
  }

  ngOnInit() { }

  showQuizz(){
    this.quizzService.getQuizz()
      .subscribe((list: any) => {
        this.quizzModels = list;
      });
  }
}
