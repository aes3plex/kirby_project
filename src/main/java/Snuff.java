import pojo.Human;
import requests.GetRequest;


public class Snuff {
    public static void main(String[] args) {
        String URL = "https://reqres.in/fsfdsf/fdsf";
        GetRequest request = new GetRequest(URL);
        System.out.println(request.getResponse(Human.class));

    }
}

