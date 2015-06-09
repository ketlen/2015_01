package br.com.encontreEmManaus.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/usuario")
public class UsuarioResource {

	
	/**
	 * 
	 * Método responsável por cadastrar Item no DB
	 *
	 * @return ArrayList<Item> 
	 * @author Genilson Ferreira <gr.ferreira@live.com>
	 * @since 16/04/2014 
	 * @version 1.0
	 */
	
	@Consumes({"application/xml"})
	@GET			
	@Path("/login/{login}/{senha}")
	@Produces("application/json")
	public String efetuarLogin(
			@PathParam("login") String login,
			@PathParam("senha") String senha){

		ConnectionFactory conn = new ConnectionFactory();
		System.out.println(">efetuarLogin()");
		
			System.out.println("login: "+login);
			System.out.println("senha: "+senha);	

			Connection conexao = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String result = null;
			conexao = conn.criarConexao();
			try {
				pstmt = conexao.prepareStatement("select fc_es_disp_login('"+login+"','"+senha+"') as resultado");
				rs = pstmt.executeQuery();
				
				while(rs.next()){
						result = rs.getString("resultado");
				}
				
			} catch (Exception e) {
				System.out.println("Erro ao efetuar login: " + e);
				e.printStackTrace();
			} finally {
				conn.fecharConexao(conexao, pstmt, rs);
			}

			
		return result;//	System.out.println("<abrirPedido()");
			
	}

	

	
	
}
