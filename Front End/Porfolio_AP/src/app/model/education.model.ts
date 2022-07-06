export class Education{
    ed_id?: number;
    ed_titulo: String;
    ed_institucion: String;
    ed_tipo: String;
    ed_descripcion: String;
    ed_img: String;
    ed_inicio: String;
    ed_final: String;

    constructor( ed_titulo: String, ed_institucion: String, ed_tipo: String, ed_descripcion: String, ed_img: String, ed_inicio: String, ed_final: String){
        this.ed_titulo = ed_titulo;
        this.ed_institucion = ed_institucion;
        this.ed_tipo = ed_tipo;
        this.ed_descripcion = ed_descripcion;
        this.ed_img = ed_img;
        this.ed_inicio = ed_inicio;
        this.ed_final = ed_final;
    }
}