import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { QuizzComponent } from './quizz/quizz.component';
import {HttpClientModule} from "@angular/common/http";
import {QuizzService} from "./quizz.service";
import { ProfilComponent } from './profil/profil.component';
import { ScoreBoardComponent } from './score-board/score-board.component';

@NgModule({
  declarations: [
    AppComponent,
    QuizzComponent,
    ProfilComponent,
    ScoreBoardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [QuizzService],
  bootstrap: [AppComponent]
})
export class AppModule { }
