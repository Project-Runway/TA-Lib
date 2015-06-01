package piatek.jacek;

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

	@Test
	public void testMinMaxIndex() {
		double[] inputsinReal = new double[] {0.49, -0.54, -4.52, 2.46, -3.31,
				5.01, 7.06, -8.15, 9.69, -2.53, 6.63, 0.06, 5.20, 8.17, -1.29,
				3.29, -7.86, -7.32, 1.65, 9.23, -7.96, -8.98, -7.69, -5.26,
				-8.66, -4.60, 7.95, 6.52, -6.77, -6.47, -4.15, -3.88, -4.79,
				-1.25, -6.37, 8.75, 3.05, -7.64, 1.74, 0.35, 3.25, 2.06, -9.07,
				3.80, 3.52, -5.16, -1.25, 1.44, 0.84, -2.48, 0.38, 8.03, 2.00,
				6.64, 1.17, -7.82, 7.01, -5.01, 7.54, 4.99, 6.45, 6.47, -6.69,
				2.07, 8.84, 4.50, -1.73, 9.27, 5.43, -9.56, -1.73, -7.06, 0.32,
				3.85, 6.30, 5.38, -1.01, 9.99, 6.63, 6.48, -4.05, -5.60, 9.44,
				0.11, -6.96, -4.63, 1.02, -5.56, -8.60, -4.67, -5.59, 4.15,
				8.66, 7.53, 2.70, -8.17, -4.83, 1.50, -0.11, -2.58};

		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outMinIdx = new int[1];
		int[] outMaxIdx = new int[1];
		/*
		 * Odejmujemy -1 od nr indeksu, który wyszed³ w excelu, poniewa¿ tutaj tablica liczy siê od 0, a w excelu o 1
		 * */
		int[] expectedMin = {70-1};
		int[] expectedMax = {78-1};

		RetCode rc = core.minMaxIndex(0, 99, inputsinReal, 100, outBegIdx,outNBElement, outMinIdx, outMaxIdx);
		
		assertArrayEquals(expectedMin, outMinIdx);
		assertArrayEquals(expectedMax, outMaxIdx);
	}
}
