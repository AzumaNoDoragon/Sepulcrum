package model.servicos.core.controller;

import java.util.List;
import java.util.ArrayList;
import model.servicos.exumacao.Exumacao;
import model.servicos.view.TelaRegistroServico;

public class GerenciadorServicos {
    private List<Exumacao> listE = new ArrayList<>();
    private Exumacao e = new Exumacao();

    public void setServico(TelaRegistroServico trs, int seletor){
        switch (seletor) {
            case 1:
                setExumacao(trs);
                break;
            case 2:

                break;
            case 3:
                
                break;
            case 4:

                break;
            case 5:

                break;
        }
    }

    public void setExumacao(TelaRegistroServico trs){
        e.setTipoServico(trs.getJtfOne());
        e.setDescricao(trs.getJtfTwo());
        e.setStatusServico(trs.getJtfThree());
        e.setDataServico(trs.getJtfFour());
        e.setIdDefunto(trs.getJtfFive());
        e.setIdTumulo(trs.getJtfSix());
        e.setIdResponsavelServico(trs.getJtfSeven());
        e.setInformacoesAdicionais(trs.getJtfEight());

        listE.add(e);
    }

    public void getExumacao(TelaRegistroServico trs, Exumacao e[], int id){
        trs.setJtfOne(e[id].getTipoServico());
        trs.setJtfTwo(e[id].getDescricao());
        trs.setJtfThree(e[id].getStatusServico());
        trs.setJtfFour(e[id].getDataServico());
        trs.setJtfFive(String.valueOf(e[id].getIdDefunto()));
        trs.setJtfSix(String.valueOf(e[id].getIdTumulo()));
        trs.setJtfSeven(String.valueOf(e[id].getIdResponsavelServico()));
        trs.setJtfEight(e[id].getInformacoesAdicionais());
    }
}