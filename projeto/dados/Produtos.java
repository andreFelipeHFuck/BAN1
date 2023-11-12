package projeto.dados;

public class Produtos {
    
    private int codProduto;
    private int precoUnitVenda;
    private int precoUnitCompra;
    private String descricao;
    private int quantidade;
    private String datasheet;

    public Produtos(int codProduto, int precoUnitVenda, int precoUnitCompra, String descricao, int quantidade, String datasheet) {
        this.codProduto = codProduto;
        this.precoUnitVenda = precoUnitVenda;
        this.precoUnitCompra = precoUnitCompra;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.datasheet = datasheet;
    }
    public int getCodProduto() {
        return codProduto;
    }
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }
    public int getPrecoUnitVenda() {
        return precoUnitVenda;
    }
    public void setPrecoUnitVenda(int precoUnitVenda) {
        this.precoUnitVenda = precoUnitVenda;
    }
    public int getPrecoUnitCompra() {
        return precoUnitCompra;
    }
    public void setPrecoUnitCompra(int precoUnitCompra) {
        this.precoUnitCompra = precoUnitCompra;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getDatasheet() {
        return datasheet;
    }
    public void setDatasheet(String datasheet) {
        this.datasheet = datasheet;
    }
    public String toString() {
        return "codProduto:" + codProduto + " precoUnitVenda:" + precoUnitVenda + " precoUnitCompra:" + precoUnitCompra + " descricao:" + descricao
         + " quantidade:" + quantidade + " datasheet:" + datasheet;
    }
}