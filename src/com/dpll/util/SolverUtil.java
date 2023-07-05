package com.dpll.util;

public final class SolverUtil {
	
	//Método utilitário para pegar uma proposição não nula
		public static int getRandomProposition(int[][] formula) {
			int cell = 0;
			for(int i = 0; i < formula.length; i++) {
				if(formula[i].length != 0) {
					for(int j = 0; j < formula[i].length; j++) {
						if(formula[i][j] != 0) {
							cell = formula[i][j];
							break;
						}
					}
				}
			}
			return cell;
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
