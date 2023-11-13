package projeto.dados;

import java.sql.Date;

public class PessoaJuridica extends Clientes{
    private String cnpj;

    public PessoaJuridica(int codCliente, int tipo, String nome, String email, String telefone, 
    String rua, String bairro, int cep, String cpf){
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
