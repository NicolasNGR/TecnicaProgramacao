package br.com.pratica.climaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClimaDados {

 private Double latitude;
 private Double longitude;

 @JsonProperty("current")
 private ClimaAtual atual;

 public Double getLatitude(){return latitude;}
 public Double getLongitude(){return longitude;}
 public ClimaAtual getAtual(){return atual;}
}
