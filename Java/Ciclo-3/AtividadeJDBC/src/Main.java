import DAO.Conexao;
import View.menuConsole;

public class Main {
    public static void main(String[] args) {
        Conexao.inicializarBanco();
        menuConsole menu = new menuConsole();
        menu.iniciar();
    }
}