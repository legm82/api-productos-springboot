package com.enrique.primerapractica.dto;

public class ResponseDTO<T> {
    private String estado;
    private String mensaje;
    private T data;

    public ResponseDTO(String estado, String mensaje, T data) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.data = data;
    }

    public String getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public T getData() {
        return data;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setData(T data) {
        this.data = data;
    }
}
