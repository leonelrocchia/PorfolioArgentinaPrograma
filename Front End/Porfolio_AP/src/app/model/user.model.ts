export class User{
    us_id?: number;
    us_nombre: String;
    us_apellido: String;
    us_img: String;
    us_titulo: String;
    us_descripcion: String;

    constructor(us_nombre: String, us_apellido: String, us_img: String, us_titulo: String, us_descripcion: String){
        this.us_nombre = us_nombre;
        this.us_apellido = us_apellido;
        this.us_img = us_img;
        this.us_titulo = us_titulo;
        this.us_descripcion = us_descripcion;
    }
}