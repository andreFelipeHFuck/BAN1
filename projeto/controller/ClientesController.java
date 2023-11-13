package projeto.controller;

import projeto.dados.Clientes;
import projeto.models.ClientesModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ClientesController {
    
    public void createCliente(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo cliente:");
        System.out.println("codCliente:");
        int codCliente = input.nextInt();
        input.nextLine();
        System.out.println("email:");
        String email = input.nextLine();
        System.out.println("telefone:");
        String telefone = input.nextLine();
        System.out.println("nome:");
        String nome = input.nextLine();
        System.out.println("rua:");
        String rua = input.nextLine();
        System.out.println("cep:");
        int cep = input.nextInt();
        input.nextLine(); 
        System.out.println("bairro:");
        String bairro = input.nextLine();
        System.out.println("tipo:");
        int tipo = input.nextInt();
        input.nextLine(); 
        System.out.println("dataNascimento (aaaa-mm-dd):");
        String dataNascimentoStr = input.nextLine();
        java.sql.Date dataNascimento = java.sql.Date.valueOf(dataNascimentoStr);
        System.out.println("sexo:");
        String sexo = input.nextLine();
        System.out.println("cpf:");
        String cpf = input.nextLine();
        System.out.println("cnpj:");
        String cnpj = input.nextLine();
        Clientes cliente = new Clientes(codCliente, email, telefone, nome, rua, cep, bairro, tipo, dataNascimento, sexo, cpf, cnpj);
        ClientesModel.create(cliente, con);
        System.out.println("Cliente criado com sucesso!!");
    }
    public void listarClientes(Connection con) throws SQLException{
        HashSet<Clientes> all = ClientesModel.listAll(con);
        Iterator<Clientes> it = all.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}