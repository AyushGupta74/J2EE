package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
     @Query(value="select * from producttab11 where price between :lpr and :hpr",nativeQuery = true)
	//@Query(value="select p from Product p where price between :lpr and :hpr")
	List<Product> findbyPrice(int lpr, int hpr);
     
    /* @Procedure(procedureName="getNumberProducts")
     public int getCount();*/

}
