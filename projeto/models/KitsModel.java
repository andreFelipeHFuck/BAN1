package projeto.models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import projeto.dados.Kits;
import projeto.dados.KitsProdutos;
import projeto.dados.KitsQuantidade;


public class KitsModel {
    
    public static void create(Kits k, Connection con) throws SQLException{
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO Kits (codKitProduto, codProduto, quantidadeProduto, nome) VALUES (?,?,?,?)");
        st.setInt(2, k.getCodKitProduto());
        st.setInt(3, k.getCodProduto());
        st.setInt(4, k.getQuantidadeProduto());
        st.setString(5, k.getNome());
        st.execute();
        st.close();
    }
    public static HashSet<Kits> listAll(Connection con) throws SQLException{
        Statement st;
        HashSet<Kits> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT codKit, codKitProduto, codProduto, quantidadeProduto, nome FROM Kits";
        ResultSet result = st.executeQuery(sql);
        while(result.next()){
            list.add(new Kits(
                    result.getInt(1), 
                    result.getInt(2), 
                    result.getInt(3),                     
                    result.getInt(4),
                    result.getString(5)));
        }
        return list;
    }
    public static HashSet<KitsProdutos> listarKitsProdutos(Connection con) throws SQLException {
        Statement st;
        HashSet<KitsProdutos> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT k.nome AS nomeKit, " +
            "       k.quantidadeProduto, " +
            "       p.nome AS nomeProduto, " +
            "       p.descricao, " +
            "       p.datasheet " +
            "FROM Kits k " +
            "INNER JOIN Produtos p ON k.codProduto = p.codProduto";
        ResultSet result = st.executeQuery(sql);

        while (result.next()) {
            list.add(new KitsProdutos(
                    result.getString(1),
                    result.getString(4),
                    result.getString(5),
                    result.getString(3),
                    result.getInt(2)));
        }
        return list;
    }
    public static HashSet<KitsQuantidade> listarKitsQuantidades(Connection con) throws SQLException {
        Statement st;
        HashSet<KitsQuantidade> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT k.codKit,k.nome AS nomeKit,k.quantidadeProduto, (SELECT SUM(quantidadeProduto) FROM Kits) AS totalProdutosEmKits FROM Kits k";
        ResultSet result = st.executeQuery(sql);

        while (result.next()) {
            list.add(new KitsQuantidade(
                    result.getInt(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4)));
        }
        return list;
    }
}
