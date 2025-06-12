package com.sepulcrum.controller.pessoa;

import javax.swing.JOptionPane;
import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.comum.TelaSelecao;
import com.sepulcrum.view.pessoa.FinadoView;
import com.sepulcrum.dao.pessoa.FinadoDAO;
import com.sepulcrum.model.pessoa.Finado;

public class FinadoController {
    private FinadoDAO daoF = new FinadoDAO();
    private ValidadorCamposInterface vc = new ValidarCampos();

    public void validarCampo(FinadoView finV){
        vc.validarCampo(finV.getJtfFiveDate(), "Data Falecimento");
        vc.validarCampo(finV.getJtfSix(), "Causa da Morte");
        vc.validarCampo(finV.getJtfSevenString(), "Certidão de Óbito");
        vc.validarCampo(finV.getJtfEight(), "Rua do Túmulo");
        vc.validarCampo(finV.getJtfNine(), "Número do Túmulo");
    }

    public void setFinado(FinadoView finV){
        validarCampo(finV);

        Finado fin = new Finado(
            finV.getJtfOne(),         // nome
            finV.getJtfTwo(),         // cpf
            finV.getJtfFourDate(),    // dataNascimento
            finV.getJtfFiveDate(),    // dataFalecimento
            finV.getJtfSevenString(), // certidaoObito
            finV.getJtfSix(),         // causaMorte
            finV.getJtfEight(),       // tumRua
            finV.getJtfNine()         // tumNumero
        );
        fin.setRg(finV.getJtfThree()); // Rg

        daoF.createFinado(fin);
    }

    public void selectFinado(TelaSelecao tsg, int seletor, int seletorCrud, int id){
        Finado fin = daoF.readFinado(id);
        if (fin == null) {
            JOptionPane.showMessageDialog(null, "Finado com Certidão de Óbito " + id + " não encontrado.");
        } else {
            tsg.dispose();
            FinadoView finV = new FinadoView(seletor, seletorCrud, id);
            getFinado(finV, fin);
        }
    }

    public void getFinado(FinadoView finV, Finado fin){
        finV.setJtfOne(fin.getNome());
        finV.setJtfTwo(fin.getCpf());
        finV.setJtfThree(fin.getRg());
        finV.setJtfFour(fin.getDataNascimento());
        finV.setJtfFive(fin.getDataFalecimento());
        finV.setJtfSix(fin.getCausaMorte());
        finV.setJtfSeven(fin.getCertidaoObito());
        finV.setJtfEight(fin.getTumRua());
        finV.setJtfNine(fin.getTumNumero());
    }

    public void updateFinado(FinadoView finV, int id){
        validarCampo(finV);

        Finado fin = daoF.readFinado(id);

        fin.setNome(finV.getJtfOne());
        fin.setCpf(finV.getJtfTwo());
        fin.setRg(finV.getJtfThree());
        fin.setDataNascimento(finV.getJtfFourDate());
        fin.setDataFalecimento(finV.getJtfFiveDate());
        fin.setCausaMorte(finV.getJtfSix());
        fin.setCertidaoObito(finV.getJtfSevenString());
        fin.setTumRua(finV.getJtfEight());
        fin.setTumNumero(finV.getJtfNine());
    }

    public void deleteFinado(int id){
        daoF.readFinado(id);
        daoF.deleteFinado(id);
    }
}