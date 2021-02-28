export class PersonaModel {
    nombre:any;
    apellido:any;
    fecha:any;
    cedula:any;

    constructor(nombre:string, apellido:string, fecha:string, cedula:string){

        this.nombre = nombre;
        this.apellido=apellido;
        this.fecha=fecha;
        this.cedula=cedula;
    }
}