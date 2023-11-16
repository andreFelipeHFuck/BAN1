package projeto.models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import projeto.dados.Kits;


public class KitsModel {
    
    public static void create(Kits k, Connection con) throws SQLException{
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO Kits (codKit, codKitProduto, codProduto, quantidadeProduto, nome) VALUES (?,?,?,?,?)");
        st.setInt(1, k.getCodKit());
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
        String sql = "SELECT codKitProduto, codProduto, quantidadeProduto, nome FROM Kits";
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
}
