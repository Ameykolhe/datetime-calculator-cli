package com.ameykolhe.datetime.service;

import java.util.ArrayList;
import java.util.List;

import com.ameykolhe.datetime.calculator.DateTimeCalculator;
import com.ameykolhe.datetime.dao.DateTimeDAO;
import com.ameykolhe.datetime.entities.DateTime;
import com.ameykolhe.datetime.exceptions.InvalidOperationException;

public class DateTimeCalculatorService {
	
	DateTimeDAO dateTimeDAO = new DateTimeDAO();
	
	DateTimeCalculator dateTimeCalculator = new DateTimeCalculator();
	
	
	public List<String> getHistory() {
		List<DateTime> history = dateTimeDAO.getHisotry();
		List<String> processedHistory = new ArrayList<>();
		
		history.forEach( element -> {
			String processedHistoryElement = element.getOperation().toString();
			switch(element.getOperation()) {
				case ADD_N_UNITS:
					processedHistoryElement += " : " + element.getDate1() + " + " + element.getValue() + " " + element.getTimeUnits() + " = " + element.getResult();
					break;
				case DIFF_BETWEEN_DATES:
					processedHistoryElement += " : " + element.getDate1() + " & " + element.getDate2() + " = " + element.getResult();
					break;
				case GET_DATA_FROM_DATE:
					processedHistoryElement += " : " + element.getDate1() + " = " + element.getResult();
					break;
				case NATURAL_LANGUAGE_PHRASES:
					processedHistoryElement += " : " + element.getNaturalLanguageOp() + " = " + element.getResult();
					break;
				case SUB_N_UNITS:
					processedHistoryElement += " : " + element.getDate1() + " - " + element.getValue() + " " + element.getTimeUnits() + " = " + element.getResult();
					break;
				default:
					break;
			}
			
			processedHistory.add(processedHistoryElement);
		});
		
		
		return processedHistory;
	}
	
	
	public void calculate(DateTime dateTime) throws InvalidOperationException {
		String result = null;
		
		switch(dateTime.getOperation()) {
			
			case DIFF_BETWEEN_DATES:
				result = dateTimeCalculator.diff_between_dates(dateTime.getDate1(), dateTime.getDate2(), dateTime.getTimeUnits());
				break;
				
			case ADD_N_UNITS:
				result = dateTimeCalculator.addNUnits(dateTime.getDate1(), dateTime.getValue(), dateTime.getTimeUnits());
				break;
				
			case SUB_N_UNITS:
				result = dateTimeCalculator.subNUnits(dateTime.getDate1(), dateTime.getValue(), dateTime.getTimeUnits());
				break;
				
			case NATURAL_LANGUAGE_PHRASES:
				result = dateTimeCalculator.processNaturalLanguagePhrases(dateTime.getNaturalLanguageOp());
				break;
		
			case GET_DATA_FROM_DATE:
				result = dateTimeCalculator.getDataFromDate(dateTime.getDate1(), dateTime.getDataRetrivalOps());
				break;
				
				
			default:
				throw new InvalidOperationException(dateTime.getOperation());
		}
		
		dateTime.setResult(result);
		dateTimeDAO.add(dateTime);
	}

}
