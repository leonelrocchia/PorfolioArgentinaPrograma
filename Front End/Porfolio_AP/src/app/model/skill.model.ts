export class Skill{
    sk_id?: number;
    sk_nombre: String;
    sk_nivel: number;


    constructor(sk_nombre: String, sk_nivel: number){
        this.sk_nombre = sk_nombre;
        this.sk_nivel = sk_nivel;
    }
}