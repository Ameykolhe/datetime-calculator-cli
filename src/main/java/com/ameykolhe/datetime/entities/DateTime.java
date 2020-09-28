package com.ameykolhe.datetime.entities;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DateTime
 */

@Entity
@Table(name="expression")
public class DateTime {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="date1")
	LocalDate date1;
    
	@Column(name="date2")
	LocalDate date2;

	@Column(name="value")
    int value;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="operation")
    Operation operation;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="naturallanguageop")
	NaturalLanguageOps naturalLanguageOp;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="timeunits")
	TimeUnits timeUnits;
	
	@Column(name="timestamp")
    Timestamp timeStamp;
    
	@Enumerated(EnumType.ORDINAL)
	@Column(name="dataretrivalops")
    DataRetrivalOps dataRetrivalOps;

	@Column(name="result")
	String result;
	
	public DateTime() {
		timeStamp =	new Timestamp(System.currentTimeMillis());
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getDate1() {
		return date1;
	}


	public void setDate1(LocalDate date1) {
		this.date1 = date1;
	}


	public LocalDate getDate2() {
		return date2;
	}


	public void setDate2(LocalDate date2) {
		this.date2 = date2;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public Operation getOperation() {
		return operation;
	}


	public void setOperation(Operation operation) {
		this.operation = operation;
	}


	public NaturalLanguageOps getNaturalLanguageOp() {
		return naturalLanguageOp;
	}


	public void setNaturalLanguageOp(NaturalLanguageOps naturalLanguageOp) {
		this.naturalLanguageOp = naturalLanguageOp;
	}


	public TimeUnits getTimeUnits() {
		return timeUnits;
	}


	public void setTimeUnits(TimeUnits timeUnits) {
		this.timeUnits = timeUnits;
	}


	public Timestamp getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}


	public DataRetrivalOps getDataRetrivalOps() {
		return dataRetrivalOps;
	}


	public void setDataRetrivalOps(DataRetrivalOps dataRetrivalOps) {
		this.dataRetrivalOps = dataRetrivalOps;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}
    

	@Override
	public String toString() {
		return "DateTime [id=" + id + ", date1=" + date1 + ", date2=" + date2 + ", value=" + value + ", operation="
				+ operation + ", naturalLanguageOp=" + naturalLanguageOp + ", timeUnits=" + timeUnits + ", timeStamp="
				+ timeStamp + ", dataRetrivalOps=" + dataRetrivalOps + ", result=" + result + "]";
	}

}