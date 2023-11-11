package projeto.dados;

public class Kits {
    private int codKit;
    private int codProduto;
    private int quantidadeProduto;


    public Kits(int codKit, int codProduto, int quantidadeProduto){
        this.codKit = codKit;
        this.codProduto = codProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Kits(){

    }

    public int getCodKit() {
        return codKit;
    }

    public void setCodKit(int codKit) {
        this.codKit = codKit;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
