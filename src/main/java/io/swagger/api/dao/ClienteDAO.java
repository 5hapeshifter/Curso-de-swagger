package io.swagger.api.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.Cliente;
import io.swagger.model.Cliente.TipoEnum;

public class ClienteDAO {

	private static List<Cliente> clientes; 
	
	public ClienteDAO() {
		clientes = new ArrayList<Cliente>();
		clientes.add(mockInicial());
	}
	
	public List<Cliente> todos(){
		return clientes;
	}
	
	public Cliente salva(Cliente cliente) {
		
		cliente.setId(generatetId());
		cliente.setDataAtualizacao(OffsetDateTime.now());
		cliente.status(true);
		
		clientes.add(cliente);
		
		return cliente;
	}
	
	public boolean exclui(Integer id) {
		
		Integer idToRemove = null;
		
		for(Cliente cliente: clientes) {
			if(cliente.getId().equals(id)) {
				idToRemove = clientes.indexOf(cliente);
			}
		}
		
		if(idToRemove != null) {
			Cliente cliente = clientes.get(idToRemove.intValue());
			
			if(cliente != null) {
				boolean removed = clientes.remove(cliente);
				return removed;
			}
		}
		
		return false;
	}
	
	public Cliente consultaPorId(Integer id) {
		
		Integer idToRead = null;
		
		for(Cliente clientelz: clientes) {
			if(clientelz.getId().equals(id)) {
				idToRead = clientes.indexOf(clientelz);
			}
		}
		
		if(idToRead != null) {
			return clientes.get(idToRead);
		}
		
		return null;
	}
	
	public List<Cliente> consultaPorSobrenome(String sobrenome) {

		Integer idToRead = null;
		List<Cliente> clienteslz = new ArrayList<Cliente>();
		
		for(Cliente clientelz: clientes) {
			if(clientelz.getSobrenome().equals(sobrenome)) {
				idToRead = clientes.indexOf(clientelz);
			}
			
			if(idToRead != null) {
				
				clienteslz.add(clientes.get(idToRead));
				
				idToRead = null;
			}
		}
		
		if(clienteslz.isEmpty()) {
			return null;
		}
		
		return clienteslz;
	}
	
	public boolean alteraStatus(Integer id) {
		
		Integer idToRemove = null;
		
		for(Cliente cliente: clientes) {
			if(cliente.getId().equals(id)) {
				idToRemove = clientes.indexOf(cliente);
			}
		}
		
		if(idToRemove != null) {
			return clientes.remove(idToRemove);
		}
		
		return false;
	}
	
	public Cliente altera(Cliente cliente) {
		
		Integer idToUpdate = null;
		
		for(Cliente clientelz: clientes) {
			if(clientelz.getId().equals(cliente.getId())) {
				idToUpdate = clientes.indexOf(clientelz);
			}
		}
		
		if(idToUpdate != null) {
			
			Cliente clientel = clientes.get(idToUpdate);
			clientel.setNome(cliente.getNome());
			clientel.setSobrenome(cliente.getSobrenome());
			clientel.setIniciais(cliente.getIniciais());
			clientel.setDataNascimento(cliente.getDataNascimento());
			clientel.setDataAtualizacao(OffsetDateTime.now());
			clientel.setStatus(cliente.isStatus());
			clientel.setTipo(cliente.getTipo());
			
			return clientel;
		}
		
		return null;
	}
	
	public Cliente alteraStatusPorId(Integer id, String status) {
		
		Integer idToUpdate = null;
		
		for(Cliente clientelz: clientes) {
			if(clientelz.getId().equals(id)) {
				idToUpdate = clientes.indexOf(clientelz);
			}
		}
		
		if(idToUpdate != null) {
			
			Cliente clientel = clientes.get(idToUpdate);
			
			if("ativo".equalsIgnoreCase(status)) {
				clientel.setStatus(true);
			}else {
				clientel.setStatus(false);
			}
			
			return clientel;
		}
		
		return null;
	}		

	private Integer generatetId() {
		Double random = Math.random() * 112;
		return new Random().nextInt(random.intValue()) + 132;
	}
	
	private Cliente mockInicial() {
		
		Cliente cliente = new Cliente();
    	cliente.setId(125);
    	cliente.setNome("Marcos Alberto");
    	cliente.setSobrenome("Nogueira");
    	cliente.setIniciais("MAN");
    	cliente.setStatus(true);
    	cliente.setTipo(TipoEnum.INTERNO);
    	cliente.setDataNascimento(LocalDate.of(1983, 6, 12));
    	cliente.setDataAtualizacao(OffsetDateTime.now());
    	
    	return cliente;
	}

}
