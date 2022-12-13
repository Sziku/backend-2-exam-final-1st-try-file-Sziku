package com.codecool.goldminer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SonarScanResultProcessor {

    public SurveyReport process(String filePatch){

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePatch));
            String st = br.readLine();
            SurveyReport surveyReport = new SurveyReport();
            while (st != null) {
                char[] loadRow = st.toCharArray();
                if(loadRow.length > 0){
                    for(int i = 0; i < loadRow.length; i++){
                        if(loadRow[i] == 'g'){
                            surveyReport.setGoldCount(surveyReport.getGoldCount() + 1);
                            if(i < loadRow.length-1 && i > 0){
                                if(loadRow[i-1] == ' ' || loadRow[i+1] == ' '){
                                    surveyReport.setEasyGoldCount(surveyReport.getEasyGoldCount() + 1);
                                }
                            }
                        }

                    }
                }

                st = br.readLine();
            }
            return surveyReport;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

