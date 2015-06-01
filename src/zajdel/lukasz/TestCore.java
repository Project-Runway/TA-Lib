package zajdel.lukasz;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.Compatibility;
import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.FuncUnstId;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

public class TestCore {
	static Core core;
	
	@BeforeClass
	public static void beforeClass(){
		core = new Core();
	}
	
	@Test
	public void testSMA(){
		
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
	}
	
	@Test
	public void TestSmaLookback(){

	int optInTimePeriod = 10;
	int expecteds = 9;
	int n = core.smaLookback(optInTimePeriod);
	
	assertEquals(expecteds, n);
	
	}
	
	@Test
	public void TestSetUnstablePeriod(){
		
		RetCode expecteds = RetCode.Success;
		FuncUnstId id = FuncUnstId.Adxr;
		int period = 10;
		RetCode actual = core.SetUnstablePeriod(id, period);
		
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void TestSumLookBack(){
		
		int expecteds = 0;
		int actual = core.subLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestTrimaLookBack(){
		
		int optInTimePeriod = 100;
		int expecteds = 99;
		int actual = core.trimaLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestTsfLookBack(){
		
		int optInTimePeriod = 7;
		int expecteds = 6;
		int actual = core.tsfLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestWillRLookBack(){
		
		int optInTimePeriod = 38;
		int expecteds = 37;
		int actual = core.willRLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestWmaLookBack(){
		
		int optInTimePeriod = 76;
		int expecteds = 75;
		int actual = core.wmaLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestAroonBackLookBack(){
		
		int optInTimePeriod = 90;
		int expecteds = 90;
		int actual = core.aroonLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestAroonOscBackLookBack(){
		
		int optInTimePeriod = 40;
		int expecteds = 40;
		int actual = core.aroonOscLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestBetaBackLookBack(){
		
		int optInTimePeriod = 37;
		int expecteds = 37;
		int actual = core.betaLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestMomBackLookBack(){
		
		int optInTimePeriod = 0;
		int expecteds = -1;
		int actual = core.momLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestrocLookBack(){
		
		int optInTimePeriod = 40;
		int expecteds = 40;
		int actual = core.rocLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestrocPLookBack(){
		
		int optInTimePeriod = 40;
		int expecteds = 40;
		int actual = core.rocPLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	@Test
	
	public void TestrocRLookBack(){
		
		int optInTimePeriod = 654;
		int expecteds = 654;
		int actual = core.rocRLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestrocR100LookBack(){
		
		int optInTimePeriod = 400;
		int expecteds = 400;
		int actual = core.rocR100Lookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestMinMaxLookBack(){
		
		int optInTimePeriod = 54;
		int expecteds = 53;
		int actual = core.minMaxLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestMinMaxIndexLookBack(){
		
		int optInTimePeriod = 65;
		int expecteds = 64;
		int actual = core.minMaxIndexLookback(optInTimePeriod);
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestCdl2CrowsLookback(){
		//TODO Wpisany na sztywno. W tej funkcji jest brany .THIS z funkcji cdl2Crows.
		// Czy musze najpierw wywolac ta funkcje i dopiero sprawdzic czy lookback dziala, czy moge tak zostawic na sztywno?
		int expecteds = 12;
		int actual = core.cdl2CrowsLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestAcosLookBack(){
		
		int expecteds = 0;
		int actual = core.acosLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestAdLookBack(){
		
		int expecteds = 0;
		int actual = core.adLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestAddLookBack(){
		
		int expecteds = 0;
		int actual = core.addLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestAsinLookBack(){
		
		int expecteds = 0;
		int actual = core.asinLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestAtanLookBack(){
		
		int expecteds = 0;
		int actual = core.atanLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestAvgPriceLookBack(){
		
		int expecteds = 0;
		int actual = core.avgPriceLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestBopLookBack(){
		
		int expecteds = 0;
		int actual = core.bopLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestCdl3OutsideLookback(){
		
		int expecteds = 3;
		int actual = core.cdl3OutsideLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestCdlEngulfingLookbackLookbackLookBack(){
		
		int expecteds = 2;
		int actual = core.cdlEngulfingLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestCdlHikkakeLookback(){
		
		int expecteds = 5;
		int actual = core.cdlHikkakeLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestCdlXSideGap3MethodsLookback(){
		
		int expecteds = 2;
		int actual = core.cdlXSideGap3MethodsLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestCeilLookback(){
		
		int expecteds = 0;
		int actual = core.ceilLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestCosLookback(){
		
		int expecteds = 0;
		int actual = core.cosLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestCoshLookback(){
		
		int expecteds = 0;
		int actual = core.coshLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestDivLookback(){
		
		int expecteds = 0;
		int actual = core.divLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestExpLookback(){
		
		int expecteds = 0;
		int actual = core.expLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestFloorLookback(){
		
		int expecteds = 0;
		int actual = core.floorLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestLnLookback(){
		
		int expecteds = 0;
		int actual = core.lnLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestLog10Lookback(){
		
		int expecteds = 0;
		int actual = core.log10Lookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestMedPriceLookback(){
		
		int expecteds = 0;
		int actual = core.medPriceLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestMultLookback(){
		
		int expecteds = 0;
		int actual = core.multLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestObvLookback(){
		
		int expecteds = 0;
		int actual = core.obvLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestSinLookback(){
		
		int expecteds = 0;
		int actual = core.sinLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestSinhLookback(){
		
		int expecteds = 0;
		int actual = core.sinhLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestSqrtLookback(){
		
		int expecteds = 0;
		int actual = core.sqrtLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestSubLookback(){
		
		int expecteds = 0;
		int actual = core.subLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestTanLookback(){
		
		int expecteds = 0;
		int actual = core.tanLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestTanhLookback(){
		
		int expecteds = 0;
		int actual = core.tanhLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestTrueRangeLookback(){
		
		int expecteds = 1;
		int actual = core.trueRangeLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestTypPriceLookback(){
		
		int expecteds = 0;
		int actual = core.typPriceLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void TestWclPriceLookback(){
		
		int expecteds = 0;
		int actual = core.wclPriceLookback();
		assertEquals(expecteds ,actual);
	}
	
	@Test
	public void SetCompatibility(){
		//TODO Jak przetestowac metode set'tera, gdy metoda nic nie zwraca?
		Compatibility compatibility = Compatibility.Default;
		Compatibility expecteds = Compatibility.Default;
		
		//Compatibility actual = core.SetCompatibility(compatibility);
		//assertEquals(expecteds ,actual);
	}
	
	@Test
	public void GetCompatibility(){
		
		Compatibility expecteds = Compatibility.Default;

		core.SetCompatibility(Compatibility.Default);
		Compatibility actual = core.getCompatibility();

		assertEquals(expecteds ,actual);
		
	}
}
