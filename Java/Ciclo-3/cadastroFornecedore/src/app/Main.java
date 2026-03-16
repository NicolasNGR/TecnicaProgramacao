package app;

import java.util.Scanner;

import client.BrasilApiClient;
import dao.EmpresaDAO;
import dao.SocioDAO;
import model.Empresa;
import util.CnpjUtil;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();

            cnpj = CnpjUtil.limpar(cnpj);

            BrasilApiClient api = new BrasilApiClient();

            Empresa empresa = api.buscar(cnpj);

            EmpresaDAO empresaDAO = new EmpresaDAO();
            empresaDAO.salvar(empresa);

            if (empresa.getQsa() != null) {

                SocioDAO socioDAO = new SocioDAO();
                socioDAO.salvar(empresa.getCnpj(), empresa.getQsa());
            }

            System.out.println("Empresa cadastrada!");

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }

        scanner.close();
    }
}