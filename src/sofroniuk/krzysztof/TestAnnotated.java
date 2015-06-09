package sofroniuk.krzysztof;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.CandleSettingType;
import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.CoreAnnotated;
import com.tictactec.ta.lib.MAType;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RangeType;
import com.tictactec.ta.lib.RetCode;
@SuppressWarnings("unused")
public class TestAnnotated {
	static CoreAnnotated core;

	@BeforeClass
	public static void beforeClass() {
		core = new CoreAnnotated();
	}

	@Test
	public void TestCdlEveningStarLookback() {

		Core c1 = new Core();

		RetCode r0 = c1.SetCandleSettings(CandleSettingType.BodyShort,
				RangeType.HighLow, 8, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong,
				RangeType.HighLow, 2, 10.0);
		assertEquals(8 + 2, c1.cdlEveningStarLookback(0));

		r0 = c1.SetCandleSettings(CandleSettingType.BodyShort,
				RangeType.HighLow, 2, 10.0);
		r1 = c1.SetCandleSettings(CandleSettingType.BodyLong,
				RangeType.HighLow, 8, 10.0);
		assertEquals(8 + 2, c1.cdlEveningStarLookback(0));
	}

	@Test
	public void TestCdlMatHoldLookback() {

		Core c1 = new Core();

		RetCode r0 = c1.SetCandleSettings(CandleSettingType.BodyShort,
				RangeType.HighLow, 8, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong,
				RangeType.HighLow, 2, 10.0);
		assertEquals(8 + 4, c1.cdlMatHoldLookback(0));

		r0 = c1.SetCandleSettings(CandleSettingType.BodyShort,
				RangeType.HighLow, 2, 10.0);
		r1 = c1.SetCandleSettings(CandleSettingType.BodyLong,
				RangeType.HighLow, 8, 10.0);
		assertEquals(8 + 4, c1.cdlMatHoldLookback(0));
	}
	
	@Test
	public void TestCdlMorningStarLookback() {

		Core c1 = new Core();

		RetCode r0 = c1.SetCandleSettings(CandleSettingType.BodyShort,
				RangeType.HighLow, 8, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong,
				RangeType.HighLow, 2, 10.0);
		assertEquals(8 + 2, c1.cdlMorningStarLookback(0));

		r0 = c1.SetCandleSettings(CandleSettingType.BodyShort,
				RangeType.HighLow, 2, 10.0);
		r1 = c1.SetCandleSettings(CandleSettingType.BodyLong,
				RangeType.HighLow, 8, 10.0);
		assertEquals(8 + 2, c1.cdlMorningStarLookback(0));
	}

