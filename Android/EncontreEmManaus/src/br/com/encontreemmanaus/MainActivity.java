package br.com.encontreemmanaus;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    Registro objRegistro;
    EditText etCategoria, etEndereco, etTelefone, etHorario;
    int contadorRegistro=0;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		chamaMenuPrincipal();
		
						
		}
	public void chamaRestaurante(){
		setContentView(R.layout.listar_locais);
		Button btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);
        btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			chamaMenuPrincipal();
				
			}
		});
		Button btRestaurantePeixaria = (Button) findViewById(R.id.btRestaurantePeixaria);
		btRestaurantePeixaria.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaRestaurantePeixaria();
				
			}
		});
	
	    }
	public void chamaMenuPrincipal(){
		
		setContentView(R.layout.activity_main);
		Button btRestaurante = (Button) findViewById(R.id.btRestaurante);
	    btRestaurante.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaRestaurante();  //chama a tela de listar ao clicar
				
			}
		}); 
	    
	    Button btCadastar = (Button) findViewById(R.id.btCadastar);
	    btCadastar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaCadastro();
				
			}
		});
	    
	    Button btshopping =(Button) findViewById(R.id.btshopping);
	    btshopping.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaShopping();
				
			}
		});
		
	}
	public void chamaRestaurantePeixaria(){
		
		setContentView(R.layout.exibir_local);
		Button btVoltar = (Button) findViewById(R.id.btVoltar);
		btVoltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaRestaurante();
				
			}
		});
		
		
	}
	
	public void chamaCadastro(){
		setContentView(R.layout.cadastro);
		Button btVoltar2 = (Button) findViewById(R.id.btvoltar2);
		btVoltar2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaMenuPrincipal();
				
			}
		});
		
		Button btGravar = (Button) findViewById(R.id.btGravar);
		btGravar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
				objRegistro = new Registro();
				etCategoria = (EditText) findViewById(R.id.categoria);
				etEndereco = (EditText) findViewById(R.id.endereco);
				etTelefone = (EditText) findViewById(R.id.telefone);
				etHorario = (EditText) findViewById(R.id.horario);
				
				//gravar
				objRegistro.categoria = etCategoria.getText().toString();
				objRegistro.endereco = etEndereco.getText().toString();
				objRegistro.telefone = etTelefone.getText().toString();
				objRegistro.horario = etHorario.getText().toString();
				contadorRegistro++;
				mensagemExibir("Gravação","Dados gravados com sucesso");
				chamaMenuPrincipal();
				
			}
				catch(Exception erro)
				{
				mensagemExibir("Erro","Deu erro ao gravar"+erro); 
						
		}
			}
		});
	}
	public  void mensagemExibir(String titulo, String texto)
	{
		AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("Ok", null);
		mensagem.show();
	}
	public void chamaShopping(){
		if (contadorRegistro == 0)
		{
			mensagemExibir("Aviso","Não tem Registo Gravados");
			
		//	chamaMenuPrincipal();
			return;
			
		}
		
		setContentView(R.layout.exibir_local2);
		
		
		TextView tvCategoria = (TextView) findViewById(R.id.tvCategoria);
		TextView tvEndereco = (TextView) findViewById(R.id.tvEndereco);
		TextView tvTelefone = (TextView) findViewById(R.id.tvTelefone);
		TextView tvHorario = (TextView) findViewById(R.id.tvHorario);
		
		tvCategoria.setText(objRegistro.categoria);
		tvEndereco.setText(objRegistro.endereco);
		tvTelefone.setText(objRegistro.telefone);
		tvHorario.setText(objRegistro.horario);
		
		Button btVoltar3 = (Button) findViewById(R.id.btVoltar3);
		btVoltar3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaMenuPrincipal();
				
			}
		});
		
		
}

}

		

// 3711
//3726 persistencia













				
		
	/*

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
	
