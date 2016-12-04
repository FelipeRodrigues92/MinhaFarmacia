package br.ucb.minhafarmacia.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ucb.minhafarmacia.entidades.Medicacao;
import br.ucb.minhafarmacia.entidades.Usuario;
import br.ucb.minhafarmacia.util.JPAUtil;

public class MedicamentoDAO {
	EntityManager manager = new JPAUtil().getEntityManager();
	
	public void cadastrar(Medicacao medic){
		manager.getTransaction().begin();
		manager.persist(medic);		
		manager.getTransaction().commit();
		manager.close();
	}
//	public void excluir(Usuario user){
//		manager.getTransaction().begin();
//		manager.remove(user);		
//		manager.getTransaction().commit();
//		manager.close();
//	}
//	public void alterar(Usuario user){
//		manager.getTransaction().begin();
////		manager.find(Usuario.class, user.getIdUsuario());
//		manager.merge(user);
//		manager.getTransaction().commit();
//		manager.close();
//	}
//	
////	getConexao().getManager().getTransaction().begin();
////	getConexao().getManager().merge(user);
////	getConexao().getManager().getTransaction().commit();
////	getConexao().getManager().close();
//	public Usuario consultar(Integer id){
//		manager.getTransaction().begin();
//		Usuario user = manager.find(Usuario.class, id);
//		manager.getTransaction().commit();
//		manager.close();
//		return user;
//	}
//	public List<Usuario> listar(){
//		List<Usuario> usuarios = manager.createQuery("Select u from Usuarios").getResultList();
//		return usuarios;
//	}

}
