package projeto.dados;

public class Transportadora {
    private int codTransportadora;
    private String nome;
    private String cnpj;
    private String email;
    private float custoKM;


    public Transportadora(int codTransportadora, String nome, String cnpj, float custoKM){
        this.codTransportadora = codTransportadora;
        this.nome = nome;
        this.cnpj = cnpj;
        this.custoKM = custoKM;
    }

    public Transportadora(){

    }

    public int getCodTransportadora() {
        return codTransportadora;
    }

    public void setCodTransportadora(int codTransportadora) {
        this.codTransportadora = codTransportadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getCustoKM() {
        return custoKM;
    }

    public void setCustoKM(float custoKM) {
        this.custoKM = custoKM;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
