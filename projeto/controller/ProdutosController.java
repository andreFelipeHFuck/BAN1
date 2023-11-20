package projeto.controller;

import projeto.dados.Produtos;
import projeto.dados.ProdutosLucrativos;
import projeto.models.ProdutosModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ProdutosController {
    
    public void createProduto(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo produto:");
        System.out.println("precoUnitVenda:");
        float precoUnitVenda = Float.parseFloat(input.nextLine());
        System.out.println("precoUnitCompra:");
        float precoUnitCompra = Float.parseFloat(input.nextLine());
        System.out.println("descricao:");
        String descricao = input.nextLine();
        System.out.println("quantidade:");
        int quantidade = Integer.parseInt(input.nextLine());
        System.out.println("nome:");
        String nome = input.nextLine();
        System.out.println("datasheet:");
        String datasheet = input.nextLine();

        Produtos produto = new Produtos(0 , precoUnitVenda, precoUnitCompra, descricao, quantidade, nome, datasheet);
        ProdutosModel.create(produto, con);
        System.out.println("Produto criado com sucesso!!");
    }

    public void listarProdutos(Connection con) throws SQLException {
        HashSet all = ProdutosModel.listAll(con);

        System.out.println();
        System.out.println("Lista dos Produtos:");
        System.out.println();

        if(all.size() == 0){
            System.out.println("Nenhum Produto encontrado");
            System.out.println();
        }else{
            Iterator<Produtos> it = all.iterator();
            while(it.hasNext()){
                System.out.println(it.next().toString());
                System.out.println();
            }

            System.out.println();
        }
    }

    public static int listarProdutosEnumerados(Connection con) throws SQLException{
        int cont;
        int op =0;

        ArrayList all = ProdutosModel.listAllArray(con);
     
        do{
            cont = 1;
            Iterator<Produtos> it = all.iterator();

            while (it.hasNext()) {
                System.out.print(cont + " -- ");
                System.out.println(it.next().getNome());
                cont++;
            }
            System.out.println("Sua opção: ");
            Scanner input = new Scanner(System.in);
            op = input.nextInt();
        }while(op == 0 || op > all.size());

        Produtos p = (Produtos) all.get(op - 1);
        return p.getCodProduto();
    }

    public static void listar10ProdutosMaisLucrativos(Connection con) throws SQLException{
        HashSet all = ProdutosModel.list10ProdutosMaisLucrativos(con);

        System.out.println();
        System.out.println("Lista dos 10 Produtos mais lucrativos:");
        System.out.println();

        if(all.size() == 0){
            System.out.println("Nenhum Produto encontrado");
            System.out.println();
        }else{
            Iterator<ProdutosLucrativos> it = all.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
                System.out.println();
            }

            System.out.println();
        }
    }

    public static void produtoMaisBarato(Connection con) throws SQLException{
        ProdutosLucrativos p = ProdutosModel.produtoMaisBarato(con);

        System.out.println();
        System.out.println("Produto mais barato: ");
        System.out.println();

       System.out.println("Nome: " + p.getNome() +
                          "Preço: " + p.getLucro());

        System.out.println();
    }

    public static void listarProdutosAcimaDaMedia(Connection con) throws SQLException{
        HashSet all = ProdutosModel.listProdutosComPrecoAcimaMedia(con);

        System.out.println();
        System.out.println("Lista Produtos com preço de Venda acima da média:");
        System.out.println();

        if(all.size() == 0){
            System.out.println("Nenhum produto encontrado");
            System.out.println();
        }else{
            Iterator<ProdutosLucrativos> it = all.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
                System.out.println();
            }

            System.out.println();
        }
    }
}
