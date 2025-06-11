package com.sepulcrum.controller.pessoa;

import javax.swing.JOptionPane;
import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.TelaRegistroGeral;
import com.sepulcrum.view.comum.TelaSelecao;
import com.sepulcrum.dao.pessoa.FamiliarDAO;
import com.sepulcrum.model.pessoa.Familiar;

public class FamiliarController{
    private FamiliarDAO daoF = new FamiliarDAO();
    private ValidadorCamposInterface vc = new ValidarCampos();

    public void validarCampo(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfOne(), "Nome");
        vc.validarCampo(trg.getJtfTwo(), "Cpf");
        vc.validarCampo(trg.getJtfFourDate(), "Data de Nascimento");
        vc.validarCampo(trg.getJtfFiveString(), "Grau de Parentesco");
        vc.validarCampo(trg.getJtfSix(), "Email");
        vc.validarCampo(trg.getJtfSevenString(), "Telefone");
        vc.validarCampo(trg.getJtfEight(), "Certidão de Óbito");
    }
    
    public void setFamiliar(TelaRegistroGeral trg){
        validarCampo(trg);

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

        daoF.createFamiliar(fam);
    }

    public void selectFamiliar(TelaSelecao tsg, int seletor, int seletorCrud, int id){
        Familiar fam = daoF.readFamiliar(id);
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

    public void updateFamiliar(TelaRegistroGeral trg, int id){
        validarCampo(trg);

        Familiar fam = daoF.readFamiliar(id);

        fam.setNome(trg.getJtfOne());
        fam.setCpf(trg.getJtfTwo());
        fam.setRg(trg.getJtfThree());
        fam.setDataNascimento(trg.getJtfFourDate());
        fam.setEmail(trg.getJtfSix());
        fam.setGrauParentesco(trg.getJtfFiveString());
        fam.setTelefone(trg.getJtfSevenString());
        fam.setCertidaoObito(trg.getJtfEight());
    }

    public void deleteFamiliar(int id){
        daoF.readFamiliar(id);
        daoF.deleteFamiliar(id);;
    }
}