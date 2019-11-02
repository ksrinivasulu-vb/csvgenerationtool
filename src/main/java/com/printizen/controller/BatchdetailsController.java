package com.printizen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.printizen.entity.Batchcolumn;
import com.printizen.entity.Batchdetail;
import com.printizen.model.BatchdetailsListContainer;
import com.printizen.service.BatchdetailService;
 
@Controller
public class BatchdetailsController {

	@Autowired
	private BatchdetailService batchdetailService;
 
	@RequestMapping(value = "/batchdetailslist", method = RequestMethod.GET)
	public String ShowBatchDetails(Model model) {

		List<Batchdetail> batchdetails = new ArrayList<Batchdetail>();
		batchdetails = batchdetailService.getBatchdetails();

		BatchdetailsListContainer batchdetailsListContainer = new BatchdetailsListContainer();
		batchdetailsListContainer.setBatchdetails(batchdetails);

		BatchdetailsListContainer BatchdetailList = new BatchdetailsListContainer();
		BatchdetailList.setBatchdetails(batchdetails);
		model.addAttribute("Batchdetails", BatchdetailList);

		return "batchdetails";
  
		

	}

}
