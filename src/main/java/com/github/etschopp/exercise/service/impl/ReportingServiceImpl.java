package com.github.etschopp.exercise.service.impl;

import com.github.etschopp.exercise.domain.Checkk;
import com.github.etschopp.exercise.domain.Employee;
import com.github.etschopp.exercise.domain.EmployeeReportData;
import com.github.etschopp.exercise.domain.LaborEntry;
import com.github.etschopp.exercise.domain.OrderedItem;
import com.github.etschopp.exercise.domain.Report;
import com.github.etschopp.exercise.domain.ReportData;
import com.github.etschopp.exercise.domain.TimeFrame;

import com.github.etschopp.exercise.service.CheckService;
import com.github.etschopp.exercise.service.EmployeeService;
import com.github.etschopp.exercise.service.LaborEntryService;
import com.github.etschopp.exercise.service.OrderedItemService;
import com.github.etschopp.exercise.service.ReportingService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import java.util.UUID;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Interval;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Weeks;

import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
@Slf4j
public class ReportingServiceImpl implements ReportingService {

    private CheckService checkService;

    private EmployeeService employeeService;
	
	private LaborEntryService laborEntryService;

    private OrderedItemService orderedItemService;

    public Report generateReport(UUID business_id, String report, String timeInterval, String start, String end) {  

           log.info("report : " + report);

           List<ReportData> listReportData = new ArrayList<ReportData>();

           DateTime startDateTime = DateTime.parse(start);
           log.info("startDateTime : " + startDateTime.toString());

           DateTime endDateTime = DateTime.parse(end);
           
           if (timeInterval.equalsIgnoreCase("hour")) {

               Hours hours = Hours.hoursBetween(startDateTime, endDateTime);

               int numHours = hours.getHours();

               for (int x = 1; x <= numHours; ++x) {
                   log.info("hours " + (x-1) + " : " + startDateTime.plusHours(x-1).toString());
                   log.info("hours " + x + " : " + startDateTime.plusHours(x).toString());
                   //listReportData.add(new ReportData(new TimeFrame(startDateTime.plusHours(x-1).toString(),startDateTime.plusHours(x).toString()), 113.0));
                   listReportData.addAll(generateReportData(startDateTime.plusHours(x-1), startDateTime.plusHours(x), report, business_id));
               }

               // Check if we have any overflow time that needs to be accounted for
               if (endDateTime.isAfter(startDateTime.plusHours(numHours))) {
                   //listReportData.add(new ReportData(new TimeFrame(startDateTime.plusHours(numHours).toString(), endDateTime.toString()), 113.0));
                   listReportData.addAll(generateReportData(startDateTime.plusHours(numHours), endDateTime, report, business_id));
               }

           }

           else if (timeInterval.equalsIgnoreCase("day")) {
           //    log.error("day : " + interval.toPeriod().toStandardDays().toString());
               Days days = Days.daysBetween(startDateTime, endDateTime);

               int numDays = days.getDays();

               for (int x = 1; x <= numDays; ++x) {
                   log.info("days " + (x-1) + " : " + startDateTime.plusDays(x-1).toString());
                   log.info("days " + x + " : " + startDateTime.plusDays(x).toString());
                   //listReportData.add(new ReportData(new TimeFrame(startDateTime.plusDays(x-1).toString(), startDateTime.plusDays(x).toString()), 113.0));
				   listReportData.addAll(generateReportData(startDateTime.plusDays(x-1), startDateTime.plusDays(x), report, business_id));
               }

               // Check if we have any overflow time that needs to be accounted for
               if (endDateTime.isAfter(startDateTime.plusDays(numDays))) {
                   //listReportData.add(new ReportData(new TimeFrame(startDateTime.plusDays(numDays).toString(), endDateTime.toString()), 113.0));
				   listReportData.addAll(generateReportData(startDateTime.plusDays(numDays), endDateTime, report, business_id));
               }
           }


           else if (timeInterval.equalsIgnoreCase("week")) {
           //    log.error("week : " + interval.toPeriod().toStandardWeeks().toString());
               Weeks weeks = Weeks.weeksBetween(startDateTime, endDateTime);

               int numWeeks = weeks.getWeeks();

               for (int x = 1; x <= numWeeks; ++x) {
                   log.info("weeks " + (x-1) + " : " + startDateTime.plusWeeks(x-1).toString());
                   log.info("weeks " + x + " : " + startDateTime.plusWeeks(x).toString());
                   //listReportData.add(new ReportData(new TimeFrame(startDateTime.plusWeeks(x-1).toString(), startDateTime.plusWeeks(x).toString()), 113.0));
				   listReportData.addAll(generateReportData(startDateTime.plusWeeks(x-1), startDateTime.plusWeeks(x), report, business_id));
               }

               // Check if we have any overflow time that needs to be accounted for
               if (endDateTime.isAfter(startDateTime.plusWeeks(numWeeks))) {
                   //listReportData.add(new ReportData(new TimeFrame(startDateTime.plusWeeks(numWeeks).toString(), endDateTime.toString()), 113.0));
				   listReportData.addAll(generateReportData(startDateTime.plusWeeks(numWeeks), endDateTime, report, business_id));
               }
           }
           else if (timeInterval.equalsIgnoreCase("month")) {
           //    log.error("month : " + interval.toPeriod().toString());

               Months months = Months.monthsBetween(startDateTime, endDateTime);

               int numMonths = months.getMonths();

               for (int x = 1; x <= numMonths; ++x) {
                   log.info("months " + (x-1) + " : " + startDateTime.plusMonths(x-1).toString());
                   log.info("months " + x + " : " + startDateTime.plusMonths(x).toString());
                   //listReportData.add(new ReportData(new TimeFrame(startDateTime.plusMonths(x-1).toString(), startDateTime.plusMonths(x).toString()), 113.0));
				   listReportData.addAll(generateReportData(startDateTime.plusMonths(x-1), startDateTime.plusMonths(x), report, business_id));
               }

               // Check if we have any overflow time that needs to be accounted for
               if (endDateTime.isAfter(startDateTime.plusMonths(numMonths))) {
                   //listReportData.add(new ReportData(new TimeFrame(startDateTime.plusMonths(numMonths).toString(), endDateTime.toString()), 113.0));
				   listReportData.addAll(generateReportData(startDateTime.plusMonths(numMonths), endDateTime, report, business_id));
               }
           }


          log.info("endDateTime : " + endDateTime.toString());

          return new Report(report, timeInterval, listReportData);

    }

