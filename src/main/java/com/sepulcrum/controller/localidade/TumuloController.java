package com.sepulcrum.controller.localidade;

import javax.swing.JOptionPane;
import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.TelaRegistroGeral;
import com.sepulcrum.view.comum.TelaSelecao;
import com.sepulcrum.dao.localidade.TumuloDAO;
import com.sepulcrum.model.localidade.Tumulo;

public class TumuloController {
    private TumuloDAO daoT = new TumuloDAO();
    private ValidadorCamposInterface vc = new ValidarCampos();

    public void validarCampo(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfOne(), "Tipo");
        vc.validarCampo(trg.getJtfTwo(), "Situação");
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
        
        daoT.createTumulo(t);
    }

    public void selectTumulo(TelaSelecao tsg, int seletor, int seletorCrud, int id){
        Tumulo t = daoT.readTumulo(id);
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

    public void updateTumulo(TelaRegistroGeral trg, int id){
        validarCampo(trg);

        Tumulo t = daoT.readTumulo(id);

        t.setTipo(trg.getJtfOne());
        t.setSituacao(trg.getJtfTwo());
        t.setDataOcupacao(trg.getJtfThree());
        t.setRua(trg.getJtfFourString());
        t.setNumero(trg.getJtfFiveString());
        t.setCemCnpj(trg.getJtfSix());
    }

    public void deleteTumulo(int id){
        daoT.readTumulo(id);
        daoT.deleteTumulo(id);
    }
}