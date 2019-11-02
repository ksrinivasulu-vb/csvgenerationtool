package com.printizen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.printizen.entity.Batchcolumn;


public interface BatchcolumnRepository extends JpaRepository<Batchcolumn, Long>{

	List <Batchcolumn>findByBatchid(String batchid);
}

