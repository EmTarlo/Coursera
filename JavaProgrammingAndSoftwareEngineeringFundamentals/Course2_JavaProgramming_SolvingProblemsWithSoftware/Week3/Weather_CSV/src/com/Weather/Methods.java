package com.Weather;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class Methods {

    String filePath = "C:\\Users\\Francesco\\Desktop\\Coursera\\JavaProgrammingAndSoftwareEngineeringFundamentals\\Course2_JavaProgramming_SolvingProblemsWithSoftware\\Week3\\Weather_CSV\\nc_weather\\";

    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestTempRecord = null;
        for(CSVRecord r:parser){
            if(coldestTempRecord==null){
                coldestTempRecord = r;
            }
            else{
                double currTemp = Double.parseDouble(r.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestTempRecord.get("TemperatureF"));
                if(currTemp<coldestTemp && currTemp!=-9999){
                    coldestTempRecord = r;
                }
            }


        }
    return coldestTempRecord;
    }


    public String  fileWithColdestTemperature(){
        String coldestTempFileName = null;
        Double coldestTemp = null;
        CSVRecord coldestTempRecord = null;
        DirectoryResource dir = new DirectoryResource();

        for(File f:dir.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currTempRecord = coldestHourInFile(fr.getCSVParser());
            double currTemp = Double.parseDouble(currTempRecord.get("TemperatureF"));

            if(coldestTemp==null){
                coldestTemp = currTemp;
            }else{
                if(currTemp<coldestTemp&&currTemp!=-9999){
                    coldestTemp=currTemp;
                    coldestTempRecord = currTempRecord;
                    coldestTempFileName = f.getPath();
                }
            }

        }
        return coldestTempFileName;
    }



    public void printAllTemps(String filePath){

        File f = new File(filePath);
        String fileName = f.getName();
        FileResource fr = new FileResource(f);
        CSVParser parser = fr.getCSVParser();

        for(CSVRecord r:parser){
            String dateTime = r.get("DateUTC");
            Double temp = Double.parseDouble(r.get("TemperatureF"));
            System.out.println("\n"+dateTime+": "+temp);
        }
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumidityRecord = null;
        for(CSVRecord currRecord:parser){
            if(lowestHumidityRecord==null){
                lowestHumidityRecord = currRecord;
            }else {
                if(!(currRecord.get("Humidity").equals("N/A"))) {
                    double currHumidity = Double.parseDouble(currRecord.get("Humidity"));
                    double lowestHumidity = Double.parseDouble(lowestHumidityRecord.get("Humidity"));
                    if (currHumidity < lowestHumidity) {
                        lowestHumidity = currHumidity;
                        lowestHumidityRecord = currRecord;
                    }
                }
            }
        }

    return lowestHumidityRecord;
    }

    public String  fileWithLowestHumidity() {
        String lowestHumidityFileName = null;
        Double lowestHumidity = null;
        CSVRecord lowestHumidityRecord = null;

        DirectoryResource dir = new DirectoryResource();

        for (File f : dir.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currHumidityRecord = lowestHumidityInFile(fr.getCSVParser());
            double currHumidity = Double.parseDouble(currHumidityRecord.get("Humidity"));

            if(lowestHumidity==null){
                lowestHumidity = currHumidity;
            }else{
            if(currHumidity < lowestHumidity && !(currHumidityRecord.get("Humidity").equals("N/A"))){
                lowestHumidity=currHumidity;
                lowestHumidityRecord = currHumidityRecord;
                lowestHumidityFileName = f.getPath();
            }
        }

        }
        return lowestHumidityFileName;

    }


    public double averageTemperatureInFile(CSVParser parser){
        double avg = 0;
        double sum = 0;
        int count = 0;

        for(CSVRecord r:parser){
            count++;
            sum = sum + Double.parseDouble(r.get("TemperatureF"));

        }

        avg = sum/count;

        return avg;

    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int threshold){
        double avgTemp=0;
        double count=0;
        double sum=0;
        String noTempMsg = "No temperatures with that humidity";

        for(CSVRecord r:parser){
            double currHumidity = Double.parseDouble(r.get("Humidity"));

            if(currHumidity>=threshold) {
                count++;
                sum = sum + Double.parseDouble(r.get("TemperatureF"));
            }

        }

        if(count==0){
            System.out.println("\n" + noTempMsg);
            avgTemp = -1;
        }else{
            avgTemp = sum/count;
        }

        return avgTemp;
    }

    public void testColdestHourInFile(){
        String path = filePath+"2014\\weather-2014-05-01.csv";
        FileResource fr = new FileResource(path);
        CSVParser parser = fr.getCSVParser();
        CSVRecord ch = coldestHourInFile(parser);
        double coldestTemp = Double.parseDouble(ch.get("TemperatureF"));
        System.out.println("\nLowest temperature on this day was: "+coldestTemp);

    }

    public void testFileWithColdestTemperature(){

        String fileColdestTemp = fileWithColdestTemperature();
        File f = new File(fileColdestTemp);
        String fileName = f.getName();
        FileResource fr = new FileResource(f);
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestHourRecord = coldestHourInFile(parser);
        Double coldestTemp = Double.parseDouble(coldestHourRecord.get("TemperatureF"));;

        System.out.println("\n"+"Coldest day is in file: "+fileName);
        System.out.println("\n"+"The coldest temperature in that file is: "+coldestTemp);
        /*System.out.println("\n"+"All the temperatures from the coldest day are: ");

        printAllTemps(fileColdestTemp);*/

    }

    public  void testLowestHumidityInFile(){
        String fileName = filePath+"\\2014\\weather-2014-07-22.csv";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidityRecord = lowestHumidityInFile(parser);
        Double lowestHumidity = Double.parseDouble(lowestHumidityRecord.get("Humidity"));
        String dateTime = lowestHumidityRecord.get("DateUTC");
        System.out.println("\nLowest Humidity was: " + lowestHumidity + " at " + dateTime);


    }



    public void testFileWithLowestHumidity(){

        String fileLowestHumidity = fileWithLowestHumidity();
        File f = new File(fileLowestHumidity);
        String fileName = f.getName();
        FileResource fr = new FileResource(f);
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidityRecord = lowestHumidityInFile(parser);
        Double lowestHumidity = Double.parseDouble(lowestHumidityRecord.get("Humidity"));;

        System.out.println("\n"+"Day with lowest humidity is in file: "+fileName);
        System.out.println("\n"+"The lowest humidity in that file is: "+ lowestHumidity + " at: " + lowestHumidityRecord.get("DateUTC"));

    }

    public void testAverageTemperatureInFile(){

        String fileName = filePath+"\\2013\\weather-2013-08-10.csv";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser();
        double avgTemp = averageTemperatureInFile(parser);
        System.out.println("\n Average temperature for this day was: " + avgTemp);

    }

    public void testAverageTemperatureWithHighHumidityInFile(){
        String fileName = filePath+"\\2013\\weather-2013-09-02.csv";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser();
        double avgTemp = averageTemperatureWithHighHumidityInFile(parser,80);
        if(avgTemp!=-1){
            System.out.println("\n Average Temp when high Humidity is: " + avgTemp);
        }
    }

}
