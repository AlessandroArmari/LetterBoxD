package com.LetterBoxD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LetterBoxD.interfaces.ILogService;
import com.LetterBoxD.model.Log;

@RestController
@RequestMapping("/log")
//@CrossOrigin
public class LogRestController {

	@Autowired
	ILogService iLogService;

	@GetMapping("/findById")
	public ResponseEntity<Log> findById(@RequestParam long id) {
		if (iLogService.findById(id) == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(iLogService.findById(id));
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Log>> findAll() {
		return ResponseEntity.ok(iLogService.findAll());
	}

	@PostMapping("/create")
	public ResponseEntity<Log> create(@RequestBody Log log) {
		return ResponseEntity.ok(iLogService.create(log));
	}

	@PutMapping("/update")
	public ResponseEntity<Log> update(@RequestParam long id, @RequestBody Log log) {
		return ResponseEntity.ok(iLogService.update(id, log));
	}

	@DeleteMapping("/delete")
	public ResponseEntity delete(long id) {
		return ResponseEntity.ok(iLogService.delete(id));
	}

}
