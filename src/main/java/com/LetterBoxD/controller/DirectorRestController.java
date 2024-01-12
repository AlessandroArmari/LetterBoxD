package com.LetterBoxD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LetterBoxD.interfaces.IDirectorService;
import com.LetterBoxD.model.Director;

@RestController
@RequestMapping("/director")
public class DirectorRestController {
	
	@Autowired
	IDirectorService iDirectorService;

	@GetMapping("/findById")
	public ResponseEntity<Director> findById(@RequestParam long id) {
		if (iDirectorService.findById(id) == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(iDirectorService.findById(id));
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Director>> findAll() {
		return ResponseEntity.ok(iDirectorService.findAll());
	}

	@PostMapping("/create")
	public ResponseEntity<Director> create(@RequestBody Director director) {
		return ResponseEntity.ok(iDirectorService.create(director));
	}

	@PutMapping("/update")
	public ResponseEntity<Director> update(@RequestParam long id, @RequestBody Director director) {
		return ResponseEntity.ok(iDirectorService.update(id, director));
	}

	@DeleteMapping("/delete")
	public ResponseEntity delete(long id) {
		return ResponseEntity.ok(iDirectorService.delete(id));
	}

}
