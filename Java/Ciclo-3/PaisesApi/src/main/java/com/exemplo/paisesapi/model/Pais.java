package com.exemplo.paisesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pais {

    @JsonProperty("name")
    private NomePais nomePais;

    private List<String> capital;
    private String region;
    private String subregion;
    private Long population;
    private Double area;

    @JsonProperty("flags")
    private Bandeira bandeira;

    private Map<String, String> languages;

    public String getNomeComum() {
        return nomePais != null ? nomePais.getCommon() : "Não informado";
    }

    public String getNomeOficial() {
        return nomePais != null ? nomePais.getOfficial() : "Não informado";
    }

    public String getCapital() {
        return (capital != null && !capital.isEmpty()) ? String.join(", ", capital) : "Não informada";
    }

    public String getRegiao() {
        return region != null ? region : "Não informada";
    }

    public String getSubRegiao() {
        return subregion != null ? subregion : "Não informada";
    }

    public Long getPopulacao() {
        return population;
    }

    public Double getArea() {
        return area;
    }

    public String getUrlBandeira() {
        return bandeira != null ? bandeira.getPng() : "";
    }

    public String getIdiomas() {
        return (languages != null && !languages.isEmpty())
                ? languages.values().stream().collect(Collectors.joining(", "))
                : "Não informado";
    }

    public void setNomePais(NomePais nomePais) {
        this.nomePais = nomePais;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NomePais {
        private String common;
        private String official;

        public String getCommon() {
            return common;
        }

        public void setCommon(String common) {
            this.common = common;
        }

        public String getOfficial() {
            return official;
        }

        public void setOfficial(String official) {
            this.official = official;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Bandeira {
        private String png;

        public String getPng() {
            return png;
        }

        public void setPng(String png) {
            this.png = png;
        }
    }
}
