package org.statefulj.webapp.model;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class LoanAccount extends Account {
	
	public static final String APPROVAL_PENDING = "APPROVAL_PENDING";
	
	@Transient
	public String getType() {
		return "Loan";
	}

}