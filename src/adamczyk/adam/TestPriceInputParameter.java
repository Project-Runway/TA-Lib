package adamczyk.adam;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.meta.PriceHolder;
import com.tictactec.ta.lib.meta.PriceInputParameter;
@SuppressWarnings("deprecation")
public class TestPriceInputParameter {
	static PriceInputParameter priceInputParameter;
	static PriceHolder priceHolder;
	
	@BeforeClass
	public static void beforeClass() {
		priceInputParameter = new PriceInputParameter(priceHolder);
	}

	@Test
	public void testInitialize() {
		
		
	}
	
	@Test
	public void testToArrays() {
		
	}

}
