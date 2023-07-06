package com.dpll.main;

import com.dpll.solver.Solver;

public class Main {

	public static void main(String[] args) {
	
		int[][] formula = new int[][] {
			{1,2,3},
			{-2,3,4},
			{-3,-4,1},
			{4,-1,3}
		};
		
		System.out.println(Solver.dpll(formula));
		
	}

}
