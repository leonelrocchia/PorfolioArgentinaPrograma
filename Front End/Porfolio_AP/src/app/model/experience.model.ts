export class Experience{
    ex_id?: number;
    ex_puesto: String;
    ex_empresa: String;
    ex_tipo: String;
    ex_descripcion: String;
    ex_img: String;
    ex_inicio: String;
    ex_final: String;

    constructor( ex_puesto: String, ex_empresa: String, ex_tipo: String, ex_descripcion: String, ex_img: String, ex_inicio: String, ex_final: String){
        this.ex_puesto = ex_puesto;
        this.ex_empresa = ex_empresa;
        this.ex_tipo = ex_tipo;
        this.ex_descripcion = ex_descripcion;
        this.ex_img = ex_img;
        this.ex_inicio = ex_inicio;
        this.ex_final = ex_final;
    }
}