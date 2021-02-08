package com.Week3;
/**
 * Write a description of class com.Week3.LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

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
     
     
}
