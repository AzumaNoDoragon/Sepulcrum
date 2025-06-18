package com.sepulcrum.controller.pessoa;

import javax.swing.JOptionPane;
import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.comum.TelaSelecao;
import com.sepulcrum.view.pessoa.FamiliarView;
import com.sepulcrum.dao.pessoa.FamiliarDAO;
import com.sepulcrum.model.pessoa.Familiar;

public class FamiliarController{
    private FamiliarDAO daoF = new FamiliarDAO();
    private ValidadorCamposInterface vc = new ValidarCampos();

    public void validarCampo(FamiliarView famV){
        vc.validarCampo(famV.getJtfOne(), "Nome");
        vc.validarCampo(famV.getJtfTwo(), "Cpf");
        vc.validarCampo(famV.getJtfFour(), "Data de Nascimento");
        vc.validarCampo(famV.getJtfFive(), "Grau de Parentesco");
        vc.validarCampo(famV.getJtfSix(), "Email");
        vc.validarCampo(famV.getJtfSeven(), "Telefone");
    }
    
    public void setFamiliar(FamiliarView famV){
        validarCampo(famV);

        Familiar fam = new Familiar(
            famV.getJtfOne(),  // nome
            famV.getJtfTwo(),  // cpf
            famV.getJtfFour(), // dataNascimento
            famV.getJtfSix(),  // email
            famV.getJtfSeven() // telefone
        );
        fam.setRg(famV.getJtfThree());            // RG
        fam.setGrauParentesco(famV.getJtfFive()); // grauParentesco
        fam.setCertidaoObito(famV.getJtfEight()); // certidaoObito

        daoF.createFamiliar(fam);
    }

    public void selectFamiliar(TelaSelecao tsg, int seletor, int seletorCrud, String id){
        Familiar fam = daoF.readFamiliar(id);
        if (fam == null) {
            JOptionPane.showMessageDialog(null, "Familiar com CPF " + id + " não encontrado.");
        } else {
            tsg.dispose();
            FamiliarView famV = new FamiliarView(seletor, seletorCrud, id);
            getFamiliar(famV, fam);
        }
    }

    public void getFamiliar(FamiliarView famV, Familiar fam){
        famV.setJtfOne(fam.getNome());
        famV.setJtfTwo(fam.getCpf());
        famV.setJtfThree(fam.getRg());
        famV.setJtfFour(fam.getDataNascimento());
        famV.setJtfSix(fam.getEmail());
        famV.setJtfFive(fam.getGrauParentesco());
        famV.setJtfSeven(fam.getTelefone());
        famV.setJtfEight(fam.getCertidaoObito());
    }

    public void updateFamiliar(FamiliarView famV, String id){
        validarCampo(famV);

        Familiar fam = daoF.readFamiliar(id);

        fam.setNome(famV.getJtfOne());
        fam.setCpf(famV.getJtfTwo());
        fam.setRg(famV.getJtfThree());
        fam.setDataNascimento(famV.getJtfFour());
        fam.setEmail(famV.getJtfSix());
        fam.setGrauParentesco(famV.getJtfFive());
        fam.setTelefone(famV.getJtfSeven());
        fam.setCertidaoObito(famV.getJtfEight());
    }

    public void deleteFamiliar(String id){
        daoF.readFamiliar(id);
        daoF.deleteFamiliar(id);;
    }
}