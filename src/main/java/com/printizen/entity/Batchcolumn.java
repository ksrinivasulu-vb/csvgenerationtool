package com.printizen.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batchcolumns")
public class Batchcolumn implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4959490404228202736L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  id;
	
	private String batchid;
	private String csvcolumn;
	
	
	public Batchcolumn() {}
	
	public Batchcolumn(String Batchid,String CsvColumn,String CsvColumnData) {
		
		this.setBatchid(Batchid);
		this.setCsvcolumn(CsvColumn);
		

	}

	public String getBatchid() {
		return batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	public String getCsvcolumn() {
		return csvcolumn;
	}

	public void setCsvcolumn(String csvcolumn) {
		this.csvcolumn = csvcolumn;
	}

	
	
	@Override
	  public String toString() {
	    return String.format("batchid=%s, csvcolumn='%s']", batchid, csvcolumn);
	  }

}
