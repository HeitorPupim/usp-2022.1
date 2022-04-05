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
		System.out.println("Menu de Operações:");
		System.out.println("\n"
				+ "(1) - Adição"
				+ "\n"
				+ "(2) - Subtração"
				+ "\n"
				+ "(3) - Multiplicação"
				+ "\n"
				+ "(4) - Divisão"
				+ "\n");
	}

	//seleciona e confere a operação
	public void selecionarOperacao(int idOperation){
		switch (idOperation) {
			case 1: {
				System.out.println("Operação de Soma (a + b)\n");
				this.operationName = "Soma";
				break;
			}
			case 2: {
				System.out.println("Operação de Subtração (a - b)\n");
				this.operationName = "Subtração";
				break;
			}
			case 3: {
				System.out.println("Operação de Multiplicação (a * b)\n");
				this.operationName = "Mutiplicação";
				break;
			}
			
			case 4: {
				System.out.println("Operação de Divisão (a / b)\n");
				this.operationName = "Divisão";
				break;
			}
			default:
				throw new IllegalArgumentException("Operação Inválida!!!\n\n" + idOperation);
		}
		
	}
	
	//faz a operação desejada:
	
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
