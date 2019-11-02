package com.printizen.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printizen.entity.Batchdetail;
import com.printizen.repository.BatchdetailRepository;

@Service
public class BatchdetailService {

	@Autowired
	BatchdetailRepository batchdetailRepository;

	@Transactional
	public Batchdetail getBatchdetailById(long id) {
		return batchdetailRepository.findById(id).orElse(null);
	}

    @Transactional
    public void savebatchdetail(Batchdetail batchdetail)
    {
    	System.out.println(batchdetail.toString());
    	batchdetailRepository.save(batchdetail);
    	
    }
    
    @Transactional
    public void deletebatchdetail(long id)
    {
    	batchdetailRepository.deleteById(id);
    }
    
    @Transactional
    public void updatebatchdetail(Batchdetail batchdetail,long id)
    {
    	batchdetailRepository.save(batchdetail);
    }
	
    
    @Transactional
	public List<Batchdetail> getBatchdetails() {
		return (List<Batchdetail>)batchdetailRepository.findAll();
	}
    
    
    

	
}
