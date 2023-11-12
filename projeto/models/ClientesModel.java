package projeto.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import projeto.dados.Clientes;

public class ClientesModel {
    
    public static void create(Clientes cliente, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO Clientes (codCliente, email, telefone, nome, rua, cep, bairro, tipo, dataNascimento, sexo, cpf, cnpj) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        st.setInt(1, cliente.getCodCliente());
        st.setString(2, cliente.getEmail());
        st.setString(3, cliente.getTelefone());
        st.setString(4, cliente.getNome());
        st.setString(5, cliente.getRua());
        st.setInt(6, cliente.getCep());
        st.setString(7, cliente.getBairro());
        st.setInt(8, cliente.getTipo());
        st.setDate(9, cliente.getDataNascimento());
        st.setString(10, cliente.getSexo());
        st.setString(11, cliente.getCpf());
        st.setString(12, cliente.getCnpj());
        st.execute();
        st.close();
    }
    public static HashSet<Clientes> listAll(Connection con) throws SQLException {
        Statement st;
        HashSet<Clientes> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT codCliente, email, telefone, nome, rua, cep, bairro, tipo, dataNascimento, sexo, cpf, cnpj FROM Clientes";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new Clientes(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getInt(6),
                    result.getString(7),
                    result.getInt(8),
                    result.getDate(9),
                    result.getString(10),
                    result.getString(11),
                    result.getString(12)));
        }
        return list;
    }
}

