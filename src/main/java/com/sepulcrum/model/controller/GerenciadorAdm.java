package com.sepulcrum.model.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.sepulcrum.model.view.TelaRegistroGeral;
import com.sepulcrum.model.view.TelaSelectGeral;
import com.sepulcrum.model.assets.ValidarCampos;
import com.sepulcrum.model.pessoas.Adm;

public class GerenciadorAdm {
    private static List<Adm> listA = new ArrayList<>();
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

    public int setAdm(TelaRegistroGeral trg){
        validarCampo(trg);

        int idCpf = verificaObjeto(Integer.parseInt(trg.getJtfTwo()));
        if(idCpf == 1){
            return 1;
        }

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

        listA.add(a);
        return 0;
    }

    public int verificaObjeto(int id){
        Adm a = buscaAdm(id);
        if(a != null){
            JOptionPane.showMessageDialog(null, "Funcionario com este CPF já existe");
            return 1;
        }
        return 0;
    }

    public Adm buscaAdm(int id) {
        for (Adm a : listA) {
            if (a.getCpf().equals(Integer.toString(id))) {
                return a;
            }
        }
        return null;
    }

    public void selectAdm(TelaSelectGeral tsg, int seletor, int seletorCrud, int id){
        Adm a = buscaAdm(id);
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

        Adm a = buscaAdm(id);

        if(!trg.getJtfTwo().equals(a.getCpf())){
            int cpfNovo = verificaObjeto(Integer.parseInt(trg.getJtfTwo()));
            if(cpfNovo == 1){
                return 1;
            }
        }

        a.setNome(trg.getJtfOne());
        a.setCpf(trg.getJtfTwo());
        a.setRg(trg.getJtfThree());
        a.setDataNascimento(trg.getJtfFourDate());
        a.setDataContratacao(trg.getJtfFiveDate());
        a.setEmail(trg.getJtfSix());
        a.setTelefone(trg.getJtfSevenString());
        a.setCargo(trg.getJtfEight());
        a.setCemCnpj(trg.getJtfNine());

        listA.add(a);
        return 0;
    }

    public void deleteAdm(int id){
        Adm a = buscaAdm(id);
        listA.remove(a);
    }
}