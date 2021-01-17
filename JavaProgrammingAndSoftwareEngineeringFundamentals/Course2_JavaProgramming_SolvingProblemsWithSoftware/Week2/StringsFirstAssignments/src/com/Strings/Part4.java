package com.Strings;


import edu.duke.URLResource;

import java.util.Locale;

public class Part4 {

    public void findAndPrintURLs(String urlAddress){
        int count = 0;
        String wlc;
        URLResource url = new URLResource(urlAddress);
        for (String w:url.words()) {
            wlc = w.toLowerCase();
            if(wlc.indexOf("youtube")!=-1){
                int startIdx = w.indexOf("\"");
                int endIdx = w.indexOf("\"",startIdx+1);
                System.out.println(w.substring(startIdx,endIdx+1));
                count++;
            }
        }
        System.out.println("\n" + count + " youtube links were found.");
    }

    public void testURL(){


    }


}
