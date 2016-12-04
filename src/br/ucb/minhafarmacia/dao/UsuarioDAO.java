package br.ucb.minhafarmacia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.ucb.minhafarmacia.entidades.Usuario;
import br.ucb.minhafarmacia.util.JPAUtil;

public class UsuarioDAO {
	EntityManager manager = new JPAUtil().getEntityManager();
	
	public void cadastrar(Usuario user){
		manager.getTransaction().begin();
		manager.persist(user);		
		manager.getTransaction().commit();
		manager.close();
	}
	public void excluir(Usuario user){
		manager.getTransaction().begin();
		manager.remove(user);		
		manager.getTransaction().commit();
		manager.close();
	}
	public void alterar(Usuario user){
		manager.getTransaction().begin();
//		manager.find(Usuario.class, user.getIdUsuario());
		manager.merge(user);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public Usuario fazLogin(String email, String senha){
		manager.getTransaction().begin();
		String jpql = "select u from Usuario u where u.email = ?1 and u.senha = ?2";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, senha);
		
		try{
			Usuario user = (Usuario) query.getSingleResult();
			return user;
		}catch (NoResultException e) {
			return null;
		}finally {
			manager.close();
		}
	}
	
	public Usuario consultar(Integer id){
		manager.getTransaction().begin();
		Usuario user = manager.find(Usuario.class, id);
		manager.getTransaction().commit();
		manager.close();
		return user;
	}
	public Usuario buscaDadosUsuario(String email){
		manager.getTransaction().begin();
		String jpql = "Select u from Usuario u where u.email = ?1";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, email);
		try{
			Usuario user = (Usuario) query.getSingleResult();
			return user;
		}catch (NoResultException e) {
			return null;
		}finally {
			manager.close();
		}
	}
	public List<Usuario> listar(){
		List<Usuario> usuarios = manager.createQuery("Select u from Usuarios").getResultList();
		return usuarios;
	}

}
