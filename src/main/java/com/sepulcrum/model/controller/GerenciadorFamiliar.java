package com.sepulcrum.model.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.sepulcrum.model.view.TelaGerenciadorGeral;
import com.sepulcrum.model.view.TelaRegistroGeral;
import com.sepulcrum.model.assets.ValidarCampos;
import com.sepulcrum.model.pessoas.Familiar;

public class GerenciadorFamiliar{
    private static List<Familiar> ListFam = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void setFamiliar(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfOne(), "Nome");
        vc.validarCampo(trg.getJtfTwo(), "Cpf");
        vc.validarCampo(trg.getJtfFourDate(), "Data de Nascimento");
        vc.validarCampo(trg.getJtfFiveString(), "Grau de Parentesco");
        vc.validarCampo(trg.getJtfSix(), "Email");
        vc.validarCampo(trg.getJtfSevenString(), "Telefone");
        vc.validarCampo(trg.getJtfEight(), "Certidão de Óbito");
        
        Familiar fam = new Familiar(
            trg.getJtfOne(),        // nome
            trg.getJtfTwo(),        // cpf
            trg.getJtfFourDate(),   // dataNascimento
            trg.getJtfSix(),        // email
            trg.getJtfSevenString() // telefone
        );

        fam.setRg(trg.getJtfThree());                  // RG
        fam.setGrauParentesco(trg.getJtfFiveString()); // grauParentesco
        fam.setCertidaoObito(trg.getJtfEight());       // certidaoObito

        ListFam.add(fam);
    }

    public Familiar buscaFamiliar(int id) {
        for (Familiar fam : ListFam) {
            if (fam.getCpf().equals(Integer.toString(id))) {
                return fam;
            }
        }
        return null;
    }

    public void SelectFamiliar(int seletor, int seletorCrud, int id){
        Familiar fam = buscaFamiliar(id);
        if (fam == null) {
            JOptionPane.showMessageDialog(null, "Familiar com CPF " + id + " não encontrado.");
            new TelaGerenciadorGeral(seletor);
        } else {
            TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
            getFamiliar(trg, fam);
        }
    }

    public void getFamiliar(TelaRegistroGeral trg, Familiar fam){
        trg.setJtfOne(fam.getNome());
        trg.setJtfTwo(fam.getCpf());
        trg.setJtfThree(fam.getRg());
        trg.setJtfFour(fam.getDataNascimento());
        trg.setJtfSix(fam.getEmail());
        trg.setJtfFive(fam.getGrauParentesco());
        trg.setJtfSeven(fam.getTelefone());
        trg.setJtfEight(fam.getCertidaoObito());
    }
}