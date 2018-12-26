package client;

import model.MyFileSummary;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shiraz on 26/12/2018.
 */
public class RestTemplateGET {

    public static void main(String[] args) {
        final String url = "http://localhost:8080/shiraz/myfile/" + args[0];
        final String url2 = "http://localhost:8080/shiraz/myfilesummary";

        RestTemplate restTemplate = new RestTemplate();
        MyFileClient response = restTemplate.getForObject(url, MyFileClient.class);
        System.out.println("response = " + response);

        MyFileSummary myFileSummary = restTemplate.getForObject(url2, MyFileSummary.class);
        System.out.println("myFileSummary = " + myFileSummary);
    }
}
