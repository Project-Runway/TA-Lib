package adamczyk.adam;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;
@SuppressWarnings("unused")
public class TestCore {
	static Core core;
	
	@BeforeClass
	public static void beforeClass() {
		core = new Core();
	}

	@Test
	public void testCdlAdvanceBlockDouble() {
		
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		int[] excpecteds = new int[] {0,0,0,0,0};
	
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlAdvanceBlock(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlAdvanceBlock(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlAdvanceBlock(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	
	}
	
	@Test
	public void testCdlAdvanceBlockFloat() {
		
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlAdvanceBlock(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlAdvanceBlock(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlAdvanceBlock(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdl3WhiteSoldiersDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		int[] excpecteds = new int[] {0,0,0,0,0};
	
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdl3WhiteSoldiers(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdl3WhiteSoldiers(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdl3WhiteSoldiers(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test
	public void testCdl3WhiteSoldiersFloat() {
		
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdl3WhiteSoldiers(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdl3WhiteSoldiers(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdl3WhiteSoldiers(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlStalledPatternDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		int[] excpecteds = new int[] {0,0,0,0,0};
	
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlStalledPattern(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlStalledPattern(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlStalledPattern(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}

	@Test 
	public void testCdlStalledPatternFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
	
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlStalledPattern(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlStalledPattern(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlStalledPattern(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdl3StarsInSouthDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		int[] excpecteds = new int[] {0,0,0,0,0};
	
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdl3StarsInSouth(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdl3StarsInSouth(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdl3StarsInSouth(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdl3StarsInSouthFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
	
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdl3StarsInSouth(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdl3StarsInSouth(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdl3StarsInSouth(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlRiseFall3MethodsDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		int[] excpecteds = new int[] {0,0,0,0,0};
	
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlRiseFall3Methods(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlRiseFall3Methods(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlRiseFall3Methods(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlRiseFall3MethodsFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
	
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlRiseFall3Methods(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlRiseFall3Methods(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlRiseFall3Methods(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlIdentical3CrowsDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		int[] excpecteds = new int[] {0,0,0,0,0};
	
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlIdentical3Crows(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlRiseFall3Methods(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlRiseFall3Methods(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlIdentical3CrowsFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
	
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlIdentical3Crows(0, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlRiseFall3Methods(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlRiseFall3Methods(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlMatHoldDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlMatHold(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlMatHold(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlMatHold(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlMatHoldFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlMatHold(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlMatHold(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlMatHold(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlKickingByLengthDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlKickingByLength(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlKickingByLength(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlKickingByLength(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlKickingByLengthFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlKickingByLength(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlKickingByLength(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlKickingByLength(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlKickingDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlKicking(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlKicking(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlKicking(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlKickingFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlKicking(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlKicking(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlKicking(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	@Test 
	public void testCdlHammerDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlHammer(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlHammer(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlHammer(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlHammerFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlHammer(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlHammer(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlHammer(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlHangingManDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlHangingMan(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlHangingMan(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlHangingMan(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlHangingManFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlHangingMan(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlHangingMan(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlHangingMan(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlSeparatingLinesDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlSeperatingLines(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlSeperatingLines(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlSeperatingLines(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlSeparatingLinesFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlSeperatingLines(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlSeperatingLines(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlSeperatingLines(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlConcealBabysWallDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlConcealBabysWall(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlConcealBabysWall(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlConcealBabysWall(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlConcealBabysWallFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlConcealBabysWall(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlConcealBabysWall(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlConcealBabysWall(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlGapSideSideWhiteDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlGapSideSideWhite(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlGapSideSideWhite(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlGapSideSideWhite(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlGapSideSideWhiteFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlGapSideSideWhite(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlGapSideSideWhite(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlGapSideSideWhite(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlRickshawManDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlRickshawMan(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlRickshawMan(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlRickshawMan(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlRickshawManFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlRickshawMan(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlRickshawMan(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlRickshawMan(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlHikkakeModnDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlHikkakeMod(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlHikkakeMod(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlHikkakeMod(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlHikkakeModFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlHikkakeMod(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlHikkakeMod(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlHikkakeMod(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlAbandonedBabyDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlAbandonedBaby(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlAbandonedBaby(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlAbandonedBaby(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlAbandonedBabyFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlAbandonedBaby(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlAbandonedBaby(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlAbandonedBaby(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlEveningStarDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlEveningStar(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlEveningStar(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlEveningStar(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlEveningStarFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlEveningStar(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlEveningStar(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlEveningStar(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlMorningStarDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlMorningStar(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlMorningStar(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlMorningStar(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlMorningStarFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlMorningStar(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlMorningStar(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlEveningStar(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlEveningDojiStarDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlEveningDojiStar(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlEveningDojiStar(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlEveningDojiStar(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlEveningDojiStarFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlEveningDojiStar(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlEveningDojiStar(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlEveningDojiStar(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlMorningDojiStarDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlMorningDojiStar(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlMorningDojiStar(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlMorningDojiStar(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlMorningDojiStarFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		double optInPenetration = 1.26;	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlMorningDojiStar(0, 4, inOpen, inHigh, inLow, inClose, optInPenetration,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlMorningDojiStar(-1, 4, inOpen, inHigh, inLow, inClose,optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlMorningDojiStar(0, -1, inOpen, inHigh, inLow, inClose, optInPenetration, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	@Test 
	public void testCdlCounterAttackDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlCounterAttack(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlCounterAttack(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlCounterAttack(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlCounterAttackFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlCounterAttack(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlCounterAttack(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlCounterAttack(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdl3LineStrikeDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdl3LineStrike(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdl3LineStrike(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdl3LineStrike(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdl3LineStrikeFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdl3LineStrike(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdl3LineStrike(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdl3LineStrike(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlInvertedHammerDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlInvertedHammer(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlInvertedHammer(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlInvertedHammer(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlInvertedHammerFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlInvertedHammer(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlInvertedHammer(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlInvertedHammer(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlShootingStarDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlShootingStar(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlShootingStar(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlShootingStar(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlShootingStarsFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlShootingStar(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlShootingStar(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlShootingStar(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlOnNeckDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlOnNeck(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlOnNeck(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlOnNeck(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlOnNeckFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlOnNeck(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlOnNeck(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlOnNeck(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlInNeckDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlInNeck(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlInNeck(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlInNeck(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlInNeckFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlInNeck(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlInNeck(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlInNeck(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdl3BlackCrowsDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdl3BlackCrows(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdl3BlackCrows(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdl3BlackCrows(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdl3BlackCrowsFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdl3BlackCrows(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdl3BlackCrows(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdl3BlackCrows(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlTakuriDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlTakuri(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlTakuri(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlTakuri(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlTakuriFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlTakuri(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlTakuri(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlTakuri(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdl3InsideDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdl3Inside(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdl3Inside(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdl3Inside(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdl3InsideFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdl3Inside(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdl3Inside(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdl3Inside(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlThrustingDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlThrusting(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlThrusting(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlThrusting(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlThrustingFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlThrusting(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlThrusting(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlThrusting(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlUpsideGap2CrowsDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlUpsideGap2Crows(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlUpsideGap2Crows(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlUpsideGap2Crows(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlUpsideGap2CrowsFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlUpsideGap2Crows(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlUpsideGap2Crows(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlUpsideGap2Crows(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlDojiStarDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlDojiStar(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlDojiStar(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlDojiStar(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlDojiStarFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlDojiStar(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlDojiStar(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlDojiStar(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlBeltHoldDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlBeltHold(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlBeltHold(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlBeltHold(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlBeltHoldFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlBeltHold(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlBeltHold(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlBeltHold(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlClosingMarubozuDouble() {
		double [] inOpen = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
		double [] inHigh = new double[] {1.26, 1.26, 1.26, 1.27, 1.27};
		double [] inLow = new double[] {1.26, 1.26, 1.26, 1.26, 1.26};
		double [] inClose = new double[] {1.26, 1.26, 1.26, 1.27, 1.26};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlClosingMarubozu(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlClosingMarubozu(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlClosingMarubozu(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testCdlBeltHoldClosingMarubozuFloat() {
		float [] inOpen = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		float [] inHigh = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.27f};
		float [] inLow = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.26f};
		float [] inClose = new float[] {1.26f, 1.26f, 1.26f, 1.27f, 1.26f};
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.cdlClosingMarubozu(0, 4, inOpen, inHigh, inLow, inClose,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.cdlClosingMarubozu(-1, 4, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.cdlClosingMarubozu(0, -1, inOpen, inHigh, inLow, inClose, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testHtTrendMode() {
		double [] inReal = new double[] {1.26, 1.26, 1.26, 1.26, 1.27};
	
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.htTrendMode(0, 4, inReal,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.htTrendMode(-1, 4, inReal, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.htTrendMode(0, -1, inReal, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
	
	@Test 
	public void testHtTrendModeFloat() {
		float [] inReal = new float[] {1.26f, 1.26f, 1.26f, 1.26f, 1.27f};
		
		int[] excpecteds = new int[] {0,0,0,0,0};
		
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		int[] outInteger = new int[5];
		RetCode rc = core.htTrendMode(0, 4, inReal,outBegIdx, outNBElement, outInteger);
		assertArrayEquals(excpecteds, outInteger);
		
		RetCode ra = core.htTrendMode(-1, 4, inReal, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeStartIndex.toString(), ra.toString());
		
		RetCode rb = core.htTrendMode(0, -1, inReal, outBegIdx, outNBElement, outInteger);
		assertEquals(RetCode.OutOfRangeEndIndex.toString(), rb.toString());
	}
}

