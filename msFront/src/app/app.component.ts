import { Component, OnInit } from '@angular/core';
import { QuizzModel } from "./model/Quizz.model";
import { QuizzService } from "./quizz.service";
import { Label } from "./model/Label.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  quizzModels!: QuizzModel[];
  labels!: Label[];
  index: number= 0;
  point: number= 0;
  resp: { questionId:any; question:any; responseId:any; response:any; } | undefined

  displayProfile:boolean=false;
  displayScoreBoard:boolean=false;

  displayGame:boolean=false;
  chooseYourTheme:boolean=false;
  chooseYourLevel:boolean=false;

  themeId!:number;
  levelId!:number;

  constructor(private quizzService:QuizzService) { }

  ngOnInit() { }

  showQuizz(){
    this.displayProfile = this.displayScoreBoard =  this.chooseYourTheme = this.chooseYourLevel = false
    this.displayGame = true
    this.quizzService.getQuizz(this.themeId, this.levelId)
      .subscribe((list: QuizzModel[])=> {
        this.quizzModels = list;
      });
  }

  getLabels(){
    this.displayProfile = this.displayScoreBoard =  this.displayGame = this.chooseYourLevel = false
    this.chooseYourTheme = true
    this.quizzService.getLabels()
    .subscribe((list: Label[]) => {
      this.labels = list;
    });
  }

  public countPoint(responseId: number,quizz:QuizzModel) {
    const response = quizz.responses.find(response => response.id == responseId)
    if (response?.isTrue){
      this.point += 1;
    }
  }

  showProfile() {
    this.displayScoreBoard = this.displayGame =  this.chooseYourTheme = this.chooseYourLevel = false
    this.displayProfile = true
  }

  showScoreBoard() {
    this.displayProfile = this.displayGame =  this.chooseYourTheme = this.chooseYourLevel = false
    this.displayScoreBoard = true
  }

  chosenTheme(event: Event) {
    let themeElt = event.currentTarget as HTMLElement;
    this.chooseYourTheme = false
    this.chooseYourLevel = true
    // @ts-ignore
    this.themeId = parseInt(themeElt.getAttribute("data-themeId"));
  }

  chosenLevel(event: Event) {
    let levelElt = event.currentTarget as HTMLElement;
    this.chooseYourLevel = false
    // @ts-ignore
    this.levelId = parseInt(levelElt.getAttribute("data-levelId"));
    this.showQuizz();
  }
}
