package stohnij.lukasz;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.CandleSetting;
import com.tictactec.ta.lib.CandleSettingType;
import com.tictactec.ta.lib.Compatibility;
import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.FuncUnstId;
import com.tictactec.ta.lib.MAType;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RangeType;
import com.tictactec.ta.lib.RetCode;
@SuppressWarnings("unused")
public class TestCore {
	static Core core;
	
	
	@BeforeClass
	public static void beforeClass(){
		core = new Core();
	
	}


	@Test
	public void testsma() {
		double[] inputsinReal = new double[] { -1.50, -9.04, 9.50, -0.84, 1.72, -1.20, -7.89, 5.64, -0.83, -2.60, -5.48,
				5.74, -9.40, 7.68, 5.51, -9.39, -4.50, -8.28, 8.83, -8.61, -2.66, 1.74,
				2.46, 9.12, -1.03, -2.73, 2.08, 5.32, 9.37, -9.75, 2.55, 2.10, 10.00,
				-3.86, -3.81, -3.93, 3.15, -5.77, -6.74, 6.64, -6.26, 7.30, 7.03, 4.11,
				-2.46, 6.17, -6.35, -4.44, 9.53, 0.93, 6.96, -3.17, -9.98, 2.41, -0.80,
				-5.11, 0.51, 2.64, -8.77, 5.52, 0.01, 6.95, 9.87, -7.22, 6.97, 8.02,
				3.47, -5.22, -7.83, -9.28, -1.44, 7.81, 1.67, 5.08, 7.26, 9.01, -2.54,
				8.07, -2.68, -3.73, -5.52, -4.23, -6.94, -5.47, 0.94, -4.39, 8.55, -1.37,
				1.29, 6.69, 8.21, 0.28, 1.22, 0.82, -7.62, 3.55, -4.35, 4.33, -7.36,
				-4.01 };
		

		double[] expecteds = new double[] { 0.13949999999999993 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sma(0, 99, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.sma(-1, 99, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.sma(0, -1, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
		
		RetCode rc4 = core.sma(0, 99, inputsinReal, 1, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.BadParam.toString(),rc4.toString());
		
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
	public void testsma2() {
			float[] inputsinReal = new float[] { -1.50f, -9.04f, 9.50f, -0.84f, 1.72f, -1.20f, -7.89f, 5.64f, -0.83f, -2.60f, -5.48f,
					5.74f, -9.40f, 7.68f, 5.51f, -9.39f, -4.50f, -8.28f, 8.83f, -8.61f, -2.66f, 1.74f,
					2.46f, 9.12f, -1.03f, -2.73f, 2.08f, 5.32f, 9.37f, -9.75f, 2.55f, 2.10f, 10.00f,
					-3.86f, -3.81f, -3.93f, 3.15f, -5.77f, -6.74f, 6.64f, -6.26f, 7.30f, 7.03f, 4.11f,
					-2.46f, 6.17f, -6.35f, -4.44f, 9.53f, 0.93f, 6.96f, -3.17f, -9.98f, 2.41f, -0.80f,
					-5.11f, 0.51f, 2.64f, -8.77f, 5.52f, 0.01f, 6.95f, 9.87f, -7.22f, 6.97f, 8.02f,
					3.47f, -5.22f, -7.83f, -9.28f, -1.44f, 7.81f, 1.67f, 5.08f, 7.26f, 9.01f, -2.54f,
					8.07f, -2.68f, -3.73f, -5.52f, -4.23f, -6.94f, -5.47f, 0.94f, -4.39f, 8.55f, -1.37f,
					1.29f, 6.69f, 8.21f, 0.28f, 1.22f, 0.82f, -7.62f, 3.55f, -4.35f, 4.33f, -7.36f,
					-4.01f };
		

		double[] expecteds = new double[] { 0.1395000151731074 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sma(0, 99, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.sma(-1, 99, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.sma(0, -1, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
		
		RetCode rc4 = core.sma(0, 99, inputsinReal, 1, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.BadParam.toString(),rc4.toString());
		
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
	public void testtan() {
		double[] inputsinReal = new double[] { -1.50 };
		

		double[] expecteds = new double[] { -14.101419947171719 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.tan(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
<<<<<<< HEAD
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.tan(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.tan(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());


=======
>>>>>>> b1973f937cf4f14ca1205da20d736091f60be388
		
	} 
	

	@Test
	public void testtan2() {
		float[] inputsinReal = new float[] { -1.50f };
		

		double[] expecteds = new double[] { -14.101419947171719 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.tan(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.tan(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.tan(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 
	
	@Test
	public void testtanh() {
		double[] inputsinReal = new double[] { -1.50 };
		

		double[] expecteds = new double[] { -0.9051482536448664 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.tanh(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
<<<<<<< HEAD
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
=======
>>>>>>> b1973f937cf4f14ca1205da20d736091f60be388
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.tanh(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.tanh(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 
	
	@Test
	public void testtanh2() {
		float[] inputsinReal = new float[] { -1.50f };
		

		double[] expecteds = new double[] { -0.9051482536448664 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.tanh(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
<<<<<<< HEAD
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
=======
>>>>>>> b1973f937cf4f14ca1205da20d736091f60be388
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.tanh(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.tanh(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 
	
	
	@Test
	public void testfloor() {
		double[] inputsinReal = new double[] { -1.50 };
		

		double[] expecteds = new double[] { -2.00 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.floor(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.floor(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.floor(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 
	
	@Test
	public void testfloor2() {
		float[] inputsinReal = new float[] { -1.50f };
		

		double[] expecteds = new double[] { -2.00 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.floor(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.floor(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.floor(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 


	@Test
	public void testln() {
		double[] inputsinReal = new double[] { 1.50 };
		

		double[] expecteds = new double[] { 0.4054651081081644 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.ln(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.ln(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.ln(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 
	
	@Test
	public void testln2() {
		float[] inputsinReal = new float[] { 1.50f };
		

		double[] expecteds = new double[] { 0.4054651081081644 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.ln(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.ln(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.ln(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	}
	
	@Test
	public void testlog10() {
		double[] inputsinReal = new double[] { 1.50 };
		

		double[] expecteds = new double[] { 0.17609125905568124 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.log10(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.log10(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.log10(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 
	
	@Test
	public void testlog102() {
		float[] inputsinReal = new float[] { 1.50f };
		

		double[] expecteds = new double[] { 0.17609125905568124 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.log10(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.log10(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.log10(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 


	@Test
	public void testsarLookback() {
		int expecteds = 1;

		
		double optInAcceleration = 100;
		double optInMaximum = 100;

	int actual = core.sarLookback(optInAcceleration, optInMaximum);
		assertEquals(expecteds, actual);
		
	
		double optInAcceleration2 = (-4e+37);
		double optInMaximum2 = 100;

	int actual2 = core.sarLookback(optInAcceleration2, optInMaximum2);
		assertEquals(1, actual2, 0);
		
		
		double optInAcceleration3 = (0.000000e+0)-1;
		double optInMaximum3 = 100;

	int actual3 = core.sarLookback(optInAcceleration3, optInMaximum3);
			assertEquals(-1, actual3, 0);
		
		
		double optInAcceleration4 = 100;
		double optInMaximum4= (-4e+37);

	int actual4 = core.sarLookback(optInAcceleration4, optInMaximum4);
			assertEquals(1, actual4, 0);
			
			
			double optInAcceleration5 = 100;
			double optInMaximum5 = (0.000000e+0)-1;

		int actual5 = core.sarLookback(optInAcceleration5, optInMaximum5);
				assertEquals(-1, actual5, 0);
		
	} 
	
	@Test
	public void testsin() {
		double[] inputsinReal = new double[] { 1.50 };
		

		double[] expecteds = new double[] { 0.9974949866040544 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sin(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		

		RetCode rc2 = core.sin(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.sin(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 
	
	@Test
	public void testsin2() {
		float[] inputsinReal = new float[] { 1.50f };
		

		double[] expecteds = new double[] { 0.9974949866040544 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sin(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.sin(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.sin(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 
	
	@Test
	public void testsinh() {
		double[] inputsinReal = new double[] { 1.50 };
		

		double[] expecteds = new double[] { 2.1292794550948173082360881380737};

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sinh(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.sinh(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.sinh(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 
	
	@Test
	public void testsinh2() {
		float[] inputsinReal = new float[] { 1.50f };
		

		double[] expecteds = new double[] { 2.1292794550948173082360881380737};

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sinh(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.sinh(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.sinh(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 

	@Test
	public void testsqrt() {
		double[] inputsinReal = new double[] { 1.50 };
		

		double[] expecteds = new double[] { 1.2247448713915890490986420373529 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sqrt(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.sqrt(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.sqrt(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 
	
	@Test
	public void testsqrt2() {
		float[] inputsinReal = new float[] { 1.50f };
		

		double[] expecteds = new double[] { 1.2247448713915890490986420373529 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sqrt(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
		RetCode rc2 = core.sqrt(-1, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(),rc2.toString());
		
		RetCode rc3 = core.sqrt(0, -3, inputsinReal, outBegIdx, outNBElement, outReal);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(),rc3.toString());
	} 

	@Test
	public void teststdDevLookback() {
		int expecteds = 99;

		
		int optInTimePeriod = 100;
		double optInNbDev = 100;
		
	int actual = core.stdDevLookback(optInTimePeriod, optInNbDev);
		assertEquals(expecteds, actual);
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		double optInNbDev2 = 100;

	int actual2 = core.stdDevLookback(optInTimePeriod2, optInNbDev2);
		assertEquals(4, actual2);
		
		
		int optInTimePeriod3 = 1;
		double optInNbDev3 = 100;

	int actual3 = core.stdDevLookback(optInTimePeriod3, optInNbDev3);
			assertEquals(-1, actual3);
		
		
		int optInTimePeriod4 = 100;
		double optInNbDev4= (-4e+37);

	int actual4 = core.stdDevLookback(optInTimePeriod4, optInNbDev4);
			assertEquals(core.varianceLookback(optInTimePeriod, optInNbDev4), actual4);
					
	} 
	
	@Test
	public void testvarianceLookback() {
		int expecteds = 99;

		
		int optInTimePeriod = 100;
		double optInNbDev = 100;

		
				
	int actual = core.varianceLookback(optInTimePeriod, optInNbDev);
		
		assertEquals(expecteds, actual);
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		double optInNbDev2 = 100;

	int actual2 = core.varianceLookback(optInTimePeriod2, optInNbDev2);
		assertEquals(4, actual2);
		
		
		int optInTimePeriod3 = 1;
		double optInNbDev3 = 100;

	int actual3 = core.varianceLookback(optInTimePeriod3, optInNbDev3);
			assertEquals(0, actual3);
		
		
		int optInTimePeriod4 = 100;
		double optInNbDev4 = (-3.000000e+37)-1;

	int actual4 = core.varianceLookback(optInTimePeriod4, optInNbDev4);
			assertEquals(optInTimePeriod-1, actual4);
			
			
		int optInTimePeriod5 = Integer.MIN_VALUE;
		double optInNbDev5 = (-4e+37);

	int actual5 = core.varianceLookback(optInTimePeriod5, optInNbDev5);
			assertEquals(4, actual5);
			
			
			int optInTimePeriod6 = 0;
			double optInNbDev6 = (-3.000000e+37)-1;

		int actual6 = core.varianceLookback(optInTimePeriod6, optInNbDev6);
				assertEquals(-1, actual6);
							
} 
	
	@Test
	public void testmovingAverageVariablePeriodLookback() {
		int expecteds = 198;

		
		int optInMinPeriod = 100;
		int optInMaxPeriod = 100;
		MAType optInMAType = MAType.Dema;
		
				
	int actual = core.movingAverageVariablePeriodLookback(optInMinPeriod, optInMaxPeriod, optInMAType);
		assertEquals(expecteds, actual);
		
		
		int optInMinPeriod2 = Integer.MIN_VALUE;
		int optInMaxPeriod2 = 100;
		MAType optInMAType2 = MAType.Dema;
		
				
	int actual2 = core.movingAverageVariablePeriodLookback(optInMinPeriod2, optInMaxPeriod2, optInMAType2);
		assertEquals(198, actual2);
		
		
		int optInMinPeriod3 = 1;
		int optInMaxPeriod3 = 100;
		MAType optInMAType3 = MAType.Dema;
		
				
	int actual3 = core.movingAverageVariablePeriodLookback(optInMinPeriod3, optInMaxPeriod3, optInMAType3);
		assertEquals(-1, actual3);
		
		
		int optInMinPeriod4 = 100;
		int optInMaxPeriod4 = 1;
		MAType optInMAType4 = MAType.Dema;
		
				
	int actual4 = core.movingAverageVariablePeriodLookback(optInMinPeriod4, optInMaxPeriod4, optInMAType4);
		assertEquals(-1, actual4);
		
		
		int optInMinPeriod5 = Integer.MIN_VALUE;
		int optInMaxPeriod5 = Integer.MIN_VALUE;
		MAType optInMAType5 = MAType.Dema;
		
				
	int actual5 = core.movingAverageVariablePeriodLookback(optInMinPeriod5, optInMaxPeriod5, optInMAType5);
		assertEquals(58, actual5);
		
		
	} 
	
	@Test
	public void testcdl3InsideLookback(){
			

			Core c1 = new Core();
			
			RetCode r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 6, 10.0);
			RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
			
			assertEquals(6+2, c1.cdl3InsideLookback());
			
			
			 r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 2, 10.0);
			 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

			 assertEquals(8+2, c1.cdl3InsideLookback());
		}
	
	
	@Test
	public void testcdlCounterAttackLookback() {
	
		Core c1 = new Core();
		
		RetCode r = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+1, c1.cdlCounterAttackLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+1, c1.cdlCounterAttackLookback());
	} 
	
	@Test
	public void testcdlDojiStarLookback() {
		
		Core c1 = new Core();
		
		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyDoji, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+1, c1.cdlDojiStarLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyDoji, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+1, c1.cdlDojiStarLookback());
	} 
	
	@Test
	public void testcdlGapSideSideWhiteLookback() {

		Core c1 = new Core();
		
		RetCode r = c1.SetCandleSettings(CandleSettingType.Near, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+2, c1.cdlGapSideSideWhiteLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.Near, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+2, c1.cdlGapSideSideWhiteLookback());
	} 
	
	@Test
	public void testcdlHaramiLookback() {

		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+1, c1.cdlHaramiLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+1, c1.cdlHaramiLookback());
	} 
	
	@Test
	public void testcdlHaramiCrossLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyDoji, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+1, c1.cdlHaramiCrossLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyDoji, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+1, c1.cdlHaramiCrossLookback());
	} 
	
	@Test
	public void testcdlHomingPigeonLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+1, c1.cdlHomingPigeonLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+1, c1.cdlHomingPigeonLookback());
	} 
	
	@Test
	public void testcdlIdentical3CrowsLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+2, c1.cdlIdentical3CrowsLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+2, c1.cdlIdentical3CrowsLookback());
	} 
	
	@Test
	public void testcdlInNeckLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+1, c1.cdlInNeckLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+1, c1.cdlInNeckLookback());
	} 
	
	@Test
	public void testcdlKickingLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+1, c1.cdlKickingLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+1, c1.cdlKickingLookback());
	} 
	
	@Test
	public void testcdlKickingByLengthLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+1, c1.cdlKickingByLengthLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+1, c1.cdlKickingByLengthLookback());
	} 
	
	@Test
	public void testcdlOnNeckLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+1, c1.cdlOnNeckLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+1, c1.cdlOnNeckLookback());
	} 
	
	@Test
	public void TestcdlRiseFall3MethodsLookback () {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+4, c1.cdlRiseFall3MethodsLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+4, c1.cdlRiseFall3MethodsLookback());
	} 
	
	@Test
	public void TestcdlThrustingLookback () {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+1, c1.cdlThrustingLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.Equal, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+1, c1.cdlThrustingLookback());
	} 
	
	@Test
	public void TestcdlUnique3RiverLookback () {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+2, c1.cdlUnique3RiverLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+2, c1.cdlUnique3RiverLookback());
	} 
	
	@Test
	public void TestcdlUpsideGap2CrowsLookback () {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6+2, c1.cdlUpsideGap2CrowsLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8+2, c1.cdlUpsideGap2CrowsLookback());
	} 
	
	@Test
	public void TestcmoLookback () {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	int actual = core.cmoLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
		int actual2 = core.cmoLookback(optInTimePeriod2);
			assertEquals(14, actual2);
			
			
		int optInTimePeriod3 = 1;
			
		int actual3 = core.cmoLookback(optInTimePeriod3);
			assertEquals(-1, actual3);
			
	} 
	
	@Test
	public void TestminusDMLookback () {
		int expecteds = 99;
		
		int optInTimePeriod = 100;
			
	int actual = core.minusDMLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
		int actual2 = core.minusDMLookback(optInTimePeriod2);
			assertEquals(13, actual2);
			
		
		int optInTimePeriod3 = 0;
			
		int actual3 = core.minusDMLookback(optInTimePeriod3);
			assertEquals(-1, actual3);
			
			
		int optInTimePeriod4 = 1;
			
		int actual4 = core.minusDMLookback(optInTimePeriod4);
			assertEquals(1, actual4);
	}
	
	@Test
	public void TestplusDMLookback() {
		int expecteds = 99;
		
		int optInTimePeriod = 100;
			
	int actual = core.plusDMLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
		int actual2 = core.plusDMLookback(optInTimePeriod2);
			assertEquals(13, actual2);
			
		
		int optInTimePeriod3 = 0;
			
		int actual3 = core.plusDMLookback(optInTimePeriod3);
			assertEquals(-1, actual3);
			
			
		int optInTimePeriod4= 1;
			
		int actual4 = core.plusDMLookback(optInTimePeriod4);
			assertEquals(1, actual4);
	}
	
	@Test
	public void TestrsiLookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	int actual = core.rsiLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
		int actual2 = core.rsiLookback(optInTimePeriod2);
			assertEquals(14, actual2);
			
		
		int optInTimePeriod3 = 0;
			
		int actual3 = core.rsiLookback(optInTimePeriod3);
			assertEquals(-1, actual3);
	}
	
	@Test
	public void TestadxrLookback() {
		int expecteds = 298;
		
		int optInTimePeriod = 2;
			
	int actual = core.adxrLookback(optInTimePeriod);
		assertEquals(4, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
	int actual2 = core.adxrLookback(optInTimePeriod2);
			assertEquals(40, actual2);
			
		
		int optInTimePeriod3 = 0;
			
	int actual3 = core.adxrLookback(optInTimePeriod3);
			assertEquals(-1, actual3);
			
				
	}
	
	@Test
	public void TestcdlBeltHoldLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6, c1.cdlBeltHoldLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 8, 10.0);

		 assertEquals(8, c1.cdlBeltHoldLookback());
	}
	
	@Test
	public void TestcdlClosingMarubozuLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6, c1.cdlClosingMarubozuLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 8, 10.0);

		 assertEquals(8, c1.cdlClosingMarubozuLookback());
	}
	
	@Test
	public void TestcdlDragonflyDojiLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyDoji, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6, c1.cdlDragonflyDojiLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyDoji, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 8, 10.0);

		 assertEquals(8, c1.cdlDragonflyDojiLookback());
	}
	
	@Test
	public void TestcdlGravestoneDojiLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyDoji, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6, c1.cdlGravestoneDojiLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyDoji, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 8, 10.0);

		 assertEquals(8, c1.cdlGravestoneDojiLookback());
	}
	
	@Test
	public void TestcdlHignWaveLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6, c1.cdlHignWaveLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8, c1.cdlHignWaveLookback());
	}

	
	@Test
	public void TestcdlLongLeggedDojiLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyDoji, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.ShadowLong, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6, c1.cdlLongLeggedDojiLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyDoji, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.ShadowLong, RangeType.HighLow, 8, 10.0);

		 assertEquals(8, c1.cdlLongLeggedDojiLookback());
	}
	
	@Test
	public void TestcdlLongLineLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.ShadowShort, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6, c1.cdlLongLineLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.ShadowShort, RangeType.HighLow, 8, 10.0);

		 assertEquals(8, c1.cdlLongLineLookback());
	}
	
	@Test
	public void TestcdlMarubozuLookback() {
		
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6, c1.cdlMarubozuLookback());
		
		
		 r = c1.SetCandleSettings(CandleSettingType.BodyLong, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.ShadowVeryShort, RangeType.HighLow, 8, 10.0);

		 assertEquals(8, c1.cdlMarubozuLookback());
	}
	
	@Test
	public void TestcdlShortLineLookback() {
	
		Core c1 = new Core();

		RetCode r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 6, 10.0);
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.ShadowShort, RangeType.HighLow, 2, 10.0);
		
		assertEquals(6, c1.cdlShortLineLookback());
			
			
		 r = c1.SetCandleSettings(CandleSettingType.BodyShort, RangeType.HighLow, 2, 10.0);
		 r1 = c1.SetCandleSettings(CandleSettingType.ShadowShort, RangeType.HighLow, 8, 10.0);

		 assertEquals(8, c1.cdlShortLineLookback());
	}
	
	@Test
	public void TestdxLookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	int actual = core.dxLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
	int actual2 = core.dxLookback(optInTimePeriod2);
				assertEquals(14, actual2);
				
			
			int optInTimePeriod3 = 0;
				
	int actual3 = core.dxLookback(optInTimePeriod3);
				assertEquals(-1, actual3);
				
							
	}
	
	@Test
	public void TestminusDILookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	int actual = core.minusDILookback(optInTimePeriod);
			assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
	int actual2 = core.minusDILookback(optInTimePeriod2);
			assertEquals(14, actual2);
					
				
			int optInTimePeriod3 = 0;
					
	int actual3 = core.minusDILookback(optInTimePeriod3);
			assertEquals(-1, actual3);
			
			
		int optInTimePeriod4 = 1;
			
		int actual4 = core.minusDILookback(optInTimePeriod4);
				assertEquals(1, actual4);
	}
	
	@Test
	public void TestplusDILookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	int actual = core.plusDILookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
	int actual2 = core.plusDILookback(optInTimePeriod2);
		assertEquals(14, actual2);
						
					
		int optInTimePeriod3 = 0;
						
	int actual3 = core.plusDILookback(optInTimePeriod3);
		assertEquals(-1, actual3);
		
		
	int optInTimePeriod4 = 1;
		
	int actual4 = core.plusDILookback(optInTimePeriod4);
			assertEquals(1, actual4);
	}
	
	@Test
	public void TestadxLookback() {
		int expecteds = 199;
		
		int optInTimePeriod = 100;
			
	int actual = core.adxLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
	int actual2 = core.adxLookback(optInTimePeriod2);
		assertEquals(27, actual2);
		
		
		int optInTimePeriod3 = 0;
		
	int actual3 = core.adxLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
		
		
	int optInTimePeriod4 = 1;
		
	int actual4 = core.adxLookback(optInTimePeriod4);
				assertEquals(-1, actual4);
	}
	
	@Test
	public void TestcdlDarkCloudCoverLookback() {
		int expecteds = 11;
		
		double optInPenetration = 100;
			
	
	int actual = core.cdlDarkCloudCoverLookback(optInPenetration);
		assertEquals(expecteds, actual);
		
		
		double optInPenetration2 = (-4e+37);
		
	int actual2 = core.cdlDarkCloudCoverLookback(optInPenetration2);
			assertEquals(11, actual2,0);
			
			
		double optInPenetration3 = (0.000000e+0)-1;
			
	int actual3 = core.cdlDarkCloudCoverLookback(optInPenetration3);
			assertEquals(-1, actual3,0);		
	}
	
	@Test
	public void TesttrixLookback() {
		int expecteds = 298;
		
		int optInTimePeriod = 100;
			
	
	int actual = core.trixLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
	int actual2 = core.trixLookback(optInTimePeriod2);
		assertEquals(88, actual2);
			
			
			int optInTimePeriod3 = 0;
			
	int actual3 = core.trixLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestemaLookback() {
		int expecteds = 99;
		
		int optInTimePeriod = 100;
			
	
	int actual = core.emaLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
	int actual2 = core.emaLookback(optInTimePeriod2);
		assertEquals(29, actual2);
				
				
		int optInTimePeriod3 = 0;
				
	int actual3 = core.emaLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestatrLookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	
	int actual = core.atrLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
	int actual2 = core.atrLookback(optInTimePeriod2);
		assertEquals(14, actual2);
					
					
			int optInTimePeriod3 = 0;
					
	int actual3 = core.atrLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestkamaLookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	
	int actual = core.kamaLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE;
		
	int actual2 = core.kamaLookback(optInTimePeriod2);
		assertEquals(30, actual2);
						
						
		int optInTimePeriod3 = 0;
						
	int actual3 = core.kamaLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestmacdFixLookback() {
		int expecteds = 124;
		
		int optInSignalPeriod = 100;
			
	
	int actual = core.macdFixLookback(optInSignalPeriod);
		assertEquals(expecteds, actual);
		
		
		int optInSignalPeriod2 = Integer.MIN_VALUE;
		
	int actual2 = core.macdFixLookback(optInSignalPeriod2);
		assertEquals(33, actual2);
						
						
		int optInSignalPeriod3 = 0;
						
	int actual3 = core.macdFixLookback(optInSignalPeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestmfiLookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	
	int actual = core.mfiLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.mfiLookback(optInTimePeriod2);
		assertEquals(14, actual2);
						
						
		int optInTimePeriod3= 0;
						
	int actual3 = core.mfiLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestnatrLookback() {
		int expecteds = 14;
		
		int optInTimePeriod = 14;
			
	
	int actual = core.natrLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.natrLookback(optInTimePeriod2);
		assertEquals(14, actual2);
							
							
			int optInTimePeriod3= 0;
							
	int actual3 = core.natrLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TesttemaLookback() {
		int expecteds = 87;
		
		int optInTimePeriod = 30;
			
	
	int actual = core.temaLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.temaLookback(optInTimePeriod2);
		assertEquals(87, actual2);
								
								
		int optInTimePeriod3= 0;
								
	int actual3 = core.temaLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
		
		
	}
	
	@Test
	public void TestdemaLookback() {
		int expecteds = 58;
		
		int optInTimePeriod = 30;
			
	
	int actual = core.demaLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.demaLookback(optInTimePeriod2);
		assertEquals(58, actual2);
									
									
			int optInTimePeriod3= 0;
									
	int actual3 = core.demaLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestcdlHikkakeModLookback() {
		
		Core c1 = new Core();

		int r = 1;
		RetCode r1 = c1.SetCandleSettings(CandleSettingType.Near, RangeType.HighLow, 2, 10.0);
		
		assertEquals(2+5, c1.cdlHikkakeModLookback());
		
		
		
		 r1 = c1.SetCandleSettings(CandleSettingType.Near, RangeType.HighLow, 0, 10.0);

		 assertEquals(1+5, c1.cdlHikkakeModLookback());
											
	}
	
	@Test
	public void TestcciLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.cciLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.cciLookback(optInTimePeriod2);
		assertEquals(13, actual2);
										
										
		int optInTimePeriod3= 0;
										
	int actual3 = core.cciLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestcorrelLookback() {
		int expecteds = 29;
		
		int optInTimePeriod = 30;
		
	
	int actual = core.correlLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.correlLookback(optInTimePeriod2);
		assertEquals(29, actual2);
											
											
		int optInTimePeriod3= 0;
											
	int actual3 = core.correlLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestlinearRegLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.linearRegLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.linearRegLookback(optInTimePeriod2);
		assertEquals(13, actual2);
												
												
		int optInTimePeriod3= 0;
												
	int actual3 = core.linearRegLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}

	@Test
	public void TestlinearRegAngleLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.linearRegAngleLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.linearRegAngleLookback(optInTimePeriod2);
		assertEquals(13, actual2);
													
													
		int optInTimePeriod3= 0;
													
	int actual3 = core.linearRegAngleLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestlinearRegInterceptLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.linearRegInterceptLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.linearRegInterceptLookback(optInTimePeriod2);
		assertEquals(13, actual2);
														
														
		int optInTimePeriod3= 0;
														
	int actual3 = core.linearRegInterceptLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestlinearRegSlopeLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.linearRegSlopeLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.linearRegSlopeLookback(optInTimePeriod2);
		assertEquals(13, actual2);
															
															
		int optInTimePeriod3= 0;
															
	int actual3 = core.linearRegSlopeLookback(optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestmaxLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.maxLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.maxLookback(optInTimePeriod2);
		assertEquals(29, actual2);
																
																
		int optInTimePeriod3= 0;
																
	int actual3 = core.maxLookback (optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestmaxIndexLookback() {
		int expecteds = 29;
		
		int optInTimePeriod = 30;
		
	
	int actual = core.maxIndexLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.maxIndexLookback(optInTimePeriod2);
		assertEquals(29, actual2);
																	
																	
		int optInTimePeriod3= 0;
																	
	int actual3 = core.maxIndexLookback (optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestmidPointLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.midPointLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.midPointLookback(optInTimePeriod2);
		assertEquals(13, actual2);
																		
																		
			int optInTimePeriod3= 0;
																		
	int actual3 = core.midPointLookback (optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestmidPriceLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.midPriceLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.midPriceLookback(optInTimePeriod2);
		assertEquals(13, actual2);
																			
																			
			int optInTimePeriod3= 0;
																			
	int actual3 = core.midPriceLookback (optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestminLookback() {
		int expecteds = 29;
		
		int optInTimePeriod = 30;
		
	
	int actual = core.minLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.minLookback(optInTimePeriod2);
		assertEquals(29, actual2);
																				
																				
		int optInTimePeriod3= 0;
																				
	int actual3 = core.minLookback (optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	@Test
	public void TestminIndexLookback() {
		int expecteds = 29;
		
		int optInTimePeriod = 30;
		
	
	int actual = core.minIndexLookback(optInTimePeriod);
		assertEquals(expecteds, actual);
		
		
		int optInTimePeriod2 = Integer.MIN_VALUE ;
		
	int actual2 = core.minIndexLookback(optInTimePeriod2);
		assertEquals(29, actual2);
																					
																					
		int optInTimePeriod3= 0;
																					
	int actual3 = core.minIndexLookback (optInTimePeriod3);
		assertEquals(-1, actual3);
	}
	
	
	
	
	
}
