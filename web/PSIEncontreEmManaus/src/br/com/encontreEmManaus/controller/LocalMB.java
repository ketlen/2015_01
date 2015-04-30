package br.com.encontreEmManaus.controller;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import java.util.ArrayList;
import java.util.List;

import br.com.encontreEmManaus.dao.LocalDao;
import br.com.encontreEmManaus.entity.Local;
import br.com.encontreEmManaus.controller.LocalREL;
import br.com.encontreEmManaus.entity.Local;
import br.com.encontreEmManaus.util.JPAUtil;

@ManagedBean
@ViewScoped
public class LocalMB {

	private List<Local> locals;
	private Local local;

	public LocalMB() {
		locals = new ArrayList<Local>();
		local = new Local();
		listar();
	}
	
	

	public List<Local> getLocals() {
		return locals;
	}

	public void setLocals(List<Local> locals) {
		this.locals = locals;
	}

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

	public void salvar() {
		try {
			LocalDao dao = new LocalDao();
			if(local.getId() == null) {
				dao.salvar(local);
				this.local = new Local();
			} else {
				dao.editar(local);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		listar();
		
}

	
	
	public void gerar() {
		
		LocalREL relatorio = new LocalREL();
		try {
		System.out.println("ENTROUUU ");
			relatorio.gerarRel(listaLocals);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ENTROUUU11111 ");
		}

	}
	
	
	
	
	
	public void deletar() {
		
		try{
		LocalDao dao = new LocalDao();
		dao.excluir(local);
		this.local = new Local();
		}catch(Exception e){
			e.printStackTrace();
		}
		listar();
	}
	

	public void listar() {
		try{
		LocalDao dao = new LocalDao();
		locals = dao.listar();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	

}
