package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Socio;

public class SocioDAO {

    public void salvar(String cnpjEmpresa, List<Socio> socios) {

        String sql =
        "INSERT INTO socios (cnpj_empresa, nome_socio, cnpj_cpf, qualificacao) " +
        "VALUES (?, ?, ?, ?)";

        try (
            Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            for (Socio s : socios) {

                stmt.setString(1, cnpjEmpresa);
                stmt.setString(2, s.getNomeSocio());
                stmt.setString(3, s.getCnpjCpfDoSocio());
                stmt.setString(4, s.getQualificacaoSocio());

                stmt.executeUpdate();
            }

        } catch (SQLException e) {

            System.out.println("Erro ao salvar socios");

        }
    }
}