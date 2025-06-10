package com.sepulcrum.model.servicos.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.sepulcrum.model.servicos.model.Vistoria;
import com.sepulcrum.model.servicos.view.TelaRegistroServico;
import com.sepulcrum.model.servicos.view.TelaSelectServico;
import com.sepulcrum.utils.ValidarCampos;

public class GerenciadorVistoria {
    private static List<Vistoria> listV = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void setVistoria(TelaRegistroServico trs){
        vc.validarCampo(trs.getJtfOne(), "Tipo de Servico");
        vc.validarCampo(trs.getJtfTen(), "Certidão de Óbito");
        // Continuar

        Vistoria v = new Vistoria(
            trs.getJtfOne(),   // tipoServicoStr
            trs.getJtfTwo(),   // descricao
            trs.getJtfThree(), // statusServicoStr
            trs.getJtfFour(),  // dataServico
            trs.getJtfFive(),  // tumRua
            trs.getJtfSix(),   // tumNumero
            trs.getJtfSeven(), // cemCnpj
            trs.getJtfEight()  // admCpf
        );

        listV.add(v);
    }

    public Vistoria buscaVistoria(int id){
        for(Vistoria v : listV){
            if(v.getIdServico() == id){
                return v;
            }
        }
        return null;
    }

    public void selectVistoria(TelaSelectServico tss, int seletor, int seletorCrud, int id){
        Vistoria v = buscaVistoria(id);
        if(v == null){
            JOptionPane.showMessageDialog(null, "Vistoria com id " + id + " não encontrado.");
        } else {
            tss.dispose();
            TelaRegistroServico trs = new TelaRegistroServico(seletor, seletorCrud, id);
            getVistoria(trs, v);
        }
    }

    public void getVistoria(TelaRegistroServico trs, Vistoria v){
        trs.setJtfOne(v.getTipoServico());
        trs.setJtfTwo(v.getDescricao());
        trs.setJtfThree(v.getStatusServico());
        trs.setJtfFour(v.getDataServico());
        trs.setJtfFive(v.getTumRua());
        trs.setJtfSix(v.getTumNumero());
        trs.setJtfSeven(v.getCemCnpj());
        trs.setJtfEight(v.getAdmCpf());
        trs.setJtfNine(v.getInformacoesAdicionais());
        // Conferir
    }
}