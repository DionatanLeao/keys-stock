package com.keys.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
