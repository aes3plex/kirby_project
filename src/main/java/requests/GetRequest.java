package requests;

import abstracts.Request;
import com.sun.jersey.api.client.ClientResponse;

import java.io.IOException;
import java.util.List;

// TODO: methods signature in super?
public class GetRequest extends Request {

    public GetRequest(String url) {
        super(url);
    }

    public Integer getStatus(){
        ClientResponse response = getJsonBuilder().get(ClientResponse.class);
        response.close();

        return response.getStatus();
    }

    // Arguments: response class
    public List<?> getResponse(Class clazz) throws IOException {
        ClientResponse clientResponse = getJsonBuilder().get(ClientResponse.class);
        List<?> response = responseFormat(clientResponse, clazz);
        clientResponse.close();

        return response;
    }
}
