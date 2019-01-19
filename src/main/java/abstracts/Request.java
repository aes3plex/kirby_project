package abstracts;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

// TODO: EXCEPTIONS
public abstract class Request {

    private ObjectMapper mapper;
    private WebResource webResource;


    public Request(String url) {
        // setting mapper
        this.mapper = new ObjectMapper();
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // setting provider
        JacksonJsonProvider provider = new JacksonJsonProvider();
        provider.setMapper(mapper);

        // setting client config
        ClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        config.getSingletons().add(provider);

        // setting client
        Client client = Client.create(config);

        // setting web resource
        this.webResource = client.resource(url);
    }

    private String castToArr(String parseString){
        String firstLetter = String.valueOf(parseString.charAt(0));
        if(!firstLetter.equals("["))
            parseString = "[" + parseString + "]";

        return parseString;
    }

    // setting data format
    protected WebResource.Builder getJsonBuilder(){
        return webResource.accept(MediaType.APPLICATION_JSON)
                .header("content-type", MediaType.APPLICATION_JSON);
    }

    // getting response list
    protected List<?> responseFormat(ClientResponse clientResponse, Class clazz) {
        List<?> response = null;

        String jsonString = clientResponse.getEntity(String.class);

        try {
            response = mapper.readValue(castToArr(jsonString),
                        mapper.getTypeFactory()
                                .constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            e.getMessage();
            clientResponse.close();
        }
        clientResponse.close();

        return response;
    }
}

