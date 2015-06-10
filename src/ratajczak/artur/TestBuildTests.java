package ratajczak.artur;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.tictactec.ta.lib.test.AllTests;
import com.tictactec.ta.lib.test.CoreTest;
import com.tictactec.ta.lib.test.MIntegerTest;
import com.tictactec.ta.lib.test.TestAbstractClosure;

public class TestBuildTests {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTests.class, CoreTest.class, MIntegerTest.class, TestEnumTypes.class);
		for (Failure f : result.getFailures()) {
			System.out.println(f.toString());
		}

		System.out.println(result.wasSuccessful());
	}
	

}
