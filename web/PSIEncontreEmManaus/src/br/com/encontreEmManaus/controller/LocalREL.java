package br.com.encontreEmManaus.controller;


import java.io.FileNotFoundException;


import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import br.com.encontreEmManaus.entity.Local;
  

public class LocalREL   {
private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public LocalREL() {
		
		//this.path = "C:/projeto/laboratorio/build/classes/";
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "br/com/laboratorio/jasper/";
		System.out.println(path);
		//System.out.printlt(this.getClass().get)
		
	}

	public void gerarRel(List<Local> locals) throws FileNotFoundException, JRException{
	
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "relatorio_local.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(locals));
		JasperExportManager.exportReportToPdfFile(print, "C://reports//test_jasper.pdf"); 
		//abrindo a tela pdf
		JasperViewer viewer = new JasperViewer(print, false);
		viewer.show();
		//abindo maximizado
		viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
	}
public String getPathToReportPackage() {
	return this.pathToReportPackage;
}

public String getPath() {
	return this.path;
}
}
