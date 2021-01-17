package com.CSV;

import edu.duke.FileResource;
import org.apache.commons.csv.*;


public class Main {

    String exports = "C:\\Users\\Francesco\\Desktop\\Coursera\\JavaProgrammingAndSoftwareEngineeringFundamentals\\Course2_JavaProgramming_SolvingProblemsWithSoftware\\Week3\\Parsing Export Data\\exports\\exportdata.csv";

    public void tester(String filePath){
        FileResource fr = new FileResource(filePath);
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");

    }

    public String countryInfo(CSVParser parser, String country){
        String cinfo,exports=" ",value=" ";

        for (CSVRecord r:parser){
            String cntry = r.get("Country");
            if(cntry.contains(country)){
                exports = r.get("Exports");
                value = r.get("Value (dollars)");
            }
        }

        cinfo = "\n" + country + ": " + exports + ": " + value;

        return cinfo;
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){

        for(CSVRecord r:parser){
            String exports = r.get("Exports");
            if(exports.contains(exportItem1)&&exports.contains(exportItem2)){
                String country = r.get("Country");
                System.out.println("\n"+country);
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem){
        int howMany=0;

        for(CSVRecord r:parser){
            String exports = r.get("Exports");
            if(exports.contains(exportItem)){
                howMany++;
            }

        }

        return howMany;
    }



    public void bigExporters(CSVParser parser, String threshold){

        for(CSVRecord r:parser){
            String currValue = r.get("Value (dollars)");
            if(currValue.length()>threshold.length()){
                String country = r.get("Country");
                System.out.println("\n"+country+" "+currValue);
            }

        }

    }


    public static void main(String[] args) {
	    com.CSV.Main m = new com.CSV.Main();
	    FileResource fr = new FileResource(m.exports);
	    CSVParser parser = fr.getCSVParser();
	    //int cocoaHowMany = m.numberOfExporters(parser,"cocoa");
        //System.out.println("\n"+cocoaHowMany+" countries export cocoa.");
        m.bigExporters(parser,"$999,999,999,999");
    }
}
