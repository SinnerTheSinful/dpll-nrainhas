package com.dpll.rainhas;

import java.util.ArrayList;

import com.dpll.util.RainhasUtil;

public class Rainhas {
	public static ArrayList<ArrayList<Integer>> createClausulas(int size){
		int[][] queenPosition = new int[size][size];
		int count = 1;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				queenPosition[i][j] = count;
				count++;
			}
		}
		ArrayList<ArrayList<Integer>> clausulas = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < size; i++) {
			ArrayList<Integer> clausula = new ArrayList<Integer>();
			for(int j = 0; j < size; j++) {
				clausula.add(queenPosition[i][j]);
			}
			clausulas.add(clausula);
			
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				
				for(int k = 0; k < size; k++) {
					if(k != i) { 
						ArrayList<Integer> clausula = new ArrayList<Integer>();
						clausula.add(RainhasUtil.invert(queenPosition[i][j]));
						clausula.add(RainhasUtil.invert(queenPosition[k][j]));
						clausulas.add(clausula);
					}
					if(k != j) {
						ArrayList<Integer> clausula = new ArrayList<Integer>();
						clausula.add(RainhasUtil.invert(queenPosition[i][j]));
						clausula.add(RainhasUtil.invert(queenPosition[i][k]));
						clausulas.add(clausula);
					}
					
					if(k+i >= 0 && k+i < size && k != 0) {
						if(k+j >= 0 && k+j < size) {
							ArrayList<Integer> clausula = new ArrayList<Integer>();
							clausula.add(RainhasUtil.invert(queenPosition[i][j]));
							clausula.add(RainhasUtil.invert(queenPosition[k+i][k+j]));
							clausulas.add(clausula);
						}
						if(j-k >= 0 && j-k < size) {
							ArrayList<Integer> clausula = new ArrayList<Integer>();
							clausula.add(RainhasUtil.invert(queenPosition[i][j]));
							clausula.add(RainhasUtil.invert(queenPosition[k+i][j-k]));
							clausulas.add(clausula);
						}
					} 
					if(i-k >= 0 && i-k < size && k != 0) {
						if(k+j >= 0 && k+j < size) {
							ArrayList<Integer> clausula = new ArrayList<Integer>();
							clausula.add(RainhasUtil.invert(queenPosition[i][j]));
							clausula.add(RainhasUtil.invert(queenPosition[i-k][k+j]));
							clausulas.add(clausula);
						}
						if(j-k >= 0 && j-k < size) {
							ArrayList<Integer> clausula = new ArrayList<Integer>();
							clausula.add(RainhasUtil.invert(queenPosition[i][j]));
							clausula.add(RainhasUtil.invert(queenPosition[i-k][j-k]));
							clausulas.add(clausula);
						}
					}
					
					
				}
				
			}
			
		}
		
		
		
		
		return clausulas;
	}
}
