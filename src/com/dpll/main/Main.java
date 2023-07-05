package com.dpll.main;

import com.dpll.solver.Solver;

public class Main {

	public static void main(String[] args) {
		int[][] formula = new int[][] {
			{-1},
			{1}
		};
		
		System.out.println(Solver.dpll(formula));
		
	}

}
