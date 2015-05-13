package br.com.encontreEmManaus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.encontreEmManaus.entity.Usuario;
import br.com.encontreEmManaus.util.JPAUtil;


public class UsuarioDao extends AbstractDao<Usuario> {
	
	public UsuarioDao(Usuario usuario) {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	
	
	
	
	public boolean existe(Usuario usuario){
		boolean resultado = false;
		EntityManager entityManagerFactory = new JPAUtil().getEntityManager();
		entityManagerFactory.getTransaction().begin();
		String hql = "select u from Usuario u where u.nome='"+usuario.getNome()+
				"' and u.senha='"+usuario.getSenha()+"'";
		Query query =entityManagerFactory.createQuery(hql);
		resultado = !query.getResultList().isEmpty();
		entityManagerFactory.getTransaction().commit();
		entityManagerFactory.close();
		return resultado;
	}
	
	private EntityManager entityManager;
	
	public Usuario consultar(Long id){
		return entityManager.getReference(Usuario.class, id);
	}
	
	public List<Usuario> listar(){
		String jpql = "Select u from Usuario u order by id";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	
	
	
	
	

}
