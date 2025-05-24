package com.sepulcrum.model.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.sepulcrum.model.view.TelaGerenciadorGeral;
import com.sepulcrum.model.view.TelaRegistroGeral;
import com.sepulcrum.model.assets.ValidarCampos;
import com.sepulcrum.model.pessoas.Adm;

public class GerenciadorAdm {
    private static List<Adm> ListA = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void validarCampo(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfOne(), "Nome");
        vc.validarCampo(trg.getJtfTwo(), "Cpf");
        vc.validarCampo(trg.getJtfFourDate(), "Data de Nascimento");
        vc.validarCampo(trg.getJtfFiveDate(), "Data de Contratação");
        vc.validarCampo(trg.getJtfSix(), "Email");
        vc.validarCampo(trg.getJtfSevenString(), "Telefone");
        vc.validarCampo(trg.getJtfEight(), "Cargo");
        vc.validarCampo(trg.getJtfNine(), "CNPJ");
    }

    public void setAdm(TelaRegistroGeral trg){
        validarCampo(trg);

        Adm a = new Adm(
            trg.getJtfOne(),         // nome
            trg.getJtfTwo(),         // cpf
            trg.getJtfFourDate(),    // dataNascimento
            trg.getJtfFiveDate(),    // dataContratacao
            trg.getJtfSix(),         // email
            trg.getJtfSevenString(), // telefone
            trg.getJtfEight(),       // cargo
            trg.getJtfNine()         // cemCnpj
        );

        a.setRg(trg.getJtfThree()); // RG

        ListA.add(a);
    }

    public Adm buscaAdm(int id) {
        for (Adm a : ListA) {
            if (a.getCpf().equals(Integer.toString(id))) {
                return a;
            }
        }
        return null;
    }

    public void SelectAdm(int seletor, int seletorCrud, int id){
        Adm a = buscaAdm(id);
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Coveiro com CPF " + id + " não encontrado.");
            new TelaGerenciadorGeral(seletor);
        } else {
            TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
            getAdm(trg, a);
        }    
    }

    public void getAdm(TelaRegistroGeral trg, Adm a){
        trg.setJtfOne(a.getNome());
        trg.setJtfTwo(a.getCpf());
        trg.setJtfThree(a.getRg());
        trg.setJtfFour(a.getDataNascimento());
        trg.setJtfFive(a.getDataContratacao());
        trg.setJtfSix(a.getEmail());
        trg.setJtfSeven(a.getTelefone());
        trg.setJtfEight(a.getCargo());
        trg.setJtfNine(a.getCemCnpj());
    }
}