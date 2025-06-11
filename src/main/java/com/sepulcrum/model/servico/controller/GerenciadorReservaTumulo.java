package com.sepulcrum.model.servico.controller;

import java.util.List;
import javax.swing.JOptionPane;
import java.util.ArrayList;

import com.sepulcrum.model.servico.model.ReservaTumulo;
import com.sepulcrum.model.servico.view.TelaRegistroServico;
import com.sepulcrum.model.servico.view.TelaSelectServico;
import com.sepulcrum.utils.ValidarCampos;

public class GerenciadorReservaTumulo {
    private static List<ReservaTumulo> listRT = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void setReservaTumulo(TelaRegistroServico trs){
        vc.validarCampo(trs.getJtfOne(), "Tipo de Servico");
        vc.validarCampo(trs.getJtfTen(), "Certidão de Óbito");
        // Continuar

        ReservaTumulo rt = new ReservaTumulo(
            trs.getJtfOne(),   // tipoServicoStr
            trs.getJtfTwo(),   // descricao
            trs.getJtfThree(), // statusServicoStr
            trs.getJtfFour(),  // dataServico
            trs.getJtfFive(),  // tumRua
            trs.getJtfSix(),   // tumNumero
            trs.getJtfSeven(), // cemCnpj
            trs.getJtfEight(), // admCpf
            trs.getJtfTen()    // cpfPessoa
        );

        // Continuar

        listRT.add(rt);
    }

    public ReservaTumulo buscaReservaTumulo(int id){
        for(ReservaTumulo rt : listRT){
            if(rt.getIdServico() == id){
                return rt;
            }
        }
        return null;
    }

    public void selectReservaTumulo(TelaSelectServico tss,int seletor, int seletorCrud, int id){
        ReservaTumulo rt = buscaReservaTumulo(id);
        if(rt == null){
            JOptionPane.showMessageDialog(null, "Reserva de Tumulo com id " + id + " não encontrado.");
        } else {
            tss.dispose();
            TelaRegistroServico trs = new TelaRegistroServico(seletor, seletorCrud, id);
            getReservaTumulo(trs, rt);
        }
    }

    public void getReservaTumulo(TelaRegistroServico trs, ReservaTumulo rt){
        trs.setJtfOne(rt.getTipoServico());
        trs.setJtfTwo(rt.getDescricao());
        trs.setJtfThree(rt.getStatusServico());
        trs.setJtfFour(rt.getDataServico());
        trs.setJtfFive(rt.getTumRua());
        trs.setJtfSix(rt.getTumNumero());
        trs.setJtfSeven(rt.getCemCnpj());
        trs.setJtfEight(rt.getAdmCpf());
        trs.setJtfNine(rt.getInformacoesAdicionais());
        // Conferir
    }
}