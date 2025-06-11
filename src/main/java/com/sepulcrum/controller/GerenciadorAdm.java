package com.sepulcrum.controller;

import javax.swing.JOptionPane;
import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.TelaRegistroGeral;
import com.sepulcrum.view.TelaSelectGeral;
import com.sepulcrum.dao.DAOAdm;
import com.sepulcrum.model.pessoas.Adm;

public class GerenciadorAdm {
    private DAOAdm daoA = new DAOAdm();
    private ValidadorCamposInterface vc = new ValidarCampos();

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

    public int setAdm(TelaRegistroGeral trg){
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

        daoA.createAdm(a);
        return 0;
    }

    public void selectAdm(TelaSelectGeral tsg, int seletor, int seletorCrud, int id){
        Adm a = daoA.readAdm(id);
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Coveiro com CPF " + id + " não encontrado.");
        } else {
            tsg.dispose();
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

    public int updateAdm(TelaRegistroGeral trg, int id){
        validarCampo(trg);

        Adm a = daoA.readAdm(id);

        a.setNome(trg.getJtfOne());
        a.setCpf(trg.getJtfTwo());
        a.setRg(trg.getJtfThree());
        a.setDataNascimento(trg.getJtfFourDate());
        a.setDataContratacao(trg.getJtfFiveDate());
        a.setEmail(trg.getJtfSix());
        a.setTelefone(trg.getJtfSevenString());
        a.setCargo(trg.getJtfEight());
        a.setCemCnpj(trg.getJtfNine());

        daoA.updateAdm(a, id);

        return 0;
    }

    public void deleteAdm(int id){
        Adm a = daoA.readAdm(id);
        daoA.deleteAdm(a, id);;
    }
}