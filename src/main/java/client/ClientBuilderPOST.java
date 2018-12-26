package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;

/**
 * Created by shiraz on 26/12/2018.
 */
public class ClientBuilderPOST {  // todo - NOT WORKING

    public static void main(String[] args) throws ParseException {
        final String url = "http://localhost:8080/shiraz/myfile/";

        MyFileClient newEntry = new MyFileClient("shirazisam", "123123123", "29/09/1968 17:23:45");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        MyFileClient postEntry = target.request().post(Entity.entity(newEntry, MediaType.APPLICATION_JSON_TYPE), MyFileClient.class);
        System.out.println("response = " + postEntry.getId());
    }
}
