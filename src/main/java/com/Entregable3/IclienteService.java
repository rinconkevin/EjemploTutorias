package com.Entregable3;

import java.util.List;
import java.util.Optional;


public interface IclienteService {
	public List<cliente> listar();
	public Optional<cliente> listarId(int idcliente);
	public cliente save(cliente c);
	public void delete(int idcliente);
}
