import abstracts.Request;
import com.sun.jersey.api.client.ClientResponse;
import pojo.InputUser;

import java.io.IOException;
import java.util.List;


// TODO: signature in super?
public class PostRequest extends Request {

    public Integer getStatus(String url, Object object){
        setBuilder(url);
        return getBuilder().post(ClientResponse.class, object).getStatus();
    }

    // TODO: what's arguments?
    public List<?> getResponse(String url, Class clazz, Object object) throws IOException {
        setBuilder(url);
        String jsonString = getBuilder().post(ClientResponse.class, object).getEntity(String.class);

        return getMapper().readValue(castToArr(jsonString),
                getMapper().getTypeFactory()
                        .constructCollectionType(List.class, clazz));
    }
}
