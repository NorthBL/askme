import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContentComponent } from './content/content.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { CategoryprobaComponent } from './categoryproba/categoryproba.component';
import { RegisterComponent } from './register/register.component';
import { AddQuestionComponent } from './add-question/add-question.component';
import { ListQuestionsComponent } from './list-questions/list-questions.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { QuestionDetailsComponent } from './question-details/question-details.component';
import { CategoryDetailsComponent } from './category-details/category-details.component';
import { UserDetailsComponent } from './user-details/user-details.component';

const routes: Routes = [
  { path: '',redirectTo: 'content', pathMatch: 'full'},
  {path: 'categories', component: CategoryprobaComponent},
  {path: 'listquestions', component: ListQuestionsComponent},
  {path: 'question/:id', component: QuestionDetailsComponent},
  {path: 'category/:id', component: CategoryDetailsComponent},
  {path: 'user/:id', component: UserDetailsComponent},
  {path: 'addquestion', component: AddQuestionComponent},
  {path: 'register', component:RegisterComponent },
  {path: 'content', component: ContentComponent},
  {path: 'footer', component:FooterComponent},
  {path: 'login', component:LoginComponent},
  {path: 'profile', component:ProfileComponent},
  {path: '**', component: PagenotfoundComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[ContentComponent,FooterComponent,QuestionDetailsComponent,LoginComponent,ProfileComponent,CategoryprobaComponent,ListQuestionsComponent,PagenotfoundComponent,CategoryDetailsComponent,UserDetailsComponent]
