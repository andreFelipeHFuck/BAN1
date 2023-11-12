package projeto.dados;

import java.sql.Date;

public class Clientes{
    
    private int codCliente;
    private String email;
    private String telefone;
    private String nome;
    private String rua;
    private int cep;
    private String bairro;
    private int tipo;
    private Date dataNascimento;
    private String sexo;
    private String cpf;
    private String cnpj;

    public Clientes(int codCliente, String email, String telefone, String nome, String rua, int cep, String bairro, int tipo,
                    Date dataNascimento, String sexo, String cpf, String cnpj){
        this.codCliente = codCliente; 
        this.email = email;               
        this.telefone = telefone;
        this.nome = nome;
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.tipo = tipo;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.cnpj = cnpj;              
    }
    public int getCodCliente() {
        return codCliente;
    }
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String toString() {
        return "codCliente:" + codCliente + " email:" + email + " telefone:" + telefone + " nome:" + nome + " rua:" + rua + " cep:" + cep + " bairro:" + bairro + 
                " tipo:" + tipo + " dataNascimento:" + dataNascimento + " sexo:" + sexo + " cpf:" + cpf + " cnpj:" + cnpj;
    }
}

