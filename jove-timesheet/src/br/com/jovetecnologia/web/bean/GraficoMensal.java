package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
@ViewScoped
public class GraficoMensal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CartesianChartModel mensal;
	
	public GraficoMensal() {
		criarMensal();
	} 	
	
	private void criarMensal() {
		mensal = new CartesianChartModel();
		
		ChartSeries trabalhado = new ChartSeries();
		trabalhado.setLabel("Horas Trabalhada");
		trabalhado.set("Semana 1", 80);
		trabalhado.set("Semana 2", 60);
		trabalhado.set("Semana 3", 55);
		trabalhado.set("Semana 4", 40);
		
		ChartSeries meta = new ChartSeries();
		meta.setLabel("Horas Obrigatorias");
		meta.set("Semana 1", 70);
		meta.set("Semana 2", 60);
		meta.set("Semana 3", 80);
		meta.set("Semana 4", 60);
		
		mensal.addSeries(trabalhado);
		mensal.addSeries(meta);
	}

	/**
	 * @return the mensal
	 */
	public CartesianChartModel getMensal() {
		return mensal;
	}
	
}
