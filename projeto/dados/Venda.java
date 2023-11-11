package projeto.dados;

import java.sql.Date;


public class Venda {
    private int codVenda;
    private int codCliente;
    private int codProduto;
    private float quantidade;
    private String formaPagamento;
    private int codTransportadora;
    private Date data;

    public Venda(int codVenda, int codCliente, int codProduto, float quantidade, String formaPagamento, int codTransportadora, Date data){
        this.codVenda = codVenda;
        this.codCliente = codCliente;
        this.codProduto = codProduto;
        this.quantidade = quantidade;
        this.formaPagamento = formaPagamento;
        this.codTransportadora = codTransportadora;
        this.data = data;
    }

    public Venda(){

    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

   public float getQuantidade() {
       return quantidade;
   }

   public void setQuantidade(float quantidade) {
       this.quantidade = quantidade;
   }

   public String getFormaPagamento() {
       return formaPagamento;
   }

   public void setFormaPagamento(String formaPagamento) {
       this.formaPagamento = formaPagamento;
   }

   public int getCodTransportadora() {
       return codTransportadora;
   }

   public void setCodTransportadora(int codTransportadora) {
       this.codTransportadora = codTransportadora;
   }

   public Date getData() {
       return data;
   }

   public void setData(Date data) {
       this.data = data;
   }

   @Override
   public String toString() {
       // TODO Auto-generated method stub
       return super.toString();
   }


}
