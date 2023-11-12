package projeto.dados;

import java.sql.Date;

public class PessoaFisica extends Clientes {
    private Date dataNacimento;
    private String sexo;
    private String cpf;

    public PessoaFisica(int codCliente, String email, String telefone, String nome, String rua, 
    int cep, String bairro, int tipo, Date dataNacimento, String sexo, String cpf){
        super(codCliente, email, telefone, nome, rua, 
        cep,  bairro,tipo);
        this.dataNacimento = dataNacimento;
        this.sexo = sexo;
        this.cpf = cpf;
    }

    public Date getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(Date dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
