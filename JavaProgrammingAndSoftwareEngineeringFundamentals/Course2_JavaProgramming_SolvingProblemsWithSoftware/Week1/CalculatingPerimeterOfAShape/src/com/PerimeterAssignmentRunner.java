package com;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int numPoints=0;
        for(Point p:s.getPoints()){
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        double per = getPerimeter(s);
        double sides = getNumPoints(s);
        double avgLen = per/sides;
        return avgLen;
    }

    public double getLargestSide(Shape s) {
        double largSide = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            if(currDist>largSide){
                largSide=currDist;
            }
            prevPt = currPt;
        }

        return largSide;
    }

    public double getLargestX(Shape s) {
        double largX = 0.0;
        for(Point p:s.getPoints()){
            if(p.getX()>largX){
                largX = p.getX();
            }
        }
        return largX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPer = 0;
        double currPer;
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            currPer = getPerimeter(s);
            if (currPer > largestPer){
                largestPer = currPer;
            }
        }
        return largestPer;
    }

    public String getFileWithLargestPerimeter() {
        double largestPer = 0;
        double currPer;
        String fileName=new String();
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            currPer = getPerimeter(s);
            if (currPer > largestPer){
                largestPer = currPer;
                fileName=f.getName();
            }
        }
        return fileName;

    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        double numPoints = getNumPoints(s);
        double avgLen = getAverageLength(s);
        double largSide = getLargestSide(s);
        double largX = getLargestX(s);
        System.out.println("perimeter = " + length +
                "\nn. of points = "+ numPoints +
                "\navg. length is = "+ avgLen +
                "\nlargest side is = " + largSide +
                "\nlargest x is: " + largX);
    }

    public void testPerimeterMultipleFiles() {
        double largestPer = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter across selected files is: " + largestPer);
    }

    public void testFileWithLargestPerimeter() {
        String fileName = new String();
        fileName = getFileWithLargestPerimeter();
        System.out.println("The file that contains the largest perimeter is: " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
}
