public class Endereco {
   
   public String rua, bairro, cidade, CEP;

   public Endereco() {
   }

   public Endereco(String rua, String bairro, String cidade, String CEP) {
      this.rua = rua;
      this.bairro = bairro;
      this.cidade = cidade;
      this.CEP = CEP;
   }

   public String getRua() {
      return this.rua;
   }

   public void setRua(String rua) {
      this.rua = rua;
   }

   public String getBairro() {
      return this.bairro;
   }

   public void setBairro(String bairro) {
      this.bairro = bairro;
   }

   public String getCidade() {
      return this.cidade;
   }

   public void setCidade(String cidade) {
      this.cidade = cidade;
   }

   public String getCEP() {
      return this.CEP;
   }

   public void setCEP(String CEP) {
      this.CEP = CEP;
   }

   public Endereco rua(String rua) {
      setRua(rua);
      return this;
   }

   public Endereco bairro(String bairro) {
      setBairro(bairro);
      return this;
   }

   public Endereco cidade(String cidade) {
      setCidade(cidade);
      return this;
   }

   public Endereco CEP(String CEP) {
      setCEP(CEP);
      return this;
   }

   @Override
   public String toString() {
      return "{" +
         " rua='" + getRua() + "'" +
         ", bairro='" + getBairro() + "'" +
         ", cidade='" + getCidade() + "'" +
         ", CEP='" + getCEP() + "'" +
         "}";
   }


}
