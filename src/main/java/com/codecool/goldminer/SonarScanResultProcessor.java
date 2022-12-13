package com.codecool.goldminer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SonarScanResultProcessor {

    public SurveyReport process(){

        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH));
            String st = br.readLine();
            while (st != null) {
                String[] loadRow = st.split(";");

                int id = Integer.parseInt(loadRow[0]);
                String currency = loadRow[1];
                System.out.println(id);
                System.out.println(currency);

                Cart cart = new Cart(currency);
                cart.setId(id);

                data.add(cart);

                st = br.readLine();
            }
            System.out.println(data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

