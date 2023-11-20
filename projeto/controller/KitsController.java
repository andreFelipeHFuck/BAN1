package projeto.controller;

import projeto.dados.Kits;
import projeto.dados.KitsProdutos;
import projeto.dados.KitsQuantidade;
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
        System.out.println("codigo KitProduto:");
        int codKitProduto = Integer.parseInt(input.nextLine());
        System.out.println("codigo do produto:");
        int codProduto = Integer.parseInt(input.nextLine());
        System.out.println("quantidade do produto:");
        int quantidadeProduto = Integer.parseInt(input.nextLine());
        System.out.println("nome:");
        String nome = input.nextLine();
        Kits k = new Kits(0, codKitProduto, codProduto, quantidadeProduto, nome);
        KitsModel.create(k, con);
        System.out.println("Kit criado com sucesso!!");
    }

    public void listarKits(Connection con) throws SQLException{
        HashSet<Kits> all = KitsModel.listAll(con);

        System.out.println();
        System.out.println("Todos os Kits da loja:");
        System.out.println();

        if(all.size() == 0){
            System.out.println("Nenhum Kit encontrado");
            System.out.println();
        }else{
            Iterator<Kits> it = all.iterator();
            while(it.hasNext()){
                System.out.println(it.next().toString());
                System.out.println();
            }

            System.out.println();
        }

        
    }

    public static void listarKitsProdutos(Connection con) throws SQLException {
        HashSet<KitsProdutos> all = KitsModel.listarKitsProdutos(con);

        System.out.println();
        System.out.println("Todos os kits e suas informacoes:");
        System.out.println();

        if(all.size() == 0) {
            System.out.println("Nenhum Kit encontrado");
            System.out.println();
        } else {
            Iterator<KitsProdutos> it = all.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void listarKitsQuantidades(Connection con) throws SQLException {
        HashSet<KitsQuantidade> all = KitsModel.listarKitsQuantidades(con);

        System.out.println();
        System.out.println("Quantidade total de produtos em kits:");
        System.out.println();

        if(all.size() == 0) {
            System.out.println("Nenhum Kit encontrado");
            System.out.println();
        } else {
            Iterator<KitsQuantidade> it = all.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
                System.out.println();
            }
            System.out.println();
        }
    }
}