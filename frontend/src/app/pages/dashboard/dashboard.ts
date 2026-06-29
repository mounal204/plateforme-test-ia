import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AiService } from '../../services/ai.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class Dashboard {

  sujet:string = '';

  questions:any[] = [];

  
constructor(
  private aiService: AiService,
  private router: Router
){}
  ouvrirEvaluation() {

  localStorage.setItem(
    "questions",
    JSON.stringify(this.questions)
  );

  alert("Évaluation ouverte pour les étudiants");

  this.router.navigate(['/']);

}

  genererQcm(){

    this.aiService.generateQcm(this.sujet)
      .subscribe({

        next:(data:any[])=>{

          this.questions = data;

        },

        error:(err)=>{

          console.log(err);

        }

      });

  }

}