package br.encontremanaus.control.mb;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.encontremanaus.model.bean.Local;
import br.encontremanaus.model.dao.JPAUtil;
import br.encontremanaus.model.dao.LocalDAO;
import br.encontremanaus.control.mb.LocalREL;

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
		EntityManager em = JPAUtil.getEntityManager();
		LocalDAO dao = new LocalDAO(em);
		listaLocals = dao.listar();
		em.close();
	}
	public void limpaFormulario(){
		this.local = new Local();
	}
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		LocalDAO dao = new LocalDAO(em);
		em.getTransaction().begin();
		dao.excluir(local);
		em.getTransaction().commit();
		em.close();
		carregarLocals();
	}
	
	
	public void gerar() {
		//System.out.println("ENTROUUU ");
		//for(int i=0 ;i<listaLocals.size();i++){
			//System.out.println("local "+listaLocals.get(i));
		//}
			
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
		LocalDAO dao = new LocalDAO(em);
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
