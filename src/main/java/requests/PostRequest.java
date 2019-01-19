package requests;

import abstracts.Request;
import com.sun.jersey.api.client.ClientResponse;

import java.io.IOException;
import java.util.List;

public class PostRequest extends Request {
    public PostRequest(String url){
        super(url);
    }

    public int getContentLength(Object object) {
        ClientResponse clientResponse = getJsonBuilder().post(ClientResponse.class, object);
        int contentLength = clientResponse.getLength();
        clientResponse.close();

        return contentLength;
    }

    public int getStatus(Object object) {
        ClientResponse clientResponse = getJsonBuilder().post(ClientResponse.class, object);
        int statusCode = clientResponse.getStatus();
        clientResponse.close();

        return statusCode;
    }

    public long getResponseTime(Object object){
        long startRequest = System.currentTimeMillis();
        ClientResponse clientResponse = getJsonBuilder().post(ClientResponse.class, object);
        long responseTime = System.currentTimeMillis() - startRequest;
        clientResponse.close();

        return responseTime;
    }

    // Arguments: response class, request object
    public List<?> getResponse(Class clazz, Object object) {
        List<?> response = null;
        ClientResponse clientResponse = getJsonBuilder().post(ClientResponse.class, object);
        if (clientResponse.getStatus() == 200 || clientResponse.getStatus() == 201) {
            response = responseFormat(clientResponse, clazz);
        } else {
            System.out.println("Failed with status: " + clientResponse.getStatus());
        }

        return response;
    }
}
