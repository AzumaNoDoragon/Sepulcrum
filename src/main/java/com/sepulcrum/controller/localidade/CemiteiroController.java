package com.sepulcrum.controller.localidade;

import javax.swing.JOptionPane;
import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.localidade.CemiterioView;
import com.sepulcrum.view.comum.TelaSelecao;
import com.sepulcrum.dao.localidade.CemiterioDAO;
import com.sepulcrum.model.localidade.Cemiterio;

public class CemiteiroController {
    private CemiterioDAO daoC = new CemiterioDAO();
    private ValidadorCamposInterface vc = new ValidarCampos();

    public void validarCampo(CemiterioView cv){
        vc.validarCampo(cv.getJtfOne(), "Nome");
        vc.validarCampo(cv.getJtfTwo(), "Estado");
        vc.validarCampo(cv.getJtfThree(), "Cidade");
        vc.validarCampo(cv.getJtfFourString(), "Rua");
        vc.validarCampo(cv.getJtfFiveString(), "Número");
        vc.validarCampo(cv.getJtfSix(), "Cep");
        vc.validarCampo(cv.getJtfEight(), "Telefone");
        vc.validarCampo(cv.getJtfNine(), "CNPJ");
        vc.validarCampo(cv.getJtfTen(), "Adiministrador");
    }

    public void setCemiterio(CemiterioView cv){
        validarCampo(cv);

        Cemiterio c = new Cemiterio(
            cv.getJtfOne(),        // nome
            cv.getJtfTwo(),        // estado
            cv.getJtfThree(),      // cidade
            cv.getJtfFourString(), // rua
            cv.getJtfFiveString(), // numero
            cv.getJtfSix(),        // cep
            cv.getJtfEight(),      // telefone
            cv.getJtfNine(),       // cnpj
            cv.getJtfTen()         // admCpf
        );
        c.setCapacidadeMax(cv.getJtfSevenInt()); // Capacidade Max

        daoC.createCemiterio(c);
    }

    public void selectCemiterio(TelaSelecao tsg, int seletor, int seletorCrud, String id){
        Cemiterio c = daoC.readCemiterio(id);
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Cemitério com CNPJ " + id + " não encontrado.");
        } else {
            tsg.dispose();
            CemiterioView cv = new CemiterioView(seletor, seletorCrud, id);
            getCemiterio(cv, c);
        }
    }

    public void getCemiterio(CemiterioView cv, Cemiterio c){
        cv.setJtfOne(c.getNome());
        cv.setJtfTwo(c.getEstado());
        cv.setJtfThree(c.getCidade());
        cv.setJtfFour(c.getRua());
        cv.setJtfFive(c.getNumero());
        cv.setJtfSix(c.getCep());
        cv.setJtfSeven(Integer.toString(c.getCapacidadeMax()));
        cv.setJtfEight(c.getTelefone());
        cv.setJtfNine(c.getCnpj());
        cv.setJtfTen(c.getAdmCpf());
    }

    public void updateCemiterio(CemiterioView cv, String id){
        validarCampo(cv);

        Cemiterio c = daoC.readCemiterio(id);

        c.setNome(cv.getJtfOne());
        c.setEstado(cv.getJtfTwo());
        c.setCidade(cv.getJtfThree());
        c.setRua(cv.getJtfFourString());
        c.setNumero(cv.getJtfFiveString());
        c.setCep(cv.getJtfSix());
        c.setCapacidadeMax(cv.getJtfSevenInt());
        c.setTelefone(cv.getJtfEight());
        c.setCnpj(cv.getJtfNine());
        c.setAdmCpf(cv.getJtfTen());

        daoC.updateCemiterio(c, id);
    }

    public void deleteCemiterio(String id){
        daoC.readCemiterio(id);
        daoC.deleteCemiterio(id);
    }
}