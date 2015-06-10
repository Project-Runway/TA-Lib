package adamczyk.adam;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.meta.helpers.SimpleHelper;

public class TestSimpleHelper {
	static SimpleHelper simpleHelper;
	
	
	@BeforeClass
	public static void beforeClass() {
		simpleHelper = new SimpleHelper("null", null);
	}

	@Test
	public void testSimpleHelper() {
		String excepctedFunc=null;
		String actualFunc=null;
		List <String> excendentArgs = null;
		List <String> actualArgs = 	null;

		assertEquals(excepctedFunc, actualFunc);
		assertEquals(excendentArgs, actualArgs);
	}

	
}
