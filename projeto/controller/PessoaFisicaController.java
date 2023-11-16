package projeto.controller;

import java.util.Scanner;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.sql.Date;

import projeto.dados.PessoaFisica;
import projeto.models.PessoaFisicaModel;

public class PessoaFisicaController {

    public void createPessoFisica(Connection con) throws SQLException{
         Scanner input = new Scanner(System.in);

        System.out.println("Pesoa Física");
        System.out.println("Insira os seguintes dados para criar um novo cliente:");
        
        System.out.print("Nome:\n> ");
        String nome = input.nextLine();

        System.out.println("Data Nascimento:");
        System.out.print("Dia:\n> ");
        String dia = input.nextLine();
        System.out.print("Mês\n> ");
        String mes = input.nextLine();
        System.out.print("Ano:\n> ");
        String ano = input.nextLine();

        Date dataNascimento = Date.valueOf(ano + '-' + mes + '-' + dia);

        System.out.print("Sexo:\n> ");
        String sexo = input.nextLine();

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

        System.out.print("CPF:\n> ");
        String cpf = input.nextLine();

        PessoaFisica p = new PessoaFisica(0, 1, nome, dataNascimento, sexo, email, telefone, rua, bairro, cep, cpf);
        PessoaFisicaModel.create(p, con);

        System.out.println("Cliente criado com sucesso!");

    }

    public static void listarPessoaFisica(Connection con) throws SQLException{
        HashSet all = PessoaFisicaModel.listAll(con);
        Iterator<PessoaFisica> it = all.iterator();

        while (it.hasNext()) {
            System.out.println(it.next().toString());
            System.out.println();
        }
    }    
}