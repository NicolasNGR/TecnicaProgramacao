package br.com.pratica.climaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.pratica.climaapi.dao.ClimaDao;
import br.com.pratica.climaapi.model.ClimaDados;

@Service
public class ClimaService {

 @Autowired
 private ClimaDao dao;

 public ClimaDados buscar(double lat,double lon){
  return dao.buscar(lat,lon);
 }
}
