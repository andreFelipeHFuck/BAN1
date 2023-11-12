package projeto.controllers;

import projeto.dados.Kits;
import projeto.models.KitsModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class KitsController {
    
    public void createKit(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo kit:");
        System.out.println("codKit:");
        int codKit = input.nextInt();
        input.nextLine();
        System.out.println("codKitProduto:");
        int codKitProduto = input.nextInt();
        input.nextLine();
        System.out.println("codProduto:");
        int codProduto = input.nextInt();
        input.nextLine();
        System.out.println("quantidadeProduto:");
        int quantidadeProduto = input.nextInt();
        input.nextLine();
        Kits k = new Kits(codKit, codKitProduto, codProduto, quantidadeProduto);
        KitsModel.create(k, con);
        System.out.println("Kit criado com sucesso!!");
    }
    void listarKits(Connection con) throws SQLException{
        HashSet<Kits> all = KitsModel.listAll(con);
        Iterator<Kits> it = all.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}