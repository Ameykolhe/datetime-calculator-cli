package com.ameykolhe.datetime.calculator;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import com.ameykolhe.datetime.entities.DataRetrivalOps;
import com.ameykolhe.datetime.entities.NaturalLanguageOps;
import com.ameykolhe.datetime.entities.TimeUnits;

public class DateTimeCalculator {

	public String diff_between_dates(LocalDate date1, LocalDate date2, TimeUnits timeUnits) {
		String result = "";
		switch(timeUnits) {
			case ALL:
				Period p;
				if(date1.isBefore(date2)) {
					p = Period.between(date1, date2);
				}
				else {
					p = Period.between(date2, date1);
				}
				if (p.getYears() > 0) {
					System.out.println(p.getYears() + " years");
					result += String.format("%d Years", p.getYears());
				}
				if (p.getMonths() > 0) {
					result += String.format(" %d Months", p.getMonths());
				}
				if (p.getDays() > 0) {
					result += String.format(" %d Days", p.getDays());
				}
				break;
			case DAYS:
				result = String.valueOf(ChronoUnit.DAYS.between(date1, date2)) + " Days";
				break;
			case MONTHS:
				result = String.valueOf(ChronoUnit.MONTHS.between(date1, date2)) + " Months" ;
				break;
			case WEEKS:
				result = String.valueOf(ChronoUnit.WEEKS.between(date1, date2)) + " Weeks";
				break;
			case YEARS:
				result = String.valueOf(ChronoUnit.YEARS.between(date1, date2)) + " Years";
				break;
			default:
				break;
		}
		return result;
	}
    
	public String addNUnits(LocalDate date, int value, TimeUnits timeUnits) {
		String result = "";
		switch(timeUnits) {
			case DAYS:
				result = date.plusDays(value).toString();
				break;
			case MONTHS:
				result = date.plusMonths(value).toString();
				break;
			case WEEKS:
				result = date.plusWeeks(value).toString();
				break;
			case YEARS:
				result = date.plusYears(value).toString();
				break;
			default:
				break;
		}
		return result;
	}
	
	
	public String subNUnits(LocalDate date, int value, TimeUnits timeUnits) {
		String result = "";
		switch(timeUnits) {
			case DAYS:
				result = date.plusDays(-value).toString();
				break;
			case MONTHS:
				result = date.plusMonths(-value).toString();
				break;
			case WEEKS:
				result = date.plusWeeks(-value).toString();
				break;
			case YEARS:
				result = date.plusYears(-value).toString();
				break;
			default:
				break;
		}
		return result;
	}
	

	public String processNaturalLanguagePhrases(NaturalLanguageOps naturalLanguageOp) {
		String result = "";
		switch(naturalLanguageOp) {
			case DAY_AFTER_TOMORROW:
				result = LocalDate.now().plusDays(2).toString();
				break;
			case DAY_BEFORE_YESTERDAY:
				result = LocalDate.now().plusDays(-2).toString();
				break;
			case LAST_MONTH:
				result = LocalDate.now().plusMonths(-1).toString();
				break;
			case LAST_WEEK:
				result = LocalDate.now().plusWeeks(-1).toString();
				break;
			case LAST_YEAR:
				result = LocalDate.now().plusYears(-1).toString();
				break;
			case NEXT_MONTH:
				result = LocalDate.now().plusMonths(1).toString();
				break;
			case NEXT_WEEK:
				result = LocalDate.now().plusWeeks(1).toString();
				break;
			case NEXT_YEAR:
				result = LocalDate.now().plusYears(1).toString();
				break;
			case TODAY:
				result = LocalDate.now().toString();
				break;
			case TOMORROW:
				result = LocalDate.now().plusDays(1).toString();
				break;
			case YESTERDAY:
				result = LocalDate.now().plusDays(-1).toString();
				break;
			default:
				break;
		}
		return result;
	}

	public String getDataFromDate(LocalDate date1, DataRetrivalOps dataRetrivalOps) {
		String result = "";
		switch(dataRetrivalOps) {
			case DAY_OF_MONTH:
				result += "Day of Month : " + date1.getDayOfMonth();
				break;
			case DAY_OF_WEEK:
				result += "Day of Week : " + date1.getDayOfWeek();
				break;
			case DAY_OF_YEAR:
				result += "Day of Year : " + date1.getDayOfYear();
				break;
			case MONTH:
				result += "Month : " + date1.getMonth();
				break;
			case WEEK_NUMBER:
				result += "Week Number : " + (int)Math.ceil(date1.getDayOfYear() / 7.0);
				break;
			case YEAR:
				result += "Year : " + date1.getYear();
				break;
			default:
				break;
		}
		return result;
	}
}
