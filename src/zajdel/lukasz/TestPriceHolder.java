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
		int actualGetSize = priceHolder.getSize();

		assertArrayEquals(excendentsO, actualO, 0);
		assertArrayEquals(excendentsH, actualH, 0);
		assertArrayEquals(excendentsL, actualL, 0);
		assertArrayEquals(excendentsC, actualC, 0);
		assertArrayEquals(excendentsV, actualV, 0);
		assertArrayEquals(excendentsI, actualI, 0);
		assertEquals(excendentsLength, actualLength);
		assertEquals(excendentsLength, actualGetSize);

	}

	@Test(expected = NullPointerException.class)
	public void testPriceHolderNullPointerExceptionsO() {
		priceHolder = new PriceHolder(null, null, null, null, null, null);
	}

	@Test(expected = NullPointerException.class)
	public void testPriceHolderNullPointerExceptionsH() {
		priceHolder = new PriceHolder(new double[] { 1 }, null, null, null,
				null, null);
	}

	@Test(expected = NullPointerException.class)
	public void testPriceHolderNullPointerExceptionsL() {
		priceHolder = new PriceHolder(new double[] { 1 }, new double[] { 1 },
				null, null, null, null);
	}

	@Test(expected = NullPointerException.class)
	public void testPriceHolderNullPointerExceptionsC() {
		priceHolder = new PriceHolder(new double[] { 1 }, new double[] { 1 },
				new double[] { 1 }, null, null, null);
	}

	@Test(expected = NullPointerException.class)
	public void testPriceHolderNullPointerExceptionsV() {
		priceHolder = new PriceHolder(new double[] { 1 }, new double[] { 1 },
				new double[] { 1 }, new double[] { 1 }, null, null);
	}

	@Test(expected = NullPointerException.class)
	public void testPriceHolderNullPointerExceptionsI() {
		priceHolder = new PriceHolder(new double[] { 1 }, new double[] { 1 },
				new double[] { 1 }, new double[] { 1 }, new double[] { 1 },
				null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPriceHolderIllegalArgumentExceptionO() {
		priceHolder = new PriceHolder(new double[] { 1 },
				new double[] { 2, 3 }, new double[] { 3, 4, 5 }, new double[] {
						4, 1, 2, 3 }, new double[] { 5, 2, 3, 5, 6 },
				new double[] { 6, 3, 2, 3, 4, 5 });
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPriceHolderIllegalArgumentExceptionH() {
		priceHolder = new PriceHolder(new double[] { 1 }, new double[] { 2 },
				new double[] { 3, 4, 5 }, new double[] { 4, 1, 2, 3 },
				new double[] { 5, 2, 3, 5, 6 },
				new double[] { 6, 3, 2, 3, 4, 5 });
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPriceHolderIllegalArgumentExceptionL() {
		priceHolder = new PriceHolder(new double[] { 1 }, new double[] { 2 },
				new double[] { 3 }, new double[] { 4, 1, 2, 3 }, new double[] {
						5, 2, 3, 5, 6 }, new double[] { 6, 3, 2, 3, 4, 5 });
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPriceHolderIllegalArgumentExceptionC() {
		priceHolder = new PriceHolder(new double[] { 1 }, new double[] { 2 },
				new double[] { 3 }, new double[] { 4 }, new double[] { 5, 2, 3,
						5, 6 }, new double[] { 6, 3, 2, 3, 4, 5 });
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPriceHolderIllegalArgumentExceptionV() {
		priceHolder = new PriceHolder(new double[] { 1 }, new double[] { 2 },
				new double[] { 3 }, new double[] { 4 }, new double[] { 5 },
				new double[] { 6, 3, 2, 3, 4, 5 });
	}

	@Test
	public void testToArrays() {

		priceHolder = new PriceHolder(new double[] { 1 }, new double[] { 2 },
				new double[] { 3 }, new double[] { 4 }, new double[] { 5 },
				new double[] { 6 });

		Object[] expecteds = new Object[] { new double[] { 1 },
				new double[] { 2 }, new double[] { 3 }, new double[] { 4 },
				new double[] { 5 }, new double[] { 6 } };
		Object[] actuals = priceHolder.toArrays();

		assertArrayEquals(expecteds, actuals);
	}
}