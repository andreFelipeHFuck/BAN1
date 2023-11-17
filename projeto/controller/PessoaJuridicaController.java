package projeto.controller;

import java.util.Scanner;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.sql.Date;

import projeto.dados.PessoaJuridica;
import projeto.models.PessoaJuridicaModel;

public class PessoaJuridicaController {
    public void createPessoaJuridica(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);

        System.out.println("Pessoa Jurídica");
        System.out.println("Insira os seguintes dados para criar um novo cliente:");

        System.out.print("Nome:\n> ");
        String nome = input.nextLine();

        System.out.print("Email:\n> ");
        String email = input.nextLine();

        System.out.print("Telefone:\n> ");
        String telefone = input.nextLine();

        System.out.print("Rua:\n> ");
        String rua = input.nextLine();

        System.out.print("Bairro\n> ");
        String bairro = input.nextLine();

        System.out.print("CEP:\n> ");
        int cep = Integer.parseInt(input.nextLine());

        System.out.print("CNPJ:\n> ");
        String cnpj = input.nextLine();

    
        PessoaJuridica p = new PessoaJuridica(0, 2, nome, email, telefone, rua, bairro, cep, cnpj);
        PessoaJuridicaModel.create(p, con);

        System.out.println("Cliente criado com sucesso!");
    }

    public static void listarPessoaJuridica(Connection con) throws SQLException{
        HashSet all = PessoaJuridicaModel.listAll(con);
        Iterator<PessoaJuridica> it = all.iterator();

        while (it.hasNext()) {
            System.out.println(it.next().toString());
            System.out.println();
        }
    }
}
