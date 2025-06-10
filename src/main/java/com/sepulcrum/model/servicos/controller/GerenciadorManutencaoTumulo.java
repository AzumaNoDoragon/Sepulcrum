package com.sepulcrum.model.servicos.controller;

import java.util.List;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import com.sepulcrum.model.servicos.model.ManutencaoTumulo;
import com.sepulcrum.model.servicos.view.TelaRegistroServico;
import com.sepulcrum.model.servicos.view.TelaSelectServico;
import com.sepulcrum.utils.ValidarCampos;

public class GerenciadorManutencaoTumulo {
    private static List<ManutencaoTumulo> listMT = new ArrayList<>();
    private ValidarCampos vc = new ValidarCampos();

    public void setManutencaoTumulo(TelaRegistroServico trs){
        vc.validarCampo(trs.getJtfOne(), "Tipo de Servico");
        // Continuar


        ManutencaoTumulo mt = new ManutencaoTumulo(
            trs.getJtfOne(),   // tipoServicoStr
            trs.getJtfTwo(),   // descricao
            trs.getJtfThree(), // statusServicoStr
            trs.getJtfFour(),  // dataServico
            trs.getJtfFive(),  // tumRua
            trs.getJtfSix(),   // tumNumero
            trs.getJtfSeven(), // cemCnpj
            trs.getJtfEight()  // admCpf
        );

        // Continuar

        listMT.add(mt);
    }

    public ManutencaoTumulo buscaManutencaoTumulo(int id){
        for(ManutencaoTumulo mt : listMT) {
            if(mt.getIdServico() == id){
                return mt;
            }
        }
        return null;
    }

    public void selectManutencaoTumulo(TelaSelectServico tss, int seletor, int seletorCrud, int id){
        ManutencaoTumulo mt = buscaManutencaoTumulo(id);
        if(mt == null){
            JOptionPane.showMessageDialog(null, "Manutenção Tumular com id " + id + " não encontrado.");
        } else {
            tss.dispose();
            TelaRegistroServico trs = new TelaRegistroServico(seletor, seletorCrud, id);
            getManutencaoTumulo(trs, mt);
        }
    }

    public void getManutencaoTumulo(TelaRegistroServico trs, ManutencaoTumulo mt){
        trs.setJtfOne(mt.getTipoServico());
        trs.setJtfTwo(mt.getDescricao());
        trs.setJtfThree(mt.getStatusServico());
        trs.setJtfFour(mt.getDataServico());
        trs.setJtfFive(mt.getTumRua());
        trs.setJtfSix(mt.getTumNumero());
        trs.setJtfSeven(mt.getCemCnpj());
        trs.setJtfEight(mt.getAdmCpf());
        trs.setJtfNine(mt.getInformacoesAdicionais());
        // Conferir
    }
}