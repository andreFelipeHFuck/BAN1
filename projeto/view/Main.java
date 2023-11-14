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
                    default:
                        break;
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                continue;
            }
        }while(op>0 && op < 7);
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
        System.out.println("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    
}
