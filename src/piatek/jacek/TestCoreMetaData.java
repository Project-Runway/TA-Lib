package piatek.jacek;

import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tictactec.ta.lib.meta.PriceInputParameter;

@SuppressWarnings("deprecation")
public class TestCoreMetaData {
	static PriceInputParameter priceInputParameter;
	@Test
	public void TestPriceInputParameters(){
		priceInputParameter = new PriceInputParameter(1, new double[] { 1 },
				new double[] { 2 }, new double[] { 3 }, new double[] { 4 },
				new double[] { 5 }, new double[] { 6 });
		
		double[] expectedO = new double[] { 1 };
		double[] expectedH = new double[] { 2 };
		double[] expectedL = new double[] { 3 };
		double[] expectedC = new double[] { 4 };
		double[] expectedV = new double[] { 5 };
		double[] expectedI = new double[] { 6 };
		
		double[] actualO = priceInputParameter.getO();
		double[] actualH = priceInputParameter.getH();
		double[] actualL = priceInputParameter.getL();
		double[] actualC = priceInputParameter.getC();
		double[] actualV = priceInputParameter.getV();
		double[] actualI = priceInputParameter.getI();
		
		assertArrayEquals(expectedO, actualO, 0);
		assertArrayEquals(expectedH, actualH, 0);
		assertArrayEquals(expectedL, actualL, 0);
		assertArrayEquals(expectedC, actualC, 0);
		assertArrayEquals(expectedV, actualV, 0);
		assertArrayEquals(expectedI, actualI, 0);
	}

	
	@Test
	public void TestGetFlags(){
		priceInputParameter = new PriceInputParameter(1, new double[] { 1 },
				new double[] { 2 }, new double[] { 3 }, new double[] { 4 },
				new double[] { 5 }, new double[] { 6 });
		
		int expected = 1;
		int i = TestCoreMetaData.priceInputParameter.getFlags();
		assertEquals(expected, i);
	}
	
	
	@Test
	public void TestGetCount(){
		priceInputParameter = new PriceInputParameter(1, new double[] { 1 },
				new double[] { 2 }, new double[] { 3 }, new double[] { 4 },
				new double[] { 5 }, new double[] { 6 });
		int expectedCount = 1;
		int i = TestCoreMetaData.priceInputParameter.getCount();
		assertEquals(expectedCount, i);
	}
	

}