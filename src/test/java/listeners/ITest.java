package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITest implements ITestListener {
   public void onTestStart(ITestResult result) {
       System.out.println(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("pass");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("fail");
    }

         public void onStart(ITestContext context) {
          System.out.println(context.getName() + "start");
    }

    public void onFinish(ITestContext context) {
        System.out.println(context.getName()+"finished");
    }
}
