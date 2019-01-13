package abstracts;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import lombok.NonNull;
import org.codehaus.jackson.map.type.TypeFactory;
import pojo.Human;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

// TODO: EXCEPTIONS
public abstract class Request {

    private ObjectMapper mapper;
    private JacksonJsonProvider provider;
    private ClientConfig config;
    private Client client;
    private WebResource webResource;
    private WebResource.Builder builder;


    public Request() {
        setMapper();
        setProvider();
        setClientConfig();
        setClient();
    }

    private void setMapper(){
        this.mapper = new ObjectMapper();
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private void setProvider(){
        this.provider = new JacksonJsonProvider();
        this.provider.setMapper(mapper);
    }

    private void setClientConfig(){
        this.config = new DefaultClientConfig();
        this.config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        this.config.getSingletons().add(provider);
    }

    private void setClient(){
        this.client = Client.create(config);
    }

    private void setWebResource(String url) {
        this.webResource = client.resource(url);
    }

    protected void setBuilder(String url){
        setWebResource(url);
        this.builder = webResource.accept(MediaType.APPLICATION_JSON)
                .header("content-type", MediaType.APPLICATION_JSON);
    }

    protected String castToArr(String parseString){
        String firstLetter = String.valueOf(parseString.charAt(0));
        if(!firstLetter.equals("["))
            parseString = "[" + parseString + "]";

        return parseString;
    }

    protected WebResource.Builder getBuilder(){
        return builder;
    }

    protected ObjectMapper getMapper(){
        return mapper;
    }
 }

