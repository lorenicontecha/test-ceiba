import { Component, OnInit } from '@angular/core';
import { PersonaServicio } from '../Servicios/persona-servicios';

@Component({
  selector: 'app-persona-listar',
  templateUrl: './persona-listar.component.html',
  styleUrls: ['./persona-listar.component.css']
})
export class PersonaListarComponent implements OnInit {

  arregloPersona: any = [];
  constructor( public personaServicio:PersonaServicio) {

   }

  ngOnInit(): void {
    this.getPersonas();
  }

  getPersonas() {
    this.personaServicio.getPersonas().subscribe(
      suc => {
        this.arregloPersona = suc.objetoRespuesta;
      },
      err => {
        console.log(err);
      }
    );
  }
  
}
