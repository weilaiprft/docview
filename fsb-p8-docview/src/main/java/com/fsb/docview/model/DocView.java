package com.fsb.docview.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "document_viewed")
public class DocView {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "doc_guid")
	private String docGuid;
	
	@Column(name = "loan_number")
	private String loanNumber;

	@Column(name = "document_type")
	private String documentType;

	@Column(name = "document_created_date")
	private Date documentCreatedDate;
	
	@Column(name = "user_name")
	private String userName;

	@Column(name = "mortrac_status")
	private String mortracStatus;

	@Column(name = "uw_status")
	private String uwStatus;
	
	@Column(name = "viewed_time")
	private Date viewedTime;

	public DocView() {
    }

    public DocView(Date viewedTime) {
        this.viewedTime = viewedTime;
    }
	
    public DocView(String loanNumber, String docGuid, String documentType, Date documentCreatedDate, String userName, 
    		String mortracStatus, String uwStatus, Date viewedTime) {
    	
    	this.loanNumber = loanNumber;
    	this.docGuid = docGuid;
    	this.documentType = documentType;
    	this.documentCreatedDate = documentCreatedDate;
    	this.userName = userName;
    	this.mortracStatus = mortracStatus;
    	this.uwStatus = uwStatus;
        this.viewedTime = viewedTime;
        
    }
    
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Date getDocumentCreatedDate() {
		return documentCreatedDate;
	}

	public void setDocumentCreatedDate(Date documentCreatedDate) {
		this.documentCreatedDate = documentCreatedDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMortracStatus() {
		return mortracStatus;
	}

	public void setMortracStatus(String mortracStatus) {
		this.mortracStatus = mortracStatus;
	}

	public String getUwStatus() {
		return uwStatus;
	}

	public void setUwStatus(String uwStatus) {
		this.uwStatus = uwStatus;
	}

	public Date getViewedTime() {
		return viewedTime;
	}

	public void setViewedTime(Date viewedTime) {
		this.viewedTime = viewedTime;
	}

	public String getDocGuid() {
		return docGuid;
	}

	public void setDocGuid(String docGuid) {
		this.docGuid = docGuid;
	}

	
	
	
	
}
