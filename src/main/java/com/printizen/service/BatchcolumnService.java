package com.printizen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printizen.entity.Batchcolumn;
import com.printizen.repository.BatchcolumnRepository;

@Service
public class BatchcolumnService {

	@Autowired
	BatchcolumnRepository batchcolumnRepository;

	@Transactional
	public Batchcolumn getBatchcolumnById(long id) {
		return batchcolumnRepository.findById(id).orElse(null);
	}

	@Transactional
	public void savebatchdetail(Batchcolumn batchcolumn) {
		batchcolumnRepository.save(batchcolumn);

	}
	
	@Transactional
	public void savebatchdetail(List<Batchcolumn> batchcolumns ) {
		
		batchcolumnRepository.saveAll(batchcolumns);
		batchcolumnRepository.flush();

	}
	
	@Transactional
	public List<Batchcolumn> getBatchcolumnById(String batchid) {
		return batchcolumnRepository.findByBatchid(batchid);
	}

}
