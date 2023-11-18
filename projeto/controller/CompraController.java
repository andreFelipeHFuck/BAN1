package projeto.controller;

import java.util.Scanner;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.sql.Date;

import projeto.dados.Compra;
import projeto.dados.MaisComprado;
import projeto.models.CompraModel;
import projeto.models.ProdutosModel;
import projeto.models.TransportadoraModel;
import projeto.models.FornecedorModel;

public class CompraController {
    public void createCompra(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);

        int codProduto = ProdutosController.listarProdutosEnumerados(con);
        int codFornecedor = FornecedorController.listarFornecedoresEnumerados(con);
        int codTransportadora = TransportadoraController.listarTransportadoraEnumera(con);

        System.out.print("Quantidade\n>");
        int quantidade = input.nextInt();

        input.nextLine();

        System.out.println("Data da entrega:");
        System.out.print("Dia:\n> ");
        String dia = input.nextLine();
        System.out.println();
        System.out.print("Mês\n> ");
        String mes = input.nextLine();
        System.out.println();
        System.out.print("Ano:\n> ");
        String ano = input.nextLine();
        System.out.println();

        Date data = Date.valueOf(ano + '-' + mes + '-' + dia);

        Compra c = new Compra(0, codFornecedor, codProduto, quantidade, codTransportadora, data);
        CompraModel.create(c, con);

        System.out.println("Compra criada com sucesso!");
    }

    public void printCompra(Compra c, Connection con) throws SQLException{
        System.out.println("Codigo Compra: " + c.getCodCompra());

        System.out.println("Produto: " + ProdutosModel.getNomeProduto(c.getCodProduto(), con));
        System.out.println("Fornecedor: " + FornecedorModel.getNomeFornecedor(c.getCodFornecedor(), con) );
        System.out.println("Transportadora: " + TransportadoraModel.getNomeTransportadora(c.getCodTransportadora(), con));

        System.out.println("Quantidade: " + c.getQuantidade());
    }

    public void listarCompras(Connection con) throws SQLException{
        HashSet all = CompraModel.listAll(con);
        Iterator<Compra> it = all.iterator();

        System.out.println();
        System.out.println("Todas as compras realizadas pela loja:");
        System.out.println();

        while(it.hasNext()){
            printCompra(it.next(), con);
            System.out.println();
        }
    }

    public void listarProdutosMaisComprados(Connection con) throws SQLException{
        HashSet all = CompraModel.listProdutosMaisComprados(con);
        Iterator<MaisComprado> it = all.iterator();

        System.out.println();
        System.out.println("Lista dos produtos mais comprados:");
        System.out.println();

        while (it.hasNext()) {
            System.out.println(it.next().toString());
            System.out.println();
        }
    }
}
