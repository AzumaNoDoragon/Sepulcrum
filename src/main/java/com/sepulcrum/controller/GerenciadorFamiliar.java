package com.sepulcrum.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.TelaRegistroGeral;
import com.sepulcrum.view.TelaSelectGeral;
import com.sepulcrum.model.pessoas.Familiar;

public class GerenciadorFamiliar{
    private static List<Familiar> listFam = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void validarCampo(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfOne(), "Nome");
        vc.validarCampo(trg.getJtfTwo(), "Cpf");
        vc.validarCampo(trg.getJtfFourDate(), "Data de Nascimento");
        vc.validarCampo(trg.getJtfFiveString(), "Grau de Parentesco");
        vc.validarCampo(trg.getJtfSix(), "Email");
        vc.validarCampo(trg.getJtfSevenString(), "Telefone");
        vc.validarCampo(trg.getJtfEight(), "Certidão de Óbito");
    }
    
    public int setFamiliar(TelaRegistroGeral trg){
        validarCampo(trg);

        int idCpf = verificarObjeto(Integer.parseInt(trg.getJtfTwo()));
        if(idCpf == 1){
            return 1;
        }

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

        listFam.add(fam);
        return 0;
    }

    public int verificarObjeto(int id){
        Familiar fam = buscaFamiliar(id);
        if(fam != null){
            JOptionPane.showMessageDialog(null, "Familiar com este CPF já existe!");
            return 1;
        }
        return 0;
    }

    public Familiar buscaFamiliar(int id) {
        for (Familiar fam : listFam) {
            if (fam.getCpf().equals(Integer.toString(id))) {
                return fam;
            }
        }
        return null;
    }

    public void selectFamiliar(TelaSelectGeral tsg, int seletor, int seletorCrud, int id){
        Familiar fam = buscaFamiliar(id);
        if (fam == null) {
            JOptionPane.showMessageDialog(null, "Familiar com CPF " + id + " não encontrado.");
        } else {
            tsg.dispose();
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

    public int updateFamiliar(TelaRegistroGeral trg, int id){
        validarCampo(trg);

        Familiar fam = buscaFamiliar(id);

        if(!trg.getJtfTwo().equals(fam.getCpf())){
            int cpfNovo = verificarObjeto(Integer.parseInt(trg.getJtfTwo()));
            if(cpfNovo == 1){
                return 1;
            }
        }

        fam.setNome(trg.getJtfOne());
        fam.setCpf(trg.getJtfTwo());
        fam.setRg(trg.getJtfThree());
        fam.setDataNascimento(trg.getJtfFourDate());
        fam.setEmail(trg.getJtfSix());
        fam.setGrauParentesco(trg.getJtfFiveString());
        fam.setTelefone(trg.getJtfSevenString());
        fam.setCertidaoObito(trg.getJtfEight());

        return 0;
    }

    public void deleteFamiliar(int id){
        Familiar fam = buscaFamiliar(id);
        listFam.remove(fam);
    }
}