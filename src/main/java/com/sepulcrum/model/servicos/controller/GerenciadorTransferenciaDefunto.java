package com.sepulcrum.model.servicos.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.sepulcrum.model.assets.ValidarCampos;
import com.sepulcrum.model.servicos.model.TransferenciaDefunto;
import com.sepulcrum.model.servicos.view.TelaGerenciadorServico;
import com.sepulcrum.model.servicos.view.TelaRegistroServico;

public class GerenciadorTransferenciaDefunto {
    private static List<TransferenciaDefunto> listTD = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void setTransferenciaDefunto(TelaRegistroServico trs){
        vc.validarCampo(trs.getJtfOne(), "Tipo de Servico");
        vc.validarCampo(trs.getJtfTen(), "Certidão de Óbito");
        // Continuar

        TransferenciaDefunto td = new TransferenciaDefunto(
            trs.getJtfOne(),     // tipoServicoStr
            trs.getJtfTwo(),     // descricao
            trs.getJtfThree(),   // statusServicoStr
            trs.getJtfFour(),    // dataServico
            trs.getJtfFive(),    // tumRua
            trs.getJtfSix(),     // tumNumero
            trs.getJtfSeven(),   // cemCnpj
            trs.getJtfEight(),   // admCpf
            trs.getJtfTen(),     // tumRuaDestino
            trs.getJtfEleven(),  // tumNumeroDestino
            trs.getJtfTwelve(),  // cemCnpjDestino
            trs.getJtfThirteen() // finCertidaoObito
        );

        listTD.add(td);
    }

    public TransferenciaDefunto buscaTransferenciaDefunto(int id){
        for(TransferenciaDefunto td : listTD){
            if(td.getIdServico() == id){
                return td;
            }
        }
        return null;
    }

    public void selectTransferenciaDefunto(int seletor, int seletorCrud, int id){
        TransferenciaDefunto td = buscaTransferenciaDefunto(id);
        if(td == null){
            JOptionPane.showConfirmDialog(null, "Transferencia de Túmulo com id " + id + " não encontrado.");
            new TelaGerenciadorServico(seletor);
        } else {
            TelaRegistroServico trs = new TelaRegistroServico(seletor, seletorCrud, id);
            getTransferenciaDefunto(trs, td);
        }
    }

    public void getTransferenciaDefunto(TelaRegistroServico trs, TransferenciaDefunto td){
        trs.setJtfOne(td.getTipoServico());
        trs.setJtfTwo(td.getDescricao());
        trs.setJtfThree(td.getStatusServico());
        trs.setJtfFour(td.getDataServico());
        trs.setJtfFive(td.getTumRua());
        trs.setJtfSix(td.getTumNumero());
        trs.setJtfSeven(td.getCemCnpj());
        trs.setJtfEight(td.getAdmCpf());
        trs.setJtfNine(td.getInformacoesAdicionais());
        trs.setJtfTen(td.getFinCertidaoObito());
        // Conferir
    }
}