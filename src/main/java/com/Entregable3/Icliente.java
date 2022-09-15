package com.Entregable3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface Icliente extends CrudRepository<cliente, Integer>{

}
