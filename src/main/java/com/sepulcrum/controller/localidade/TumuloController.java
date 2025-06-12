package com.sepulcrum.controller.localidade;

import javax.swing.JOptionPane;
import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.comum.TelaSelecaoTumulo;
import com.sepulcrum.view.localidade.TumuloView;
import com.sepulcrum.dao.localidade.TumuloDAO;
import com.sepulcrum.model.localidade.Tumulo;

public class TumuloController {
    private TumuloDAO daoT = new TumuloDAO();
    private ValidadorCamposInterface vc = new ValidarCampos();

    public void validarCampo(TumuloView tv){
        vc.validarCampo(tv.getJtfOne(), "Tipo");
        vc.validarCampo(tv.getJtfTwo(), "Situação");
        vc.validarCampo(tv.getJtfFourString(), "Rua");
        vc.validarCampo(tv.getJtfFiveString(), "Número");
        vc.validarCampo(tv.getJtfSix(), "CNPJ");
    }

    public void setTumulo(TumuloView tv){
        validarCampo(tv);

        Tumulo t = new Tumulo(
            tv.getJtfOne(),        // tipo
            tv.getJtfTwo(),        // situacao
            tv.getJtfThree(),      // dataOcupacao
            tv.getJtfFourString(), // rua
            tv.getJtfFiveString(), // numero
            tv.getJtfSix()         // cemCnpj
        );
        
        daoT.createTumulo(t);
    }

    public void selectTumulo(TelaSelecaoTumulo tst, int seletor, int seletorCrud, String num, String rua, String cnpj){
        Tumulo t = daoT.readTumulo(num, rua, cnpj);
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Túmulo de código " + num + rua + cnpj + " não encontrado.");
        } else {
            tst.dispose();
            TumuloView tv = new TumuloView(seletor, seletorCrud, num, rua, cnpj);
            getTumulo(tv, t);
        }
    }

    public void getTumulo(TumuloView tv, Tumulo t){
        tv.setJtfOne(t.getTipo());
        tv.setJtfTwo(t.getSituacao());
        tv.setJtfThree(t.getDataOcupacao());
        tv.setJtfFour(t.getRua());
        tv.setJtfFive(t.getNumero());
        tv.setJtfSix(t.getCemCnpj());
    }

    public void updateTumulo(TumuloView tv, String num, String rua, String cnpj){
        validarCampo(tv);

        Tumulo t = daoT.readTumulo(num, rua, cnpj);

        t.setTipo(tv.getJtfOne());
        t.setSituacao(tv.getJtfTwo());
        t.setDataOcupacao(tv.getJtfThree());
        t.setRua(tv.getJtfFourString());
        t.setNumero(tv.getJtfFiveString());
        t.setCemCnpj(tv.getJtfSix());
    }

    public void deleteTumulo(String num, String rua, String cnpj){
        daoT.readTumulo(num, rua, cnpj);
        daoT.deleteTumulo(num, rua, cnpj);
    }
}