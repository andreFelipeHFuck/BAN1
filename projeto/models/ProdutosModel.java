package projeto.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import projeto.dados.Produtos;

public class ProdutosModel {

    public static void create(Produtos produto, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO Produtos (codProduto, precoUnitVenda, precoUnitCompra, descricao, quantidade, datasheet) VALUES (?,?,?,?,?,?)");
        st.setInt(1, produto.getCodProduto());
        st.setInt(2, produto.getPrecoUnitVenda());
        st.setInt(3, produto.getPrecoUnitCompra());
        st.setString(4, produto.getDescricao());
        st.setInt(5, produto.getQuantidade());
        st.setString(6, produto.getDatasheet());
        st.execute();
        st.close();
    }

    public static HashSet<Produtos> listAll(Connection con) throws SQLException {
        Statement st;
        HashSet<Produtos> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT codProduto, precoUnitVenda, precoUnitCompra, descricao, quantidade, datasheet FROM Produtos";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new Produtos(
                    result.getInt(1),
                    result.getInt(2),
                    result.getInt(3),
                    result.getString(4),
                    result.getInt(5),
                    result.getString(6)));
        }
        return list;
    }
}
