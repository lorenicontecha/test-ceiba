import { Component, OnInit } from '@angular/core';
import {DpDatePickerModule} from 'ng2-date-picker';
import { PersonaModel } from '../Modelo/persona.model';
import { PersonaServicio } from '../Servicios/persona-servicios';


@Component({
  selector: 'app-persona-crear',
  templateUrl: './persona-crear.component.html',
  styleUrls: ['./persona-crear.component.css']
})
export class PersonaCrearComponent implements OnInit {


  public cedulaG;
  public nombresG;
  public apellidosG;
  public fechaG;

  constructor(public personaServicio:PersonaServicio) { }

  ngOnInit(): void {

  }

  guardarPersona() {
    

    let persona = new PersonaModel(this.nombresG, this.apellidosG, this.fechaG, this.cedulaG);
    console.log("persona", persona);
    this.personaServicio.guardarPersonas(persona).subscribe(
      suc => {
        if (suc["codigoHttp"] === 200) {
          console.log("Bien");
        }
      },
      err => {
        console.log(err);
      }
    );
  }

}
