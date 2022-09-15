package com.Entregable3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class clienteService implements IclienteService{
	
	@Autowired
	private Icliente data;
	
	@Override
	public List<cliente> listar() {
		return (List<cliente>) data.findAll();
	} 

	@Override
	public Optional<cliente> listarId(int idcliente) {
		return data.findById(idcliente); 
	}

	@Override
	public cliente save(cliente c) {
		return data.save(c);
	}

	@Override
	public void delete(int idcliente) {
		data.deleteById(idcliente);
		
	}
	
}
