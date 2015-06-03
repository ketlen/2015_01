package br.com.encontreemmanaus;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	//Button btRestaurante;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		chamaMenuPrincipal();
		
				
		}
	public void chamaRestaurantes(){
		setContentView(R.layout.listar_locais);
		
	   Button	btVoltar = (Button) findViewById(R.id.btvoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaVoltar();
				
			}
		});
        Button	btRestaurantePeixaria = (Button) findViewById(R.id.btrestaurantepeixaria);
        btRestaurantePeixaria.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaRestaurantePeixaria();
				
			}
		});
		
	}
	
	public void chamaVoltar(){
		setContentView(R.layout.activity_main);
		
		
	
		
		
	}
	public void chamaRestaurantePeixaria(){
		setContentView(R.layout.exibir_local);
		
		Button	btVoltarConsulta = (Button) findViewById(R.id.btvoltarconsulta);
        btVoltarConsulta.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamaVoltarConsulta();
				
			}
		});
	}
	public void chamaVoltarConsulta(){
		setContentView(R.layout.activity_main);
		
	}
	public void chamaMenuPrincipal(){
		setContentView(R.layout.activity_main);
	Button	btRestaurante = (Button) findViewById(R.id.btrestaurante);
		btRestaurante.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				chamaRestaurantes(); // chama a tela de cadastro ao clicar
								
			}
		});
			
				
		
	}

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
		return super.onOptionsItemSelected(item);
	}
}
