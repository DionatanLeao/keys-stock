package com.keys.stock.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 * @author dionatan
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Key {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String model;
	private String type;
	private Integer quantity;

}
