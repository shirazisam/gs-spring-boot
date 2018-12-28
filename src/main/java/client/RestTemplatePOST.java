package client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;

/**
 * Created by shiraz on 26/12/2018.
 */
public class RestTemplatePOST {

    public static void main(String[] args) throws ParseException {
        final String url = "http://localhost:8080/shiraz/myfile/";

        RestTemplate restTemplate = new RestTemplate();
        MyFileClient newEntry = new MyFileClient("shirazisam", "123123123", "29/09/1968 17:23:45");
        ResponseEntity<MyFileClient> response = restTemplate.postForEntity(url, newEntry, MyFileClient.class);
        System.out.println("response = " + response.getStatusCode());  // 200 = OK
    }
}
