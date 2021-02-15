package com.Week3;
/**
 * Write a description of class com.Week3.Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.time.LocalDate;
import java.util.*;

public class Tester
{
    /*public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new LocalDate(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }*/
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }

    public void testUniqueIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        int unique_ips_count = la.countUniqueIPs();
        System.out.println(unique_ips_count);
    }

    public void testPrintAllHigherThanNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(400);
    }

    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        ArrayList<String> result = la.uniqueIPVisitsOnDay("Sep 27");
        System.out.println(result.size());

    }

    public void testCountUniqueIPsInRange(){
        int count_unique_IPs_in_range;
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        count_unique_IPs_in_range = la.countUniqueIPsInRange(400,499);
        System.out.println(count_unique_IPs_in_range + " unique IP addresses were found meeting the specified conditions.");

    }

    public void testCountVisitsPerIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String,Integer> visits_per_IP = la.countVisitsPerIP();
        System.out.println(visits_per_IP);

    }

    public void testMostNumberVisitsByIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,Integer> visitsPerIP = la.countVisitsPerIP();
        int mostNumberVisits = la.mostNumberVisitsByIP(visitsPerIP);
        System.out.println("\nMost number of visits was: "+mostNumberVisits);

    }

    public void  testIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,Integer> visitsPerIP = la.countVisitsPerIP();
        ArrayList<String> ips_most_visits = la.iPsMostVisits(visitsPerIP);
        System.out.println(ips_most_visits);

    }

    public void  testIPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String,ArrayList<String>> date_to_IPs = la.iPsForDays();
        System.out.println(date_to_IPs);
    }

    public void testDayWithMostIPVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> iPsForDays = la.iPsForDays();
        String day_most_visits = la.dayWithMostIPVisits(iPsForDays);
        System.out.println(day_most_visits);

    }

    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> iPsForDays = la.iPsForDays();
        ArrayList<String> ipsWithMostVisitsOnDate = la.iPsWithMostVisitsOnDay(iPsForDays,"Sep 30");
        System.out.println(ipsWithMostVisitsOnDate);
    }


}
