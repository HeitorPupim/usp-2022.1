import java.util.Date;
import java.text.SimpleDateFormat;

public class ProdutoPerecivel extends Produto {

	int year,month,date;
	
	Date dataValidade = new Date(2022, 11, 21);
	
	
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
	
	

}
