package zajdel.lukasz;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tictactec.ta.lib.meta.PriceHolder;

public class TestPriceHolder {
	static PriceHolder priceHolder;


	@Test
	public void testPriceHolder() {

		priceHolder = new PriceHolder(new double[] { 1 }, new double[] { 2 },
				new double[] { 3 }, new double[] { 4 }, new double[] { 5 },
				new double[] { 6 });
		
		double[] excendentsO = new double[] { 1 };
		double[] excendentsH = new double[] { 2 };
		double[] excendentsL = new double[] { 3 };
		double[] excendentsC = new double[] { 4 };
		double[] excendentsV = new double[] { 5 };
		double[] excendentsI = new double[] { 6 };
		int excendentsLength = 1;

		double[] actualO = priceHolder.getO();
		double[] actualH = priceHolder.getH();
		double[] actualL = priceHolder.getL();
		double[] actualC = priceHolder.getC();
		double[] actualV = priceHolder.getV();
		double[] actualI = priceHolder.getI();
		int actualLength = priceHolder.length;

		assertArrayEquals(excendentsO, actualO,0);
		assertArrayEquals(excendentsH, actualH,0);
		assertArrayEquals(excendentsL, actualL,0);
		assertArrayEquals(excendentsC, actualC,0);
		assertArrayEquals(excendentsV, actualV,0);
		assertArrayEquals(excendentsI, actualI,0);
		assertEquals(excendentsLength, actualLength);

	}
}