package stohnij.lukasz;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MAType;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

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
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		assertArrayEquals(expecteds, outReal, 0);
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
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	
 
	@Test
	public void testtan() {
		double[] inputsinReal = new double[] { -1.50 };
		

		double[] expecteds = new double[] { -14.101419947171719 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.tan(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);;
	} 
	

	@Test
	public void testtan2() {
		float[] inputsinReal = new float[] { -1.50f };
		

		double[] expecteds = new double[] { -14.101419947171719 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.tan(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void testtanh() {
		double[] inputsinReal = new double[] { -1.50 };
		

		double[] expecteds = new double[] { -0.9051482536448664 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.tanh(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void testtanh2() {
		float[] inputsinReal = new float[] { -1.50f };
		

		double[] expecteds = new double[] { -0.9051482536448664 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.tanh(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	
	@Test
	public void testfloor() {
		double[] inputsinReal = new double[] { -1.50 };
		

		double[] expecteds = new double[] { -2.00 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.floor(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void testfloor2() {
		float[] inputsinReal = new float[] { -1.50f };
		

		double[] expecteds = new double[] { -2.00 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.floor(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 


	@Test
	public void testln() {
		double[] inputsinReal = new double[] { 1.50 };
		

		double[] expecteds = new double[] { 0.4054651081081644 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.ln(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void testln2() {
		float[] inputsinReal = new float[] { 1.50f };
		

		double[] expecteds = new double[] { 0.4054651081081644 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.ln(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void testlog10() {
		double[] inputsinReal = new double[] { 1.50 };
		

		double[] expecteds = new double[] { 0.17609125905568124 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.log10(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void testlog102() {
		float[] inputsinReal = new float[] { 1.50f };
		

		double[] expecteds = new double[] { 0.17609125905568124 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.log10(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 


	@Test
	public void testsarLookback() {
		int expecteds = 1;

		
		double optInAcceleration = 100;
		double optInMaximum = 100;

		
				
	int actual = core.sarLookback(optInAcceleration, optInMaximum);
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testsin() {
		double[] inputsinReal = new double[] { 1.50 };
		

		double[] expecteds = new double[] { 0.9974949866040544 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sin(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void testsin2() {
		float[] inputsinReal = new float[] { 1.50f };
		

		double[] expecteds = new double[] { 0.9974949866040544 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sin(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void testsinh() {
		double[] inputsinReal = new double[] { 1.50 };
		

		double[] expecteds = new double[] { 2.1292794550948173082360881380737};

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sinh(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void testsinh2() {
		float[] inputsinReal = new float[] { 1.50f };
		

		double[] expecteds = new double[] { 2.1292794550948173082360881380737};

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sinh(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 

	@Test
	public void testsqrt() {
		double[] inputsinReal = new double[] { 1.50 };
		

		double[] expecteds = new double[] { 1.2247448713915890490986420373529 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sqrt(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void testsqrt2() {
		float[] inputsinReal = new float[] { 1.50f };
		

		double[] expecteds = new double[] { 1.2247448713915890490986420373529 };

		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.sqrt(0, 0, inputsinReal, outBegIdx, outNBElement, outReal);
		System.out.println(rc);
		System.out.println(outBegIdx.value);
		System.out.println(outNBElement.value);
		
		
		assertArrayEquals(expecteds, outReal, 0);
	} 

	@Test
	public void teststdDevLookback() {
		int expecteds = 99;

		
		int optInTimePeriod = 100;
		double optInNbDev = 100;

		
				
	int actual = core.stdDevLookback(optInTimePeriod, optInNbDev);
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testvarianceLookback() {
		int expecteds = 99;

		
		int optInTimePeriod = 100;
		double optInNbDev = 100;

		
				
	int actual = core.varianceLookback(optInTimePeriod, optInNbDev);
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testmovingAverageVariablePeriodLookback() {
		int expecteds = 198;

		
		int optInMinPeriod = 100;
		int optInMaxPeriod = 100;
		MAType optInMAType = MAType.Dema;
		
				
	int actual = core.movingAverageVariablePeriodLookback(optInMinPeriod, optInMaxPeriod, optInMAType);
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdl3InsideLookback() {
		int expecteds = 12;
			
	int actual = core.cdl3InsideLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	
	@Test
	public void testcdlCounterAttackLookback() {
		int expecteds = 11;
			
	int actual = core.cdlCounterAttackLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdlDojiStarLookback() {
		int expecteds = 11;
			
	int actual = core.cdlDojiStarLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdlGapSideSideWhiteLookback() {
		int expecteds = 7;
			
	int actual = core.cdlGapSideSideWhiteLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdlHaramiLookback() {
		int expecteds = 11;
			
	int actual = core.cdlHaramiLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdlHaramiCrossLookback() {
		int expecteds = 11;
			
	int actual = core.cdlHaramiCrossLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdlHomingPigeonLookback() {
		int expecteds = 11;
			
	int actual = core.cdlHomingPigeonLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdlIdentical3CrowsLookback() {
		int expecteds = 12;
			
	int actual = core.cdlIdentical3CrowsLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdlInNeckLookback() {
		int expecteds = 11;
			
	int actual = core.cdlInNeckLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdlKickingLookback() {
		int expecteds = 11;
			
	int actual = core.cdlKickingLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdlKickingByLengthLookback() {
		int expecteds = 11;
			
	int actual = core.cdlKickingByLengthLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void testcdlOnNeckLookback() {
		int expecteds = 11;
			
	int actual = core.cdlOnNeckLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void TestcdlRiseFall3MethodsLookback () {
		int expecteds = 14;
			
	int actual = core.cdlRiseFall3MethodsLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void TestcdlThrustingLookback () {
		int expecteds = 11;
			
	int actual = core.cdlThrustingLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void TestcdlUnique3RiverLookback () {
		int expecteds = 12;
			
	int actual = core.cdlUnique3RiverLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void TestcdlUpsideGap2CrowsLookback () {
		int expecteds = 12;
			
	int actual = core.cdlUpsideGap2CrowsLookback();
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void TestcmoLookback () {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	int actual = core.cmoLookback(optInTimePeriod);
		
		assertEquals(expecteds, actual);
	} 
	
	@Test
	public void TestminusDMLookback () {
		int expecteds = 99;
		
		int optInTimePeriod = 100;
			
	int actual = core.minusDMLookback(optInTimePeriod);
		
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestplusDMLookback() {
		int expecteds = 99;
		
		int optInTimePeriod = 100;
			
	int actual = core.plusDMLookback(optInTimePeriod);
		
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestrsiLookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	int actual = core.rsiLookback(optInTimePeriod);
		
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestadxrLookback() {
		int expecteds = 298;
		
		int optInTimePeriod = 100;
			
	int actual = core.adxrLookback(optInTimePeriod);
		
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlBeltHoldLookback() {
		int expecteds = 10;
		
			
	int actual = core.cdlBeltHoldLookback();
		
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlClosingMarubozuLookback() {
		int expecteds = 10;
		
			
	int actual = core.cdlClosingMarubozuLookback();
		
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlDragonflyDojiLookback() {
		int expecteds = 10;
		
			
	int actual = core.cdlDragonflyDojiLookback();
		
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlGravestoneDojiLookback() {
		int expecteds = 10;
		
			
	int actual = core.cdlGravestoneDojiLookback();
	
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlHignWaveLookback() {
		int expecteds = 10;
	
			
	int actual = core.cdlHignWaveLookback();
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlLongLeggedDojiLookback() {
		int expecteds = 10;
		
			
	int actual = core.cdlLongLeggedDojiLookback();
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlLongLineLookback() {
		int expecteds = 10;
		
			
	int actual = core.cdlLongLineLookback();
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlMarubozuLookback() {
		int expecteds = 10;
		
			
	int actual = core.cdlMarubozuLookback();
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlShortLineLookback() {
		int expecteds = 10;
		
			
	int actual = core.cdlShortLineLookback();
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestdxLookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	int actual = core.dxLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestminusDILookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	int actual = core.minusDILookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestplusDILookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	int actual = core.plusDILookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestadxLookback() {
		int expecteds = 199;
		
		int optInTimePeriod = 100;
			
	int actual = core.adxLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlDarkCloudCoverLookback() {
		int expecteds = 11;
		
		double optInPenetration = 100;
			
	
	int actual = core.cdlDarkCloudCoverLookback(optInPenetration);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TesttrixLookback() {
		int expecteds = 298;
		
		int optInTimePeriod = 100;
			
	
	int actual = core.trixLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestemaLookback() {
		int expecteds = 99;
		
		int optInTimePeriod = 100;
			
	
	int actual = core.emaLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestatrLookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	
	int actual = core.atrLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestkamaLookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	
	int actual = core.kamaLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestmacdFixLookback() {
		int expecteds = 124;
		
		int optInSignalPeriod = 100;
			
	
	int actual = core.macdFixLookback(optInSignalPeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestmfiLookback() {
		int expecteds = 100;
		
		int optInTimePeriod = 100;
			
	
	int actual = core.mfiLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestnatrLookback() {
		int expecteds = 14;
		
		int optInTimePeriod = 14;
			
	
	int actual = core.natrLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TesttemaLookback() {
		int expecteds = 87;
		
		int optInTimePeriod = 30;
			
	
	int actual = core.temaLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestdemaLookback() {
		int expecteds = 58;
		
		int optInTimePeriod = 30;
			
	
	int actual = core.demaLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcdlHikkakeModLookback() {
		int expecteds = 10;
		
			
	
	int actual = core.cdlHikkakeModLookback();
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcciLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.cciLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestcorrelLookback() {
		int expecteds = 29;
		
		int optInTimePeriod = 30;
		
	
	int actual = core.correlLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestlinearRegLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.linearRegLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}

	@Test
	public void TestlinearRegAngleLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.linearRegAngleLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestlinearRegInterceptLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.linearRegInterceptLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestlinearRegSlopeLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.linearRegSlopeLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestmaxLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.maxLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestmaxIndexLookback() {
		int expecteds = 29;
		
		int optInTimePeriod = 30;
		
	
	int actual = core.maxIndexLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestmidPointLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.midPointLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestmidPriceLookback() {
		int expecteds = 13;
		
		int optInTimePeriod = 14;
		
	
	int actual = core.midPriceLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestminLookback() {
		int expecteds = 29;
		
		int optInTimePeriod = 30;
		
	
	int actual = core.minLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestminIndexLookback() {
		int expecteds = 29;
		
		int optInTimePeriod = 30;
		
	
	int actual = core.minIndexLookback(optInTimePeriod);
			
		assertEquals(expecteds, actual);
	}
	
	
	
	
	
}
