import static org.junit.Assert.*;

import org.junit.Test;


public class MainTest {
	Solver s = new Solver(3, "LLL");
	int[] foo = {1, 2, 3};
	int[] bar = {4, 5, 6};
	Solver s2 = new Solver(4, "LRLR");
	
	@Test
	public void testConcat() {
		int[] res = s.concat(foo, bar);
		int[] actual = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(actual, res);
	}
	
	@Test
	public void testReverse() {
		int[] actual = s.reverse(foo);
		int[] toTest = {3, 2, 1};
		assertArrayEquals(toTest, actual);
	}
	
	@Test
	public void testInit() {
		for(int i = 0; i < s.problem.length; i++) {
			System.out.println(s.problem[i][0]);
		}
	}
	
	@Test
	public void testLeft() {
		int[] result = s.Solve();
		System.out.println("====");
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	@Test
	public void testAdvanced() {
		int[] result = s2.Solve();
		System.out.println("====");
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
