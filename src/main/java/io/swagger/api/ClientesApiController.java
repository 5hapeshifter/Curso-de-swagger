package io.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.dao.ClienteDAO;
import io.swagger.model.Cliente;
import io.swagger.model.Clientes;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-09-01T14:51:54.578Z")

@Controller
public class ClientesApiController implements ClientesApi {

    private static final Logger log = LoggerFactory.getLogger(ClientesApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private ClienteDAO clienteDAO;
    
    
    @org.springframework.beans.factory.annotation.Autowired
    public ClientesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.clienteDAO = new ClienteDAO();
    }
    
    /**
     * 501 - NAO DESENVOLVIDO
     * return new ResponseEntity<Clientes>(HttpStatus.NOT_IMPLEMENTED):
     * 
     * 400 - REQUISICAO INVALIDA
     * return new ResponseEntity<Clientes>(HttpStatus.BAD_REQUEST):
     * 
     * 401 - REQUISICAO NAO AUTORIZADA
     * return new ResponseEntity<Clientes>(HttpStatus.UNAUTHORIZED); 
     */
    public ResponseEntity<Clientes> consultaTodos() {
    	
    	ResponseEntity<Clientes> responseEntity = null;
    	
        try {
        	
        	List<Cliente> clientes = clienteDAO.todos();
        	
        	//404 NENHUM REGISTRO ENCONTRADO
        	if(clientes != null) {
        		if(clientes.size() <= 0) {// se a quantidade de clientes retornada for <= 0 nenhum cliente será retornado.
        			responseEntity = new ResponseEntity<Clientes>(objectMapper.readValue(objectMapper.writeValueAsString(clientes), Clientes.class), HttpStatus.INTERNAL_SERVER_ERROR);
        		} else {
        			//200 SUCESSO
        			responseEntity = new ResponseEntity<Clientes>(objectMapper.readValue(objectMapper.writeValueAsString(clientes), Clientes.class), HttpStatus.OK);
        		}
        	}
                
        }catch (Exception e) {
        	
        	log.error("Erro ao tentar consultar clientes.");
        	responseEntity = new ResponseEntity<Clientes>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
		return responseEntity;
    }
    
}
