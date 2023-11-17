package projeto.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import projeto.dados.Transportadora;

public class TransportadoraModel {
    public static void create(Transportadora t, Connection con) throws SQLException{
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO transportadora (nome, cnpj, email, custokm)" + "VALUES (?, ?, ?, ?)");

            st.setString(1, t.getNome());
            st.setString(2, t.getCnpj());
            st.setString(3, t.getEmail());
            st.setDouble(4, t.getCustoKM());
            st.execute();
            st.close();
    }

public static HashSet<Transportadora> listAll(Connection con) throws SQLException{
    Statement st;
    HashSet<Transportadora> list = new HashSet();
    st = con.createStatement();
    String sql = "SELECT codTransportadora, nome, cnpj, email, custokm FROM transportadora";
    ResultSet result = st.executeQuery(sql);
    while (result.next()) {
        list.add(
            new Transportadora(
                result.getInt(1),
                result.getString(2),
                result.getString(3),
                result.getString(4),
                result.getFloat(5)
            )
        );
    }

    return list;
}

public static String getNomeTransportadora(int codTransportadora, Connection con) throws SQLException{
    Statement st;
    st = con.createStatement();

    String sql = "SELECT nome FROM transportadora WHERE codtransportadora= " + codTransportadora;
    ResultSet result = st.executeQuery(sql);
    result.next();

    return result.getString(1);
}


}
