package br.com.encontreEmManaus.teste;

import br.com.encontreEmManaus.dao.AgendaDao;
import br.com.encontreEmManaus.entity.Agenda;

public class TesteAgenda {

public static void main(String[] args) {
		
		Agenda agenda = new Agenda();
		agenda.setLocal("Manauara");
		agenda.setEvento("shopping");
		agenda.setData(null);
				
		AgendaDao dao = new  AgendaDao();
		dao.salvar(agenda);

	}
}
