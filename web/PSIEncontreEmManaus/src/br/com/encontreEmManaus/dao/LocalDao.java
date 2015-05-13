package br.com.encontreEmManaus.dao;

import br.com.encontreEmManaus.entity.Local;


import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.encontreEmManaus.entity.Local;
@SuppressWarnings("unchecked")
public class LocalDao {

	private EntityManager entityManager;
	
	public LocalDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Local local){
		entityManager.persist(local);
	}
	public void alterar(Local local){
		entityManager.merge(local);
	}
	public void excluir(Local local){
		entityManager.remove(entityManager.merge(local));
	}
	
	public Local consultar(Long id){
		return entityManager.getReference(Local.class, id);
	}
	
	public List<Local> listar(){
		String jpql = "Select p from Local p order by id";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}

