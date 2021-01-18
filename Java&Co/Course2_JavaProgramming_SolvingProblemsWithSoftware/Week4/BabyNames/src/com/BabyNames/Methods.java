package com.BabyNames;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class Methods {

    public void totalBirthsAndNames(CSVParser parser){

        int totBirths=0;
        int femaleBirths=0;
        int maleBirths=0;
        int totNames=0;
        int femaleNames=0;
        int maleNames=0;

        for(CSVRecord r:parser){

            if(r.get(1).equals("F")){
                femaleNames++;
                femaleBirths += Integer.parseInt(r.get(2));
            }else if(r.get(1).equals("M")){
                maleNames++;
                maleBirths += Integer.parseInt(r.get(2));

            }
        }

        totBirths = femaleBirths + maleBirths;
        totNames = femaleNames + maleNames;

        System.out.println("\nBirth stats:");
        System.out.println("\nTotal births:"+totBirths);
        System.out.println("\nFemale births:"+femaleBirths);
        System.out.println("\nMale births:"+maleBirths+"\n\n");
        System.out.println("\nNames stats:");
        System.out.println("\nTotal names:"+totNames);
        System.out.println("\nFemale names:"+femaleNames);
        System.out.println("\nMale names:"+maleNames);

    }

    public int getRank(CSVParser parser, String name, String gender){
        int rank = 0;

        for(CSVRecord r:parser){
            if(r.get(1).equals(gender)){
                rank++;
                if(r.get(0).equals(name)){
                    return rank;
                }
            }
        }
        return -1;
    }

    public String getName(CSVParser parser, int rank, String gender){
        int currRank = 0;
        String result = "No Name";

        for(CSVRecord r:parser){
            if(r.get(1).equals(gender)){
                currRank++;
                if(currRank==rank){
                    return r.get(0);
                }
            }
        }

        return result;
    }


    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = 0;
        String newName;

        String folderPath = "C:\\Users\\Francesco\\Desktop\\Coursera\\JavaProgrammingAndSoftwareEngineeringFundamentals\\Course2_JavaProgramming_SolvingProblemsWithSoftware\\Week4\\BabyNames\\src\\BabyNamesFiles\\us_babynames_by_year";
        String fileName = "\\yob"+year+".csv";
        String filePath = folderPath + fileName;

        String newFileName = "\\yob"+newYear+".csv";
        String newFilePath = folderPath + newFileName;

        FileResource fr = new FileResource(filePath);
        CSVParser parser = fr.getCSVParser(false);

        rank = getRank(parser,name,gender);

        FileResource newFr = new FileResource(newFilePath);
        CSVParser newParser = newFr.getCSVParser(false);

        newName = getName(newParser,rank,gender);

        String print = "\n"+name+" born in "+year+" would be "+newName+" if she was born in "+newYear;
        System.out.println(print);

    }

    public int yearOfHighestRank(String name, String gender) {
        int count = 0;
        int highestRank=0;
        int yearOfHighestRank=0;


        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            count++;
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            int currRank = getRank(parser,name,gender);

            if(count==1){
               highestRank = currRank;
               yearOfHighestRank = Integer.parseInt(f.getName().substring(3, 7));
            }else {
                if (currRank < highestRank) {
                    highestRank = currRank;
                    yearOfHighestRank = Integer.parseInt(f.getName().substring(3, 7));
                }
            }
        }
        return yearOfHighestRank;

    }


    public double getAverageRank(String name, String gender) {
        double avg = -1;
        int count = 0;
        double sum = 0;

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {

            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            int currRank = getRank(parser, name, gender);
            if (currRank != -1) {
                count++;
                sum += currRank;
            }
        }

        if(sum!=0&&count!=0){
            avg = sum/count;
        }

    return avg;
    }

    public int getTotalBirthsRankedHigher(String name, String gender){
        int totBirthsRankedHigher = 0;
        int currRank = 0;

        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            int benchmarkRank = getRank(parser,name,gender);
            CSVParser newParser = fr.getCSVParser(false);
            for(CSVRecord rec:newParser){
                if(rec.get(1).equals(gender)){
                    currRank++;
                    if(currRank<benchmarkRank){
                        totBirthsRankedHigher += Integer.parseInt(rec.get(2));
                    }
                }
            }
        }

    return totBirthsRankedHigher;

    }


    public void testTotalBirthsAndNames(){
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            totalBirthsAndNames(parser);

        }
    }

    public void testGetRank() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            int result = getRank(parser,"Frank","M");
            System.out.println("\n"+result);

        }
    }

    public void testGetName(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            String result = getName(parser, 450, "M ");
            System.out.println("\n" + result);
        }
    }

    public void testYearOfHighestRank(){
        int year = yearOfHighestRank("Mich", "M");
        System.out.println("\n"+year);

    }

    public void testGetAverageRank(){
        double avg = getAverageRank("Robert","M");
        System.out.println("\n"+avg);
    }

    public void testGetTotalBirthsRankedHigher(){
        int totBirths = getTotalBirthsRankedHigher("Drew", "M");
        System.out.println("\n"+totBirths);

    }

}
