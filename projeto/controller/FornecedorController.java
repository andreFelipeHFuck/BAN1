package projeto.controller;

import projeto.dados.Fornecedor;
import projeto.models.FornecedorModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class FornecedorController {
    
    public void createFornecedor(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo fornecedor:");
        System.out.println("codFornecedor:");
        int codFornecedor = input.nextInt();
        input.nextLine(); 
        System.out.println("nome:");
        String nome = input.nextLine();
        System.out.println("cnpj:");
        String cnpj = input.nextLine();
        System.out.println("email:");
        String email = input.nextLine();

        Fornecedor fornecedor = new Fornecedor(codFornecedor, nome, cnpj, email);
        FornecedorModel.create(fornecedor, con);
        System.out.println("Fornecedor criado com sucesso!!");
    }

    public void listarFornecedores(Connection con) throws SQLException {
        HashSet<Fornecedor> all = FornecedorModel.listAll(con);
        Iterator<Fornecedor> it = all.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
