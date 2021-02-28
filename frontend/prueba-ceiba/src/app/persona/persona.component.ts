import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit {

  public activeListar: any;
  public activeCrear: any;

  constructor(private _router: Router) {
    
   }

  ngOnInit(): void {
  }

  listar(){
    this.resetActive();
    this.activeListar = true;
    this._router.navigate(['listar']);
  }

  crear(){
    this.resetActive();
    this.activeCrear = true;
    this._router.navigate(['crear']);
  }
  
  resetActive(){
    this.activeCrear = false;
    this.activeListar = false;
  }

}
