package api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    GetUsersTest.class,
    PostUsersTest.class
})
public class ApiTestSuite {
    // just as holder
}
