package com.prueba.ceiba.model;

import java.io.Serializable;

public class Respuesta implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigoHttp;
	private String mensaje;
	private Object objetoRespuesta;

	public Respuesta(int codigoHttp, String mensaje, Object objetoRespuesta) {
		this.codigoHttp = codigoHttp;
		this.mensaje = mensaje;
		this.objetoRespuesta = objetoRespuesta;
	}

	public int getCodigoHttp() {
		return codigoHttp;
	}

	public void setCodigoHttp(int codigoHttp) {
		this.codigoHttp = codigoHttp;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getObjetoRespuesta() {
		return objetoRespuesta;
	}

	public void setObjetoRespuesta(Object objetoRespuesta) {
		this.objetoRespuesta = objetoRespuesta;
	}

}
