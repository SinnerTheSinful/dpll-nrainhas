package com.dpll.solver;

public class Solver {
	// Metodo solver dpll
	public static boolean dpll(int[][] formula) {
		//Simplifica f�rmula inicial
		int[][] formulaSimples = simplifica(formula);
		
		//Come�amos assumindo que a formula simplificada � valida
		boolean isValid = true;
		
		for(int i = 0; i < formulaSimples.length; i++) {
			
			//Vasculhamos a formula por clausulas n�o vazias
			if(formulaSimples[i].length != 0) {
				
				//Caso achemos uma clausula n�o vazia, sabemos que a f�rmula ainda n�o � valida
				isValid = false;
				
				//Assumimos ent�o que ela � insatsfazivel
				boolean isEmpty = true;
				
				for(int j = 0; j < formulaSimples[i].length; j++) {
					
					//Ent�o vasculhamos por clausulas n�o nulas
					if(formulaSimples[i][j] != 0) {
						
						//Caso achemos uma clausula n�o nula sabemos que a f�rmula ainda n�o � insatisfazivel
						isEmpty = false;
					}
				}
				
				//Retornamos falso se houver alguma clausula nula
				if(isEmpty) return false;
			}
		}
		
		//Retornamos verdadeiro se toadas as clausulas forem vazias
		if(isValid) return true;
		
		//Pegamos um literal aleat�rio e sua nega��o
		int[] random1 = new int[] {getRandomProposition(formulaSimples)};
		int[] random2 = new int[] {getRandomProposition(formulaSimples) * (-1)};
		
		//Somamos � formula
		int[][] formulaAlterada1 = append(formulaSimples, random1);
		int[][] formulaAlterada2 = append(formulaSimples, random2);
		
		//Verificamos se � verdade para o literal novo
		if(dpll(formulaAlterada1)) {
			return true;
			
			//Ou sua nega��o
		} else if(dpll(formulaAlterada2)) {
			return true;
			
			//Ou � falso de vez
		} else {
			return false;
		}
	}
	
	//M�todo simplifica
	private static int[][] simplifica(int[][] formula) {
		
		//Vari�vel aqui para garantir que o loop s� termina quando autorizado
		boolean out = false;
		while(!out) {
			
			//Vari�vel para compara��o
			int clausula = 0;
			
			//Vasculhamos as clausulas
			for(int i = 0; i < formula.length; i++) {
				
				//Buscando por clausulas unit�rias
				if(formula[i].length == 1) {
					clausula = formula[i][0];
				}
			}
			
			//Caso n�o achemos nenhuma
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
		
		//Retornamos a f�rmula de entrada depois de suas autera��es
		return formula;
	}
	
	//M�todo utilitario para adicionar uma nova clausula na formula
	private static int[][] append(int[][] array, int[] cell) {
		int[][] appended = new int[array.length+1][];
		for(int i = 0; i < array.length; i++) {
			appended[i] = array[i];
		}
		appended[array.length] = cell;
		return appended;
	}
	
	//M�todo utilit�rio para pegar uma proposi��o n�o nula
	private static int getRandomProposition(int[][] formula) {
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
	
}