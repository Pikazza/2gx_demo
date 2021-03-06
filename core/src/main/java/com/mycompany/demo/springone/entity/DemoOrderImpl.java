package com.mycompany.demo.springone.entity;

import org.broadleafcommerce.core.order.domain.OrderImpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="DEMO_ORDER")
public class DemoOrderImpl extends OrderImpl implements DemoOrder {

	private static final long serialVersionUID = 1L;

	@Column(name="EXPIRY_DATE")
	protected Date expirationDate;
	
	@Override
	public Date getExpirationDate() {
		return this.expirationDate;
	}

	@Override
	public void setExpirationDate(Date date) {
		this.expirationDate = date;
	}
	
    @Override
	public Long getSecondsUntilExpiration() {
	    Date now = new Date();
	    
	    Long secondsUntilExpiration = 0L;
	    if (expirationDate != null) {
	        secondsUntilExpiration = (expirationDate.getTime() - now.getTime()) / 1000;
	    }
	    
	    return secondsUntilExpiration;
	}

}
