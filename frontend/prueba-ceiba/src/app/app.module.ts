import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonaComponent } from './persona/persona.component';
import { PersonaCrearComponent } from './persona-crear/persona-crear.component';
import { RouterModule, Routes } from '@angular/router';
import { PersonaListarComponent } from './persona-listar/persona-listar.component';
import { DpDatePickerModule } from 'ng2-date-picker';
import { PersonaServicio } from './Servicios/persona-servicios';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

const routes: Routes = [
  { path: 'crear', component: PersonaCrearComponent, pathMatch: 'full' },
  { path: 'listar', component: PersonaListarComponent, pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    PersonaComponent,
    PersonaCrearComponent,
    PersonaListarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
    DpDatePickerModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PersonaServicio],
  bootstrap: [AppComponent]
})
export class AppModule { }
