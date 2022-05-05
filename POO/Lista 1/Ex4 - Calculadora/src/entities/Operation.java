package entities;

import java.util.Scanner;

public class Operation {
	
	public int idOperation;
	public String operationName;
	public float n1, n2, result;
	
		
	Scanner sc = new Scanner(System.in);
	
	//construtor simples:
	public Operation(int idOperation) {
		this.idOperation = idOperation;
	}

	//construtor completo: 
	public Operation(int idOperation, float n1, float n2){
		this.idOperation = idOperation;
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public void setN1(float n1) {
		this.n1 = n1;
	}

	public void setN2(float n2) {
		this.n2 = n2;
	}

	public float getN1() {
		return n1;
	}

	public float getN2() {
		return n2;
	}

	public float getResult() {
		return result;
	}
	public String getOperationName(){
		return operationName;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}


	public void printMenu() {
		System.out.println("Menu de Opera��es:");
		System.out.println("\n"
				+ "(1) - Adi��o"
				+ "\n"
				+ "(2) - Subtra��o"
				+ "\n"
				+ "(3) - Multiplica��o"
				+ "\n"
				+ "(4) - Divis�o"
				+ "\n");
	}

	//seleciona e confere a opera��o
	public void selecionarOperacao(int idOperation){
		switch (idOperation) {
			case 1: {
				System.out.println("Opera��o de Soma (a + b)\n");
				this.operationName = "Soma";
				break;
			}
			case 2: {
				System.out.println("Opera��o de Subtra��o (a - b)\n");
				this.operationName = "Subtra��o";
				break;
			}
			case 3: {
				System.out.println("Opera��o de Multiplica��o (a * b)\n");
				this.operationName = "Mutiplica��o";
				break;
			}
			
			case 4: {
				System.out.println("Opera��o de Divis�o (a / b)\n");
				this.operationName = "Divis�o";
				break;
			}
			default:
				throw new IllegalArgumentException("Opera��o Inv�lida!!!\n\n" + idOperation);
		}
		
	}
	
	//faz a opera��o desejada:
	
	public void fazerOperacao(int idOperation, float a, float b) {
		switch (idOperation) {
			case 1: {
				System.out.println(a + " + " + b + " = " + (a+b) + "\n");
				result = (a + b);
				break;
			}
			case 2: {
				System.out.println(a + " - " + b + " = " + (a-b)+ "\n");
				result = (a - b);
				break;
			}
			case 3: {
				System.out.println(a + " * " + b + " = " + (a*b) + "\n");
				result =  (a * b);
				break;
			}
			case 4: {
				System.out.println(a + " / " + b + " = " + (a/b) + "\n");
				result  = (a / b);
				break;
			}
		}
	}
}
