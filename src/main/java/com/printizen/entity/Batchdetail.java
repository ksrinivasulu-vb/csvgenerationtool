package com.printizen.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "batchdetails")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Batchdetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1202836034209109847L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String batchid;
	private String batchname;
	private Integer batchsize;
	private String filename;
	private Boolean isactive;
	private Timestamp createddate;
	private long userid;
	
	
	
	public Batchdetail() {}
	
	public Batchdetail(String Batchid,String Batchname, Timestamp createdDate, long userID ) {
		this.batchid=Batchid;
		this.batchname=Batchname;
		this.createddate= createdDate;
		this.userid=userID;
	}
	
	
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	public Integer getBatchsize() {
		return batchsize;
	}

	public void setBatchsize(Integer batchsize) {
		this.batchsize = batchsize;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	
	@Override
	  public String toString() {
	    return String.format("Batch ID=%s, Batch Name='%s', Created Date='%s', User ID=%d, File Name='%s']", batchid, batchname, createddate, userid,filename );
	  }

	

	
}
