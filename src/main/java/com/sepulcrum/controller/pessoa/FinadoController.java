package com.sepulcrum.controller.pessoa;

import javax.swing.JOptionPane;
import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.TelaRegistroGeral;
import com.sepulcrum.view.comum.TelaSelecao;
import com.sepulcrum.dao.pessoa.FinadoDAO;
import com.sepulcrum.model.pessoa.Finado;

public class FinadoController {
    private FinadoDAO daoF = new FinadoDAO();
    private ValidadorCamposInterface vc = new ValidarCampos();

    public void validarCampo(TelaRegistroGeral trg){
        vc.validarCampo(trg.getJtfFiveDate(), "Data Falecimento");
        vc.validarCampo(trg.getJtfSix(), "Causa da Morte");
        vc.validarCampo(trg.getJtfSevenString(), "Certidão de Óbito");
        vc.validarCampo(trg.getJtfEight(), "Rua do Túmulo");
        vc.validarCampo(trg.getJtfNine(), "Número do Túmulo");
    }

    public void setFinado(TelaRegistroGeral trg){
        validarCampo(trg);

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

        daoF.createFinado(fin);
    }

    public void selectFinado(TelaSelecao tsg, int seletor, int seletorCrud, int id){
        Finado fin = daoF.readFinado(id);
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

    public void updateFinado(TelaRegistroGeral trg, int id){
        validarCampo(trg);

        Finado fin = daoF.readFinado(id);

        fin.setNome(trg.getJtfOne());
        fin.setCpf(trg.getJtfTwo());
        fin.setRg(trg.getJtfThree());
        fin.setDataNascimento(trg.getJtfFourDate());
        fin.setDataFalecimento(trg.getJtfFiveDate());
        fin.setCausaMorte(trg.getJtfSix());
        fin.setCertidaoObito(trg.getJtfSevenString());
        fin.setTumRua(trg.getJtfEight());
        fin.setTumNumero(trg.getJtfNine());
    }

    public void deleteFinado(int id){
        daoF.readFinado(id);
        daoF.deleteFinado(id);
    }
}