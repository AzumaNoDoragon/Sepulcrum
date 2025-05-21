package com.sepulcrum.model.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.sepulcrum.model.view.TelaGerenciadorGeral;
import com.sepulcrum.model.view.TelaRegistroGeral;
import com.sepulcrum.model.assets.ValidarCampos;
import com.sepulcrum.model.pessoas.Finado;

public class GerenciadorFinado {
    private static List<Finado> ListFin = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void setFinado(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfFiveDate(), "Data Falecimento");
        vc.validarCampo(trg.getJtfSix(), "Causa da Morte");
        vc.validarCampo(trg.getJtfSevenString(), "Certidão de Óbito");
        vc.validarCampo(trg.getJtfEight(), "Rua do Túmulo");
        vc.validarCampo(trg.getJtfNine(), "Número do Túmulo");

        Finado fin = new Finado(
            trg.getJtfOne(),         // nome
            trg.getJtfTwo(),         // cpf
            trg.getJtfFourDate(),    // dataNascimento
            trg.getJtfFiveDate(),    // dataFalecimento
            trg.getJtfSevenString(), // certidaoObito
            trg.getJtfSix(),         // causaMorte
            trg.getJtfEight(),       // tumRua
            trg.getJtfNine()         // tumNumero
        );

        fin.setRg(trg.getJtfThree()); // Rg

        ListFin.add(fin);
    }

    public Finado buscaFinado(int id) {
        for (Finado fin : ListFin) {
            if (fin.getCertidaoObito().equals(Integer.toString(id))) {
                return fin;
            }
        }
        return null;
    }

    public void SelectFinado(int seletor, int seletorCrud, int id){
        Finado fin = buscaFinado(id);
        if (fin == null) {
            JOptionPane.showMessageDialog(null, "Finado com Certidão de Óbito " + id + " não encontrado.");
            new TelaGerenciadorGeral(seletor);
        } else {
            TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
            getFinado(trg, fin);
        }
    }

    public void getFinado(TelaRegistroGeral trg, Finado fin){
        trg.setJtfOne(fin.getNome());
        trg.setJtfTwo(fin.getCpf());
        trg.setJtfThree(fin.getRg());
        trg.setJtfFour(fin.getDataNascimento());
        trg.setJtfFive(fin.getDataFalecimento());
        trg.setJtfSix(fin.getCausaMorte());
        trg.setJtfSeven(fin.getCertidaoObito());
        trg.setJtfEight(fin.getTumRua());
        trg.setJtfNine(fin.getTumNumero());
    }
}