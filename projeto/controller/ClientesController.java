package projeto.controller;

import projeto.dados.Clientes;
import projeto.models.ClientesModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ClientesController {
    
    public static void createCliente(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo cliente:");
        System.out.println("email:");
        String email = input.nextLine();
        System.out.println("telefone:");
        String telefone = input.nextLine();
        System.out.println("nome:");
        String nome = input.nextLine();
        System.out.println("rua:");
        String rua = input.nextLine();
        System.out.println("cep:");
        int cep = Integer.parseInt(input.nextLine());
        System.out.println("bairro:");
        String bairro = input.nextLine();
        System.out.println("tipo:");
        int tipo = Integer.parseInt(input.nextLine());
        Clientes cliente = new Clientes(0, email, telefone, nome, rua, cep, bairro, tipo);
        ClientesModel.create(cliente, con);
        System.out.println("Cliente criado com sucesso!!");
    }

    public static void listarClientes(Connection con) throws SQLException{
        HashSet<Clientes> all = ClientesModel.listAll(con);
        Iterator<Clientes> it = all.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }

    public static int listarClientesEnumerados(Connection con) throws SQLException{
        int cont;
        int op = 0;

        ArrayList all = ClientesModel.listAllArray(con);

        do{
            cont = 1;
            Iterator<Clientes> it = all.iterator();

            while (it.hasNext()) {
                System.out.print(cont + " -- ");
                System.out.println(it.next().getNome());
                cont++;
            }
            System.out.println("Sua opção: ");
            Scanner input = new Scanner(System.in);
            op = input.nextInt();
        }while(op == 0 || op > all.size());

        Clientes c = (Clientes) all.get(op - 1);
        return c.getCodCliente();
    }
}