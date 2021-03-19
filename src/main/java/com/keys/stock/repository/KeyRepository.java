package com.keys.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keys.stock.model.entity.Key;

/***
 * 
 * @author dionatan
 *
 */
@Repository
public interface KeyRepository extends JpaRepository<Key, Long> {

}
