package com.keys.stock.model.entity;

import javax.persistence.Entity;

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
public class Keys {

	private String modelo;
	private Integer quantidade;

}
