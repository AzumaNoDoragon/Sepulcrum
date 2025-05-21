package com.sepulcrum.model.servicos.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.sepulcrum.model.assets.ValidarCampos;
import com.sepulcrum.model.servicos.model.Exumacao;
import com.sepulcrum.model.servicos.view.TelaRegistroServico;
import com.sepulcrum.model.view.TelaGerenciadorGeral;

public class GerenciadorExumacao {
    private static List<Exumacao> listE = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void setExumacao(TelaRegistroServico trs){
        vc.validarCampo(trs.getJtfOne(), "Tipo de Servico");
        vc.validarCampo(trs.getJtfTen(), "Certidão de Óbito");
        // Continuar

        Exumacao e = new Exumacao(
            trs.getJtfOne(),   // tipoServicoStr
            trs.getJtfTwo(),   // descricao
            trs.getJtfThree(), // statusServicoStr
            trs.getJtfFour(),  // dataServico
            trs.getJtfFive(),  // tumRua
            trs.getJtfSix(),   // tumNumero
            trs.getJtfSeven(), // cemCnpj
            trs.getJtfEight(), // admCpf
            trs.getJtfTen()    // finCertidaoObito
        );

        // Continuar

        listE.add(e);
    }

    public Exumacao buscaExumacao(int id) {
        for (Exumacao e : listE) {
            if (e.getIdServico() == id) {
                return e;
            }
        }
        return null;
    }

    public void selectExumacao(int seletor, int seletorCrud, int id){
        Exumacao e = buscaExumacao(id);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Exumação com id " + id + " não encontrado.");
            new TelaGerenciadorGeral(seletor);
        } else {
            TelaRegistroServico trs = new TelaRegistroServico(seletor, seletorCrud, id);
            getExumacao(trs, e);
        }
    }

    public void getExumacao(TelaRegistroServico trs, Exumacao e){
        trs.setJtfOne(e.getTipoServico());
        trs.setJtfTwo(e.getDescricao());
        trs.setJtfThree(e.getStatusServico());
        trs.setJtfFour(e.getDataServico());
        trs.setJtfFive(e.getTumRua());
        trs.setJtfSix(e.getTumNumero());
        trs.setJtfSeven(e.getCemCnpj());
        trs.setJtfEight(e.getAdmCpf());
        trs.setJtfNine(e.getInformacoesAdicionais());
        trs.setJtfTen(e.getFinCertidaoObito());
        // Conferir
    }
}