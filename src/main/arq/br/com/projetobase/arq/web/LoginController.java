package br.com.projetobase.arq.web;

import org.hsqldb.User;

import br.com.caelum.vraptor.Controller;

@Controller
public class LoginController extends AbstractController {

	public void login(User usuario) {
		dadosSessao.setUsuario(usuario);
	}
	
	public void form() {

	}

}
