package projeto.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import projeto.dados.Fornecedor;

public class FornecedorModel {

    public static void create(Fornecedor fornecedor, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO Fornecedor ( nome, cnpj, email) VALUES (?,?,?)");
        st.setString(1, fornecedor.getNome());
        st.setString(2, fornecedor.getCnpj());
        st.setString(3, fornecedor.getEmail());
        st.execute();
        st.close();
    }
    public static HashSet<Fornecedor> listAll(Connection con) throws SQLException {
        Statement st;
        HashSet<Fornecedor> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT codFornecedor, nome, cnpj, email FROM Fornecedor";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new Fornecedor(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)));
        }
        return list;
    }
}

