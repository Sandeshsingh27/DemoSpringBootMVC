package com.sandesh.springmvcboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandesh.springmvcboot.model.Alien;

import jakarta.websocket.server.PathParam;

@Controller
public class AlienRestController {
	@Autowired
	AlienRepo repo;
	
	 @GetMapping(path = "aliens", produces = {"application/xml", "application/json"})
	 @ResponseBody 				// this annotation will help the return type to be treated as object or variable not jsp page
    public List<Alien> getAliens() {
        List<Alien> aliens = repo.findAll();
        
//        int i = 9/0;
        
        System.out.println("fetching aliens");
        return aliens;
    }
	 
	 @GetMapping(path = "alien/{id}", produces = {"application/xml", "application/json"})
	 @ResponseBody 
    public ResponseEntity<Alien> getAlien(@PathVariable int id) {
        Optional<Alien> alien = repo.findById(id);
        if (alien.isPresent()) {
            return ResponseEntity.ok(alien.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	 
	 @PostMapping(path = "/alien", consumes = {"application/xml", "application/json"})
	 @ResponseBody
    public ResponseEntity<Alien> createAlien(@RequestBody Alien alien) {
        Alien savedAlien = repo.save(alien);
        return ResponseEntity.ok(savedAlien);
    }

    @PutMapping(path = "/alien", produces = {"application/xml", "application/json"}, consumes = {"application/xml", "application/json"})
    @ResponseBody
    public ResponseEntity<Alien> updateAlien(@RequestBody Alien alien) {
        Optional<Alien> existingAlien = repo.findById(alien.getAid());
        if (existingAlien.isPresent()) {
            Alien updatedAlien = repo.save(alien);
            return ResponseEntity.ok(updatedAlien);
        } else {
            Alien savedAlien = repo.save(alien);
            return ResponseEntity.ok(savedAlien);
        }
    }
    
    @DeleteMapping(path = "alien/{id}", produces = {"application/xml", "application/json"})
    @ResponseBody
    public ResponseEntity<Alien> deleteAlien(@PathVariable int id) {
        Optional<Alien> alien = repo.findById(id);
        if (alien.isPresent()) {
            repo.deleteById(id);
            return ResponseEntity.ok(alien.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
