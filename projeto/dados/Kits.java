package projeto.dados;

public class Kits {
    
    private int codKit;
    private int codKitProduto;
    private int codProduto;
    private int quantidadeProduto;

    public Kits(int codKit, int codKitProduto, int codProduto, int quantidadeProduto) {
        this.codKit = codKit;
        this.codKitProduto = codKitProduto;
        this.codProduto = codProduto;
        this.quantidadeProduto = quantidadeProduto;
    }
    public int getCodKit() {
        return codKit;
    }
    public void setCodKit(int codKit) {
        this.codKit = codKit;
    }
    public int getCodKitProduto() {
        return codKitProduto;
    }
    public void setCodKitProduto(int codKitProduto) {
        this.codKitProduto = codKitProduto;
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
    public String toString() {
        return "codKit:" + codKit + " codKitProduto:" + codKitProduto + " codProduto:" + codProduto + " quantidadeProduto:" + quantidadeProduto;
    }
}
