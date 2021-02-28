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
  public guardar;
  public error;
  public mensajeError;

  constructor(public personaServicio:PersonaServicio) { }

  ngOnInit(): void {

  }

  public cambiarGuardar() {
    setTimeout(() => {
      this.guardar = false
    }, 4000);
  }

  public cambiarError() {
    setTimeout(() => {
      this.error = false
    }, 4000);
  }

  public setearError(error: boolean, mensaje: string) {
    this.error = error;
    this.mensajeError = mensaje;
  }

  guardarPersona() {
    

    let persona = new PersonaModel(this.nombresG, this.apellidosG, this.fechaG, this.cedulaG);
    console.log("persona", persona);
    this.personaServicio.guardarPersonas(persona).subscribe(
      suc => {
        if (suc["codigoHttp"] === 200) {
          this.guardar = true;
          this.cambiarGuardar();
        }else{
          this.setearError(true, suc["mensaje"]);
          console.log("error: ",this.error);
          this.cambiarError();
        }
      },
      err => {
        this.setearError(true, err.error.mensaje);
        console.log("error: ",this.error);
        this.cambiarError();
      }
    );
  }

}
