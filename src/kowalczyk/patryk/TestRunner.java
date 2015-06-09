package kowalczyk.patryk;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestCore.class);
		for (Failure f : result.getFailures())
		{
			System.out.print(f.toString());
		}
		System.out.print(result.wasSuccessful());
	}

}
