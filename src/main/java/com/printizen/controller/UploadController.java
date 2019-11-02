package com.printizen.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.printizen.entity.Batchcolumn;
import com.printizen.entity.Batchdetail;
import com.printizen.service.BatchcolumnService;
import com.printizen.service.BatchdetailService;

@Controller
public class UploadController {

	// destination folder to upload the files
	private static String UPLOAD_FOLDER = "C://test//";

	// The Environment object will be used to read parameters from the
	// application.properties configuration file
	@Autowired
	private Environment env;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private BatchdetailService batchdetailService;

	@Autowired
	private BatchcolumnService batchcolumnService;
	

	@RequestMapping("/upload")
	public ModelAndView showUpload() {
		return new ModelAndView("upload");
	}

	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		ModelAndView model = new ModelAndView();

		if (file.isEmpty()) {
			return new ModelAndView("upload", "message", "Please select a file and try again");
		}

		BufferedReader reader = null;
		try {

			File destination = new File(UPLOAD_FOLDER + file.getOriginalFilename());
			if (destination.exists()) {
				
				if(destination.delete()) {
					System.out.println("successfully deleted");
				}
				else {
					System.out.println("failed  deleted");
				}
			}
			
			

			file.transferTo(destination);

			reader = new BufferedReader(new FileReader(destination));
			String[] csvheaders = reader.readLine().split(",");
			httpSession.setAttribute("header", csvheaders);
			
			reader.close();

			model.addObject("sellerSKUID", "seller SKU ID");
			model.addObject("Subcategory", "Sub-category");
			model.addObject("Brand", "Brand");
			model.addObject("ModelName", "ModelName");

			model.addObject("dropdownsize", String.valueOf(5));

			model.addObject("message", "File Uploaded sucessfully");
			model.addObject("csvheader", csvheaders);
			// model.addObject("headers", headers);
			model.addObject("csvfile", destination.getPath());

			model.setViewName("status");

		} catch (IOException e) {

			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return model;
		// return new ModelAndView("status", "message", "File Uploaded sucessfully");
	}

	private int getSelectedFieldIndex(String fieldName) {
		String[] headers = (String[]) httpSession.getAttribute("header");
		
		for(int i=0;i<headers.length;i++) {
			if (headers[i].equals(fieldName)) {
				return i;
			}
			
		}
		return -1;
	}

	@PostMapping("/template")
	public ModelAndView uploadStatus(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		Enumeration en = request.getParameterNames();

		Batchdetail batchdetail = new Batchdetail();
		ArrayList<Batchcolumn> batchcolumns = new ArrayList<Batchcolumn>();

		long batchid = getbatchID();
		

		int number = 1;
		while (en.hasMoreElements()) {
			String value = "";
			Object objOri = en.nextElement();
			String param = (String) objOri;
			String param1 = "";

			Batchcolumn batchcolumn = new Batchcolumn();

			batchcolumn.setBatchid(String.valueOf(batchid));

			if (param.contains("csvheader")) {
				String[] selected = request.getParameterValues(param);
				String columnconcat = "";
				for (int i = 0; i < selected.length; i++) {
					
					if (!selected[i].contains("none"))
						columnconcat = columnconcat + "$$" +getSelectedFieldIndex(selected[i]) + "$$" + " ";
				}

				param1 = (String) en.nextElement();

				columnconcat = columnconcat + " " + request.getParameter(param1);

				batchcolumn.setCsvcolumn(columnconcat);
				batchcolumns.add(batchcolumn);

				model.addObject(columnconcat);
				System.out.println(columnconcat);

			}
			number++;

		}

	  	

		batchdetail.setBatchid(String.valueOf(batchid));
		batchdetail.setBatchname(request.getParameter("batchname"));
		batchdetail.setBatchsize(Integer.valueOf(request.getParameter("batchsize")));
		batchdetail.setIsactive(true);

	

		batchdetail.setCreateddate(new Timestamp(new Date().getTime()));
		batchdetail.setUserid(1);
		batchdetail.setFilename(request.getParameter("csvfilename"));

		batchdetailService.savebatchdetail(batchdetail);
		batchcolumnService.savebatchdetail(batchcolumns);

		model.addObject("BatchNumber", batchid);
		model.addObject("BatchName", request.getParameter("batchname"));

		model.setViewName("template");
 
		return model;
	} 
 
	@GetMapping("/selectedFields/{batchid}")
	public ModelAndView GetselectedFields(@PathVariable("batchid") String batchid) {
		batchcolumnService.getBatchcolumnById(batchid);
		
		ModelAndView model = new ModelAndView();
	
		return null; 
	}

	// https://stackoverflow.com/questions/18227787/java-unique-10-digit-id
	private static final long LIMIT = 10000000000L;
	private static long last = 0;

	public static long getbatchID() {
		// 10 digits.
		long id = System.currentTimeMillis() % LIMIT;
		if (id <= last) {
			id = (last + 1) % LIMIT;
		}
		return last = id;
	}

}
