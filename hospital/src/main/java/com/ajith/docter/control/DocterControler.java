package com.ajith.docter.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajith.docter.model.DocterModel;
import com.ajith.docter.request.DocRequest;
import com.ajith.docter.service.DocterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doc")
public class DocterControler {

	@Autowired
	DocterService service;

	@GetMapping("/get")
	private Map<Integer, DocterModel> getDoc() {
		return service.get();
	}

	@GetMapping("/get/{id}")
	private ResponseEntity<Object> getDoc(@PathVariable(name = "id") int id1) {
		return service.get(id1);
	}

	@PostMapping("/put")
	private ResponseEntity<Object> putdoc(@RequestBody @Valid DocRequest docin) {
		return service.put(docin);
	}

	@DeleteMapping("/clearDb")
	private ResponseEntity<Object> clear() {
		service.empty();
		return new ResponseEntity<Object>("Database cleared", HttpStatus.OK);
	}

	@DeleteMapping("/clearDb/{id}")
	private ResponseEntity<Object> clear(@PathVariable int id) {
		service.empty(id);
		return new ResponseEntity<Object>("Database cleared", HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	private ResponseEntity<Object> update(@RequestBody @Valid DocRequest entry, @PathVariable int id) {
		return service.update(entry, id);
	}
}