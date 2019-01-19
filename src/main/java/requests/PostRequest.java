package requests;

import abstracts.Request;
import com.sun.jersey.api.client.ClientResponse;

import java.io.IOException;
import java.util.List;

public class PostRequest extends Request {
    private ClientResponse clientResponse;

    public PostRequest(String url){
        super(url);
    }


    // Arguments: request object
    public Integer getStatus(Object object) {
        clientResponse = getJsonBuilder().post(ClientResponse.class, object);
        clientResponse.close();

        return clientResponse.getStatus();
    }

    // Arguments: response class, request object
    public List<?> getResponse(Class clazz, Object object){
        List<?> response = null;
        clientResponse = getJsonBuilder().post(ClientResponse.class, object);
        if(clientResponse.getStatus() == 200 || clientResponse.getStatus() == 201) {
            response = responseFormat(clientResponse, clazz);
        } else {
            System.out.println("Failed with status: " + clientResponse.getStatus());
        }
        clientResponse.close();

        return response;
    }
}
