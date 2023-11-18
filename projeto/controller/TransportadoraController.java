package projeto.controller;

import java.util.Scanner;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.sql.Date;

import projeto.dados.Transportadora;
import projeto.models.TransportadoraModel;


public class TransportadoraController {
    public void createTransportadora(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);

        System.out.println("Transportadora");
        System.out.println("Insira os seguintes dados para criar uma nova transportadora:");

        System.out.print("Nome:\n> ");
        String nome = input.nextLine();

        System.out.print("CNPJ:\n>");
        String cnpj = input.nextLine();

        System.out.print("Email:\n>");
        String email = input.nextLine();

        System.out.print("Custo por KM:\n>");
        float custokm = Float.parseFloat(input.nextLine());

        Transportadora t = new Transportadora(0, nome, cnpj, email, custokm);
        TransportadoraModel.create(t, con);

        System.out.println("Transportadora criada com sucesso!");
    }

    public static void listarTransportadoras(Connection con) throws SQLException{
        HashSet all = TransportadoraModel.listAll(con);
        Iterator<Transportadora> it = all.iterator();

        while (it.hasNext()) {
            System.out.println(it.next().toString());
            System.out.println();
        }
    }

    public static int listarTransportadoraEnumera(Connection con) throws SQLException{
        int cont;
        int op = 0;

        ArrayList all = TransportadoraModel.listAllArray(con);

        do{
            cont = 1;
            Iterator<Transportadora> it = all.iterator();

            while (it.hasNext()) {
                System.out.print(cont + " -- ");
                System.out.println(it.next().getNome());
                cont++;
            }
            System.out.println("Sua opção: ");
            Scanner input = new Scanner(System.in);
            op = input.nextInt();
        }while(op == 0 || op > all.size());

        Transportadora t = (Transportadora) all.get(op - 1);
        return t.getCodTransportadora();
    }
}
