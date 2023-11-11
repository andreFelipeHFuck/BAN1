package projeto.apresentacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import projeto.persistencia.Conexao;

public class Main {

    public static void main(String[] args) {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
    }
    
}
