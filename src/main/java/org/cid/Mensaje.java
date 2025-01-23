package org.cid;

public class Mensaje {

    private String idMensaje;
    private String mensaje;
    private String autorMensaje;
    private String fechaMensaje;

    public Mensaje(){}

    public Mensaje(String mensaje, String autorMensaje, String fechaMensaje) {
        this.mensaje = mensaje;
        this.autorMensaje = autorMensaje;
        this.fechaMensaje = fechaMensaje;
    }

    public String getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(String idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutorMensaje() {
        return autorMensaje;
    }

    public void setAutorMensaje(String autorMensaje) {
        this.autorMensaje = autorMensaje;
    }

    public String getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(String fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "idMensaje='" + idMensaje + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", autorMensaje='" + autorMensaje + '\'' +
                ", fechaMensaje='" + fechaMensaje + '\'' +
                '}';
    }
}
