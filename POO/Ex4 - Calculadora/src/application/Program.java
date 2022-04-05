package application;

import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import entities.Operation;
import entities.Person;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		
		
		System.out.println("Bem vindo à Calculadora !");
		System.out.println("------------------------" + dtf.format(now) + "------------------------");
		System.out.println("");
		System.out.println("Informe seu Nome:");
		String pNome = sc.nextLine();
		System.out.println("Informe sua Idade: ");
		int pIdade = sc.nextInt();
		sc.nextLine();
		System.out.println("Por fim, informe seu CPF: ");
		String pCPF = sc.nextLine();
		
		// criando cadastro da pessoa
		Person person = new Person(pNome, pIdade, pCPF);
		
		System.out.println();
		person.welcomePerson();
		
		Operation operation = new Operation(0);
		
		operation.printMenu();
		
		System.out.println(person.getpNome() + ", por favor, insira o nº da operação que deseja realizar:");
		int operationNumber = sc.nextInt();
	
		//se passar, vamos continuar o cálculo..
		
		operation.setIdOperation(operationNumber);
		operation.selecionarOperacao(operationNumber);
		
		System.out.println("Insira o valor de (a):");
		operation.setN1(sc.nextFloat());
		System.out.println("Insira o valor de (b):");
		operation.setN2(sc.nextFloat());
	
		operation.fazerOperacao(operationNumber, operation.getN1(), operation.getN2());
		
		System.out.println();
		System.out.println("Resultado:" + operation.getResult() + "\n");
		System.out.println(person); 
		System.out.println("Realizou a operação de " +  operation.getOperationName() + " em "
				+ dtf.format(now) +
				" entre " + operation.getN1() +
				" e " + operation.getN2() + 
				" obtendo o resultado de: "+ operation.getResult());
		
		sc.close();
	}

}
