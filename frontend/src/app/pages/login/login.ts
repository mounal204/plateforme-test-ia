import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AiService } from '../../services/ai.service';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  email: string = '';
  password: string = '';
  role: string = 'etudiant';

 constructor(
  private router: Router,
  private aiService: AiService
) {} 

  connecter() {

  const user = {
    email: this.email,
    password: this.password
  };

  this.aiService.login(user)
    .subscribe({

      next: (data:any) => {

        console.log(data);

        if(data.role === 'TEACHER'){
          this.router.navigate(['/dashboard']);
        }
        else if(data.role === 'STUDENT'){
          this.router.navigate(['/qcm']);
        }

      },

      error: () => {

        alert('Email ou mot de passe incorrect');

      }

    });

}

}

