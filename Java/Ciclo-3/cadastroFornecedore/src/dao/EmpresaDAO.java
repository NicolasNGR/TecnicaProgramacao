package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Empresa;

public class EmpresaDAO {

    public void salvar(Empresa empresa) {

        String sql =
        "INSERT INTO empresas (cnpj, razao_social, nome_fantasia, logradouro, municipio, uf, cnae) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, empresa.getCnpj());
            stmt.setString(2, empresa.getRazaoSocial());
            stmt.setString(3, empresa.getNomeFantasia());
            stmt.setString(4, empresa.getLogradouro());
            stmt.setString(5, empresa.getMunicipio());
            stmt.setString(6, empresa.getUf());
            stmt.setString(7, empresa.getCnae());

            stmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Erro ao salvar empresa");

        }
    }
}