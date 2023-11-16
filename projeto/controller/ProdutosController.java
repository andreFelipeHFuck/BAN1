package projeto.controller;

import projeto.dados.Produtos;
import projeto.models.ProdutosModel;

import java.sql.Connection;
import java.sql.SQLException;
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
        Iterator<Produtos> it = all.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
            System.out.println();
        }
    }
}
