package hbaserest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * You must start HBase rest service prior to using this example.
 * Go to https://docs.hortonworks.com/HDPDocuments/HDP2/HDP-2.4.3/bk_installing_manually_book/content/ref-2a6efe32-d0e1-4e84-9068-4361b8c36dc8.1.html
 * for more info on how to start service
 * In this example I started rest service on port 7775
 */

/**
 * Created by smanjee on 10/21/16.
 */
public class HBaseRestExample {
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    public static void getAllTables() {
        Client client = Client.create();
        WebResource service = null;
        try {
            service = client.resource("http://sunman0.field.hortonworks.com:7775/"
                    //+
                    //URLEncoder.encode("my_namespace:MY_TABLE", UTF8_CHARSET.displayName()) + "/" +
                    //URLEncoder.encode("employee1", UTF8_CHARSET.displayName()) + "/" +
                    //URLEncoder.encode("natural_person:first_name", UTF8_CHARSET.displayName())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClientResponse response = service.get(ClientResponse.class);
        if (response.hasEntity() && response.getStatus() == 200) {
            System.out.println(response.getEntity(String.class));
        }
    }

    public static void getTableSchema() {
        Client client = Client.create();
        WebResource service = null;

        try {
            System.out.println(
                    URLEncoder.encode("urlParameterString", java.nio.charset.StandardCharsets.UTF_8.toString()) );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            service = client.resource("http://sunman0.field.hortonworks.com:7775/"
                    +
                    URLEncoder.encode("AIRLINE", java.nio.charset.StandardCharsets.UTF_8.toString())
                    +
                    URLEncoder.encode("schema", java.nio.charset.StandardCharsets.UTF_8.toString())
                    //+
                    //URLEncoder.encode("AIRLINE/schema", UTF8_CHARSET.displayName())
                    //URLEncoder.encode("my_namespace:MY_TABLE", UTF8_CHARSET.displayName()) + "/" +
                    //URLEncoder.encode("employee1", UTF8_CHARSET.displayName()) + "/" +
                    //URLEncoder.encode("natural_person:first_name", UTF8_CHARSET.displayName())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClientResponse response = service.get(ClientResponse.class);
        if (response.hasEntity() && response.getStatus() == 200) {
            System.out.println(response.getEntity(String.class));
        }
    }


    public static void main(String [] args)
    {

        //HBaseRestExample.getAllTables();
        HBaseRestExample.getTableSchema();


    }



}
