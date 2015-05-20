package br.com.encontreEmManaus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.encontreEmManaus.dao.ComentarioDao;
import br.com.encontreEmManaus.dao.UsuarioDao;
import br.com.encontreEmManaus.entity.Comentario;
import br.com.encontreEmManaus.entity.Usuario;

@ManagedBean
@ViewScoped
public class ComentarioMB {

	private static final long serialVersionUID = 1L;
	private List<Comentario> comentarios;
	private Comentario comentario;
	
	public ComentarioMB() {
		comentarios = new ArrayList<Comentario>();
		comentario = new Comentario();
		listar();
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public Comentario getComentario() {
		return comentario;
	}
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	
	public void salvar() {
		try {
			ComentarioDao dao = new ComentarioDao();
			if(comentario.getId() == null) {
				dao.salvar(comentario);
				this.comentario = new Comentario();
			} else {
				dao.editar(comentario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		listar();
		
}

	public void deletar() {
		// ct = comentario;
		try{
		ComentarioDao dao = new ComentarioDao();
		dao.excluir(comentario);
		this.comentario = new Comentario();
		listar();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void listar() {
		try{
		ComentarioDao dao = new ComentarioDao();
		comentarios = dao.listar();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
