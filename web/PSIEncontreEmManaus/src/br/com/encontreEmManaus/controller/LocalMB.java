package br.com.encontreEmManaus.controller;


import java.util.ArrayList;



import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.encontreEmManaus.entity.Local;
import br.com.encontreEmManaus.util.JPAUtil;
import br.com.encontreEmManaus.dao.LocalDao;;



@ViewScoped// vinculada com a pag web escopo
@ManagedBean//
public class LocalMB {
	//Atributos devem ser iniciados
	private Local local = new Local();
	
	public Local getLocal() {
		return local;
	}
	
	public void setLocal(Local local) {
		this.local = local;
	}
	
	//Atributo que guarda a colecao locals armazenados em BD
	public List<Local> listaLocals = new ArrayList<Local>();
	
	public List<Local> getListaLocals() {
		return listaLocals;
	}	

	//Metodo invocado apos a classe ser carregada pelo servidor
	@PostConstruct
	public void carregarLocals(){
		EntityManager entityManagerFactory = JPAUtil.getEntityManager();
		LocalDao dao = new LocalDao(entityManagerFactory);
		listaLocals = dao.listar();
		entityManagerFactory.close();
	}
	public void limpaFormulario(){
		this.local = new Local();
	}
	public void excluir(){
		EntityManager entityManagerFactory = JPAUtil.getEntityManager();
		LocalDao dao = new LocalDao(entityManagerFactory);
		entityManagerFactory.getTransaction().begin();
		dao.excluir(local);
		entityManagerFactory.getTransaction().commit();
		entityManagerFactory.close();
		carregarLocals();
	}
	
	public void gerar() {
					
		LocalREL relatorio = new LocalREL();
		try {
		System.out.println("ENTROUUU ");
			relatorio.gerarRel(listaLocals);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void salvar(){
		EntityManager em = JPAUtil.getEntityManager();
		LocalDao dao = new LocalDao(em);
		em.getTransaction().begin();
		local.setDataCadastro(Calendar.getInstance());
		if(local.getId()!=null){
			dao.alterar(local);
		}else{
			dao.cadastrar(local);
		}
		em.getTransaction().commit();
		em.close();
		local  = new Local();
		carregarLocals();
	}
}
