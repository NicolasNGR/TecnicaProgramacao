package br.com.pratica.climaapi.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import br.com.pratica.climaapi.model.ClimaDados;

@Repository
public class ClimaDao {

 public ClimaDados buscar(double lat,double lon){
  String url="https://api.open-meteo.com/v1/forecast?latitude="+lat+
  "&longitude="+lon+"&current=temperature_2m,windspeed_10m,weathercode";
  return new RestTemplate().getForObject(url,ClimaDados.class);
 }
}
