package br.ucb.minhafarmacia.teste;

import br.ucb.minhafarmacia.dao.UsuarioDAO;
import br.ucb.minhafarmacia.entidades.Usuario;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario u = new UsuarioDAO().buscaDadosUsuario("kleiton@gmail.com");
		System.out.println("->"+u.getNome());
		System.out.println("-->"+u.getMedicacoes().size());
	}

}
