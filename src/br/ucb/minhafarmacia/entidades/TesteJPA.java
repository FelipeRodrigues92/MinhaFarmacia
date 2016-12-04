package br.ucb.minhafarmacia.entidades;

import javax.persistence.EntityManager;

import br.ucb.minhafarmacia.util.JPAUtil;



public class TesteJPA {

	
	public static void main(String[] args) {
		
		Usuario pessoa = new Usuario();
//		pessoa.setIdUsuario(6);
		pessoa.setNome("Minersfsva");

		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
	//	pessoa = manager.find(Pessoa.class, 7);
		manager.persist(pessoa);
//		pessoa = manager.find(Pessoa.class, 1);
//		pessoa.setNome("Ciclana");
//		System.out.println(pessoa.getNome());
		
		manager.getTransaction().commit();
		manager.close();
	}

}
