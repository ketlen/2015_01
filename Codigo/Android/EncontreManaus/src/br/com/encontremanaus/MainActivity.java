package br.com.encontremanaus;

import android.app.Activity;

import android.app.AlertDialog;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;//manipulando os dados
public class MainActivity extends Activity {
Registro objRegistro;
EditText etnomefavorito;


SQLiteDatabase bancoDados = null;//banco de dados
Cursor cursor;//responsavel por visualização e busca

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
	
		chamamenu();
		abreouCriaBanco();
		}
	
	public void abreouCriaBanco()//abri ou cria baco se existir
	{
		try{
			bancoDados = openOrCreateDatabase("bancomanaus", MODE_WORLD_READABLE, null);
			String sql = "CREATE TABLE IF NOT EXISTS cadastro"
					+" (id INTERGER PRIMARY KEY, nome TEXT);";
			
			mensagemExibir("eita banco", "banco criado com sucesso");
			   bancoDados.execSQL(sql);
		}
			
		catch(Exception erro)
		{
			mensagemExibir("erro banco", "erro ao abri banco"+erro.getMessage());
			
		}
	}
	
	public void fechaBanco()
	{
		try
		{
			bancoDados.close();//fechar banco de dados	
		}
		catch(Exception erro)
		{
			mensagemExibir("erro banco", "erro ao abri banco"+erro.getMessage());
		}
		
	}
	

	

	public void chamalistarcategoria(){
    setContentView(R.layout.listarcategoria);
    Button btmenu = (Button) findViewById(R.id.btmenu);
    btmenu.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			chamamenu();
		}
	});
    
    
	}
			public void chamamenu(){
				setContentView(R.layout.activity_main);
				Button  btlistarcategoria = (Button) findViewById(R.id.btlistarcategoria);
				Button  btcadastrofavorito =(Button) findViewById(R.id.btcadastrofavorito);
				Button  btcomentario = (Button) findViewById(R.id.btcomentario);
				
				
				btcomentario.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						chamacomentario();
					}
				});				
				
				btcadastrofavorito.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						chamamanterfavorito();// chama atela de listar categoria ao clicar
						
						
						
					}
				});
			    
						
				
				
				btlistarcategoria.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							chamalistarcategoria();// chama atela de listar categoria ao clicar
							
						}
					});
				    
				    
				 
				 
			}
	
			
			public void chamacomentario(){
				setContentView(R.layout.comentario);
				Button btmenu = (Button) findViewById(R.id.btmenu);
				Button btenviar = (Button) findViewById(R.id.btenviar);
				
				btenviar.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						mensagemExibir("Foi", "Mensagem enviado com sucesso");
						
					}
				});
				
				btmenu.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						chamamenu();
					}
				});
			
			}
	
			public void chamamanterfavorito(){
				setContentView(R.layout.manterfavorito);
				Button btsalvarfavorito= (Button) findViewById(R.id.btsalvarfavorito);
				Button btconsulta = (Button) findViewById(R.id.btconsulta);
				
				
				
				btconsulta.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						chamaconsulta();
					}
				});
				
				
				btsalvarfavorito.setOnClickListener(new View.OnClickListener(){
								@Override
					public void onClick(View v) {
					
									
					objRegistro = new Registro();
					etnomefavorito = (EditText) findViewById(R.id.nomefavorito);
					mensagemExibir("Gravação", "Dados gravados com sucesso");
					//grvar
					objRegistro.nome = etnomefavorito.getText().toString();
					
					//chamamenu();
					
					
									}			
										
					
				});
			}
			
			
			private boolean buscarDados()
			{
				cursor = bancoDados.query("cadastro", 
					new	String [] {"nomefavorito"}, 
					null,//selection, 
					null,//selectionArgs, 
					null,//groupBy, 
					null,//having, 
					null);//"order by nome"//orderBy)
				
				int numeroRegistro = cursor.getCount();
				if  (numeroRegistro != 0)
				{
					cursor.moveToFirst();//posiciona no primeiro registro
					return true;
				}
				else
					return false;
				
			}
			
			
			
			public void gravarRegistro()
			{
				String sql="INSERT INTO cadastro (nome)  values('"
						+etnomefavorito.getText().toString()+"', ' ";
				bancoDados.execSQL(sql);
				
			}
			
			
			
			
			
			public void mensagemExibir (String titulo, String texto)
			{
				AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
				mensagem.setTitle(titulo);
				mensagem.setMessage(texto);
				mensagem.setNeutralButton("ok", null);
				mensagem.show();
				
				
				
				
				
			}
			
			
			public void chamaconsulta(){
				setContentView(R.layout.consulta);
				TextView tvnome = (TextView) findViewById(R.id.tvnome);
			    
				tvnome.setText(objRegistro.nome);
				//tvnome.setText(cursor.getString(cursor.getColumnIndex("nomefavorito")));
				
				
							}
			
}





			


