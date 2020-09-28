package com.ameykolhe.datetime;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.ameykolhe.datetime.entities.DataRetrivalOps;
import com.ameykolhe.datetime.entities.DateTime;
import com.ameykolhe.datetime.entities.NaturalLanguageOps;
import com.ameykolhe.datetime.entities.Operation;
import com.ameykolhe.datetime.entities.TimeUnits;
import com.ameykolhe.datetime.exceptions.InvalidOperationException;
import com.ameykolhe.datetime.service.DateTimeCalculatorService;

/**
 * Hello world!
 *
 */
public class DateTimeCalculatorRunner 
{
    public static void main( String[] args ) throws InvalidOperationException
    {
        int operationChoice = 0;
        
        Scanner sc = new Scanner(System.in);
        
        DateTimeCalculatorService service = new DateTimeCalculatorService();
        
        do {
        	DateTime dateTime = new DateTime();
        	System.out.println("\n\n---------------------------------------------- Simple DateTime Calculator ----------------------------------------------\n");
        	System.out.println("\n1. Difference Between Dates\n2. Add N Units to date\n3. Sub N Units from Date");
        	System.out.println("4. Natural Language Phrases\n5. Get Data from Date\n6. Display History\n7. exit");
        	operationChoice = sc.nextInt();
        	if (0 < operationChoice && operationChoice < 6) {
        		dateTime.setOperation(Operation.values()[operationChoice - 1]);
        		switch(dateTime.getOperation()) {
					case ADD_N_UNITS:
						System.out.print("Enter Date (yyyy-mm-dd) : ");
						dateTime.setDate1(LocalDate.parse(sc.next()));
						System.out.print("1. Days\n2. Weeks\n3. Months\n4. Years\nSelect timeunit to add : ");
						dateTime.setTimeUnits(TimeUnits.values()[sc.nextInt() - 1]);
						System.out.print("Enter value : ");
						dateTime.setValue(sc.nextInt());
						service.calculate(dateTime);
						System.out.println("\nResult : " + dateTime.getResult());
						break;
					case DIFF_BETWEEN_DATES:
						System.out.print("Enter Date1 (yyyy-mm-dd) : ");
						dateTime.setDate1(LocalDate.parse(sc.next()));
						System.out.print("Enter Date2 (yyyy-mm-dd) : ");
						dateTime.setDate2(LocalDate.parse(sc.next()));
						System.out.print("1. Days\n2. Weeks\n3. Months\n4. Years\n5. All\nSelect Result Type : ");
						dateTime.setTimeUnits(TimeUnits.values()[sc.nextInt() - 1]);
						service.calculate(dateTime);
						System.out.println("\nResult : " + dateTime.getResult());
						break;
					case GET_DATA_FROM_DATE:
						System.out.print("Enter Date (yyyy-mm-dd) : ");
						dateTime.setDate1(LocalDate.parse(sc.next()));
						System.out.print("1. Day of Week\n2. Day of Month\n3. Day of Year\n4. Week number\n5. Month\n6. Year\nSelect data to retrieve : ");
						dateTime.setDataRetrivalOps(DataRetrivalOps.values()[sc.nextInt() - 1]);
						service.calculate(dateTime);
						System.out.println("\nResult : " + dateTime.getResult());
						break;
					case NATURAL_LANGUAGE_PHRASES:
						for (int i = 0; i < NaturalLanguageOps.values().length; i++) {
							String string = NaturalLanguageOps.values()[i].toString();
							System.out.println( i + 1 + ". " + string);
						}
						System.out.print("Select statement : ");
						dateTime.setNaturalLanguageOp(NaturalLanguageOps.values()[sc.nextInt() - 1]);
						service.calculate(dateTime);
						System.out.println("\nResult : " + dateTime.getResult());
						break;
					case SUB_N_UNITS:
						System.out.print("Enter Date (yyyy-mm-dd) : ");
						dateTime.setDate1(LocalDate.parse(sc.next()));
						System.out.print("1. Days\n2. Weeks\n3. Months\n4. Years\nSelect timeunit to substract : ");
						dateTime.setTimeUnits(TimeUnits.values()[sc.nextInt() - 1]);
						System.out.print("Enter value : ");
						dateTime.setValue(sc.nextInt());
						service.calculate(dateTime);
						System.out.println("\nResult : " + dateTime.getResult());
						break;
					default:
						break;
        		}
        	} else if (operationChoice == 6) {
        		List<String> history = service.getHistory();
        		System.out.println("------------------- HISTORY -------------------\n\n");
        		history.forEach(System.out::println);
        	}
        	
        }while(operationChoice != 7);
        System.out.println();
        
        sc.close();
    
        
        
        
//    	DateTime dateTime = new DateTime();
//    	
//    	LocalDate date1 = LocalDate.parse("2020-01-01");
//    	LocalDate date2 = LocalDate.parse("2020-09-27");
//    	
//    	dateTime.setDate1(date1);
//    	dateTime.setDate2(date2);
//    	dateTime.setValue(5);
//    	dateTime.setOperation(Operation.GET_DATA_FROM_DATE);
//    	dateTime.setDataRetrivalOps(DataRetrivalOps.WEEK_NUMBER);
//    	dateTime.setNaturalLanguageOp(NaturalLanguageOps.NEXT_MONTH);
//    	dateTime.setTimeUnits(TimeUnits.WEEKS);
//    	
//    	DateTimeCalculatorService dateTimeCalculatorService = new DateTimeCalculatorService();
//    	
//    	try {
//			dateTimeCalculatorService.calculate(dateTime);
//			System.out.println(dateTime.getResult());
//    	} catch (InvalidOperationException e) {
//			System.out.println(e.toString());
//		}
    
    }
}
