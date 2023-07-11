package com.dpll.solver;

import java.util.ArrayList;

import com.dpll.util.SolverUtil;

public class Solver {
	
	public static ArrayList<Integer> clausulasValidas = new ArrayList<Integer>();
	
	// Metodo solver dpll
	public static boolean dpll(int[][] formula) {
		//Simplifica fórmula inicial
		int[][] formulaSimples = simplifica(formula);
		
		//Começamos assumindo que a formula simplificada é valida
		boolean isValid = true;
		
		for(int i = 0; i < formulaSimples.length; i++) {
			
			//Vasculhamos a formula por clausulas não vazias
			if(formulaSimples[i].length != 0) {
				
				//Caso achemos uma clausula não vazia, sabemos que a fórmula ainda não é valida
				isValid = false;
				
				//Assumimos então que ela é insatsfazivel
				boolean isEmpty = true;
				
				for(int j = 0; j < formulaSimples[i].length; j++) {
					
					//Então vasculhamos por clausulas não nulas
					if(formulaSimples[i][j] != 0) {
						
						//Caso achemos uma clausula não nula sabemos que a fórmula ainda não é insatisfazivel
						isEmpty = false;
					}
				}
				
				//Retornamos falso se houver alguma clausula nula
				if(isEmpty) return false;
			}
		}
		
		//Retornamos verdadeiro se toadas as clausulas forem vazias
		if(isValid) return true;
		
		//Pegamos um literal aleatório e sua negação
		int prop = SolverUtil.getRandomProposition(formulaSimples);
		int[] random1 = new int[] {prop};
		int[] random2 = new int[] {prop * (-1)};
		
		//Somamos à formula
		int[][] formulaAlterada1 = SolverUtil.append(SolverUtil.cloneArray(formulaSimples), random1);
		int[][] formulaAlterada2 = SolverUtil.append(SolverUtil.cloneArray(formulaSimples), random2);
		
		//Verificamos se é verdade para o literal novo ou sua negação e retornamos o seguinte resultado
		if(dpll(formulaAlterada1)) {
			return true;
		} else if(dpll(formulaAlterada2)){
			return true;
		} else {
			return false;
		}
	}
	
	//Método simplifica
	private static int[][] simplifica(int[][] formula) {
		
		//Variável aqui para garantir que o loop só termina quando autorizado
		boolean out = false;
		while(!out) {
			
			//Variável para comparação
			int clausula = 0;
			
			//Vasculhamos as clausulas
			for(int i = 0; i < formula.length; i++) {
				
				//Buscando por clausulas unitárias
				if(formula[i].length == 1) {
					clausula = formula[i][0];
				}
			}
			
			//Caso não achemos nenhuma
			if(clausula == 0) {
				
				//Saimos do loop
				out = true;
				
				//Caso achemos uma
			} else {
				
				//Vasculhamos todos os literais
				for(int i = 0; i < formula.length; i++) {
					for(int j = 0; j < formula[i].length; j++) {
						
						//Caso o literal esteja em uma clausula
						if(formula[i][j] == clausula) {
							
							//Tornamos ela uma clausula vazia
							formula[i] = new int[0];
							
							//Caso o literal negado esteja em uma clausula
						} else if(formula[i][j] == clausula * (-1)) {
							
							//Nulificamos o literal
							formula[i][j] = 0;
						}
					}
				}
			}
		}
		
		//Retornamos a fórmula de entrada depois de suas auterações
		return formula;
	}
	
	
	
	
	
}
