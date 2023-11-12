package projeto.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import projeto.dados.PessoaFisica;

public class PessoaFisicaDAO {
    
    public static void create(PessoaFisica p, Connection con) throws SQLException{
        PreparedStatement st;

            st = con.prepareStatement("INSERT INTO clientes (tipo, nome, datanascimento, sexo, email, telefone, rua, bairro, cep, cpf)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        
            st.setInt(1, 1);
            st.setString(2, p.getNome());
            st.setDate(3, p.getDataNacimento());
            st.setString(4, p.getSexo());
            st.setString(5, p.getEmail());
            st.setString(6, p.getTelefone());
            st.setString(7, p.getRua());
            st.setString(8, p.getBairro());
            st.setInt(9, p.getCep());
            st.setString(10, p.getCpf());
            st.execute();
            st.close();
    }       
}
