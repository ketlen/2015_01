package br.encontremanaus.model.dao;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.encontremanaus.model.bean.Local;
@SuppressWarnings("unchecked")
public class LocalDAO {

	private EntityManager entityManager;
	
	public LocalDAO(EntityManager entityManager) {
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
	public List<Local> gerarRelatorio(String data){
		String jpql = "Select p from Local p where p.nome='Maria' order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
