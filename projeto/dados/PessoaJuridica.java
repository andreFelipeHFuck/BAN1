package projeto.dados;

public class PessoaJuridica extends Clientes{
    private String cnpj;

    public PessoaJuridica(int codCliente, String email, String telefone, String nome, String rua, 
    int cep, String bairro, int tipo, String cnpj){
        super(codCliente, email, telefone, nome, rua, 
        cep,  bairro,tipo);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
