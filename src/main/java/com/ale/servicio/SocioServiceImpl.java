package com.ale.servicio;

import com.ale.dao.SocioDao;
import com.ale.domain.Socio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    private SocioDao socioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Socio> listarSocios() {
        return (List<Socio>) socioDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Socio socio) {
        socioDao.save(socio);
    }

    @Override
    @Transactional
    public void eliminar(Socio socio) {
        socioDao.delete(socio);
    }

    @Override
    @Transactional(readOnly = true)
    public Socio encontrarSocio(Socio socio) {
        return socioDao.findById(socio.getIdSocio()).orElse(null);
    }

}
