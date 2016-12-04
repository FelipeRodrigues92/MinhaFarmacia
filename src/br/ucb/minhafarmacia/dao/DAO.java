package br.ucb.minhafarmacia.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ucb.minhafarmacia.entidades.Usuario;
import br.ucb.minhafarmacia.util.JPAUtil;

	public class DAO<T>{
		private final Class<T> classe;
		public DAO(Class<T> classe){
			this.classe = classe;
		}
	EntityManager manager = new JPAUtil().getEntityManager();
	public void cadastrar(T t){
		manager.getTransaction().begin();
		manager.persist(t);		
		manager.getTransaction().commit();
		manager.close();
		
	}
	public void excluir(T t){
		manager.getTransaction().begin();
		manager.remove(manager.merge(t));		
		manager.getTransaction().commit();
		manager.close();
	}
	public void alterar(T t){
		manager.getTransaction().begin();
		manager.merge(t);		
		manager.getTransaction().commit();
		manager.close();
	}
//	public Medicacao consultar(Integer id){
//		manager.getTransaction().begin();
//		T t = manager.find(id);
//		manager.getTransaction().commit();
//		manager.close();
//		return t;
//	}
	public List<T> listar(){
//		List<T> usuarios = manager.createQuery("Select u from Usuarios u").getResultList();
//		manager.close();
		return  manager.createQuery("select object(u) from Usuario as u").getResultList();
	}
	
}
