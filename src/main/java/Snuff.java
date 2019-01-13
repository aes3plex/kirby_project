import java.io.IOException;
import java.util.List;

import abstracts.Request;

import pojo.Human;
import pojo.InputUser;
import pojo.OutputUser;


public class Snuff {
    public static void main(String[] args) throws IOException {


        String URL = "https://reqres.in/api/users";
        String URL2 = "https://reqres.in/api/users/2";

        InputUser inputUser = new InputUser("Ivan", "Developer");

        //GetRequest request = new GetRequest();
        GetRequest request = new GetRequest();
        List<?> response =  request.getResponse(URL2, Human.class);
        System.out.println(response.get(0).toString());
        //System.out.println(request.getStatus(URL));

    }
}
