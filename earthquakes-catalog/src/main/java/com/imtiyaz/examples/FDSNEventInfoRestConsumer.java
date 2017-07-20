package com.imtiyaz.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by imtiyaz on 7/18/17.
 */
public class FDSNEventInfoRestConsumer {

    public static void main(String[] args) throws Throwable {
        String url = "https://earthquake.usgs.gov/fdsnws/event/1/application.json";
        //String url = "https://earthquake.usgs.gov/fdsnws/event/1/catalogs";

        RestTemplate restTemplate = new RestTemplate();
         //JsonResponse result = restTemplate.getForObject(url, JsonResponse.class);

        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);

        ObjectMapper mapper = new ObjectMapper();
        JsonResponse jsonResponse = mapper.readValue(result, JsonResponse.class);

        System.out.println(jsonResponse);


    }
}
