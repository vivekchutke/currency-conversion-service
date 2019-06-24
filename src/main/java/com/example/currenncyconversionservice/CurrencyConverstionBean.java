package com.example.currenncyconversionservice;

import java.math.BigDecimal;

public class CurrencyConverstionBean {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversitionValue;
	private BigDecimal qty;
	private BigDecimal totalCalculatedValue;
	private int portNumber;
	
	
	
	
	public CurrencyConverstionBean() {

	}

	@Override
	public String toString() {
		return "CurrencyConverstionBean [id=" + id + ", from=" + from + ", to=" + to + ", conversitionValue="
				+ conversitionValue + ", qty=" + qty + ", totalCalculatedValue=" + totalCalculatedValue + ", port="
				+ portNumber + "]";
	}

	public CurrencyConverstionBean(Long id, String from, String to, BigDecimal conversitionValue, BigDecimal qty,
			BigDecimal totalCalculatedValue, int portNumber) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversitionValue = conversitionValue;
		this.qty = qty;
		this.totalCalculatedValue = totalCalculatedValue;
		this.portNumber = portNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}


	public BigDecimal getConversitionValue() {
		return conversitionValue;
	}

	public void setConversitionValue(BigDecimal conversitionValue) {
		this.conversitionValue = conversitionValue;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public BigDecimal getTotalCalculatedValue() {
		return totalCalculatedValue;
	}

	public void setTotalCalculatedValue(BigDecimal totalCalculatedValue) {
		this.totalCalculatedValue = totalCalculatedValue;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}


}