    public List<ReportData> generateReportData (DateTime startDateTime, DateTime endDateTime, String reportType, UUID businessID) {

       // ReportData reportData = new ReportData(new TimeFrame(startDateTime.toString(),startDateTime.toString()), 113.0);
	   
	   List<ReportData> reportData = new ArrayList<ReportData>();

       // EGS - Get employees by business_id, then get checks from the time range and then get ordered items from the check id. Skip voided items. Sum the selling prices for each employee      
       // FCP - Get checks from the time range and then get ordered items from the check id. Return sum(item cost) / sum(price)
       // LCP - need laborentries and checks from time range. Sum the labor cost (rate * hours) and the sales, then labor cost/sales

       if (reportType.equalsIgnoreCase("EGS")) {
           log.info("generateReportData  : EGS report");

           for (Employee ebbid : employeeService.getEmployees(businessID)) {
              log.info("employee : " + ebbid.getFirst_name() + " " + ebbid.getLast_name() + "\n");

			  double price = 0.0;
			  
			  List<Checkk> checksByEmployeeID = checkService.getChecksByEmployee(ebbid.getId()).stream().filter(c -> DateTime.parse(c.getClosed_at()).isAfter(startDateTime)).filter(c -> DateTime.parse(c.getClosed_at()).isBefore(endDateTime)).collect(Collectors.toList());
         
              for(Checkk cbeid : checksByEmployeeID) {
                  log.info("check : " + cbeid.getId() + "\n");
                  List<OrderedItem> orderedItemByCheckID = orderedItemService.getOrderedItems(cbeid.getId()).stream().filter(c -> c.isVoided() == false).collect(Collectors.toList()); 

                  for(OrderedItem oibcid : orderedItemByCheckID) {
                     log.info("to string : " + oibcid.toString() + "\n");
					 price += oibcid.getPrice();
					 log.info("price : " + oibcid.getPrice() + "\n");
                  }
                   
              }
			  
			reportData.add(new EmployeeReportData(new TimeFrame(startDateTime.toString(), endDateTime.toString()), price, ebbid.getFirst_name() + " " + ebbid.getLast_name()));
			
           }
           
       }
       else if (reportType.equalsIgnoreCase("FCP")) {
		   
		   log.info("generateReportData  : FCP report");
		   
		   double cost = 0.0;
		   double price = 0.0;
		   double fcp = 0.0;

           for (Employee ebbid : employeeService.getEmployees(businessID)) {
 			  
			  List<Checkk> checksByEmployeeID = checkService.getChecksByEmployee(ebbid.getId()).stream().filter(c -> DateTime.parse(c.getClosed_at()).isAfter(startDateTime)).filter(c -> DateTime.parse(c.getClosed_at()).isBefore(endDateTime)).collect(Collectors.toList());
         
              for(Checkk cbeid : checksByEmployeeID) {
                  log.info("check : " + cbeid.getId() + "\n");
                  List<OrderedItem> orderedItemByCheckID = orderedItemService.getOrderedItems(cbeid.getId()); 

                  for(OrderedItem oibcid : orderedItemByCheckID) {
                     log.info("to string : " + oibcid.toString() + "\n");
					 cost += oibcid.getCost();
					 log.info("cost : " + oibcid.getCost() + "\n");
					 price += oibcid.getPrice();
					 log.info("price : " + oibcid.getPrice() + "\n");
					 log.info("cost/price : " + cost/price + "\n");
                     log.info("ordered item  : " + oibcid.getName() + " cost : " + oibcid.getCost() + " price : " + oibcid.getPrice() + "cost/price" + cost/price + "\n");
                  }
                   
              }
			  
           }
		   
			  
		   //if (Double.isNaN(cost/price) == true) {fcp = 0.0;}
		   //else {fcp = Double.parseDouble(new DecimalFormat(".##").format(cost/price));}
		   
		   if (cost == 0.0) {fcp = 0.0;}
		   else if (price == 0.0) {fcp = 0.0;}
		   else {fcp = Double.parseDouble(new DecimalFormat(".##").format(cost/price));}
			  
		   reportData.add(new ReportData(new TimeFrame(startDateTime.toString(), endDateTime.toString()), fcp));
	   }
       else if (reportType.equalsIgnoreCase("LCP")) {
		   
		   log.info("generateReportData  : LCP report");
		   
		   double labor = 0.0;
		   double sales = 0.0;
		   double lcp = 0.0;

           for (Employee ebbid : employeeService.getEmployees(businessID)) {
			   
			  double rate = ebbid.getPay_rate();
 			  
			  List<Checkk> checksByEmployeeID = checkService.getChecksByEmployee(ebbid.getId()).stream().filter(c -> DateTime.parse(c.getClosed_at()).isAfter(startDateTime)).filter(c -> DateTime.parse(c.getClosed_at()).isBefore(endDateTime)).collect(Collectors.toList());
         
              for(Checkk cbeid : checksByEmployeeID) {
                  log.info("check : " + cbeid.toString() + "\n");
				  //List<OrderedItem> orderedItemByCheckID = orderedItemService.getOrderedItems(cbeid.getId()).stream().filter(c -> c.isVoided() == false).collect(Collectors.toList()); 
                  List<OrderedItem> orderedItemByCheckID = orderedItemService.getOrderedItems(cbeid.getId()); 

                  for(OrderedItem oibcid : orderedItemByCheckID) {
                     log.info("to string : " + oibcid.toString() + "\n");
					 sales += oibcid.getPrice();
					 log.info("price : " + oibcid.getPrice() + "\n");
					 log.info("sales : " + sales + "\n");
                     //log.info("ordered item  : " + oibcid.getName() + " cost : " + oibcid.getCost() + " price : " + oibcid.getPrice() + "cost/price" + cost/price + "\n");
                  }
                   
              }
			  
			  Interval startEndInterval = new Interval (startDateTime, endDateTime);
			     
			  //List<LaborEntry> laborEntryByEmployeeID = laborEntryService.getLaborEntriesByEmployee(ebbid.getId());
			  
			  //for (LaborEntry lebeid : laborEntryByEmployeeID) {
				//  log.info("lebeid : " + lebeid.toString() + "\n");
			  //}
			  
			  List<LaborEntry> laborEntryByEmployeeID = laborEntryService.getLaborEntriesByEmployee(ebbid.getId()).stream().filter(c -> Interval.parse(c.getClock_in() + "/" + c.getClock_out()).overlaps(startEndInterval) == true).collect(Collectors.toList());
			  
			  for (LaborEntry lebeid : laborEntryByEmployeeID) {
				  
				  double shiftPay = 0.0;
				  double shiftPayInMinutes = 0.0;
				  
				  log.info("lebeid to string : " + lebeid.toString() + "\n");
				  log.info("startEndInterval to string : " + startEndInterval.toString() + "\n");
				  
				  
				  Interval shift = Interval.parse(lebeid.getClock_in() + "/" + lebeid.getClock_out());
				  log.info("shift to string : " + shift.toString() + "\n");
							  
				  // Get the number of minutes, to account for partial hours in a shift
				  shiftPayInMinutes = Minutes.minutesIn(startEndInterval.overlap(shift)).getMinutes();
				  log.info("shiftPayInMinutes : " + shiftPayInMinutes + "\n");
				  
				  shiftPay = (rate * shiftPayInMinutes) / 60;
				  log.info("shiftPay : " + shiftPay + "\n");
				  
				  labor += shiftPay;
				  log.info("running labor total : " + labor + "\n");
			  }
			  
           }
		   
			  
		   log.info("total labor : " + labor + "\n");
		   log.info("total sales : " + sales + "\n");
		   
		   if (labor == 0.0) {lcp = 0.0;}
		   else if (sales == 0.0) {lcp = 0.0;}
		   else {lcp = Double.parseDouble(new DecimalFormat(".##").format(labor/sales));}

		  			  
		   reportData.add(new ReportData(new TimeFrame(startDateTime.toString(), endDateTime.toString()), lcp));
	   }

       return reportData;
    }

}