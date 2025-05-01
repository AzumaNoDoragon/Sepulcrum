package com.sepulcrum.model.servicos.controller;

import java.util.List;
import java.util.ArrayList;
import com.sepulcrum.model.servicos.model.Exumacao;
import com.sepulcrum.model.servicos.model.ManutencaoTumulo;
import com.sepulcrum.model.servicos.model.ReservaTumulo;
import com.sepulcrum.model.servicos.model.TransferenciaDefunto;
import com.sepulcrum.model.servicos.model.Vistoria;
import com.sepulcrum.model.servicos.model.utils.Servico;
import com.sepulcrum.model.servicos.view.TelaRegistroServico;

public class GerenciadorServicos {
    private List<Exumacao> listE = new ArrayList<>();
    private List<ManutencaoTumulo> listMT = new ArrayList<>();
    private List<ReservaTumulo> listRT = new ArrayList<>();
    private List<TransferenciaDefunto> listTD = new ArrayList<>();
    private List<Vistoria> listV = new ArrayList<>();

    public void setServico(TelaRegistroServico trs, Servico st){
        st.setIdServico(1);
        st.setTipoServico(trs.getJtfOne()); //tipoServico
        st.setDescricao(trs.getJtfTwo()); //descricao
        st.setStatusServico(trs.getJtfThree()); //statusServico
        st.setDataServico(trs.getJtfFour()); //dataServico
        st.setIdTumulo(trs.getJtfSix()); //idTumulo
        st.setIdResponsavelServico(trs.getJtfSeven()); //idResponsavelServico
        st.setInformacoesAdicionais(trs.getJtfEight()); //informacoesAdicionais
    }

    public void getServico(TelaRegistroServico trs, Servico st){
        trs.setJtfOne(st.getTipoServico()); //tipoServico
        trs.setJtfTwo(st.getDescricao()); //descricao
        trs.setJtfThree(st.getStatusServico()); //statusServico
        trs.setJtfFour(st.getDataServico()); //dataServico
        trs.setJtfSix(String.valueOf(st.getIdTumulo())); //idTumulo
        trs.setJtfSeven(String.valueOf(st.getIdResponsavelServico())); //idResponsavelServico
        trs.setJtfEight(st.getInformacoesAdicionais()); //informacoesAdicionais
    }

    public void setExumacao(TelaRegistroServico trs){
        Exumacao e = new Exumacao();
        setServico(trs, e);
        e.setIdDefunto(trs.getJtfFive());
        listE.add(e);
    }

    public void getExumacao(TelaRegistroServico trs, int id){
        System.out.println(listE.size());
        Exumacao e = listE.get(id);
        getServico(trs, e);
        trs.setJtfFive(String.valueOf(e.getIdDefunto()));
    }
    
    public void setReservaTumulo(TelaRegistroServico trs){
        ReservaTumulo rt = new ReservaTumulo();
        setServico(trs, rt);
        rt.setIdPessoa(trs.getJtfFive()); //Verificar rota correta
        
        listRT.add(rt);
    }
    
    public void getReservaTumulo(TelaRegistroServico trs, int id){
        ReservaTumulo rt = listRT.get(id);
        getServico(trs, rt);
        trs.setJtfFive(String.valueOf(rt.getIdPessoa()));
    }
    
    public void setTransferenciaDefunto(TelaRegistroServico trs){
        TransferenciaDefunto td = new TransferenciaDefunto();
        setServico(trs, td);
        td.setIdTumuloDestino(trs.getJtfFive()); //Verificar rota correta
        td.setIdDefunto(trs.getJtfFive()); //Verificar rota correta
        
        listTD.add(td);
    }
    
    public void getTransferenciaDefunto(TelaRegistroServico trs, int id){
        TransferenciaDefunto td = listTD.get(id);
        getServico(trs, td);
        trs.setJtfFive(String.valueOf(td.getIdTumuloDestino()));
        trs.setJtfFive(String.valueOf(td.getIdDefunto()));
    }

    public void setManutencaoTumulo(TelaRegistroServico trs){
        ManutencaoTumulo mt = new ManutencaoTumulo();
        setServico(trs, mt);
    
        listMT.add(mt);
    }
    
    public void getManutencaoTumulo(TelaRegistroServico trs, int id){
        ManutencaoTumulo mt = listMT.get(id);
        getServico(trs, mt);
    }
    
    public void setVistoria(TelaRegistroServico trs){
        Vistoria v = new Vistoria();
        setServico(trs, v);
        
        listV.add(v);
    }
    
    public void getVistoria(TelaRegistroServico trs, int id){
        Vistoria v = listV.get(id);
        getServico(trs, v);
    }
}