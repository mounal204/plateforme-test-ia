import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AiService } from '../../services/ai.service';
import { Router } from '@angular/router';


interface Question {

  id?: number;

  question: string;

  choixA: string;

  choixB: string;

  choixC: string;

  choixD: string;

  bonneReponse: string;

}




@Component({
  selector: 'app-qcm',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './qcm.html',
  styleUrl: './qcm.css'
})


export class QcmComponent implements OnInit {



  sujet:string = "";


  questions: Question[] = [];


  reponses: {[key:number]: string} = {};


  note:number|null = null;




  constructor(
  private aiService: AiService,
  private router: Router
){}
  ngOnInit() {

  const data = localStorage.getItem("questions");

  if (data) {

    this.questions = JSON.parse(data);

  }

}




  genererQcm(){


    this.aiService.generateQcm(this.sujet)

    .subscribe({

      next:(data:Question[])=>{


        console.log("Questions reçues :", data);


        this.questions = data;


        this.reponses = {};


        this.note = null;


      },


      error:(err)=>{


        console.log("Erreur API :", err);


      }


    });


  }





  choisirReponse(
    index:number,
    reponse:string
  ){


    this.reponses[index] = reponse;


  }






  envoyer() {

  const reponsesFormatees = this.questions.map(
    (question, index) => ({

      questionId: question.id,

      reponseChoisie: this.reponses[index]

    })
  );

  const resultat = {

    reponses: reponsesFormatees

  };

  console.log("Résultat envoyé :", resultat);

  this.aiService.corriger(resultat)

    .subscribe({

      next: (data: any) => {

  console.log("Correction :", data);

  this.note = data.note;

  localStorage.setItem(
    "resultat",
    JSON.stringify({
      note: data.note,
      questions: this.questions,
      reponses: this.reponses
    })
  );

  this.router.navigate(['/resultat']);

},

      error: (err) => {

        console.log("Erreur correction :", err);

      }

    });

}



}