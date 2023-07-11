package com.dpll.main;

import com.dpll.rainhas.Rainhas;
import com.dpll.solver.Solver;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		Solver s = new Solver(size);
		
		sc.close();
		
		ArrayList<ArrayList<Integer>> formula = Rainhas.createClausulas(size);
		int[][] formulaConvertida = new int[formula.size()][];
		
		
		for(int i = 0; i < formula.size(); i++) {
			formulaConvertida[i] = formula.get(i).stream().mapToInt(j -> j).toArray();
		}
		
		System.out.println(s.dpll(formulaConvertida));
		
		for(int i = 0; i < s.clausulasValidas.size(); i++) {
			System.out.println(s.clausulasValidas.get(i));
		}
		
		
	}

}
