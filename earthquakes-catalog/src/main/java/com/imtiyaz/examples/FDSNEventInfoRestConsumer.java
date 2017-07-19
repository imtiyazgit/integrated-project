package com.imtiyaz.examples;

import org.springframework.web.client.RestTemplate;

/**
 * Created by imtiyaz on 7/18/17.
 */
public class FDSNEventInfoRestConsumer {

    public static void main(String[] args) {
        String url = "https://earthquake.usgs.gov/fdsnws/event/1/application.json";

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
    }
}
