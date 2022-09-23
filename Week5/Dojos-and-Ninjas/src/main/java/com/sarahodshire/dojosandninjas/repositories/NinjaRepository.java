package com.sarahodshire.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sarahodshire.dojosandninjas.models.Dojo;
import com.sarahodshire.dojosandninjas.models.Ninja;


@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
	List<Ninja> findAllByDojo(Dojo dojo);
}