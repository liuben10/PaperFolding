import java.lang.Math;
import java.util.Arrays;


public class Main {
	public static void main(String...args) {
		Solver s = new Solver(2, "LL");
		int[] resultofproblem = s.Solve();
		String teststring = "order ";
		for(int i = 0; i < resultofproblem.length; i++) {
			teststring += resultofproblem[i] + ", ";
		}
		System.out.println("Sample test with Solve(2, 'LL'): " + teststring);
		if (args.length != 0) {
			Solver mysolve = new Solver(args[0].length(), args[0]);
			int[] resultofSolve = mysolve.Solve();
			String tst = "order ";
			for(int i = 0; i < resultofSolve.length; i++) {
				tst += resultofSolve[i] + ", ";
			}
			System.out.println("My test problem, (" + args[0].length() + ", " + args[0] + ") order: " + tst);
		}
	}
}

final class Solver {
	int size;
	int[][] problem;
	String folding;
	
	public Solver(int n, String fold) {
		this.folding = fold;
		this.size = (int) Math.pow(2, n);
		int[][] result = new int[size][];
		for(int i = 1; i <= size; i++) {
			int[] toAdd = new int[1];
			toAdd[0] = i;
			result[i-1] = toAdd;
		}
		this.problem = result;
	}
	
	public int[] concat(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int cnt = 0;
		for(int i = 0; i < arr1.length; i++) {
			result[i] = arr1[i];
			cnt++;
		}
		for(int i = cnt; i < arr2.length + arr1.length; i++) {
			result[i] = arr2[i-arr1.length];
		}
		return result;
	}
	
	
	public int[] reverse(int[] arr) {
		int[] result = new int[arr.length];
		int cnt = 0;
		for(int i = arr.length-1; i >= 0; i--) {
			result[cnt] = arr[i];
			cnt += 1;
		}
		return result;
	}
	
	public int[] Solve() {
		for(int i = 0; i < folding.length(); i++) {
			if (String.valueOf(folding.charAt(i)).equals("L")) {
				Left();
			} else {
				Right();
			}
		}
		return this.problem[0];
	}
	
	public void Left() {
		int midpoint = this.problem.length / 2;
		int[][] newproblem = new int[midpoint][];
		int fntpnt;
		int bpnt = midpoint;
		int mdpnt = midpoint - 1;
		int[][] oldproblem = this.problem;
		for ( fntpnt = 0; fntpnt < midpoint; fntpnt++) {
			int[] reversed = reverse(oldproblem[mdpnt]);
			newproblem[fntpnt] = concat(reversed, oldproblem[bpnt]);
			bpnt++;
			mdpnt--;
		}
		this.problem = newproblem;
	}
	
	public void Right() {
		int midpoint = this.problem.length / 2;
		int[][] newproblem = new int[midpoint][];
		int[][] oldproblem = this.problem;
		int fntpnt;
		int bpnt = this.problem.length - 1;
		for( fntpnt = 0; fntpnt < midpoint; fntpnt++) {
			int[] reversed = reverse(oldproblem[bpnt]);
			newproblem[fntpnt] = concat(reversed, this.problem[fntpnt]);
			bpnt--;
		}
		this.problem = newproblem;
	}
}