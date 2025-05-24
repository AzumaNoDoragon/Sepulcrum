package com.sepulcrum.model.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.sepulcrum.model.view.TelaGerenciadorGeral;
import com.sepulcrum.model.view.TelaRegistroGeral;
import com.sepulcrum.model.assets.ValidarCampos;
import com.sepulcrum.model.localidade.Tumulo;

public class GerenciadorTumulo {
    private static List<Tumulo> listT = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void validarCampo(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfOne(), "Tipo");
        vc.validarCampo(trg.getJtfTwo(), "Situação");
        vc.validarCampo(trg.getJtfThree(), "Data de Ocupação");
        vc.validarCampo(trg.getJtfFourString(), "Rua");
        vc.validarCampo(trg.getJtfFiveString(), "Número");
        vc.validarCampo(trg.getJtfSix(), "CNPJ");
    }

    public void setTumulo(TelaRegistroGeral trg){
        validarCampo(trg);

        Tumulo t = new Tumulo(
            trg.getJtfOne(),        // tipo
            trg.getJtfTwo(),        // situacao
            trg.getJtfThree(),      // dataOcupacao
            trg.getJtfFourString(), // rua
            trg.getJtfFiveString(), // numero
            trg.getJtfSix()         // cemCnpj
        );
        
        listT.add(t);
    }

    public Tumulo buscaTumulo(int id) {
        for (Tumulo t : listT) {
            if (t.getNumero().equals(Integer.toString(id))) {
                return t;
            }
        }
        return null;
    }

    public void SelectTumulo(int seletor, int seletorCrud, int id){
        Tumulo t = buscaTumulo(id);
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Túmulo de código " + id + " não encontrado.");
            new TelaGerenciadorGeral(seletor);
        } else {
            TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
            getTumulo(trg, t);
        }
    }

    public void getTumulo(TelaRegistroGeral trg, Tumulo t){
        trg.setJtfOne(t.getTipo());
        trg.setJtfTwo(t.getSituacao());
        trg.setJtfThree(t.getDataOcupacao());
        trg.setJtfFour(t.getRua());
        trg.setJtfFive(t.getNumero());
        trg.setJtfSix(t.getCemCnpj());
    }
}