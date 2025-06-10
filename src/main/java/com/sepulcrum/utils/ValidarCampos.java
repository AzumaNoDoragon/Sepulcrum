package com.sepulcrum.utils;

import java.sql.Date;

public class ValidarCampos implements ValidadorCamposInterface {
    @Override
    public void validarCampo(String campo, String nomeCampo){
        if(campo == null || campo.trim().isEmpty()){
            throw new IllegalArgumentException("Campo '" + nomeCampo + "' vazio ou inválido.");
        }
    }

    @Override
    public void validarCampo(Date campo, String nomeCampo){
        if(campo == null){
            throw new IllegalArgumentException("Campo '" + nomeCampo + "' vazio ou inválido.");
        }
    }
}