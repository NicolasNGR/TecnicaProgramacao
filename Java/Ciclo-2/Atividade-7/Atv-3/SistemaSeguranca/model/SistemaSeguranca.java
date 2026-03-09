package SistemaSeguranca.model;

public class SistemaSeguranca implements IAutenticavel {
	
    private final String usuarioCorreto = "admin";
    private final String senhaCorreta = "1234";
    private boolean autenticado = false;

    @Override
    public boolean login(String usuario, String senha) {
        if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
            autenticado = true;
            System.out.println("✅ Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("❌ Usuário ou senha incorretos. Tente novamente.");
            return false;
        }
    }

    @Override
    public void logout() {
        if (autenticado) {
            autenticado = false;
            System.out.println("👋 Logout realizado com sucesso!");
        } else {
            System.out.println("⚠️ Nenhum usuário está logado.");
        }
    }

    public boolean isAutenticado() {
        return autenticado;
    }
}

