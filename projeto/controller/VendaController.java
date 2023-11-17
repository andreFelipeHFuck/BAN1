package projeto.controller;

import java.util.Scanner;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.sql.Date;

import projeto.dados.Venda;
import projeto.dados.Clientes;
import projeto.dados.FormaPagamento;
import projeto.models.VendaModel;
import projeto.models.ClientesModel;
import projeto.models.ProdutosModel;
import projeto.models.TransportadoraModel;

public class VendaController {
    public void createVenda(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);
    }

    public void printVenda(Venda v, Connection con) throws SQLException{
        System.out.println("Codigo Venda: " + v.getCodVenda());

        System.out.println(v.getCodCliente());

        Clientes c = ClientesModel.getCliente(v.getCodCliente(), con);
        System.out.println(c);

        System.out.println("Produto: " + ProdutosModel.getNomeProduto(v.getCodProduto(), con));
        System.out.println("Transportadora: " + TransportadoraModel.getNomeTransportadora(v.getCodTransportadora(), con));

        System.out.println("Quantidade: " + v.getQuantidade());
        System.out.println("Forma de pagamento: " + v.getFormaPagamento());

        System.out.println(v.getData());
    }

    public void listarVendas(Connection con) throws SQLException{
        HashSet all = VendaModel.listAll(con);
        Iterator<Venda> it = all.iterator();

        while (it.hasNext()) {
            printVenda(it.next(), con);
            System.out.println();
        }
    }

    public void listarFormaPagamento(Connection con) throws SQLException{
        HashSet all = VendaModel.listFormaPagamento(con);
        Iterator<FormaPagamento> it = all.iterator();

        System.out.println();
        System.out.println("Forma de pagamento: ");

        while (it.hasNext()) {
            System.out.println(it.next().toString());
            System.out.println();
        }
    }

    public int menuTipoCliente(){
        System.out.println();
        System.out.println("Escolha o tipo de cliente: ");
        System.out.println("1 -- Pessoa Fisíca");
        System.out.println("2 -- Pessoa Jurídica");
        System.out.println("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public int tiposCliente(){
        int op = 0;

        do{
            op = menuTipoCliente();
        }while(op == 0 || op > 3);

        return op;
    }

    public void listarVendasClientesPorTipo(Connection con) throws SQLException{
        int tipo = tiposCliente();

        System.out.println();
        if(tipo == 1){
            System.out.println("Pessoas Fisícas: ");
        }else if(tipo == 2){
            System.out.println("Pessoas Jurídicas");
        }

        System.out.println();
        HashSet all = VendaModel.listVendasClientesPorTipo(tipo, con);
        Iterator<Venda> it = all.iterator();

        while (it.hasNext()) {
            printVenda(it.next(), con);
            System.out.println();
        }
    }
}
