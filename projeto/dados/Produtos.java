package projeto.dados;

public class Produtos {
    private int codProduto;
    private float precoUnitario;
    private float precoUnitarioCompra;
    private String descricao;
    private int quantidade;
    private String datasheet;


    public Produtos(int codCliente, float precoUnitario, float precoUnitarioCompra, String descricao, int quantidade, String datasheet){
        this.codProduto = codProduto;
        this.precoUnitario = precoUnitario;;
        this.precoUnitarioCompra = precoUnitarioCompra;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.datasheet = datasheet;
    }

    public Produtos(){

    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public float getPrecoUnitarioCompra() {
        return precoUnitarioCompra;
    }

    public void setPrecoUnitarioCompra(float precoUnitarioCompra) {
        this.precoUnitarioCompra = precoUnitarioCompra;
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

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
