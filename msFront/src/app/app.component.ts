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
  index: number= 0;
  point: number= 0;
  resp: { questionId:any; question:any; responseId:any; response:any; } | undefined

  displayProfile:boolean=false;
  displayGame:boolean=false;
  displayScoreBoard:boolean=false;


  constructor(private quizzService:QuizzService) { }

  ngOnInit() { }

  showQuizz(){
    this.displayProfile = this.displayScoreBoard = false
    this.displayGame = true
    this.quizzService.getQuizz()
      .subscribe((list: QuizzModel[])=> {
        this.quizzModels = list;
      });
  }

  public countPoint(responseId: number,quizz:QuizzModel) {
    const response = quizz.responses.find(response => response.id == responseId)
    if (response?.isTrue){
      this.point += 1;
    }
  }

  showProfile() {
    this.displayGame = this.displayScoreBoard = false
    this.displayProfile = true
  }

  showScoreBoard() {
    this.displayGame = this.displayProfile = false
    this.displayScoreBoard = true
  }
}
