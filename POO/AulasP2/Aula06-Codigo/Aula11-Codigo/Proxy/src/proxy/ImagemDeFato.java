package proxy;

public class ImagemDeFato implements Imagem{
    private String sArquivoDaImagem;

    //construtor.
    public ImagemDeFato(String sAArquivoDaImagem)
    {
        this.sArquivoDaImagem = sAArquivoDaImagem;

        carregaImagemDoDisco(); //printa "Carregando" + string
        //faz um carregamento...
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }       
    }

    private void carregaImagemDoDisco()
    {
        System.out.println("Carregando   " + sArquivoDaImagem);
    }

    public void exibeImagem()
    {
        System.out.println("Exibindo " + sArquivoDaImagem);
    }
}
