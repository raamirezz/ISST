package com.isst.demo.service;

import java.util.List;

public interface ComunidadService {
    void guardarComunidad(int codigo, String calle, String provincia, List<String> instalaciones);
}
