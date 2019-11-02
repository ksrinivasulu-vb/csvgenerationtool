package com.printizen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CsvgenerationContoller {

	@RequestMapping(value = "/generatecsv", method = RequestMethod.GET)
	public String ShowBatchDetails(Model model) {

		return "generatecsv";
	}
}
