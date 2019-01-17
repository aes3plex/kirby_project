package api;

import org.junit.Test;
import requests.GetRequest;

import static org.junit.Assert.assertEquals;

public class GetUsersTest {
    private final String URL = "https://reqres.in/api/users/2";
    private final Integer expectedCode = 200;
    private GetRequest request = new GetRequest(URL);

    @Test(timeout = 10000)
    public void getUserTest(){
        assertEquals(request.getStatus(), expectedCode);
    }

}
