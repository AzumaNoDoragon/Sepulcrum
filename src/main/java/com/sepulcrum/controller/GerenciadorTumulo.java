package com.sepulcrum.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.TelaRegistroGeral;
import com.sepulcrum.view.TelaSelectGeral;
import com.sepulcrum.model.localidade.Tumulo;

public class GerenciadorTumulo {
    private static List<Tumulo> listT = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void validarCampo(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfOne(), "Tipo");
        vc.validarCampo(trg.getJtfTwo(), "Situação");
        vc.validarCampo(trg.getJtfFourString(), "Rua");
        vc.validarCampo(trg.getJtfFiveString(), "Número");
        vc.validarCampo(trg.getJtfSix(), "CNPJ");
    }

    public int setTumulo(TelaRegistroGeral trg){
        validarCampo(trg);

        int idNumero = verificarObjeto(Integer.parseInt(trg.getJtfFiveString()));
        if(idNumero == 1){
            return 1;
        }

        Tumulo t = new Tumulo(
            trg.getJtfOne(),        // tipo
            trg.getJtfTwo(),        // situacao
            trg.getJtfThree(),      // dataOcupacao
            trg.getJtfFourString(), // rua
            trg.getJtfFiveString(), // numero
            trg.getJtfSix()         // cemCnpj
        );
        
        listT.add(t);
        return 0;
    }

    public int verificarObjeto(int id){
        Tumulo t = buscaTumulo(id);
        if(t != null){
            JOptionPane.showMessageDialog(null, "Tumulo com este número já existe");
            return 1;
        }
        return 0;
    }

    public Tumulo buscaTumulo(int id) {
        for (Tumulo t : listT) {
            if (t.getNumero().equals(Integer.toString(id))) {
                return t;
            }
        }
        return null;
    }

    public void selectTumulo(TelaSelectGeral tsg, int seletor, int seletorCrud, int id){
        Tumulo t = buscaTumulo(id);
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Túmulo de código " + id + " não encontrado.");
        } else {
            tsg.dispose();
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

    public int updateTumulo(TelaRegistroGeral trg, int id){
        validarCampo(trg);

        Tumulo t = buscaTumulo(id);

        if(!trg.getJtfFiveString().equals(t.getNumero())){
            int numeroNovo = verificarObjeto(Integer.parseInt(trg.getJtfFiveString()));
            if(numeroNovo == 1){
                return 1;
            }
        }

        t.setTipo(trg.getJtfOne());
        t.setSituacao(trg.getJtfTwo());
        t.setDataOcupacao(trg.getJtfThree());
        t.setRua(trg.getJtfFourString());
        t.setNumero(trg.getJtfFiveString());
        t.setCemCnpj(trg.getJtfSix());

        return 0;
    }

    public void deleteTumulo(int id){
        Tumulo t = buscaTumulo(id);
        listT.remove(t);
    }
}