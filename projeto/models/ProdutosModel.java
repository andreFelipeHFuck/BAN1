package projeto.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import projeto.dados.Produtos;

public class ProdutosModel {

    public static void create(Produtos produto, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO Produtos (precoUnitVenda, precoUnitCompra, descricao, quantidade, nome, datasheet) VALUES (?,?,?,?,?,?)");
        st.setFloat(1, produto.getPrecoUnitVenda());
        st.setFloat(2, produto.getPrecoUnitCompra());
        st.setString(3, produto.getDescricao());
        st.setInt(4, produto.getQuantidade());
        st.setString(5, produto.getNome());
        st.setString(6, produto.getDatasheet());
        
        st.execute();
        st.close();
    }

    public static HashSet<Produtos> listAll(Connection con) throws SQLException {
        Statement st;
        HashSet<Produtos> list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT codProduto, precoUnitVenda, precoUnitCompra, descricao, quantidade, nome, datasheet FROM produtos";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new Produtos(
                    result.getInt(1),
                    result.getFloat(2),
                    result.getFloat(3),
                    result.getString(4),
                    result.getInt(5),
                    result.getString(6),
                    result.getString(7)));
        }
        return list;
    }

    public static ArrayList<Produtos> listAllArray(Connection con) throws SQLException {
        Statement st;
        ArrayList<Produtos> list = new ArrayList();
        st = con.createStatement();
        String sql = "SELECT codProduto, precoUnitVenda, precoUnitCompra, descricao, quantidade, nome, datasheet FROM produtos";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new Produtos(
                    result.getInt(1),
                    result.getFloat(2),
                    result.getFloat(3),
                    result.getString(4),
                    result.getInt(5),
                    result.getString(6),
                    result.getString(7)));
        }
        return list;
    }

    public static String getNomeProduto(int codProduto, Connection con) throws SQLException{
        Statement st;
        st = con.createStatement();

        String sql = "SELECT nome FROM produtos WHERE codproduto= " + codProduto;
        ResultSet result = st.executeQuery(sql);
        result.next();

        return result.getString(1);
    }
}
