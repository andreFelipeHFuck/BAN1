package projeto.negocio;

import java.sql.Connection;
import java.sql.SQLException;


import projeto.persistencia.PessoaFisicaDAO;
import projeto.dados.PessoaFisica;

public class PessoaFisicaNegocio {

    public void createPessoFisica(PessoaFisica p, Connection con) throws SQLException{
        PessoaFisicaDAO.create(p, con);
    }
    
}
