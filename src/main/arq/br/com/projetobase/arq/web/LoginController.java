package br.com.projetobase.arq.web;

import br.com.caelum.vraptor.Controller;
import br.com.projetobase.dominio.Usuario;

@Controller
public class LoginController extends AbstractController {

	public void login(Usuario usuario) {
		dadosSessao.setUsuario(usuario);
	}
	
	public void form() {
	}

}