	@Test
	public void TestCdlTakuriLookback() {

		Core c1 = new Core();

		RetCode r0 = c1.SetCandleSettings(CandleSettingType.BodyDoji,
				RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort,
				RangeType.HighLow, 2, 10.0);
		RetCode r2 = c1.SetCandleSettings(CandleSettingType.ShadowVeryLong,
				RangeType.HighLow, 1, 10.0);
		assertEquals(6, c1.cdlTakuriLookback());

		r0 = c1.SetCandleSettings(CandleSettingType.BodyDoji,
				RangeType.HighLow, 7, 10.0);
		r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort,
				RangeType.HighLow, 3, 10.0);
		r2 = c1.SetCandleSettings(CandleSettingType.ShadowVeryLong,
				RangeType.HighLow, 8, 10.0);
		assertEquals(8, c1.cdlTakuriLookback());
	}

	@Test
	public void TestApo() {

		double[] inReal = new double[] { 3, 25, 4, 5, 62, 3, 2, 1 };
		double[] expecteds = new double[] { -10.189471879286693 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];

		MAType optInMAType = MAType.Ema;

		int optInFastPeriod = 8;
		int optInSlowPeriod = 2;

		RetCode ra = core.apo(-1, 7, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.apo(0, -1, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.apo(0, 7, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

		double[] inReal1 = new double[] { 12, 7, 9, 4, 1, 3, 6, 7, 1 };
		int optInFastPeriod1 = Integer.MIN_VALUE;
		int optInSlowPeriod1 = Integer.MIN_VALUE;
		double[] expecteds1 = new double[] { 0 };
		double[] outReal1 = new double[1];

		core.apo(0, 9, inReal1, optInFastPeriod1, optInSlowPeriod1,
				optInMAType, outBegIdx, outNBElement, outReal1);
		assertArrayEquals(expecteds1, outReal1, 0);
	}

	@Test
	public void TestApoFloat() {

		float[] inReal = new float[] { 3, 25, 4, 5, 62, 3, 2, 1 };
		double[] expecteds = new double[] { -10.189471879286693 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];

		MAType optInMAType = MAType.Ema;

		int optInFastPeriod = 8;
		int optInSlowPeriod = 2;

		RetCode ra = core.apo(-1, 7, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.apo(0, -1, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.apo(0, 7, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

		float[] inReal1 = new float[] { 12, 7, 9, 4, 1, 3, 6, 7, 1 };
		int optInFastPeriod1 = Integer.MIN_VALUE;
		int optInSlowPeriod1 = Integer.MIN_VALUE;
		double[] expecteds1 = new double[] { 0 };
		double[] outReal1 = new double[1];

		core.apo(0, 9, inReal1, optInFastPeriod1, optInSlowPeriod1,
				optInMAType, outBegIdx, outNBElement, outReal1);
		assertArrayEquals(expecteds1, outReal1, 0);
	}

	@Test
	public void TestPpo() {

		double[] inReal = new double[] { 3, 25, 4, 5, 62, 3, 2, 1 };
		double[] expecteds = new double[] { -77.63407146123194 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];

		MAType optInMAType = MAType.Ema;

		int optInFastPeriod = 8;
		int optInSlowPeriod = 2;

		RetCode ra = core.ppo(-1, 7, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.ppo(0, -1, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.ppo(0, 7, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

		double[] inReal1 = new double[] { 12, 7, 9, 4, 1, 3, 6, 7, 1 };
		int optInFastPeriod1 = Integer.MIN_VALUE;
		int optInSlowPeriod1 = Integer.MIN_VALUE;
		double[] expecteds1 = new double[] { 0 };
		double[] outReal1 = new double[1];

		core.ppo(0, 9, inReal1, optInFastPeriod1, optInSlowPeriod1,
				optInMAType, outBegIdx, outNBElement, outReal1);
		assertArrayEquals(expecteds1, outReal1, 0);
	}

	@Test
	public void TestPpoFloat() {

		float[] inReal = new float[] { 3, 25, 4, 5, 62, 3, 2, 1 };
		double[] expecteds = new double[] { -77.63407146123194 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];

		MAType optInMAType = MAType.Ema;

		int optInFastPeriod = 8;
		int optInSlowPeriod = 2;

		RetCode ra = core.ppo(-1, 7, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.ppo(0, -1, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.ppo(0, 7, inReal, optInFastPeriod, optInSlowPeriod,
				optInMAType, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

		float[] inReal1 = new float[] { 12, 7, 9, 4, 1, 3, 6, 7, 1 };
		int optInFastPeriod1 = Integer.MIN_VALUE;
		int optInSlowPeriod1 = Integer.MIN_VALUE;
		double[] expecteds1 = new double[] { 0 };
		double[] outReal1 = new double[1];

		core.ppo(0, 9, inReal1, optInFastPeriod1, optInSlowPeriod1,
				optInMAType, outBegIdx, outNBElement, outReal1);
		assertArrayEquals(expecteds1, outReal1, 0);
	}

	@Test
	public void TestBop() {

		double[] inOpen = new double[] { 9.99, 7.96, 10.02, 4.99, 5.49 };
		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inClose = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] expecteds = new double[] { -0.2, -0.24999999999999994, -0.2,
				-0.25, -0.3333333333333333 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode ra = core.bop(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.bop(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.bop(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	}

	@Test
	public void TestBopFloat() {

		float[] inOpen = new float[] { 9, 7, 10, 4, 5 };
		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		float[] inClose = new float[] { 8, 6, 9, 3, 4 };
		double[] expecteds = new double[] { -0.2, -0.25, -0.2, -0.25,
				-0.3333333333333333 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode ra = core.bop(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.bop(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.bop(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	}

	@Test
	public void TestVariance() {

		double[] inReal = new double[] { -1.50, -9.04, 9.50, -0.84, 1.72,
				-1.20, -7.89, 5.64, -0.83, -2.60, -5.48, 5.74, -9.40, 7.68,
				5.51, -9.39, -4.50, -8.28, 8.83, -8.61, -2.66, 1.74, 2.46,
				9.12, -1.03, -2.73, 2.08, 5.32, 9.37, -9.75, 2.55, 2.10, 10.00,
				-3.86, -3.81, -3.93, 3.15, -5.77, -6.74, 6.64, -6.26, 7.30,
				7.03, 4.11, -2.46, 6.17, -6.35, -4.44, 9.53, 0.93, 6.96, -3.17,
				-9.98, 2.41, -0.80, -5.11, 0.51, 2.64, -8.77, 5.52, 0.01, 6.95,
				9.87, -7.22, 6.97, 8.02, 3.47, -5.22, -7.83, -9.28, -1.44,
				7.81, 1.67, 5.08, 7.26, 9.01, -2.54, 8.07, -2.68, -3.73, -5.52,
				-4.23, -6.94, -5.47, 0.94, -4.39, 8.55, -1.37, 1.29, 6.69,
				8.21, 0.28, 1.22, 0.82, -7.62, 3.55, -4.35, 4.33, -7.36, -4.01 };
		double[] expecteds = new double[] { 34.52310875000001 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];
		double optInNbDev = 2;

		RetCode ra = core.variance(-1, 99, inReal, 100, optInNbDev, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.variance(0, -1, inReal, 100, optInNbDev, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.variance(0, 99, inReal, 100, optInNbDev, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

		double[] inReal1 = new double[] { 1.50, 7, 9.50, 0.84, 1.72 };
		int optInTimePeriod1 = Integer.MIN_VALUE;
		double[] expecteds1 = new double[] { 12.124256000000003 };
		double[] outReal1 = new double[1];

		core.variance(0, 4, inReal1, optInTimePeriod1, optInNbDev, outBegIdx,
				outNBElement, outReal1);
		assertArrayEquals(expecteds1, outReal1, 0);

	}

	@Test
	public void TestVarianceFloat() {

		float[] inReal = new float[] { -1, -9, 9, 0, 1, -1, -7, 5, 0, -2, -5,
				5, -9, 7, 5, -9, -4, -8, 8, -8, -2, 1, 2, 9, -1, -2, 2, 5, 9,
				-9, 2, 2, 10, -3, -3, -3, 3, -5, -6, 6, -6, 7, 7, 4, -2, 6, -6,
				-4, 9, 0, 6, -3, -9, 2, 0, -5, 0, 2, -8, 5, 0, 6, 9, -7, 6, 8,
				3, -5, -7, -9, -1, 7, 1, 5, 7, 9, -2, 8, -2, -3, -5, -4, -6,
				-5, 0, -4, 8, -1, 1, 6, 8, 0, 1, 0, -7, 3, -4, 4, -7, -4 };
		double[] expecteds = new double[] { 29.8944 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];
		double optInNbDev = 2;

		RetCode ra = core.variance(-1, 99, inReal, 100, optInNbDev, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.variance(0, -1, inReal, 100, optInNbDev, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.variance(0, 99, inReal, 100, optInNbDev, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

		float[] inReal1 = new float[] { 1, 7, 9, 0, 1 };
		int optInTimePeriod1 = Integer.MIN_VALUE;
		double[] expecteds1 = new double[] { 13.439999999999998 };
		double[] outReal1 = new double[1];

		core.variance(0, 4, inReal1, optInTimePeriod1, optInNbDev, outBegIdx,
				outNBElement, outReal1);
		assertArrayEquals(expecteds1, outReal1, 0);

	}

	@Test
	public void TestAvgPrice() {

		double[] inOpen = new double[] { 9.99, 7.96, 10.02, 4.99, 5.49 };
		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inClose = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] expecteds = new double[] { 9.99, 7.710000000000001, 10.02,
				4.74, 4.99 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode ra = core.avgPrice(-1, 4, inOpen, inHigh, inLow, inClose,
				outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.avgPrice(0, -1, inOpen, inHigh, inLow, inClose,
				outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.avgPrice(0, 4, inOpen, inHigh, inLow, inClose,
				outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	}

	@Test
	public void TestAvgPriceFloat() {

		float[] inOpen = new float[] { 9, 7, 10, 4, 5 };
		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		float[] inClose = new float[] { 8, 6, 9, 3, 4 };
		double[] expecteds = new double[] { 9, 6.75, 10, 3.75, 4.5 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode ra = core.avgPrice(-1, 4, inOpen, inHigh, inLow, inClose,
				outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.avgPrice(0, -1, inOpen, inHigh, inLow, inClose,
				outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.avgPrice(0, 4, inOpen, inHigh, inLow, inClose,
				outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	}

	@Test
	public void TestWclPrice() {

		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inClose = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] expecteds = new double[] { 9.74, 7.460000000000001, 9.77,
				4.49, 4.74 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode ra = core.wclPrice(-1, 4, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.wclPrice(0, -1, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.wclPrice(0, 4, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

	}

	@Test
	public void TestWclPriceFloat() {

		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		float[] inClose = new float[] { 8, 6, 9, 3, 4 };
		double[] expecteds = new double[] { 8.75, 6.5, 9.75, 3.5, 4.25 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode ra = core.wclPrice(-1, 4, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.wclPrice(0, -1, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.wclPrice(0, 4, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

	}

	@Test
	public void TestTypPrice() {

		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inClose = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] expecteds = new double[] { 9.99, 7.626666666666668, 10.02,
				4.656666666666667, 4.823333333333333 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode ra = core.typPrice(-1, 4, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.typPrice(0, -1, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.typPrice(0, 4, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

	}

	@Test
	public void TestTypPriceFloat() {

		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		float[] inClose = new float[] { 8, 6, 9, 3, 4 };
		double[] expecteds = new double[] { 9, 6.666666666666667, 10,
				3.6666666666666665, 4.333333333333333 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode ra = core.typPrice(-1, 4, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.typPrice(0, -1, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.typPrice(0, 4, inHigh, inLow, inClose, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

	}

	@Test
	public void TestMedPrice() {

		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] expecteds = new double[] { 10.49, 7.960000000000001, 10.52,
				4.99, 4.99 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode ra = core.medPrice(-1, 4, inHigh, inLow, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.medPrice(0, -1, inHigh, inLow, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.medPrice(0, 4, inHigh, inLow, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

	}

	@Test
	public void TestEma() {

		double[] inReal = new double[] { -1.50, -9.04, 9.50, -0.84, 1.72,
				-1.20, -7.89, 5.64, -0.83, -2.60, -5.48, 5.74, -9.40, 7.68,
				5.51, -9.39, -4.50, -8.28, 8.83, -8.61, -2.66, 1.74, 2.46,
				9.12, -1.03, -2.73, 2.08, 5.32, 9.37, -9.75, 2.55, 2.10, 10.00,
				-3.86, -3.81, -3.93, 3.15, -5.77, -6.74, 6.64, -6.26, 7.30,
				7.03, 4.11, -2.46, 6.17, -6.35, -4.44, 9.53, 0.93, 6.96, -3.17,
				-9.98, 2.41, -0.80, -5.11, 0.51, 2.64, -8.77, 5.52, 0.01, 6.95,
				9.87, -7.22, 6.97, 8.02, 3.47, -5.22, -7.83, -9.28, -1.44,
				7.81, 1.67, 5.08, 7.26, 9.01, -2.54, 8.07, -2.68, -3.73, -5.52,
				-4.23, -6.94, -5.47, 0.94, -4.39, 8.55, -1.37, 1.29, 6.69,
				8.21, 0.28, 1.22, 0.82, -7.62, 3.55, -4.35, 4.33, -7.36, -4.01 };
		double[] expecteds = new double[] { 0.13949999999999993 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];
		double optInNbDev = 2;

		RetCode ra = core.ema(-1, 99, inReal, 100, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.ema(0, -1, inReal, 100, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.ema(0, 99, inReal, 100, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		double[] inReal1 = new double[] { -1.50, -9.04, 9.50, -0.84, 1.72,
				-1.20, -7.89, 5.64, -0.83, -2.60, -5.48, 5.74, -9.40, 7.68,
				5.51, -9.39, -4.50, -8.28, 8.83, -8.61, -2.66, 1.74, 2.46,
				9.12, -1.03, -2.73, 2.08, 5.32, 9.37, -9.75, 2.55 };
		int optInTimePeriod1 = Integer.MIN_VALUE;
		double[] expecteds1 = new double[] { -0.36733333333333357 };
		double[] outReal1 = new double[1];

		core.ema(0, 29, inReal1, optInTimePeriod1, outBegIdx, outNBElement,
				outReal1);
		assertArrayEquals(expecteds1, outReal1, 0);

	}

	@Test
	public void TestEmaFloat() {

		float[] inReal = new float[] { -1, -9, 9, 0, 1, -1, -7, 5, 0, -2, -5,
				5, -9, 7, 5, -9, -4, -8, 8, -8, -2, 1, 2, 9, -1, -2, 2, 5, 9,
				-9, 2, 2, 10, -3, -3, -3, 3, -5, -6, 6, -6, 7, 7, 4, -2, 6, -6,
				-4, 9, 0, 6, -3, -9, 2, 0, -5, 0, 2, -8, 5, 0, 6, 9, -7, 6, 8,
				3, -5, -7, -9, -1, 7, 1, 5, 7, 9, -2, 8, -2, -3, -5, -4, -6,
				-5, 0, -4, 8, -1, 1, 6, 8, 0, 1, 0, -7, 3, -4, 4, -7, -4 };
		double[] expecteds = new double[] { 0.16 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];
		double optInNbDev = 2;

		RetCode ra = core.ema(-1, 99, inReal, 100, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.ema(0, -1, inReal, 100, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.ema(0, 99, inReal, 100, outBegIdx, outNBElement,
				outReal);
		assertArrayEquals(expecteds, outReal, 0);

		float[] inReal1 = new float[] { -1, -9, 9, 0, 1, -1, -7, 5, 0, -2, -5,
				5, -9, 7, 5, -9, -4, -8, 8, -8, -2, 1, 2, 9, -1, -2, 2, 5, 9,
				-9 };
		int optInTimePeriod1 = Integer.MIN_VALUE;
		double[] expecteds1 = new double[] { -0.3 };
		double[] outReal1 = new double[1];

		core.ema(0, 29, inReal1, optInTimePeriod1, outBegIdx, outNBElement,
				outReal1);
		assertArrayEquals(expecteds1, outReal1, 0);

	}

	@Test
	public void TestMedPriceFloat() {

		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		double[] expecteds = new double[] { 9.5, 7, 10.5, 4, 4.5 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode ra = core.medPrice(-1, 4, inHigh, inLow, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());

		RetCode rb = core.medPrice(0, -1, inHigh, inLow, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());

		RetCode rc = core.medPrice(0, 4, inHigh, inLow, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

	}

	@Test
	public void TestAdd() {

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
	public void TestDiv() {

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
	public void TestMult() {

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
	public void TestSub() {

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
	public void TestAddFloat() {

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
	public void TestDivFloat() {

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
	public void TestMultFloat() {

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
	public void TestSubFloat() {

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
	public void TestAcos() {

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
	public void TestAsin() {

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
	public void TestAtan() {

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
	public void TestCeil() {

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
	public void TestCos() {

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
	public void TestCosh() {

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
	public void TestExp() {

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
	public void TestFloor() {

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
	public void TestLn() {

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
	public void TestLog10() {

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
	public void TestSin() {

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
	public void TestSinh() {

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
	public void TestSqrt() {

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
	public void TestTan() {

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
	public void TestTanh() {

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
	public void TestaCosFloat() {

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
	public void TestAsinFloat() {

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
	public void TestAtanFloat() {

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
	public void TestCeilFloat() {

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
	public void TestCosFloat() {

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
	public void TestCoshFloat() {

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
	public void TestExpFloat() {

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
