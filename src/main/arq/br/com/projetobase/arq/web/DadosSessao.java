package br.com.projetobase.arq.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import org.hsqldb.User;

@SessionScoped
public class DadosSessao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	User usuario;

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
}
