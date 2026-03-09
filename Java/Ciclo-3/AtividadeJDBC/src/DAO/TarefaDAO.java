package DAO;

import Model.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    public void inserir(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas(titulo, descricao, status, categoria_id) VALUES(?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarefa.getTitulo());
            pstmt.setString(2, tarefa.getDescricao());
            pstmt.setString(3, tarefa.getStatus());
            pstmt.setInt(4, tarefa.getCategoriaId());
            pstmt.executeUpdate();

            System.out.println("Tarefa cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar tarefa: " + e.getMessage());
        }
    }

    public List<Tarefa> listarTodas() {
        List<Tarefa> tarefas = new ArrayList<>();

        String sql = """
                SELECT t.id, t.titulo, t.descricao, t.status, t.categoria_id, c.nome AS categoria_nome
                FROM tarefas t
                INNER JOIN categorias c ON t.categoria_id = c.id
                ORDER BY t.id
                """;

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Tarefa t = new Tarefa(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("status"),
                        rs.getInt("categoria_id"),
                        rs.getString("categoria_nome")
                );
                tarefas.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar tarefas: " + e.getMessage());
        }

        return tarefas;
    }

    public List<Tarefa> listarPorStatus(String status) {
        List<Tarefa> tarefas = new ArrayList<>();

        String sql = """
                SELECT t.id, t.titulo, t.descricao, t.status, t.categoria_id, c.nome AS categoria_nome
                FROM tarefas t
                INNER JOIN categorias c ON t.categoria_id = c.id
                WHERE t.status = ?
                ORDER BY t.id
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, status);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Tarefa t = new Tarefa(
                		rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("status"),
                        rs.getInt("categoria_id"),
                        rs.getString("categoria_nome")
                );
                tarefas.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar por status: " + e.getMessage());
        }

        return tarefas;
    }

    public List<Tarefa> listarPorCategoria(int categoriaId) {
        List<Tarefa> tarefas = new ArrayList<>();

        String sql = """
                SELECT t.id, t.titulo, t.descricao, t.status, t.categoria_id, c.nome AS categoria_nome
                FROM tarefas t
                INNER JOIN categorias c ON t.categoria_id = c.id
                WHERE c.id = ?
                ORDER BY t.id
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, categoriaId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Tarefa t = new Tarefa(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("status"),
                        rs.getInt("categoria_id"),
                        rs.getString("categoria_nome")
                );
                tarefas.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar por categoria: " + e.getMessage());
        }

        return tarefas;
    }

    public boolean atualizar(Tarefa tarefa) {
        String sql = "UPDATE tarefas SET titulo = ?, descricao = ?, categoria_id = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarefa.getTitulo());
            pstmt.setString(2, tarefa.getDescricao());
            pstmt.setInt(3, tarefa.getCategoriaId());
            pstmt.setInt(4, tarefa.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar tarefa: " + e.getMessage());
        }

        return false;
    }

    public boolean concluir(int id) {
        String sql = "UPDATE tarefas SET status = 'CONCLUIDA' WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao concluir tarefa: " + e.getMessage());
        }

        return false;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir tarefa: " + e.getMessage());
        }

        return false;
    }

    public Tarefa buscarPorId(int id) {
        String sql = """
                SELECT t.id, t.titulo, t.descricao, t.status, t.categoria_id, c.nome AS categoria_nome
                FROM tarefas t
                INNER JOIN categorias c ON t.categoria_id = c.id
                WHERE t.id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Tarefa(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("status"),
                        rs.getInt("categoria_id"),
                        rs.getString("categoria_nome")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar tarefa: " + e.getMessage());
        }

        return null;
    }
}