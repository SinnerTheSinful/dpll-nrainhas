package com.dpll.util;

import java.util.ArrayList;
import java.util.Random;

public final class SolverUtil {
	
	//Método utilitário para pegar uma proposição não nula aleatória
		public static int getRandomProposition(int[][] formula) {
			
			ArrayList<Integer> cellList = new ArrayList<Integer>();
			
			for(int i = 0; i < formula.length; i++) {
				if(formula[i].length != 0) {
					for(int j = 0; j < formula[i].length; j++) {
						if(formula[i][j] != 0) {
							cellList.add(formula[i][j]);
						}
					}
				}
			}
			Random rand = new Random();
			int ret = cellList.get(rand.nextInt(cellList.size()));
			return ret;
		}
		
		//Método utilitario para adicionar uma nova clausula na formula
		public static int[][] append(int[][] array, int[] cell) {
			int[][] appended = new int[array.length+1][];
			for(int i = 0; i < array.length; i++) {
				appended[i] = array[i];
			}
			appended[array.length] = cell;
			return appended;
		}

}
