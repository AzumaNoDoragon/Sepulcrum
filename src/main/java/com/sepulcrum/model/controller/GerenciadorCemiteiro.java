package com.sepulcrum.model.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.sepulcrum.model.view.TelaGerenciadorGeral;
import com.sepulcrum.model.view.TelaRegistroGeral;
import com.sepulcrum.model.assets.ValidarCampos;
import com.sepulcrum.model.localidade.Cemiterio;

public class GerenciadorCemiteiro {
    private static List<Cemiterio> listC = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void setCemiterio(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfOne(), "Nome");
        vc.validarCampo(trg.getJtfTwo(), "Estado");
        vc.validarCampo(trg.getJtfThree(), "Cidade");
        vc.validarCampo(trg.getJtfFourString(), "Rua");
        vc.validarCampo(trg.getJtfFiveString(), "Número");
        vc.validarCampo(trg.getJtfSix(), "Cep");
        vc.validarCampo(trg.getJtfEight(), "Telefone");
        vc.validarCampo(trg.getJtfNine(), "CNPJ");
        vc.validarCampo(trg.getJtfTen(), "Adiministrador");

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

        listC.add(c);
    }

    public Cemiterio buscaCemiterio(int id) {
        for (Cemiterio c : listC) {
            if (c.getCnpj().equals(Integer.toString(id))) {
                return c;
            }
        }
        return null;
    }

    public void SelectCemiterio(int seletor, int seletorCrud, int id){
        Cemiterio c = buscaCemiterio(id);
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Cemitério com CNPJ " + id + " não encontrado.");
            new TelaGerenciadorGeral(seletor);
        } else {
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
}