package requests;

import abstracts.Request;
import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.ProcessingException;
import java.io.IOException;
import java.util.List;

// TODO: methods signature in super?
public class GetRequest extends Request  {
    private ClientResponse clientResponse;

    public GetRequest(String url) {
        super(url);
    }

    public Integer getStatus() {
        clientResponse = getJsonBuilder().get(ClientResponse.class);
        clientResponse.close();

        return clientResponse.getStatus();
    }

    // Arguments: response class
    public List<?> getResponse(Class clazz){
        List<?> response = null;
        clientResponse = getJsonBuilder().get(ClientResponse.class);

        if(clientResponse.getStatus() == 200) {
            response = responseFormat(clientResponse, clazz);
        } else {
            System.out.println("Failed with status: " + clientResponse.getStatus());
        }
        clientResponse.close();

        return response;
    }
}
