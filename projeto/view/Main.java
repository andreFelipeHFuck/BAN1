package projeto.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import projeto.controller.PessoaFisicaController;
import projeto.controller.PessoaJuridicaController;
import projeto.controller.TransportadoraController;
import projeto.controller.ProdutosController;
import projeto.controller.FornecedorController;
import projeto.controller.KitsController;
import projeto.models.Conexao;

public class Main {

    public static void main(String[] args) throws SQLException{


        Conexao c = new Conexao();
        Connection con = c.getConnection();

        int op = 0;

        do{
            op = menu();
            try{
                switch (op) {
                    case 1:
                       new PessoaFisicaController().createPessoFisica(con);
                        break;
                    case 2:
                        new PessoaFisicaController().listarPessoaFisica(con);
                        break;
                    case 3:
                        new PessoaJuridicaController().createPessoaJuridica(con);
                        break;
                    case 4:
                        new PessoaJuridicaController().listarPessoaJuridica(con);
                        break;
                    case 5:
                        new TransportadoraController().createTransportadora(con);
                        break;
                    case 6:
                        new TransportadoraController().listarTransportadoras(con);
                        break;
                    case 7:
                        new ProdutosController().createProduto(con);
                        break;
                    case 8:
                        new ProdutosController().listarProdutos(con);
                        break;
                    case 9:
                        new FornecedorController().createFornecedor(con);
                        break;
                    case 10:
                        new FornecedorController().listarFornecedores(con);
                        break;
                    case 11:
                        new KitsController().createKit(con);
                        break;
                    case 12:
                        new KitsController().listarKits(con);
                        break;
                    default:
                        break;
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                continue;
            }
        }while(op>0 && op < 13);
        con.close();
    }

    public static int menu(){
        System.out.println("Informe o número da opção que deseja executar:");
        System.out.println("1 -- Inserir um novo cliente (Pessoa Física)");
        System.out.println("2 -- Listar todos os clientes (Pessoa Física)");
        System.out.println("3 -- Inserir um novo cliente (Pessoa Jurídica)");
        System.out.println("4 -- Listar todos os cliente (Pessoa Jurídica)");
        System.out.println("5 -- Inserir uma nova transportadora");
        System.out.println("6 -- Listar todos as Transportadoras");
        System.out.println("7 -- Inserir um novo produto");
        System.out.println("8 -- Listar todos os produtos");
        System.out.println("9 -- Inserir um novo fornecedor");
        System.out.println("10 -- Listar todos os fornecedores");
        System.out.println("11 -- Inserir um novo kit");
        System.out.println("12 -- Listar todos os kits");
        System.out.println("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    
}
