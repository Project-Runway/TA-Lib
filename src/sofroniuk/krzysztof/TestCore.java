package sofroniuk.krzysztof;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

public class TestCore {
	static Core core;

	@BeforeClass
	public static void beforeClass() {
		core = new Core();
	}

	@Test
	public void testadd() {

		double[] inputsinReal0 = new double[] { 1, 2, 3, 4, 5 };
		double[] inputsinReal1 = new double[] { 1, 2, 3, 4, 5 };
		double[] expecteds = new double[] { 2, 4, 6, 8, 10 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode rc = core.add(0, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);

		RetCode ra = core.add(-1, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.add(0, -1, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testdiv() {

		double[] inputsinReal0 = new double[] { 5, 4, 3, 2, 1 };
		double[] inputsinReal1 = new double[] { 1, 2, 3, 4, 5 };
		double[] expecteds = new double[] { 5, 2, 1, 0.5, 0.2 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode rc = core.div(0, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);

		RetCode ra = core.div(-1, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.div(0, -1, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testmult() {

		double[] inputsinReal0 = new double[] { 2, 3, 4, 5, 6 };
		double[] inputsinReal1 = new double[] { 1, 2, 3, 4, 5 };
		double[] expecteds = new double[] { 2, 6, 12, 20, 30 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode rc = core.mult(0, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);

		RetCode ra = core.mult(-1, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.mult(0, -1, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testsub() {

		double[] inputsinReal0 = new double[] { 10, 9, 8, 7, 6 };
		double[] inputsinReal1 = new double[] { 2, 4, 2, 5, 8 };
		double[] expecteds = new double[] { 8, 5, 6, 2, -2 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode rc = core.sub(0, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);

		RetCode ra = core.sub(-1, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.sub(0, -1, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testaddfloat() {

		float[] inputsinReal0 = new float[] { 10, 9, 8, 7, 6 };
		float[] inputsinReal1 = new float[] { 2, 4, 2, 5, 8 };
		double[] expecteds = new double[] { 8, 5, 6, 2, -2 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode rc = core.add(0, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);

		RetCode ra = core.add(-1, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.add(0, -1, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testdivfloat() {

		float[] inputsinReal0 = new float[] { 5, 4, 3, 2, 1 };
		float[] inputsinReal1 = new float[] { 1, 2, 3, 4, 5 };
		double[] expecteds = new double[] { 5, 2, 1, 0.5, 0.2 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode rc = core.div(0, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);

		RetCode ra = core.div(-1, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.div(0, -1, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testmultfloat() {

		float[] inputsinReal0 = new float[] { 2, 3, 4, 5, 6 };
		float[] inputsinReal1 = new float[] { 1, 2, 3, 4, 5 };
		double[] expecteds = new double[] { 5, 2, 1, 0.5, 0.2 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode rc = core.mult(0, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);

		RetCode ra = core.mult(-1, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.mult(0, -1, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testsubfloat() {

		float[] inputsinReal0 = new float[] { 10, 9, 8, 7, 6 };
		float[] inputsinReal1 = new float[] { 2, 4, 2, 5, 8 };
		double[] expecteds = new double[] { 8, 5, 6, 2, -2 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode rc = core.sub(0, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);

		RetCode ra = core.sub(-1, 4, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.sub(0, -1, inputsinReal0, inputsinReal1, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testacos() {

		double[] inputsinReal = new double[] { -1, 0, 1 };
		double[] expecteds = new double[] { 3.141592653589793,
				1.5707963267948966, 0 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.acos(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.acos(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.acos(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testasin() {

		double[] inputsinReal = new double[] { -1, 0, 1 };
		double[] expecteds = new double[] { -1.5707963267948966, 0,
				1.5707963267948966 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.asin(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.asin(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.asin(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testatan() {

		double[] inputsinReal = new double[] { -0.5, 0, 0.5 };
		double[] expecteds = new double[] { -0.4636476090008061, 0,
				0.4636476090008061 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.atan(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.atan(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.atan(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testceil() {

		double[] inputsinReal = new double[] { 1.1, 2.2, 3.3 };
		double[] expecteds = new double[] { 2, 3, 4 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.ceil(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.ceil(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.ceil(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testcos() {

		double[] inputsinReal = new double[] { -1, 0, 1 };
		double[] expecteds = new double[] { 0.5403023058681398, 1,
				0.5403023058681398 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.cos(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.cos(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.cos(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testcosh() {

		double[] inputsinReal = new double[] { -0.5, 0, 0.5 };
		double[] expecteds = new double[] { 1.1276259652063807, 1,
				1.1276259652063807 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.cosh(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.cosh(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.cosh(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testexp() {

		double[] inputsinReal = new double[] { 1, 2, 3 };
		double[] expecteds = new double[] { 2.718281828459045,
				7.38905609893065, 20.085536923187668 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.exp(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.exp(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.exp(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testfloor() {

		double[] inputsinReal = new double[] { 1.1, 2.2, 3.3 };
		double[] expecteds = new double[] { 1, 2, 3 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.floor(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.floor(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.floor(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testln() {

		double[] inputsinReal = new double[] { 10, 20, 30 };
		double[] expecteds = new double[] { 2.302585092994046,
				2.995732273553991, 3.4011973816621555 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.ln(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.ln(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.ln(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testlog10() {

		double[] inputsinReal = new double[] { 10, 20, 30 };
		double[] expecteds = new double[] { 1, 1.3010299956639813,
				1.4771212547196624 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.log10(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.log10(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.log10(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testsin() {

		double[] inputsinReal = new double[] { 1, 2, 3 };
		double[] expecteds = new double[] { 0.8414709848078965,
				0.9092974268256817, 0.1411200080598672 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.sin(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.sin(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.sin(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testsinh() {

		double[] inputsinReal = new double[] { 1, 2, 3 };
		double[] expecteds = new double[] { 1.1752011936438014,
				3.626860407847019, 10.017874927409903 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.sinh(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.sinh(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.sinh(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testsqrt() {

		double[] inputsinReal = new double[] { 1, 2, 3 };
		double[] expecteds = new double[] { 1, 1.4142135623730951,
				1.7320508075688772 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.sqrt(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.sqrt(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.sqrt(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testtan() {

		double[] inputsinReal = new double[] { -1, 0, 1 };
		double[] expecteds = new double[] { -1.5574077246549023, 0,
				1.5574077246549023 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.tan(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.tan(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.tan(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testtanh() {

		double[] inputsinReal = new double[] { -1, 0, 1 };
		double[] expecteds = new double[] { -0.7615941559557649, 0,
				0.7615941559557649 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.tanh(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.tanh(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.tanh(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testacosfloat() {

		float[] inputsinReal = new float[] { -1, 0, 1 };
		double[] expecteds = new double[] { 3.141592653589793,
				1.5707963267948966, 0 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.acos(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.acos(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.acos(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testasinfloat() {

		float[] inputsinReal = new float[] { -1, 0, 1 };
		double[] expecteds = new double[] { -1.5707963267948966, 0,
				1.5707963267948966 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.asin(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.asin(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.asin(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testatanfloat() {

		float[] inputsinReal = new float[] { -1, 0, 1 };
		double[] expecteds = new double[] { -0.7853981633974483, 0,
				0.7853981633974483 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.atan(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.atan(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.atan(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testceilfloat() {

		float[] inputsinReal = new float[] { (float) 1.1, (float) 2.2,
				(float) 3.3 };
		double[] expecteds = new double[] { 2, 3, 4 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.ceil(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.ceil(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.ceil(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testcosfloat() {

		float[] inputsinReal = new float[] { -1, 0, 1 };
		double[] expecteds = new double[] { 0.5403023058681398, 1,
				0.5403023058681398 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.cos(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.cos(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.cos(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testcoshfloat() {

		float[] inputsinReal = new float[] { (float) -0.5, 0, (float) 0.5 };
		double[] expecteds = new double[] { 1.1276259652063807, 1,
				1.1276259652063807 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.cosh(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.cosh(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.cosh(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test
	public void testexpfloat() {

		float[] inputsinReal = new float[] { 1, 2, 3 };
		double[] expecteds = new double[] { 2.718281828459045,
				7.38905609893065, 20.085536923187668 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.exp(0, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode ra = core.exp(-1, 2, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.exp(0, -1, inputsinReal, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
}
