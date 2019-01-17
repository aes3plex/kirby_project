package requests;

import abstracts.Request;
import com.sun.jersey.api.client.ClientResponse;

import java.io.IOException;
import java.util.List;

public class PostRequest extends Request {

    public PostRequest(String url){
        super(url);
    }


    // Arguments: request object
    public Integer getStatus(Object object) {
        ClientResponse response = getJsonBuilder().post(ClientResponse.class, object);
        response.close();

        return response.getStatus();
    }

    // Arguments: response class, request object
    public List<?> getResponse(Class clazz, Object object) throws IOException {
        ClientResponse clientResponse = getJsonBuilder().post(ClientResponse.class, object);
        List<?> response = responseFormat(clientResponse, clazz);
        clientResponse.close();

        return response;
    }
}
