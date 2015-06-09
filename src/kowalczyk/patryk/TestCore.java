package kowalczyk.patryk;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

public class TestCore {
	static Core core;
	
	@BeforeClass
	public static void BeforeClass() {
		core = new Core();
	}

	
	/*@Test
	public void TestMFI(){
		double[] inputsinReal = new double[] {
		}
		
		double[] expecteds = new double[] { 0.0 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		RetCode rc = core.mfi(0, 99,inputsinReal, inputsinReal, inputsinReal, inputsinReal, 1000, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
		
	}*/
	
	@Test
	public void TestTrima() {
		
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
		
		double[] expecteds = new double[] { 0.4333960784313724 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		RetCode rc = core.trima(0, 99, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestTrimaFloat() {
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
		

		double[] expecteds = new double[] { 0.43339609629383274 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.trima(0, 99, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
	} 

	private void assertArrayEquals(double[] expecteds, double[] outReal, int i) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void TestTema() {
		
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
		
		double[] expecteds = new double[] { 0.0 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		RetCode rc = core.tema(0, 99, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestTemaFloat() {
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
		

		double[] expecteds = new double[] { 0.0 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.tema(0, 99, inputsinReal, 100, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void TestDema() {
		
		double[] inputsinReal = new double[] { -1.50, -9.04, 9.50, -0.84, 1.72};
		
		double[] expecteds = new double[] { 0.0 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		RetCode rc = core.dema(0, 4, inputsinReal, 5, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestDemaFloat() {
			float[] inputsinReal = new float[] { -1.50f, -9.04f, 9.50f, -0.84f, 1.72f };
		

		double[] expecteds = new double[] { 0.0 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.dema(0, 4, inputsinReal, 5, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void TestKama() {
		
		double[] inputsinReal = new double[] { -2.50, -7.04, 5.50, -0.64, 4.72};
		
		double[] expecteds = new double[] { 0.0 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		RetCode rc = core.kama(0, 4, inputsinReal, 5, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestKamaFloat() {
			float[] inputsinReal = new float[] { -2.50f, -7.04f, 5.50f, -0.64f, 4.72f };
		

		double[] expecteds = new double[] { 0.0 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		
		
		RetCode rc = core.kama(0, 4, inputsinReal, 5, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void TestBeta() {

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
		double[] expecteds = new double[] {0};

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];
		
		
		double[] inReal1 = new double[] { -1.50, -9.04, 9.50, -0.84, 1.72,
				-1.20, -7.89, 5.64, -0.83, -2.60 };
		
		double[] outReal1 = new double[1];
		
		RetCode rc = core.beta(0, 109, inReal, inReal1, 110, outBegIdx, outNBElement, outReal1);
		assertArrayEquals(expecteds, outReal, 0);

	}
	
	@Test
	public void TestBetaFloat() {

		float[] inReal = new float[] { -1.50f, -9.04f, 9.50f, -0.84f, 1.72f, -1.20f, -7.89f, 5.64f, -0.83f, -2.60f, -5.48f,
				5.74f, -9.40f, 7.68f, 5.51f, -9.39f, -4.50f, -8.28f, 8.83f, -8.61f, -2.66f, 1.74f,
				2.46f, 9.12f, -1.03f, -2.73f, 2.08f, 5.32f, 9.37f, -9.75f, 2.55f, 2.10f, 10.00f,
				-3.86f, -3.81f, -3.93f, 3.15f, -5.77f, -6.74f, 6.64f, -6.26f, 7.30f, 7.03f, 4.11f,
				-2.46f, 6.17f, -6.35f, -4.44f, 9.53f, 0.93f, 6.96f, -3.17f, -9.98f, 2.41f, -0.80f,
				-5.11f, 0.51f, 2.64f, -8.77f, 5.52f, 0.01f, 6.95f, 9.87f, -7.22f, 6.97f, 8.02f,
				3.47f, -5.22f, -7.83f, -9.28f, -1.44f, 7.81f, 1.67f, 5.08f, 7.26f, 9.01f, -2.54f,
				8.07f, -2.68f, -3.73f, -5.52f, -4.23f, -6.94f, -5.47f, 0.94f, -4.39f, 8.55f, -1.37f,
				1.29f, 6.69f, 8.21f, 0.28f, 1.22f, 0.82f, -7.62f, 3.55f, -4.35f, 4.33f, -7.36f,
				-4.01f };
		double[] expecteds = new double[] {0};

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];
		
		float[] inReal1 = new float[] { -1.50f, -9.04f, 9.50f, -0.84f, 1.72f,
				-1.20f, -7.89f, 5.64f, -0.83f, -2.60f };
		
		double[] outReal1 = new double[1];
		
		RetCode rc = core.beta(0, 109, inReal, inReal1, 110, outBegIdx, outNBElement, outReal1);
		assertArrayEquals(expecteds, outReal, 0);

	}
	
	@Test
	public void TestSar() {
		
		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		
		double[] expecteds = new double[] { 0 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[3];
		
		RetCode rc = core.sar(0, 4,  inHigh,  inLow, 5, -5 , outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestSarFloat() {
		
		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		
		double[] expecteds = new double[] { 0 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[3];
		
		RetCode rc = core.sar(0, 4,  inHigh,  inLow, 5, -5 , outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestMinusDM() {
		
		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };;
		
		double[] expecteds = new double[] { 10.68 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[3];
		
		RetCode rc = core.minusDM(0, 4,  inHigh,  inLow, 5, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestMinusDMFloat() {
		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		
		double[] expecteds = new double[] { 10.679999947547913 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[3];
		
		RetCode rc = core.minusDM(0, 4,  inHigh,  inLow, 5, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void TestPlusDM() {
		
		double[] inputsinReal = new double[] { -2.50, -7.04, 5.50, -0.64, 4.72};
		
		double[] expecteds = new double[] { 17.9 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		RetCode rc = core.plusDM(0, 4,  inputsinReal,  inputsinReal, 5, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestPlusDMFloat() {
			float[] inputsinReal = new float[] { -2.50f, -7.04f, 5.50f, -0.64f, 4.72f };
		

		double[] expecteds = new double[] { 17.899999737739563 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[1];
		
		RetCode rc = core.plusDM(0, 4,  inputsinReal,  inputsinReal, 5, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	} 
	
	@Test
	public void TestMinMax() {
		
		double[] inputsinReal = new double[] { -3.74899758, 8.79802864,
				-0.14931231, -1.56997335, 8.905047, 2.43794917, -2.57177967,
				1.50790575, 6.28525889, -1.23445402 };
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outMin = new double[1];
		double[] outMax = new double[1];
		
		int[] expectedMin = new int[] { };
		int[] expectedMax = new int[] { };

		RetCode rc = core.minMax(0, 9, inputsinReal, 10, outBegIdx, outNBElement, outMin, outMax);
		
		assertArrayEquals(expectedMin, outMin);
		assertArrayEquals(expectedMax, outMax);
	}
	
	
	
	private void assertArrayEquals(int[] expectedMin, double[] outMin) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void TestMinMaxFloat() {
			float[] inputsinReal = new float[] { -2.50f, -7.04f, 5.50f, -0.64f, 4.72f };
		
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outMinIdx = new int[1];
		int[] outMaxIdx = new int[1];
		
		double[] outMin = new double[1];
		double[] outMax = new double[1];
		
		int[] expectedMin = new int[] { };
		int[] expectedMax = new int[] { };
		
		RetCode rc = core.minMax(0, 4, inputsinReal, 5, outBegIdx, outNBElement, outMin, outMax);
		assertArrayEquals(expectedMin, outMin);
		assertArrayEquals(expectedMax, outMax);
		
	}
	
	@Test
	public void TestAdOsct() {
		
		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inClose = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] inVolume = new double[] { 9.99, 7.96, 10.02, 4.99, 5.49 };
		double[] expecteds = new double[] { -0.2, -0.24999999999999994, -0.2,
				-0.25, -0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[5];
		
		
		RetCode rc =  core.adOsc(0, 4, inHigh, inLow, inClose, inVolume, 
				1, 10, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestAdOsctFloat() {
		
		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		float[] inClose = new float[] { 8, 6, 9, 3, 4 };
		float[] inVolume = new float[] { 9, 7, 10, 4, 5 };
		double[] expecteds = new double[] { -0.2, -0.25, -0.2, -0.25,
				-0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[5];
		
		
		RetCode rc =  core.adOsc(0, 4, inHigh, inLow, inClose, inVolume, 
				1, 10, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	
	@Test
	public void TestNatr() {
		
		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inClose = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] expecteds = new double[] { -0.2, -0.24999999999999994, -0.2,
				-0.25, 0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[4];
		
		
		RetCode rc =  core.natr(0, 4, inHigh, inLow, inClose, 5, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void TestNatrFloat() {
		
		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		float[] inClose = new float[] { 8, 6, 9, 3, 4 };
		double[] expecteds = new double[] { -0.2, -0.25, -0.2, -0.25,
				-0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[4];
		
		
		RetCode rc =  core.natr(0, 4, inHigh, inLow, inClose, 5, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void TestCmo() {

		double[] inReal = new double[] { 10, 20, 30 };
		double[] expecteds = new double[] { 2.302585092994046,
				2.995732273553991, 3.4011973816621555 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.cmo(0, 2, inReal, 100, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void TestCmoFloat() {

		float[] inReal = new float[] { -1, 0, 1 };
		double[] expecteds = new double[] { 3.141592653589793, 0,
				1.5707963267948966};

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.cmo(0, 2, inReal, 100, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void TestMfi() {
		
		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inClose = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] inVolume = new double[] { 9.99, 7.96, 10.02, 4.99, 5.49 };
		double[] expecteds = new double[] { -0.2, -0.24999999999999994, -0.2,
				-0.25, -0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[5];
		
		
		RetCode rc =  core.mfi(0, 4, inHigh, inLow, inClose, inVolume, 10, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestMfiFloat() {
		
		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		float[] inClose = new float[] { 8, 6, 9, 3, 4 };
		float[] inVolume = new float[] { 9, 7, 10, 4, 5 };
		double[] expecteds = new double[] { -0.2, -0.25, -0.2, -0.25,
				-0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[5];
		
		
		RetCode rc =  core.mfi(0, 4, inHigh, inLow, inClose, inVolume, 10, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void TestRsi() {

		double[] inReal = new double[] { 10, 20, 30 };
		double[] expecteds = new double[] { 2.302585092994046,
				2.995732273553991 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.rsi(0, 2, inReal, 100, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void TestRsiFloat() {

		float[] inReal = new float[] { -1, 0, 1 };
		double[] expecteds = new double[] { 3.141592653589793,
				1.5707963267948966, 0 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.rsi(0, 2, inReal, 100, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	/*@Test
	public void TestCorrel() {

		double[] inReal = new double[] { 8.21, 0.28, 1.22, 0.82, -7.62, 
				3.55, -4.35, 4.33, -7.36, -4.01 };
		
		double[] expecteds = new double[] {};

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];
		
		
		double[] inReal1 = new double[] { -1.50, -9.04, 9.50, -0.84, 1.72,
				-1.20, -7.89, 5.64, -0.83, -2.60 };
		
		double[] outReal1 = new double[1];
		
		RetCode rc = core.correl(0, 19, inReal, inReal1, 20, outBegIdx, outNBElement, outReal1);
		assertArrayEquals(expecteds, outReal, 0);
	} */
	
	
	/*@Test
	public void TestCorrelFloat() {

		float[] inReal = new float[] {  -4.50f, -8.28f, 8.83f, -8.61f, -2.66f, 1.74f,
				2.46f, 9.12f, -1.03f, -2.73f };
		double[] expecteds = new double[] {0};

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[1];
		
		float[] inReal1 = new float[] { -1.50f, -9.04f, 9.50f, -0.84f, 1.72f,
				-1.20f, -7.89f, 5.64f, -0.83f, -2.60f };
		
		double[] outReal1 = new double[1];
		
		RetCode rc = core.correl(0, 19, inReal, inReal1, 20, outBegIdx, outNBElement, outReal1);
		assertArrayEquals(expecteds, outReal, 0);

	} */
	
	@Test
	public void TestWillR() {
		
		double[] inHigh = new double[] { 5.96, 9.96, 13.02, 2.99, 6.49 };
		double[] inLow = new double[] { 7.99, 12.99, 8.02, 6.99, 3.49 };
		double[] inClose = new double[] { 9.99, 7.96, 10.02, 4.99, 5.49 };
		double[] expecteds = new double[] { -0.2, -0.24999999999999994, -0.2,
				-0.25, -0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[4];
		
		RetCode rc =  core.willR(0, 4, inHigh, inLow, inClose, 15, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestWillRFloat() {
		
		float[] inHigh = new float[] { 8, 6, 9, 3, 4 };
		float[] inLow = new float[] { 12, 9, 13, 6, 6 };
		float[] inClose = new float[] { 9, 7, 10, 4, 5 };
		double[] expecteds = new double[] { -0.2, -0.25, -0.2, -0.25,
				-0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[5];
		
		
		RetCode rc =  core.willR(0, 4, inHigh, inLow, inClose, 15, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void TestCci() {
		
		double[] inHigh = new double[] { 5.96, 9.96, 13.02, 2.99, 6.49 };
		double[] inLow = new double[] { 7.99, 12.99, 8.02, 6.99, 3.49 };
		double[] inClose = new double[] { 9.99, 7.96, 10.02, 4.99, 5.49 };
		double[] expecteds = new double[] { -0.2, -0.24999999999999994, -0.2,
				-0.25, -0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[4];
		
		RetCode rc =  core.cci(0, 4, inHigh, inLow, inClose, 15, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
		
	}
	
	@Test
	public void TestCciFloat() {
		
		float[] inHigh = new float[] { 8, 6, 9, 3, 4 };
		float[] inLow = new float[] { 12, 9, 13, 6, 6 };
		float[] inClose = new float[] { 9, 7, 10, 4, 5 };
		double[] expecteds = new double[] { -0.2, -0.25, -0.2, -0.25,
				-0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		double[] outReal = new double[5];
		
		
		RetCode rc =  core.cci(0, 4, inHigh, inLow, inClose, 15, outBegIdx, outNBElement, outReal);
		
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void TestAtr() {

		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inClose = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] expecteds = new double[] { 9.74, 7.460000000000001, 9.77,
				4.49, 4.74 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode rc = core.atr(0, 4, inHigh, inLow, inClose, 15, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

	}

	@Test
	public void TestAtrFloat() {

		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		float[] inClose = new float[] { 8, 6, 9, 3, 4 };
		double[] expecteds = new double[] { 8.75, 6.5, 9.75, 3.5, 4.25 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[5];

		RetCode rc = core.atr(0, 4, inHigh, inLow, inClose, 15, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

	}

	@Test
	public void TestTrix() {

		double[] inReal = new double[] { 10, 20, 30 };
		double[] expecteds = new double[] { 2.302585092994046,
				2.995732273553991 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.trix(0, 2, inReal, 50, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void TestTrixFloat() {

		float[] inReal = new float[] { -1, 0, 1 };
		double[] expecteds = new double[] { 3.141592653589793,
				1.5707963267948966, 0 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.trix(0, 2, inReal, 50, outBegIdx, outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);
	}
	
	@Test
	public void TestAroon() {

		double[] inHigh = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inLow = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] expecteds = new double[] { 9.74, 7.460000000000001, 9.77,
				4.49, 4.74 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outAroonDown = new double[3];
		double[] outAroonUp = new double[3];

		RetCode rc = core.aroon(0, 4, inHigh, inLow, 15, outBegIdx,
				outNBElement, outAroonDown, outAroonUp);
		assertArrayEquals(expecteds, outAroonDown, 0);
		assertArrayEquals(expecteds, outAroonUp, 0);
		
	}

	@Test
	public void TestAroonFloat() {

		float[] inHigh = new float[] { 7, 5, 8, 2, 3 };
		float[] inLow = new float[] { 8, 6, 9, 3, 4 };
		double[] expecteds = new double[] { 8.75, 6.5, 9.75, 3.5, 4.25 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outAroonDown = new double[3];
		double[] outAroonUp = new double[3];

		RetCode rc = core.aroon(0, 4, inHigh, inLow, 15, outBegIdx,
				outNBElement, outAroonDown, outAroonUp);
		assertArrayEquals(expecteds, outAroonDown, 0);
		assertArrayEquals(expecteds, outAroonUp, 0);

	}
	
	@Test
	public void TestAroonOsc() {

		double[] inHigh = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inLow = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] expecteds = new double[] { 9.74, 7.460000000000001, 9.77,
				4.49, 4.74 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.aroonOsc(0, 4, inHigh, inLow, 15, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

		
	}

	@Test
	public void TestAroonOscFloat() {

		float[] inHigh = new float[] { 7, 5, 8, 2, 3 };
		float[] inLow = new float[] { 8, 6, 9, 3, 4 };
		double[] expecteds = new double[] { 8.75, 6.5, 9.75, 3.5, 4.25 };

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] outReal = new double[3];

		RetCode rc = core.aroonOsc(0, 4, inHigh, inLow, 15, outBegIdx,
				outNBElement, outReal);
		assertArrayEquals(expecteds, outReal, 0);

	}
	
	@Test
	public void TestCdlAdvanceBlockLookback() {
		
		int expecteds = 12;
		int actual =  core.cdlAdvanceBlockLookback();
		
		assertEquals(expecteds, actual);
	}
	
	/*@Test
	public void TestCdlDoji() {
		
		double[] inOpen = new double[] { 9.99, 7.96, 10.02, 4.99, 5.49 };
		double[] inHigh = new double[] { 12.99, 9.96, 13.02, 6.99, 6.49 };
		double[] inLow = new double[] { 7.99, 5.96, 8.02, 2.99, 3.49 };
		double[] inClose = new double[] { 8.99, 6.96, 9.02, 3.99, 4.49 };
		double[] expecteds = new double[] { -0.2, -0.24999999999999994, -0.2,
				-0.25, -0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		int[] outInteger = new int[5];
		
		
		RetCode rc =  core.cdlDoji(0, 4, inHigh, inLow, inClose, inOpen, outBegIdx, outNBElement, outInteger);
		
		assertArrayEquals(expecteds, outInteger, 0);
		
	}
	
	@Test
	public void TestCdlDojiFloat() {
		
		float[] inOpen = new float[] { 9, 7, 10, 4, 5 };
		float[] inHigh = new float[] { 12, 9, 13, 6, 6 };
		float[] inLow = new float[] { 7, 5, 8, 2, 3 };
		float[] inClose = new float[] { 8, 6, 9, 3, 4 };
		double[] expecteds = new double[] { -0.2, -0.25, -0.2, -0.25,
				-0.3333333333333333 };
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		int[] outInteger = new int[5];
		
		
		RetCode rc =  core.cdlDoji(0, 4, inHigh, inLow, inClose, inOpen, outBegIdx, outNBElement, outInteger);
		
		assertArrayEquals(expecteds, outInteger, 0);
	} */
	
}
