package proxy;

public class ImagemProxy implements Imagem{
    private String sArquivoDaImagem;
    private ImagemDeFato iImagemDeFato;

    public ImagemProxy(String sAArquivoDaImagem){
        this.sArquivoDaImagem = sAArquivoDaImagem;
    }
    // o Proxy tem uma ligação com o objeto real. 
    // O objeto real é instanciado apenas quando necessário.
    // restringe acesso por partes da aplicação (proteção)
    // proxy = representante/procurador.
    
    public void exibeImagem(){
        if (iImagemDeFato == null){
           /*O construtor de imagem de fato carrega do disco*/
           // é um request. ele chama o objeto real agora.
           iImagemDeFato = new ImagemDeFato(sArquivoDaImagem);
        }
        iImagemDeFato.exibeImagem();
    }
}

