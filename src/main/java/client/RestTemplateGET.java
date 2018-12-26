package client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.MyFileSummary;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by shiraz on 26/12/2018.
 * <p>
 * Example of :
 * - Client GET requests,
 * - serialization (marshalling) and deserialization (unmarshalling)
 * - introduction of JsonRoot element into domain object via om.enable()
 */
public class RestTemplateGET {

    public static void main(String[] args) throws IOException {
        final String url = "http://localhost:8080/shiraz/myfile/" + args[0];
        final String url2 = "http://localhost:8080/shiraz/myfilesummary";

        RestTemplate restTemplate = new RestTemplate();
        MyFileClient response = restTemplate.getForObject(url, MyFileClient.class);
        System.out.println("response = " + response);

        MyFileSummary myFileSummary = restTemplate.getForObject(url2, MyFileSummary.class);
        System.out.println("myFileSummary = " + myFileSummary);

        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(myFileSummary);
        System.out.println("after serialization-->");
        System.out.println(jsonString);

        om.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        MyFileSummary summary = om.readValue(jsonString, MyFileSummary.class);
        System.out.println("after deserialization-->");
        System.out.println("summary = " + summary);

    }
}
