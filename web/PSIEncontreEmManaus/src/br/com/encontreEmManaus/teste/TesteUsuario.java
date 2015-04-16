package br.com.encontreEmManaus.teste;

import br.com.encontreEmManaus.dao.UsuarioDao;
import br.com.encontreEmManaus.entity.Usuario;

public class TesteUsuario {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Nilson");
		usuario.setCpf("89776554");
		usuario.setEmail("nilson@hotmail.com");
		usuario.setSenha("9876");
		usuario.setTelefone("88776");
		
		UsuarioDao dao = new  UsuarioDao();
		dao.salvar(usuario);

	}

}
