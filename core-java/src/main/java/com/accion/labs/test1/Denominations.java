package com.accion.labs.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by imtiyaz on 7/4/17.
 */
public class Denominations {

    private static Map<String, String> lookupTable = new HashMap<String, String>();

    static {
        lookupTable.put("1", "1c");
        lookupTable.put("2", "2c");
        lookupTable.put("5", "5c");
        lookupTable.put("10", "10c");
        lookupTable.put("25", "25c");
        lookupTable.put("100", "1$");
        lookupTable.put("200", "2$");
        lookupTable.put("500", "5$");
        lookupTable.put("1000", "10$");
        lookupTable.put("2000", "20$");
    }

    public static String find(Optional amtInCentsOnly) throws IOException
    {
        if (!amtInCentsOnly.isPresent()) {
            System.out.println("Can not find denominations for empty value");
            return "";
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int den[]={2000,1000,500,200,100,25,10, 5,2,1}; //storing all the denominations in an array
        int amount=Integer.valueOf(amtInCentsOnly.get().toString());

        int count=0;

        String result = "";

        for(int i=0;i<10;i++) //Since there are 10 different types of notes, hence we check for each note.
        {
            count=amount/den[i]; // counting number of den[i] notes
            if(count!=0) //printing that denomination if the count is not zero
            {
                result += getPrintedAmount(den[i], count);
            }
            amount=amount%den[i]; //finding the remaining amount whose denomination is to be found
        }
        return result;
    }

    private static String getPrintedAmount(int amt, int count) {
        String result = "";
        String amount = lookupTable.get(amt+"");
        for (int i = 0; i < count; i++) {
            result += amount;
        }
        return result;
    }

}
