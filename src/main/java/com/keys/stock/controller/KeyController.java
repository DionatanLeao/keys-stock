package com.keys.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.keys.stock.model.entity.Key;
import com.keys.stock.repository.KeyRepository;

@RestController
@RequestMapping("/keys")
public class KeyController {

	@Autowired
	private KeyRepository keyRepository;

	@GetMapping
	public List<Key> findAll() {
		return keyRepository.findAll();
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Key findById(@PathVariable Long id) {
		return keyRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Key save(@RequestBody Key key) {
		return keyRepository.save(key);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Key update(@PathVariable Long id, @RequestBody Key keyUpdate) {
		return keyRepository.findById(id).map(key -> {
			key.setModel(keyUpdate.getModel());
			key.setType(keyUpdate.getType());
			key.setQuantity(keyUpdate.getQuantity());
			return keyRepository.save(key);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		keyRepository.findById(id).map(key -> {
			keyRepository.delete(key);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}

}
