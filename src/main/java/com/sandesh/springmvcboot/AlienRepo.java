package com.sandesh.springmvcboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandesh.springmvcboot.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
	// List<Alien> findByAname(String aname); // This is called Query DSL(user defined method must follow specified naming convention eg, startwith findBy<variable name>
	
//	List<Alien> findByAnameOrderByAidDesc(String aname);  // we can order it as well
	
	@Query("from Alien where aname = :name")
	List<Alien> findByName(@Param("name") String aname);
}
