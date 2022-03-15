import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class MyTest {

	JavaFXTemplate theGame = new JavaFXTemplate();
	ArrayList<Integer> testArray = new ArrayList<Integer>();
	ArrayList<Integer> testArray2 = new ArrayList<Integer>();
	ArrayList<Integer> testArray3 = new ArrayList<Integer>();

	@Test
	void test() {
		testArray = theGame.RandomInts20(20);
		assertEquals(20,testArray.size(), "not 20 ints long");
	}

	@Test
	void under80int20() {
		testArray = theGame.RandomInts20(20);
		for (Integer i : testArray){
			assertTrue(i < 81);
		}
	}

	@Test
	void size6(){
		testArray = theGame.RandomInts20(6);
		assertEquals(6,testArray.size(), "not 6 ints long");
	}

	@Test
	void under80int6() {
		testArray = theGame.RandomInts20(6);
		for (Integer i : testArray){
			assertTrue(i < 81);
		}
	}

	@Test
	void size0(){
		testArray = theGame.RandomInts20(0);
		assertEquals(0,testArray.size(), "not 0 ints long");
	}

	@Test
	void under80int0() {
		testArray = theGame.RandomInts20(0);
		for (Integer i : testArray){
			assertTrue(i < 81);
		}
	}

	@Test
	void size1(){
		testArray = theGame.RandomInts20(1);
		assertEquals(1,testArray.size(), "not 1 ints long");
	}

	@Test
	void under80int1() {
		testArray = theGame.RandomInts20(1);
		for (Integer i : testArray){
			assertTrue(i < 81);
		}
	}

	@Test
	void size4(){
		testArray = theGame.RandomInts20(4);
		assertEquals(4,testArray.size(), "not 4 ints long");
	}

	@Test
	void under80int4() {
		testArray = theGame.RandomInts20(4);
		for (Integer i : testArray){
			assertTrue(i < 81);
		}
	}

	@Test
	void size8(){
		testArray = theGame.RandomInts20(8);
		assertEquals(8,testArray.size(), "not 8 ints long");
	}

	@Test
	void under80int8() {
		testArray = theGame.RandomInts20(8);
		for (Integer i : testArray){
			assertTrue(i < 81);
		}
	}

	@Test
	void size10(){
		testArray = theGame.RandomInts20(10);
		assertEquals(10,testArray.size(), "not 10 ints long");
	}

	@Test
	void under80int10() {
		testArray = theGame.RandomInts20(10);
		for (Integer i : testArray){
			assertTrue(i < 81);
		}
	}

	@Test
	void match1(){
		testArray.add(0, 1);
		testArray.add(1, 2);
		testArray.add(2,3);
		testArray2.add(0, 0);
		testArray2.add(1, 2);
		testArray2.add(2, 4);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(1, testArray3.size(), "does not equal 1 match");
	}

	@Test
	void match2(){
		testArray.add(0, 1);
		testArray.add(1, 2);
		testArray.add(2,3);
		testArray2.add(0, 1);
		testArray2.add(1, 2);
		testArray2.add(2, 4);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(2, testArray3.size(), "does not equal 2 match");
	}

	@Test
	void match3(){
		testArray.add(0, 1);
		testArray.add(1, 2);
		testArray.add(2,3);
		testArray2.add(0, 1);
		testArray2.add(1, 2);
		testArray2.add(2, 3);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(3, testArray3.size(), "does not equal 3 match");
	}

	@Test
	void match4(){
		testArray.add(0, 1);
		testArray.add(1, 2);
		testArray.add(2,3);
		testArray2.add(0, 1);
		testArray2.add(1, 2);
		testArray2.add(2, 4);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(2, testArray3.size(), "does not equal 4 match");
	}

	@Test
	void match5(){
		testArray.add(0, 1);
		testArray.add(1, 2);
		testArray.add(2, 4);
		testArray.add(3, 11);
		testArray.add(4, 21);
		testArray.add(5, 31);
		testArray2.add(0, 1);
		testArray2.add(1, 2);
		testArray2.add(2, 4);
		testArray2.add(3, 11);
		testArray2.add(4, 21);
		testArray2.add(5, 41);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(5, testArray3.size(), "does not equal 5 match");
	}

	@Test
	void match6(){
		testArray.add(0, 1);
		testArray.add(1, 2);
		testArray.add(2, 4);
		testArray.add(3, 11);
		testArray.add(4, 21);
		testArray.add(5, 31);
		testArray2.add(0, 1);
		testArray2.add(1, 2);
		testArray2.add(2, 4);
		testArray2.add(3, 11);
		testArray2.add(4, 21);
		testArray2.add(5, 31);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(6, testArray3.size(), "does not equal 6 match");
	}

	@Test
	void match7(){
		testArray.add(0, 1);
		testArray.add(1, 2);
		testArray.add(2, 3);
		testArray.add(3, 5);
		testArray.add(4, 7);
		testArray.add(5, 13);
		testArray.add(6, 12);
		testArray.add(7, 21);
		testArray.add(8, 31);
		testArray2.add(0, 1);
		testArray2.add(1, 2);
		testArray2.add(2, 5);
		testArray2.add(3, 17);
		testArray2.add(4, 13);
		testArray2.add(5, 15);
		testArray2.add(6, 21);
		testArray2.add(7, 12);
		testArray2.add(8, 3);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(7, testArray3.size(), "does not equal 7 match");
	}

	@Test
	void match8(){
		testArray.add(0, 1);
		testArray.add(1, 2);
		testArray.add(2, 3);
		testArray.add(3, 5);
		testArray.add(4, 7);
		testArray.add(5, 13);
		testArray.add(6, 12);
		testArray.add(7, 21);
		testArray.add(8, 31);
		testArray2.add(0, 1);
		testArray2.add(1, 2);
		testArray2.add(2, 5);
		testArray2.add(3, 7);
		testArray2.add(4, 13);
		testArray2.add(5, 15);
		testArray2.add(6, 21);
		testArray2.add(7, 12);
		testArray2.add(8, 3);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(8, testArray3.size(), "does not equal 8 match");
	}

	@Test
	void match9(){
		testArray.add(0, 11);
		testArray.add(1, 2);
		testArray.add(2, 3);
		testArray.add(3, 5);
		testArray.add(4, 7);
		testArray.add(5, 13);
		testArray.add(6, 12);
		testArray.add(7, 21);
		testArray.add(8, 31);
		testArray.add(9, 77);
		testArray2.add(0, 1);
		testArray2.add(1, 2);
		testArray2.add(2, 5);
		testArray2.add(3, 7);
		testArray2.add(4, 13);
		testArray2.add(5, 31);
		testArray2.add(6, 21);
		testArray2.add(7, 12);
		testArray2.add(8, 3);
		testArray2.add(9, 77);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(9, testArray3.size(), "does not equal 9 match");
	}

	@Test
	void match10(){
		testArray.add(0, 1);
		testArray.add(1, 2);
		testArray.add(2, 3);
		testArray.add(3, 5);
		testArray.add(4, 7);
		testArray.add(5, 13);
		testArray.add(6, 12);
		testArray.add(7, 21);
		testArray.add(8, 31);
		testArray.add(9, 77);
		testArray2.add(0, 1);
		testArray2.add(1, 2);
		testArray2.add(2, 5);
		testArray2.add(3, 7);
		testArray2.add(4, 13);
		testArray2.add(5, 31);
		testArray2.add(6, 21);
		testArray2.add(7, 12);
		testArray2.add(8, 3);
		testArray2.add(9, 77);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(10, testArray3.size(), "does not equal 10 match");
	}

	@Test
	void match0(){
		testArray.add(0, 100);
		testArray.add(1, 200);
		testArray.add(2, 300);
		testArray.add(3, 500);
		testArray.add(4, 700);
		testArray.add(5, 1300);
		testArray.add(6, 1200);
		testArray.add(7, 2100);
		testArray.add(8, 3100);
		testArray.add(9, 7700);
		testArray2.add(0, 1);
		testArray2.add(1, 2);
		testArray2.add(2, 5);
		testArray2.add(3, 7);
		testArray2.add(4, 13);
		testArray2.add(5, 31);
		testArray2.add(6, 21);
		testArray2.add(7, 12);
		testArray2.add(8, 3);
		testArray2.add(9, 77);
		testArray3 = theGame.matchingNumbers(testArray, testArray2);
		assertEquals(0, testArray3.size(), "does not equal 0 match");
	}
}
