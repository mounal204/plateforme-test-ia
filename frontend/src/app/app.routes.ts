import { Routes } from '@angular/router';

import { Login } from './pages/login/login';
import { Dashboard } from './pages/dashboard/dashboard';
import { QcmComponent } from './pages/qcm/qcm';
import { Resultat } from './pages/resultat/resultat';
export const routes: Routes = [

  { path: '', component: Login },

  { path: 'dashboard', component: Dashboard },

  { path: 'qcm', component: QcmComponent },

  { path: 'resultat', component: Resultat}

];