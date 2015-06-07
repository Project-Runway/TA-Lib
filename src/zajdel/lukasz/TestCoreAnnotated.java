package zajdel.lukasz;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.Compatibility;
import com.tictactec.ta.lib.CoreAnnotated;
import com.tictactec.ta.lib.FuncUnstId;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

public class TestCoreAnnotated {
	static CoreAnnotated core;

	@BeforeClass
	public static void beforeClass() {
		core = new CoreAnnotated();
	}

	@Test
	public void testSMA() {

		double[] inputsinReal = new double[] { -1.50, -9.04, 9.50, -0.84, 1.72,
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

		core.sma(0, 99, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode rb = core.sma(-1, 99, inputsinReal, 100, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), rb.toString());

		RetCode rb1 = core.sma(0, -1, inputsinReal, 100, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb1.toString());

		RetCode rb2 = core.sma(0, 99, inputsinReal, 1, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.BadParam.toString(), rb2.toString());

		double[] inputsinReal1 = new double[] { -1.50, -9.04, 9.50, -0.84,
				1.72, -1.20, -7.89, 5.64, -0.83, -2.60, -5.48, 5.74, -9.40,
				7.68, 5.51, -9.39, -4.50, -8.28, 8.83, -8.61, -2.66, 1.74,
				2.46, 9.12, -1.03, -2.73, 2.08, 5.32, 9.37, -9.75 };
		int optInTimePeriod1 = Integer.MIN_VALUE;
		double[] expecteds1 = new double[] { -0.36733333333333357 };
		double[] outReal1 = new double[1];

		core.sma(0, 29, inputsinReal1, optInTimePeriod1, outBegIdx,
				outNBElement, outReal1);
		assertArrayEquals(expecteds1, outReal1, 0);

	}

	@Test
	public void testSMAFloat() {

		float[] inputsinReal = new float[] { -1, -9, 9, 0, 1, -1, -7, 5, 0, -2,
				-5, 5, -9, 7, 5, -9, -4, -8, 8, -8, -2, 1, 2, 9, -1, -2, 2, 5,
				9, -9, 2, 2, 10, -3, -3, -3, 3, -5, -6, 6, -6, 7, 7, 4, -2, 6,
				-6, -4, 9, 0, 6, -3, -9, 2, 0, -5, 0, 2, -8, 5, 0, 6, 9, -7, 6,
				8, 3, -5, -7, -9, -1, 7, 1, 5, 7, 9, -2, 8, -2, -3, -5, -4, -6,
				-5, 0, -4, 8, -1, 1, 6, 8, 0, 1, 0, -7, 3, -4, 4, -7, -4 };
		double[] expecteds = new double[] { 0.16 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();

		double[] outReal = new double[1];

		core.sma(0, 99, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

		RetCode rb = core.sma(-1, 99, inputsinReal, 100, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), rb.toString());

		RetCode rb1 = core.sma(0, -1, inputsinReal, 100, outBegIdx,
				outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb1.toString());

		RetCode rb2 = core.sma(0, 99, inputsinReal, 1, outBegIdx, outNBElement,
				outReal);
		assertEquals(RetCode.BadParam.toString(), rb2.toString());

		float[] inputsinReal1 = new float[] { -1, -9, 9, -0, 1, -1, -7, 5, -0,
				-2, -5, 5, -9, 7, 5, -9, -4, -8, 8, -8, -2, 1, 2, 9, -1, -2, 2,
				5, 9, -9 };
		int optInTimePeriod1 = Integer.MIN_VALUE;
		double[] expecteds1 = new double[] { -0.3 };
		double[] outReal1 = new double[1];

		core.sma(0, 29, inputsinReal1, optInTimePeriod1, outBegIdx,
				outNBElement, outReal1);
		assertArrayEquals(expecteds1, outReal1, 0);

	}

	@Test
	public void testSmaLookback() {

		int optInTimePeriod = 10;
		int expecteds = 9;

		int n = core.smaLookback(optInTimePeriod);
		assertEquals(expecteds, n);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.smaLookback(optInTimePeriod1);
		assertEquals(29, actual1);

		int optInTimePeriod2 = 1;
		int actual2 = core.smaLookback(optInTimePeriod2);
		assertEquals(-1, actual2);

	}

	@Test
	public void testSetUnstablePeriod() {

		RetCode expecteds = RetCode.Success;
		FuncUnstId id = FuncUnstId.Adxr;
		int period = 10;

		RetCode actual = core.SetUnstablePeriod(id, period);
		assertEquals(expecteds, actual);

		FuncUnstId id1 = FuncUnstId.All;
		RetCode actual1 = core.SetUnstablePeriod(id1, period);
		assertEquals(RetCode.BadParam.toString(), actual1.toString());

		int actual2 = core.GetUnstablePeriod(id);
		assertEquals(period, actual2);
	}

	@Test
	public void testSumLookBack() {

		int expecteds = 0;
		int actual = core.subLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testTrimaLookBack() {

		int optInTimePeriod = 100;
		int expecteds = 99;
		int actual = core.trimaLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.trimaLookback(optInTimePeriod1);
		assertEquals(29, actual1);

		int optInTimePeriod2 = 1;
		int actual2 = core.trimaLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testTsfLookBack() {

		int optInTimePeriod = 7;
		int expecteds = 6;
		int actual = core.tsfLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.tsfLookback(optInTimePeriod1);
		assertEquals(13, actual1);

		int optInTimePeriod2 = 1;
		int actual2 = core.tsfLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testWillRLookBack() {

		int optInTimePeriod = 38;
		int expecteds = 37;
		int actual = core.willRLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.willRLookback(optInTimePeriod1);
		assertEquals(13, actual1);

		int optInTimePeriod2 = 1;
		int actual2 = core.willRLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testWmaLookBack() {

		int optInTimePeriod = 76;
		int expecteds = 75;
		int actual = core.wmaLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.wmaLookback(optInTimePeriod1);
		assertEquals(29, actual1);

		int optInTimePeriod2 = 1;
		int actual2 = core.wmaLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testAroonBackLookBack() {

		int optInTimePeriod = 90;
		int expecteds = 90;
		int actual = core.aroonLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.aroonLookback(optInTimePeriod1);
		assertEquals(14, actual1);

		int optInTimePeriod2 = 1;
		int actual2 = core.aroonLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testAroonOscBackLookBack() {

		int optInTimePeriod = 40;
		int expecteds = 40;
		int actual = core.aroonOscLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.aroonOscLookback(optInTimePeriod1);
		assertEquals(14, actual1);

		int optInTimePeriod2 = 1;
		int actual2 = core.aroonOscLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testBetaLookBack() {

		int optInTimePeriod = 37;
		int expecteds = 37;
		int actual = core.betaLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.betaLookback(optInTimePeriod1);
		assertEquals(5, actual1);

		int optInTimePeriod2 = 0;
		int actual2 = core.betaLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testMomLookBack() {

		int optInTimePeriod = 5;
		int expecteds = 5;
		int actual = core.momLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.momLookback(optInTimePeriod1);
		assertEquals(10, actual1);

		int optInTimePeriod2 = 0;
		int actual2 = core.momLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testRocLookBack() {

		int optInTimePeriod = 40;
		int expecteds = 40;
		int actual = core.rocLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.rocLookback(optInTimePeriod1);
		assertEquals(10, actual1);

		int optInTimePeriod2 = 0;
		int actual2 = core.rocLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testRocPLookBack() {

		int optInTimePeriod = 40;
		int expecteds = 40;
		int actual = core.rocPLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.rocPLookback(optInTimePeriod1);
		assertEquals(10, actual1);

		int optInTimePeriod2 = 0;
		int actual2 = core.rocPLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testRocRLookBack() {

		int optInTimePeriod = 654;
		int expecteds = 654;
		int actual = core.rocRLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.rocRLookback(optInTimePeriod1);
		assertEquals(10, actual1);

		int optInTimePeriod2 = 0;
		int actual2 = core.rocRLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testRocR100LookBack() {

		int optInTimePeriod = 400;
		int expecteds = 400;
		int actual = core.rocR100Lookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.rocR100Lookback(optInTimePeriod1);
		assertEquals(10, actual1);

		int optInTimePeriod2 = 0;
		int actual2 = core.rocR100Lookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testMinMaxLookBack() {

		int optInTimePeriod = 54;
		int expecteds = 53;
		int actual = core.minMaxLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.minMaxLookback(optInTimePeriod1);
		assertEquals(29, actual1);

		int optInTimePeriod2 = 1;
		int actual2 = core.minMaxLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testMinMaxIndexLookBack() {

		int optInTimePeriod = 65;
		int expecteds = 64;
		int actual = core.minMaxIndexLookback(optInTimePeriod);
		assertEquals(expecteds, actual);

		int optInTimePeriod1 = Integer.MIN_VALUE;
		int actual1 = core.minMaxIndexLookback(optInTimePeriod1);
		assertEquals(29, actual1);

		int optInTimePeriod2 = 1;
		int actual2 = core.minMaxIndexLookback(optInTimePeriod2);
		assertEquals(-1, actual2);
	}

	@Test
	public void testCdl2CrowsLookback() {
		int expecteds = 12;
		int actual = core.cdl2CrowsLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdl3BlackCrowsLookback() {

		int expecteds = 13;
		int actual = core.cdl3BlackCrowsLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdl3LineStrikeLookback() {

		int expecteds = 8;
		int actual = core.cdl3LineStrikeLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlBreakawayLookback() {

		int expecteds = 14;
		int actual = core.cdlBreakawayLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlConcealBabysWallLookback() {

		int expecteds = 13;
		int actual = core.cdlConcealBabysWallLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlLadderBottomLookback() {

		int expecteds = 14;
		int actual = core.cdlLadderBottomLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlMatchingLowLookback() {

		int expecteds = 6;
		int actual = core.cdlMatchingLowLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlPiercingLookback() {

		int expecteds = 11;
		int actual = core.cdlPiercingLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlStickSandwhichLookback() {

		int expecteds = 7;
		int actual = core.cdlStickSandwhichLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlTasukiGapLookback() {

		int expecteds = 7;
		int actual = core.cdlTasukiGapLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlTristarLookback() {

		int expecteds = 12;
		int actual = core.cdlTristarLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testHtDcPeriodLookback() {

		int expecteds = 32;
		int actual = core.htDcPeriodLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testHtDcPhaseLookback() {

		int expecteds = 63;
		int actual = core.htDcPhaseLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testHtPhasorLookback() {

		int expecteds = 32;
		int actual = core.htPhasorLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testHtSineLookback() {

		int expecteds = 63;
		int actual = core.htSineLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testHtTrendlineLookback() {

		int expecteds = 63;
		int actual = core.htSineLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testHtTrendModeLookback() {

		int expecteds = 63;
		int actual = core.htTrendModeLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlDojiLookback() {

		int expecteds = 10;
		int actual = core.cdlDojiLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlSpinningTopLookback() {

		int expecteds = 10;
		int actual = core.cdlSpinningTopLookback();

		assertEquals(expecteds, actual);
	}

	@Test
	public void testAcosLookBack() {

		int expecteds = 0;
		int actual = core.acosLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testAdLookBack() {

		int expecteds = 0;
		int actual = core.adLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testAddLookBack() {

		int expecteds = 0;
		int actual = core.addLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testAsinLookBack() {

		int expecteds = 0;
		int actual = core.asinLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testAtanLookBack() {

		int expecteds = 0;
		int actual = core.atanLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testAvgPriceLookBack() {

		int expecteds = 0;
		int actual = core.avgPriceLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testBopLookBack() {

		int expecteds = 0;
		int actual = core.bopLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdl3OutsideLookback() {

		int expecteds = 3;
		int actual = core.cdl3OutsideLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlEngulfingLookbackLookbackLookBack() {

		int expecteds = 2;
		int actual = core.cdlEngulfingLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlHikkakeLookback() {

		int expecteds = 5;
		int actual = core.cdlHikkakeLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testCdlXSideGap3MethodsLookback() {

		int expecteds = 2;
		int actual = core.cdlXSideGap3MethodsLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testCeilLookback() {

		int expecteds = 0;
		int actual = core.ceilLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testCosLookback() {

		int expecteds = 0;
		int actual = core.cosLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testCoshLookback() {

		int expecteds = 0;
		int actual = core.coshLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testDivLookback() {

		int expecteds = 0;
		int actual = core.divLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testExpLookback() {

		int expecteds = 0;
		int actual = core.expLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testFloorLookback() {

		int expecteds = 0;
		int actual = core.floorLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testLnLookback() {

		int expecteds = 0;
		int actual = core.lnLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testLog10Lookback() {

		int expecteds = 0;
		int actual = core.log10Lookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testMedPriceLookback() {

		int expecteds = 0;
		int actual = core.medPriceLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testMultLookback() {

		int expecteds = 0;
		int actual = core.multLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testObvLookback() {

		int expecteds = 0;
		int actual = core.obvLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testSinLookback() {

		int expecteds = 0;
		int actual = core.sinLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testSinhLookback() {

		int expecteds = 0;
		int actual = core.sinhLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testSqrtLookback() {

		int expecteds = 0;
		int actual = core.sqrtLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testSubLookback() {

		int expecteds = 0;
		int actual = core.subLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testTanLookback() {

		int expecteds = 0;
		int actual = core.tanLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testTanhLookback() {

		int expecteds = 0;
		int actual = core.tanhLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testTrueRangeLookback() {

		int expecteds = 1;
		int actual = core.trueRangeLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testTypPriceLookback() {

		int expecteds = 0;
		int actual = core.typPriceLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testWclPriceLookback() {

		int expecteds = 0;
		int actual = core.wclPriceLookback();
		assertEquals(expecteds, actual);
	}

	@Test
	public void testGetSetCompatibility() {

		core.SetCompatibility(Compatibility.Default);
		Compatibility expecteds = Compatibility.Default;

		Compatibility actual = core.getCompatibility();
		assertEquals(expecteds, actual);
	}
}