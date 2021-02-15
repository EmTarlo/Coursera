package com.Week3;
/**
 * Write a description of class com.Week3.LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     private String source;
     
     public LogAnalyzer() {
         records = new ArrayList<>();
         source = "C:\\Users\\Francesco\\Desktop\\Coursera\\Java&Co\\Course3_JavaProgramming_Arrays_Lists_StructuredData\\Week3\\Input_Files\\";
     }
        
     public void readFile(String filename) {
         LogEntry logEntry;
         FileResource fr = new FileResource(source+filename);
         for(String le:fr.lines()){
             logEntry = WebLogParser.parseEntry(le);
             records.add(logEntry);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }

     public int countUniqueIPs(){
         int count_distinct_IPs;
         ArrayList<String> unique_IPs = new ArrayList<>();
         String curr_ip;
         for (LogEntry le:records) {
             curr_ip = le.getIpAddress();
             if(!unique_IPs.contains(curr_ip)){
                 unique_IPs.add(curr_ip);
             }
         }
         count_distinct_IPs = unique_IPs.size();
         return count_distinct_IPs;
     }

     public void  printAllHigherThanNum(int threshold){
         for (LogEntry le:records) {
             if(le.getStatusCode()>threshold){
                 System.out.println(le);
             }
         }
     }


     public ArrayList<String> uniqueIPVisitsOnDay(String date){
         ArrayList<String> unique_IPs_On_Day = new ArrayList<>();
         String curr_ip;
         for (LogEntry le:records) {

             LocalDate curr_dateTime = le.getAccessTime();
             int day = curr_dateTime.getDayOfMonth();
             String month_full = curr_dateTime.getMonth().toString();
             String month = month_full.substring(0,1) + month_full.substring(1,3).toLowerCase();
             String curr_date_as_String = month+" "+day;

             if (curr_date_as_String.equals(date)) {
                 curr_ip = le.getIpAddress();


                 if (!unique_IPs_On_Day.contains(curr_ip)) {
                     unique_IPs_On_Day.add(curr_ip);
                 }
             }
         }
         return unique_IPs_On_Day;
     }

    public int countUniqueIPsInRange(int threshold1, int threshold2){
        ArrayList<String> unique_IPs_In_Range = new ArrayList<>();
        String curr_ip;
        int curr_status_code;
        for (LogEntry le:records) {
            curr_status_code = le.getStatusCode();
            if (curr_status_code>=threshold1 && curr_status_code<=threshold2) {
                curr_ip = le.getIpAddress();
                if (!unique_IPs_In_Range.contains(curr_ip)) {
                    unique_IPs_In_Range.add(curr_ip);
                }
            }
        }
        return unique_IPs_In_Range.size();
    }

    public HashMap<String,Integer> countVisitsPerIP(){
        HashMap<String,Integer> visitsPerIP = new HashMap<>();
        for (LogEntry le:records){
            String curr_ip = le.getIpAddress();
            if(!visitsPerIP.containsKey(curr_ip)) {
                visitsPerIP.put(curr_ip, 1);
            }
            else{
                int curr_count = visitsPerIP.get(curr_ip);
                curr_count+=1;
                visitsPerIP.put(curr_ip,curr_count);
            }
        }

        return visitsPerIP;
    }

    public int mostNumberVisitsByIP(HashMap<String,Integer> visitsPerIP){
         int max = 0;

         for(String ip:visitsPerIP.keySet()){
             int curr_visits = visitsPerIP.get(ip);
             if(curr_visits>max){
                 max = curr_visits;
             }
         }
        return max;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> visitsPerIP){
         ArrayList<String> ips_with_counts = new ArrayList<>();
         int max = mostNumberVisitsByIP(visitsPerIP);
         for(String ip:visitsPerIP.keySet()){
             int curr_visits = visitsPerIP.get(ip);
             if(curr_visits==max){
                 ips_with_counts.add(ip);
             }
         }
         return ips_with_counts;
    }

    public HashMap<String,ArrayList<String>> iPsForDays(){
        HashMap<String,ArrayList<String>> date_to_IPs = new HashMap<String,ArrayList<String>>();
        for(LogEntry le:records){

            LocalDate date = le.getAccessTime();
            int day = date.getDayOfMonth();
            String month_full = date.getMonth().toString();
            String month = month_full.substring(0,1) + month_full.substring(1,3).toLowerCase();
            String curr_date_as_String = month+" "+day;
            String curr_ip = le.getIpAddress();
            if(!date_to_IPs.containsKey(curr_date_as_String)) {
                ArrayList<String> new_Array = new ArrayList<>();
                new_Array.add(curr_ip);
                date_to_IPs.put(curr_date_as_String,new_Array);
            }
            else{
                ArrayList<String> curr_Array = date_to_IPs.get(curr_date_as_String);
                curr_Array.add(curr_ip);
            }

        }

    return date_to_IPs;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> date_to_IPs){
         String day_most_visits = new String();
         int max_visits=0;
         for(String date:date_to_IPs.keySet()){
             ArrayList<String> curr_array = date_to_IPs.get(date);
             int curr_visits = curr_array.size();
             if(curr_visits>max_visits){
                 max_visits = curr_visits;
                 day_most_visits = date;
             }
         }
         return day_most_visits;
    }

    public ArrayList<String>  iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> date_to_IPs,String date){
        ArrayList<String> ips_on_date = date_to_IPs.get(date);
        HashMap<String, Integer> ips_on_date_count_visits = new HashMap<>();
        for(String ip:ips_on_date){
            if(!ips_on_date_count_visits.containsKey(ip)){
                ips_on_date_count_visits.put(ip,1);
            }else{
                int curr_count =  ips_on_date_count_visits.get(ip);
                curr_count++;
                ips_on_date_count_visits.put(ip,curr_count);
            }
        }

        int max_visits_on_date = mostNumberVisitsByIP(ips_on_date_count_visits);

        ArrayList<String> ips_with_max_visits_on_date = new ArrayList<>();

        for(String ip:ips_on_date_count_visits.keySet()){
            if(ips_on_date_count_visits.get(ip)==max_visits_on_date){
                ips_with_max_visits_on_date.add(ip);
            }
        }

        return ips_with_max_visits_on_date;

    }


}








