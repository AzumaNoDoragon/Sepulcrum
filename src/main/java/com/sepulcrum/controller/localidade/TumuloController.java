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
        vc.validarCampo(tv.getJtfFour(), "Rua");
        vc.validarCampo(tv.getJtfFive(), "Número");
        vc.validarCampo(tv.getJtfSix(), "CNPJ");
        vc.validarCampo(tv.getJtfSix(), "CPF do comprador");
    }

    public void setTumulo(TumuloView tv){
        validarCampo(tv);

        Tumulo t = new Tumulo(
            tv.getJtfOne(),   // tipo
            tv.getJtfTwo(),   // situacao
            tv.getJtfThree(), // dataOcupacao
            tv.getJtfFour(),  // rua
            tv.getJtfFive(),  // numero
            tv.getJtfSix()    // cemCnpj
        );
        t.setFamCpf(tv.getJtfSeven()); // famCpf
        
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
        tv.setJtfSeven(t.getFamCpf());
    }

    public void updateTumulo(TumuloView tv, String num, String rua, String cnpj){
        validarCampo(tv);

        Tumulo t = daoT.readTumulo(num, rua, cnpj);

        t.setTipo(tv.getJtfOne());
        t.setSituacao(tv.getJtfTwo());
        t.setDataOcupacao(tv.getJtfThree());
        t.setRua(tv.getJtfFour());
        t.setNumero(tv.getJtfFive());
        t.setCemCnpj(tv.getJtfSix());
        t.setFamCpf(tv.getJtfSeven());
    }

    public void deleteTumulo(String num, String rua, String cnpj){
        daoT.readTumulo(num, rua, cnpj);
        daoT.deleteTumulo(num, rua, cnpj);
    }
}