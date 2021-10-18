package com.ale.servicio;

import com.ale.domain.Socio;
import java.util.List;

public interface SocioService {

    public List<Socio> listarSocios();

    public void guardar(Socio socio);

    public void eliminar(Socio socio);

    public Socio encontrarSocio(Socio socio);

}
