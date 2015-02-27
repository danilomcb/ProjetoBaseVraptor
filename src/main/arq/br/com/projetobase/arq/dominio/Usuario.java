package br.com.projetobase.arq.dominio;

import javax.persistence.Table;

@Table
public class Usuario extends AbstractEntity {
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object objeto) {
		return super.equals(objeto);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}