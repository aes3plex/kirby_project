package load.loadreqs;

import com.github.myzhan.locust4j.AbstractTask;
import com.github.myzhan.locust4j.Locust;
import requests.GetRequest;


public class GetUserLoad extends AbstractTask {

    private GetRequest request;
    private int weight;

    public GetUserLoad(int weight, String url){
        this.weight = weight;
        request = new GetRequest(url);
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void execute() {
        assert request.getStatus() == 200;
        Locust.getInstance().recordSuccess("http", getName(), request.getResponseTime(), request.getContentLength());
    }
}
