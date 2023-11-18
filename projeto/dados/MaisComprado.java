package projeto.dados;

public class MaisComprado {
    private String nome;
    private int quantidade;
    private float precounitcompra;

    public MaisComprado(String nome, int quantidade, float precounitcompra){
        this.nome = nome;
        this.quantidade = quantidade;
        this.precounitcompra = precounitcompra;
    }

    public String getNome() {
        return nome;
    }

    public float getPrecounitcompra() {
        return precounitcompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Nome produto: " + nome +
                "\nQuantidada: " + quantidade +
                "\nPreço unidade compra: " + precounitcompra + 
                "\n";
    }
}
