package com.sepulcrum.model.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.sepulcrum.model.view.TelaRegistroGeral;
import com.sepulcrum.model.view.TelaSelectGeral;
import com.sepulcrum.model.assets.ValidarCampos;
import com.sepulcrum.model.pessoas.Finado;

public class GerenciadorFinado {
    private static List<Finado> listFin = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void validarCampo(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfFiveDate(), "Data Falecimento");
        vc.validarCampo(trg.getJtfSix(), "Causa da Morte");
        vc.validarCampo(trg.getJtfSevenString(), "Certidão de Óbito");
        vc.validarCampo(trg.getJtfEight(), "Rua do Túmulo");
        vc.validarCampo(trg.getJtfNine(), "Número do Túmulo");
    }

    public int setFinado(TelaRegistroGeral trg){
        validarCampo(trg);

        int idCertidaoObito = verificarObjeto(Integer.parseInt(trg.getJtfSevenString()));
        if(idCertidaoObito == 1){
            return 1;
        }

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

        listFin.add(fin);
        return 0;
    }

    public int verificarObjeto(int id){
        Finado fin = buscaFinado(id);
        if(fin != null){
            JOptionPane.showMessageDialog(null, "Finado com est a Certidao de Obito já existe!");
            return 1;
        }
        return 0;
    }

    public Finado buscaFinado(int id) {
        for (Finado fin : listFin) {
            if (fin.getCertidaoObito().equals(Integer.toString(id))) {
                return fin;
            }
        }
        return null;
    }

    public void SelectFinado(TelaSelectGeral tsg, int seletor, int seletorCrud, int id){
        Finado fin = buscaFinado(id);
        if (fin == null) {
            JOptionPane.showMessageDialog(null, "Finado com Certidão de Óbito " + id + " não encontrado.");
        } else {
            tsg.dispose();
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

    public int updateFinado(TelaRegistroGeral trg, int id){
        validarCampo(trg);

        Finado fin = buscaFinado(id);

        if(!trg.getJtfSevenString().equals(fin.getCertidaoObito())){
            int certidaoObitoNovo = verificarObjeto(Integer.parseInt(trg.getJtfNine()));
            if(certidaoObitoNovo == 1){
                return 1;
            }
        }

        fin.setNome(trg.getJtfOne());
        fin.setCpf(trg.getJtfTwo());
        fin.setRg(trg.getJtfThree());
        fin.setDataNascimento(trg.getJtfFourDate());
        fin.setDataFalecimento(trg.getJtfFiveDate());
        fin.setCausaMorte(trg.getJtfSix());
        fin.setCertidaoObito(trg.getJtfSevenString());
        fin.setTumRua(trg.getJtfEight());
        fin.setTumNumero(trg.getJtfNine());

        listFin.add(fin);
        return 0;
    }

    public void deleteFinado(int id){
        Finado fin = buscaFinado(id);
        listFin.remove(fin);
    }
}