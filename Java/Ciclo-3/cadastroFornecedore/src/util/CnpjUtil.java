package util;

public class CnpjUtil {

    public static String limpar(String cnpj) {
        return cnpj.replaceAll("\\D", "");
    }
}