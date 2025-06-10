package com.sepulcrum.controller;

import javax.swing.JOptionPane;

import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.TelaRegistroGeral;
import com.sepulcrum.view.TelaSelectGeral;
import com.sepulcrum.dao.DAOCemiterio;
import com.sepulcrum.model.localidade.Cemiterio;

public class GerenciadorCemiteiro {
    private DAOCemiterio daoC = new DAOCemiterio();
    private ValidadorCamposInterface vc = new ValidarCampos();

    public void validarCampo(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfOne(), "Nome");
        vc.validarCampo(trg.getJtfTwo(), "Estado");
        vc.validarCampo(trg.getJtfThree(), "Cidade");
        vc.validarCampo(trg.getJtfFourString(), "Rua");
        vc.validarCampo(trg.getJtfFiveString(), "Número");
        vc.validarCampo(trg.getJtfSix(), "Cep");
        vc.validarCampo(trg.getJtfEight(), "Telefone");
        vc.validarCampo(trg.getJtfNine(), "CNPJ");
        vc.validarCampo(trg.getJtfTen(), "Adiministrador");
    }

    public int setCemiterio(TelaRegistroGeral trg){
        validarCampo(trg);

        Cemiterio c = new Cemiterio(
            trg.getJtfOne(),        // nome
            trg.getJtfTwo(),        // estado
            trg.getJtfThree(),      // cidade
            trg.getJtfFourString(), // rua
            trg.getJtfFiveString(), // numero
            trg.getJtfSix(),        // cep
            trg.getJtfEight(),      // telefone
            trg.getJtfNine(),       // cnpj
            trg.getJtfTen()         // admCpf
        );
        c.setCapacidadeMax(trg.getJtfSevenInt()); // Capacidade Max

        daoC.createCemiterio(c);
        return 0;
    }

    public void selectCemiterio(TelaSelectGeral tsg, int seletor, int seletorCrud, int id){
        Cemiterio c = daoC.readCemiterio(id);
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Cemitério com CNPJ " + id + " não encontrado.");
        } else {
            tsg.dispose();
            TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
            getCemiterio(trg, c);
        }
    }

    public void getCemiterio(TelaRegistroGeral trg, Cemiterio c){
        trg.setJtfOne(c.getNome());
        trg.setJtfTwo(c.getEstado());
        trg.setJtfThree(c.getCidade());
        trg.setJtfFour(c.getRua());
        trg.setJtfFive(c.getNumero());
        trg.setJtfSix(c.getCep());
        trg.setJtfSeven(Integer.toString(c.getCapacidadeMax()));
        trg.setJtfEight(c.getTelefone());
        trg.setJtfNine(c.getCnpj());
        trg.setJtfTen(c.getAdmCpf());
    }

    public int updateCemiterio(TelaRegistroGeral trg, int id){
        validarCampo(trg);

        Cemiterio c = daoC.readCemiterio(id);

        c.setNome(trg.getJtfOne());
        c.setEstado(trg.getJtfTwo());
        c.setCidade(trg.getJtfThree());
        c.setRua(trg.getJtfFourString());
        c.setNumero(trg.getJtfFiveString());
        c.setCep(trg.getJtfSix());
        c.setCapacidadeMax(trg.getJtfSevenInt());
        c.setTelefone(trg.getJtfEight());
        c.setCnpj(trg.getJtfNine());
        c.setAdmCpf(trg.getJtfTen());

        daoC.updateCemiterio(c, id);

        return 0;
    }

    public void deleteCemiterio(int id){
        Cemiterio c = daoC.readCemiterio(id);
        daoC.deleteCemiterio(c, id);
    }
}