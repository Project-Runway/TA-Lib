package ratajczak.artur;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.tictactec.ta.lib.test.AllTests;
import com.tictactec.ta.lib.test.CoreTest;
import com.tictactec.ta.lib.test.MIntegerTest;


public class AllTestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(
				piatek.jacek.TestAnnotated.class,
				piatek.jacek.TestCore.class,
				piatek.jacek.TestCoreMetaData.class,
				piatek.jacek.TestPriceInputParameter.class,
				
				AllTests.class, CoreTest.class, MIntegerTest.class, TestEnumTypes.class,
				
				sofroniuk.krzysztof.TestAnnotated.class,
				sofroniuk.krzysztof.TestCore.class,
				
				stohnij.lukasz.TestAnnotated.class,
				stohnij.lukasz.TestCore.class,
				stohnij.lukasz.TestCoreMetaData.class,
				stohnij.lukasz.TestCoreMetaInfo.class,
				
				zajdel.lukasz.TestCore.class,
				zajdel.lukasz.TestCoreAnnotated.class,
				zajdel.lukasz.TestPriceHolder.class
			
				
				);
		for (Failure f : result.getFailures()) {
			System.out.println(f.toString());
		}

		System.out.println(result.wasSuccessful());
	}
	

}

