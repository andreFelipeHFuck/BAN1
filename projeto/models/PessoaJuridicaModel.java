package projeto.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import projeto.dados.PessoaJuridica;

public class PessoaJuridicaModel {
    public static void create(PessoaJuridica p, Connection con) throws SQLException{
        PreparedStatement st;

        st = con.prepareStatement("INSERT INTO clientes (tipo, nome, email, telefone, rua, bairro, cep, cnpj)" +
                                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            st.setInt(1, 2);
            st.setString(2, p.getNome());
            st.setString(3, p.getEmail());
            st.setString(4, p.getTelefone());
            st.setString(5, p.getRua());
            st.setString(6, p.getBairro());
            st.setInt(7, p.getCep());
            st.setString(8, p.getCnpj());
            st.execute();
            st.close();
    }

    public static HashSet listAll(Connection con) throws SQLException{
        Statement st;
        HashSet list = new HashSet();

            st = con.createStatement();
            String sql = "SELECT codCliente, nome, email, telefone, rua, bairro, cep, cnpj FROM clientes WHERE tipo=2";
            ResultSet result = st.executeQuery(sql);

            while (result.next()){
                list.add(
                    new PessoaJuridica(
                         result.getInt(1),
                         2, 
                         result.getString(2), 
                         result.getString(3), 
                         result.getString(4), 
                         result.getString(5), 
                         result.getString(6),
                         result.getInt(7), 
                         result.getString(8)
                    )
                ); 

            }

            return list;

    }


}
