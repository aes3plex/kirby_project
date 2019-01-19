package requests;

import abstracts.Request;
import com.sun.jersey.api.client.ClientResponse;

import java.io.IOException;
import java.util.List;

public class GetRequest extends Request  {
    public GetRequest(String url) {
        super(url);
    }

    public int getContentLength() {
        ClientResponse clientResponse = getJsonBuilder().get(ClientResponse.class);
        int contentLength = clientResponse.getLength();
        clientResponse.close();
        return contentLength;
    }

    public int getStatus() {
        ClientResponse clientResponse = getJsonBuilder().get(ClientResponse.class);
        int statusCode = clientResponse.getStatus();
        clientResponse.close();

        return statusCode;
    }

    public long getResponseTime(){
        long startRequest = System.currentTimeMillis();
        ClientResponse clientResponse = getJsonBuilder().get(ClientResponse.class);
        long responseTime = System.currentTimeMillis() - startRequest;
        clientResponse.close();

        return responseTime;
    }

    // Arguments: response class
    public List<?> getResponse(Class clazz){
        List<?> response = null;
        ClientResponse clientResponse = getJsonBuilder().get(ClientResponse.class);
        if (clientResponse.getStatus() == 200) {
            response = responseFormat(clientResponse, clazz);
        } else {
            System.out.println("Failed with status: " + clientResponse.getStatus());
        }

        return response;
    }
}
