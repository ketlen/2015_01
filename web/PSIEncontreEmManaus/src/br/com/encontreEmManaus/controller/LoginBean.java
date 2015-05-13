package br.com.encontreEmManaus.controller;

import javax.faces.bean.ManagedBean;




import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.encontreEmManaus.entity.Usuario;
import br.com.encontreEmManaus.util.JPAUtil;
import br.com.encontreEmManaus.dao.UsuarioDao;


@ManagedBean
@SessionScoped
public class LoginBean {
	
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public String efetuarLogin(){
		
		UsuarioDao dao = new UsuarioDao (null);
		boolean loginValido = dao.existe(usuario);
		if(loginValido){
			return "index";
		
		}else {
			return "login";
		}
	
	
	}
	//public String efetuarLogOut(){
		//encerra a sessão
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		//redirecionamento da página
		//return "/login.xhtml?faces-redirect=true";
	}
//}
