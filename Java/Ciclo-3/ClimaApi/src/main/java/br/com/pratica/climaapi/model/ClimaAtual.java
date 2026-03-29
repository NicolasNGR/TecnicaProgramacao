package br.com.pratica.climaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClimaAtual {

 @JsonProperty("temperature_2m")
 private Double temperatura;

 @JsonProperty("windspeed_10m")
 private Double vento;

 @JsonProperty("weathercode")
 private Integer code;

 public Double getTemperatura(){return temperatura;}
 public Double getVento(){return vento;}
 public Integer getCode(){return code;}

 public String getDescricao(){
  if(code==null) return "Desconhecido";
  if(code==0) return "Céu limpo";
  if(code<=3) return "Parcialmente nublado";
  if(code<=48) return "Neblina";
  if(code<=67) return "Chuva";
  if(code<=77) return "Neve";
  if(code<=82) return "Pancadas de chuva";
  return "Desconhecido";
 }
}
