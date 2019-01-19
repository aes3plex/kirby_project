package api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pojo.InputUser;
import requests.PostRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class PostUsersTest {
    private String URL = "https://reqres.in/api/users";
    private static Integer HTTP_CREATED = 201;
    private PostRequest request = new PostRequest(URL);
    private InputUser user;


    public PostUsersTest(InputUser user){
        this.user = user;
    }

    @Parameterized.Parameters(name = "now {index} parameter")
    public static List<InputUser> data(){
        ArrayList<InputUser> data = new ArrayList<InputUser>();
        data.add(new InputUser("Ivan", "Developer"));
        data.add(new InputUser("Oleg", "QA"));
        data.add(new InputUser("Tomara", "Anal"));

        return data;
    }

    @Test(timeout = 10000)
    public void ivanTest(){
        assertEquals(request.getStatus(user), HTTP_CREATED);
    }
}
