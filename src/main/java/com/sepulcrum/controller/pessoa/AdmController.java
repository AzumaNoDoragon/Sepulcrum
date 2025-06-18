package com.sepulcrum.controller.pessoa;

import javax.swing.JOptionPane;
import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.comum.TelaSelecao;
import com.sepulcrum.view.pessoa.AdmView;
import com.sepulcrum.dao.pessoa.AdmDAO;
import com.sepulcrum.model.pessoa.Adm;

public class AdmController {
    private AdmDAO daoA = new AdmDAO();
    private ValidadorCamposInterface vc = new ValidarCampos();

    public void validarCampo(AdmView av){
        vc.validarCampo(av.getJtfOne(), "Nome");
        vc.validarCampo(av.getJtfTwo(), "Cpf");
        vc.validarCampo(av.getJtfFour(), "Data de Nascimento");
        vc.validarCampo(av.getJtfFive(), "Data de Contratação");
        vc.validarCampo(av.getJtfSix(), "Email");
        vc.validarCampo(av.getJtfSeven(), "Telefone");
        vc.validarCampo(av.getJtfEight(), "Cargo");
    }

    public void setAdm(AdmView av){
        validarCampo(av);

        Adm a = new Adm(
            av.getJtfOne(),   // nome
            av.getJtfTwo(),   // cpf
            av.getJtfFour(),  // dataNascimento
            av.getJtfFive(),  // dataContratacao
            av.getJtfSix(),   // email
            av.getJtfSeven(), // telefone
            av.getJtfEight(), // cargo
            av.getJtfNine()   // cemCnpj
        );
        a.setRg(av.getJtfThree()); // RG

        daoA.createAdm(a);
    }

    public void selectAdm(TelaSelecao tsg, int seletor, int seletorCrud, String id){
        Adm a = daoA.readAdm(id);
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Coveiro com CPF " + id + " não encontrado.");
        } else {
            tsg.dispose();
            AdmView av = new AdmView(seletor, seletorCrud, id);
            getAdm(av, a);
        }    
    }

    public void getAdm(AdmView av, Adm a){
        av.setJtfOne(a.getNome());
        av.setJtfTwo(a.getCpf());
        av.setJtfThree(a.getRg());
        av.setJtfFour(a.getDataNascimento());
        av.setJtfFive(a.getDataContratacao());
        av.setJtfSix(a.getEmail());
        av.setJtfSeven(a.getTelefone());
        av.setJtfEight(a.getCargo());
        av.setJtfNine(a.getCemCnpj());
    }

    public void updateAdm(AdmView av, String id){
        validarCampo(av);

        Adm a = daoA.readAdm(id);

        a.setNome(av.getJtfOne());
        a.setCpf(av.getJtfTwo());
        a.setRg(av.getJtfThree());
        a.setDataNascimento(av.getJtfFour());
        a.setDataContratacao(av.getJtfFive());
        a.setEmail(av.getJtfSix());
        a.setTelefone(av.getJtfSeven());
        a.setCargo(av.getJtfEight());
        a.setCemCnpj(av.getJtfNine());

        daoA.updateAdm(a, id);
    }

    public void deleteAdm(String id){
        daoA.readAdm(id);
        daoA.deleteAdm(id);
    }
}