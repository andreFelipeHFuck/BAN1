package projeto.dados;

public class ProdutosLucrativos {
    private String nome;
    private float lucro;

    public ProdutosLucrativos(String nome, float lucro){
        this.nome = nome;
        this.lucro = lucro;
    }

    public float getLucro() {
        return lucro;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
               "\nLucro: " + lucro;
    }
}
