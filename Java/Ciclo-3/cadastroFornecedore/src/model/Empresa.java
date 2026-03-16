package model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Empresa {

    private String cnpj;

    @SerializedName("razao_social")
    private String razaoSocial;

    @SerializedName("nome_fantasia")
    private String nomeFantasia;

    private String logradouro;
    private String municipio;
    private String uf;

    @SerializedName("cnae_fiscal_descricao")
    private String cnae;

    private List<Socio> qsa;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public List<Socio> getQsa() {
        return qsa;
    }

    public void setQsa(List<Socio> qsa) {
        this.qsa = qsa;
    }
}