package br.com.prog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.prog.dao.TransportadoraDAO;
import br.com.prog.database.ProjetoException;
import br.com.prog.model.Transportadora;



@ManagedBean
@SessionScoped 
public class TransportadoraController {
	
	private Transportadora transportadora = new Transportadora();
	private List<Transportadora> transportadoras =new ArrayList<Transportadora>();

	

	public Transportadora getTransportadora() {
		return transportadora;
	}


	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}


	public List<Transportadora> getTransportadoras() {
		return transportadoras;
	}


	public void setTransportadoras(List<Transportadora> transportadoras) {
		this.transportadoras = transportadoras;
	}


	public String cadastrar() {
		
		TransportadoraDAO transportadoraDao = new TransportadoraDAO();
		
		try {
			transportadoraDao.adicionarTransportadora(this.transportadora);
		} 
		catch (ProjetoException e) {
			e.printStackTrace();
		}
		
		this.transportadora = new Transportadora();
		
		return "transportadoras?faces-redirect=true";
	}
	

	public String alterar() {
		
		TransportadoraDAO transportadoraDao = new TransportadoraDAO();
		
		try {			
			transportadoraDao.alterarTransportadora(transportadora);
		}
		catch (ProjetoException e) {
			e.printStackTrace();
		}
		
		return "transportadoras?faces-redirect=true";
		
	}
		
	
	public void listar(){
		TransportadoraDAO transportadoraDao = new TransportadoraDAO();
		this.transportadoras = transportadoraDao.listar();
	}
	
	public String deletar(Integer id) {
		
		TransportadoraDAO transportadoraDao = new TransportadoraDAO();
		
		try {
			transportadoraDao.deletarTransportadora(id);
		}
		catch (ProjetoException e) {
			e.printStackTrace();
		}
		
		return "transportadoras?faces-redirect=true";

	}
	
	//public String buscar(String nome){
	public Transportadora buscar(String nome){	
		TransportadoraDAO transportadoraDao = new TransportadoraDAO();
		//transportadoraDao.buscar(nome);
		
		//return "buscarTransportadora?faces-redirect=true";
		return transportadoraDao.buscar(nome);
	}
	
	public String preparar(Transportadora transp){
		this.transportadora = transp;
		return "alterarTransportadora?faces-redirect=true";
				
	}
	
	public String paraTemplate(){
		this.transportadora = new Transportadora();	
		return "/transportadora?faces-redirect=true";
	}
}
