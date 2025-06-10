package com.sepulcrum.utils;

import java.sql.Date;

public interface ValidadorCamposInterface {
    void validarCampo(String campo, String nomeCampo);
    void validarCampo(Date campo, String nomeCampo);
}