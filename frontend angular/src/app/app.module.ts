import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { ProfileComponent } from './profile/profile.component';
import {HttpClientModule} from '@angular/common/http';
import { CategoryprobaComponent } from './categoryproba/categoryproba.component';
import { RegisterComponent } from './register/register.component';
import { CategoryService } from './category.service';
import { AddQuestionComponent } from './add-question/add-question.component';
import { QuestionService } from './question.service';
import { AnswserService } from './answser.service';
import { AddAnswerComponent } from './add-answer/add-answer.component';
import { ListQuestionsComponent } from './list-questions/list-questions.component';
import { QuestionDetailsComponent } from './question-details/question-details.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ListAnswersComponent } from './list-answers/list-answers.component';
import { CookieService } from 'ngx-cookie-service';
import { CategoryDetailsComponent } from './category-details/category-details.component';
import { UserDetailsComponent } from './user-details/user-details.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    routingComponents,
    ProfileComponent,
    CategoryprobaComponent,
    RegisterComponent,
    AddQuestionComponent,
    AddAnswerComponent,
    ListQuestionsComponent,
    QuestionDetailsComponent,
    PagenotfoundComponent,
    ListAnswersComponent,
    CategoryDetailsComponent,
    UserDetailsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CategoryService,QuestionService,AnswserService,CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
