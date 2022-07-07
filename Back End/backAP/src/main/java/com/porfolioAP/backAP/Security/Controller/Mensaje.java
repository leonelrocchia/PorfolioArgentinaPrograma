package com.porfolioAP.backAP.Security.Controller;

public class Mensaje {
    private String mensaje;

    //Constructores

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //Getter & Setter

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
