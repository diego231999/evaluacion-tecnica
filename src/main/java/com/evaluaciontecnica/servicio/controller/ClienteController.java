package com.evaluaciontecnica.servicio.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evaluaciontecnica.servicio.entity.Cliente;
import com.evaluaciontecnica.servicio.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	
	@ResponseBody
	@PostMapping(value="/")
	public ResponseEntity nuevoCliente(@RequestBody Cliente cliente){
		HashMap<String, Object> responseMap= new HashMap<>();
		Optional<Cliente> cliente_opt= clienteRepository.findById(cliente.getCodCliente());
		
		if (!cliente_opt.isPresent() && cliente.getAbreviatura()!=null && cliente.getCodigoSAP()!=null 
				&& !(cliente.getEstado()=='\0') && cliente.getGrupoFacturacion()!=null && cliente.getInactivoDesde()!=null
				&& cliente.getNombreCompleto()!=null && cliente.getNombreCorto()!=null && cliente.getRuc()!=null) {
			
			clienteRepository.save(cliente);
			responseMap.put("CodOperacion", 1);
			responseMap.put("mensaje", "Cliente registrado");
			responseMap.put("cliente", cliente);
			return new ResponseEntity(responseMap,HttpStatus.OK);
			
		}else {
			responseMap.put("CodOperacion", 0);
			responseMap.put("mensaje", "Cliente no registrado, ingrese valores correctos");
			return new ResponseEntity(responseMap,HttpStatus.BAD_REQUEST);
		}	
	}
	
	@ResponseBody
	@GetMapping(value="/{id}")
	public ResponseEntity obtenerCliente(@PathVariable("id") String id){
		HashMap<String, Object> responseMap= new HashMap<>();
		Optional<Cliente> cliente_opt= clienteRepository.findById(id);
		if (cliente_opt.isPresent()) {
			responseMap.put("CodOperacion", 1);
			responseMap.put("mensaje", "Operación exitosa");
			responseMap.put("cliente", cliente_opt.get());
			return new ResponseEntity(responseMap,HttpStatus.OK);
		}else {
			responseMap.put("CodOperacion", 0);
			responseMap.put("mensaje", "Elemento no encontrado");
			return new ResponseEntity(responseMap,HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@PutMapping(value="/{id}")
	public ResponseEntity editarCliente(@PathVariable String id, @RequestBody Cliente cliente_edit){
		HashMap<String, Object> responseMap= new HashMap<>();
		Optional<Cliente> cliente_opt= clienteRepository.findById(id);
		if (cliente_opt.isPresent()) {
			
			Cliente cliente = cliente_opt.get();
			cliente.setAbreviatura(cliente_edit.getAbreviatura());
			cliente.setCodigoSAP(cliente_edit.getCodigoSAP());
			cliente.setGrupoFacturacion(cliente_edit.getGrupoFacturacion());
			cliente.setInactivoDesde(cliente_edit.getInactivoDesde());
			cliente.setNombreCompleto(cliente_edit.getNombreCompleto());
			cliente.setNombreCorto(cliente_edit.getNombreCorto());
			cliente.setRuc(cliente_edit.getRuc());
			clienteRepository.save(cliente);
			
			responseMap.put("CodOperacion", 1);
			responseMap.put("mensaje", "Editado exitosamente");
			responseMap.put("cliente", cliente);
			return new ResponseEntity(responseMap,HttpStatus.OK);
		}else {
			responseMap.put("CodOperacion", 0);
			responseMap.put("mensaje", "Elemento no encontrado");
			return new ResponseEntity(responseMap,HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@DeleteMapping(value="/{id}")
	public ResponseEntity borrarCliente(@PathVariable("id") String id){
		HashMap<String, Object> responseMap= new HashMap<>();
		Optional<Cliente> cliente_opt= clienteRepository.findById(id);
		if (cliente_opt.isPresent()) {
			Cliente cliente2= cliente_opt.get();
			cliente2.setEstado('0');
			clienteRepository.save(cliente2);
			responseMap.put("CodOperacion", 1);
			responseMap.put("mensaje", "Borrado exitoso");
			responseMap.put("cliente", cliente_opt.get());
			return new ResponseEntity(responseMap,HttpStatus.OK);
		}else {
			responseMap.put("CodOperacion", 0);
			responseMap.put("mensaje", "Elemento no encontrado");
			return new ResponseEntity(responseMap,HttpStatus.BAD_REQUEST);
		}
	}

	
}
