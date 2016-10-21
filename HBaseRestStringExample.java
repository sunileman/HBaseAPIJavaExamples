package hbaserest;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;


import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.*;
import org.json.simple.JSONObject;


/**
 * You must start HBase rest service prior to using this example.
 * Go to https://docs.hortonworks.com/HDPDocuments/HDP2/HDP-2.4.3/bk_installing_manually_book/content/ref-2a6efe32-d0e1-4e84-9068-4361b8c36dc8.1.html
 * for more info on how to start service
 * In this example I started rest service on port 7775
 */

/**
 * Created by smanjee on 10/21/16.
 */
public class HBaseRestStringExample {
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    public static void getAllTables() {

        UriComponents uri =
                UriComponentsBuilder.newInstance()
                        .scheme("http")
                        .host("xxxx.xxxx,hortonworks.com")
                        .port(7775)
                        .build()
                        .encode();

        System.out.println(uri.toString());


        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, String.class);

        String responseBody = result.getBody();
        System.out.println(responseBody);

    }




    public static void getTableSchema() {

        UriComponents uri =
                UriComponentsBuilder.newInstance()
                        .scheme("http")
                        .host("xxxx.xxxx,hortonworks.com")
                        .port(7775)
                        .path("/{table}/{type}/")
                        .build()
                        .expand("AIRLINE", "schema")
                        .encode();

        System.out.println(uri.toString());


        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, String.class);

        String responseBody = result.getBody();
        System.out.println(responseBody);
    }




    public static void main(String [] args)
    {

        HBaseRestStringExample.getAllTables();
        HBaseRestStringExample.getTableSchema();


    }



}
