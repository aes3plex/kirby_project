package load;

import com.github.myzhan.locust4j.Locust;
import load.loadreqs.GetUserLoad;


// FREEZED FOR BETTER DAYS

// Terminal: locust -f locust-master.py --master --master-bind-host=127.0.0.1 --master-bind-port=5557

public class LocustStarter {
    public static void loadIt(){
        String url = "https://reqres.in/api/users/2";
        Locust locust = Locust.getInstance();
        locust.setMasterHost("127.0.0.1");
        locust.setMasterPort(5557);

        locust.run(new GetUserLoad(5, url));
    }
}
