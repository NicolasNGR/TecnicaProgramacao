package Model;

public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;
    private String status;
    private int categoriaId;
    private String categoriaNome;

    // Construtor vazio
    public Tarefa() {
    }

    // Construtor usado para criar tarefa nova
    public Tarefa(String titulo, String descricao, String status, int categoriaId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.categoriaId = categoriaId;
    }

    // Construtor usado quando vem do banco
    public Tarefa(int id, String titulo, String descricao, String status, int categoriaId, String categoriaNome) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.categoriaId = categoriaId;
        this.categoriaNome = categoriaNome;
    }

    // GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }


    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Título: " + titulo +
                " | Descrição: " + descricao +
                " | Status: " + status +
                " | Categoria: " + categoriaNome;
    }
}