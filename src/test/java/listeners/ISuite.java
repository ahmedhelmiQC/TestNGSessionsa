package listeners;

import org.testng.ISuiteListener;

public class ISuite implements ISuiteListener {
    public void onStart(org.testng.ISuite suite) {
        System.out.println(suite.getName() + "start Suite");
    }

    public void onFinish(org.testng.ISuite suite) {
        System.out.println(suite.getName() + " finished");
    }
}
