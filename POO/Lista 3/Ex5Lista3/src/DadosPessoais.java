public class DadosPessoais {
   
   public String CPF, nome, sobrenome, numCelular;

   public Endereco endereco = new Endereco();

   public DadosPessoais() {
   }

   public DadosPessoais(String CPF, String nome, String sobrenome, String numCelular) {
      this.CPF = CPF;
      this.nome = nome;
      this.sobrenome = sobrenome;
      this.numCelular = numCelular;
   }

   public String getCPF() {
      return this.CPF;
   }

   public void setCPF(String CPF) {
      this.CPF = CPF;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getSobrenome() {
      return this.sobrenome;
   }

   public void setSobrenome(String sobrenome) {
      this.sobrenome = sobrenome;
   }

   public String getNumCelular() {
      return this.numCelular;
   }

   public void setNumCelular(String numCelular) {
      this.numCelular = numCelular;
   }

   public DadosPessoais CPF(String CPF) {
      setCPF(CPF);
      return this;
   }

   public DadosPessoais nome(String nome) {
      setNome(nome);
      return this;
   }

   public DadosPessoais sobrenome(String sobrenome) {
      setSobrenome(sobrenome);
      return this;
   }

   public DadosPessoais numCelular(String numCelular) {
      setNumCelular(numCelular);
      return this;
   }

   @Override
   public String toString() {
      return "{" +
         " CPF='" + getCPF() + "'" +
         ", nome='" + getNome() + "'" +
         ", sobrenome='" + getSobrenome() + "'" +
         ", numCelular='" + getNumCelular() + "'" +
         "}";
   }
  
}
