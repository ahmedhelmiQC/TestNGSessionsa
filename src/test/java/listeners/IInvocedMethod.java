package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class IInvocedMethod implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println(method.getTestMethod().getMethodName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println(testResult.getStatus()==ITestResult.FAILURE);
    }

//    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
//
//    }
//
//    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
//
//    }

}
