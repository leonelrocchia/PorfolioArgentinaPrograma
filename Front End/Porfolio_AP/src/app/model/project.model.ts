export class Project{
    pr_id?: number;
    pr_nombre: String;
    pr_cliente: String;
    pr_tipo: String;
    pr_descripcion: String;
    pr_img: String;
    pr_fecha: String;
    pr_link: String;

    constructor(pr_nombre: String, pr_cliente: String, pr_tipo: String, pr_descripcion: String, pr_img: String, pr_fecha: String, pr_link: String){
        this.pr_nombre = pr_nombre;
        this.pr_cliente = pr_cliente;
        this.pr_tipo = pr_tipo;
        this.pr_descripcion = pr_descripcion;
        this.pr_img = pr_img;
        this.pr_fecha = pr_fecha;
        this.pr_link = pr_link;
    }
}