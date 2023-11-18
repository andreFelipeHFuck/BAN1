package projeto.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import projeto.dados.Compra;
import projeto.dados.MaisComprado;

public class CompraModel {
    
    public static void create(Compra c, Connection con) throws SQLException{
        PreparedStatement st;

            st = con.prepareStatement("INSERT INTO compra (codfornecedor, codproduto, quantidade, codtransportadora, data)" + 
                                      "VALUES(?, ?, ?, ?, ?)");

                st.setInt(1, c.getCodFornecedor());
                st.setInt(2, c.getCodProduto());
                st.setInt(3, c.getQuantidade());
                st.setInt(4, c.getCodTransportadora());
                st.setDate(5, c.getData());
                st.execute();
                st.close();
    }


    public static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();

            st = con.createStatement();
            String sql = "SELECT codcompra, codfornecedor, codproduto, quantidade, codtransportadora, data FROM compra";
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                list.add(
                    new Compra(
                        result.getInt(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getInt(4),
                        result.getInt(5),
                        result.getDate(6)
                    )
                );
            }

            return list;
    }

    public static HashSet listProdutosMaisComprados(Connection con) throws SQLException{
        Statement st;
        HashSet list = new HashSet();

            st = con.createStatement();
            String sql = "SELECT p.nome, c.quantidade, p.precounitcompra FROM produtos p JOIN compra c ON p.codproduto=c.codproduto " +
                         "ORDER BY p.precounitcompra DESC";
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                list.add(
                    new MaisComprado(
                        result.getString(1), 
                        result.getInt(2), 
                        result.getFloat(3))
                );
            }

            return list;
    }
}
