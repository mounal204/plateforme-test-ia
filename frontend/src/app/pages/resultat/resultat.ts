import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-resultat',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './resultat.html',
  styleUrl: './resultat.css'
})
export class Resultat implements OnInit {

  note: number = 0;

  mention: string = '';

  questions: any[] = [];

  reponses: any = {};

  constructor(private router: Router) {}

  ngOnInit() {

    const data = localStorage.getItem('resultat');

    if (data) {

      const resultat = JSON.parse(data);

      this.note = resultat.note;

      this.questions = resultat.questions;

      this.reponses = resultat.reponses;

      if (this.note >= 16) {
        this.mention = 'Excellent';
      }
      else if (this.note >= 12) {
        this.mention = 'Bien';
      }
      else if (this.note >= 10) {
        this.mention = 'Passable';
      }
      else {
        this.mention = 'Insuffisant';
      }

    }

  }

  retourConnexion() {

    localStorage.removeItem('questions');
    localStorage.removeItem('resultat');

    this.router.navigate(['/']);

  }

}
