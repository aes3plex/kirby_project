import abstracts.Request;
import com.sun.jersey.api.client.ClientResponse;

import java.io.IOException;
import java.util.List;

// TODO: methods signature in super?
public class GetRequest extends Request {

    public Integer getStatus(String url){
        setBuilder(url);
        return getBuilder().get(ClientResponse.class).getStatus();
    }

    // TODO: what's arguments?
    public List<?> getResponse(String url, Class clazz) throws IOException {
        setBuilder(url);
        String jsonString = getBuilder().get(ClientResponse.class).getEntity(String.class);

        return getMapper().readValue(castToArr(jsonString),
                getMapper().getTypeFactory()
                        .constructCollectionType(List.class, clazz));

    }
}
