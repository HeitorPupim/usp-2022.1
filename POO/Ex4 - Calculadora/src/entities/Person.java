package entities;

public class Person {
	
	public String pNome, pCPF;
	public int pIdade;

	public Person(String nome, int idade, String CPF) {
		this.pNome = nome;
		this.pIdade = idade;
		this.pCPF = CPF;
	}

	// user data: 
	public String toString() {
		return "Nome:" + pNome + "\nIdade:" + pIdade + "\nCPF:" + pCPF;
	}
	
	public void welcomePerson(){
		System.out.println("Bem vindo(a) " +pNome + " !"); ;
	}

	public String getpNome() {
		return pNome;
	}

	
	
	
	
	
	
}


