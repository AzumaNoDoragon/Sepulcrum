package com.sepulcrum.model.servicos.controller;

import java.util.List;
import java.sql.Date;
import java.util.ArrayList;
import com.sepulcrum.model.servicos.model.Exumacao;
import com.sepulcrum.model.servicos.model.ManutencaoTumulo;
import com.sepulcrum.model.servicos.model.ReservaTumulo;
import com.sepulcrum.model.servicos.model.TransferenciaDefunto;
import com.sepulcrum.model.servicos.model.Vistoria;
import com.sepulcrum.model.servicos.model.utils.Servicos;
import com.sepulcrum.model.servicos.view.TelaRegistroServico;

public class GerenciadorServicos {
    private List<Exumacao> listE = new ArrayList<>();
    private List<ReservaTumulo> listRT = new ArrayList<>();
    private List<TransferenciaDefunto> listTD = new ArrayList<>();
    private List<ManutencaoTumulo> listMT = new ArrayList<>();
    private List<Vistoria> listV = new ArrayList<>();

    private void validarCampo(String campo, String nomeCampo){
        if(campo == null || campo.trim().isEmpty()){
            throw new IllegalArgumentException("Campo '" + nomeCampo + "' vazio ou inválido.");
        }
    }

    private void validarCampo(Date campo, String nomeCampo){
        if(campo == null){
            throw new IllegalArgumentException("Campo '" + nomeCampo + "' vazio ou inválido.");
        }
    }

    public void setServico(TelaRegistroServico trs, Servicos s){
        validarCampo(trs.getJtfTwo() , "Descrição");
        validarCampo(trs.getJtfThree() , "Status do Serviço");
        validarCampo(trs.getJtfFour() , "Data Do Serviço");
        validarCampo(trs.getJtfFive() , "Rua do Túmulo");
        validarCampo(trs.getJtfSix() , "Número do Túmulo");
        validarCampo(trs.getJtfSeven() , "CNPJ do Cemitério");
        validarCampo(trs.getJtfEight() , "CPF do Responsável pelo Serviço");

        s.setTipoServico(trs.getJtfOne()); // tipoServico
        s.setDescricao(trs.getJtfTwo()); // descricao
        s.setStatusServico(trs.getJtfThree()); // statusServico
        s.setDataServico(trs.getJtfFour()); // dataServico
        s.setTumRua(trs.getJtfFive()); // tumRua
        s.setTumNumero(trs.getJtfSix()); // tumNumero
        s.setCemCnpj(trs.getJtfSeven()); // cemCnpj
        s.setAdmCpf(trs.getJtfEight()); //admCpf
        s.setInformacoesAdicionais(trs.getJtfNine()); //informacoesAdicionais
    }
    
    public void setExumacao(TelaRegistroServico trs){
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
            
        setServico(trs, e);
        validarCampo(trs.getJtfTen(), "Certidão de Óbito");
        e.setFinCertidaoObito(trs.getJtfTen());
        listE.add(e);
    }
    
    public void setReservaTumulo(TelaRegistroServico trs){
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

        setServico(trs, rt);
        validarCampo(trs.getJtfTen(), "CPF do comprador");
        rt.setIdPessoa(trs.getJtfTen());
        listRT.add(rt);
    }

    public void setTransferenciaDefunto(TelaRegistroServico trs){
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

        setServico(trs, td);
        validarCampo(trs.getJtfTen(), "Rua Túmulo Destino");
        validarCampo(trs.getJtfEleven(), "Número Túmulo Destino");
        validarCampo(trs.getJtfTwelve(), "CNPJ do Cemitério Destino");
        validarCampo(trs.getJtfThirteen(), "Certidão de Óbito do Finado");
        td.setTumNumeroDestino(trs.getJtfTen());
        td.setTumRuaDestino(trs.getJtfEleven());
        td.setCemCnpjDestino(trs.getJtfTwelve());
        td.setFinCertidaoObito(trs.getJtfThirteen());
        listTD.add(td);
    }

    public void setManutencaoTumulo(TelaRegistroServico trs){
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

        setServico(trs, mt);
        listMT.add(mt);
    }
    
    public void setVistoria(TelaRegistroServico trs){
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

        setServico(trs, v);
        listV.add(v);
    }

    public void getServico(TelaRegistroServico trs, Servicos s){
        trs.setJtfOne(s.getTipoServico()); //tipoServico
        trs.setJtfTwo(s.getDescricao()); //descricao
        trs.setJtfThree(s.getStatusServico()); //statusServico
        trs.setJtfFour(s.getDataServico()); //dataServico
        trs.setJtfSix(String.valueOf(s.getIdTumulo())); //idTumulo
        trs.setJtfSeven(String.valueOf(s.getIdResponsavelServico())); //idResponsavelServico
        trs.setJtfEight(s.getInformacoesAdicionais()); //informacoesAdicionais
    }

    public void getExumacao(TelaRegistroServico trs, int id){
        System.out.println(listE.size());
        Exumacao e = listE.get(id);
        getServico(trs, e);
        trs.setJtfFive(String.valueOf(e.getIdDefunto()));
    }
    
    
    public void getReservaTumulo(TelaRegistroServico trs, int id){
        ReservaTumulo rt = listRT.get(id);
        getServico(trs, rt);
        trs.setJtfFive(String.valueOf(rt.getIdPessoa()));
    }
    
    
    public void getTransferenciaDefunto(TelaRegistroServico trs, int id){
        TransferenciaDefunto td = listTD.get(id);
        getServico(trs, td);
        trs.setJtfFive(String.valueOf(td.getIdTumuloDestino()));
        trs.setJtfFive(String.valueOf(td.getIdDefunto()));
    }

    
    public void getManutencaoTumulo(TelaRegistroServico trs, int id){
        ManutencaoTumulo mt = listMT.get(id);
        getServico(trs, mt);
    }

    
    public void getVistoria(TelaRegistroServico trs, int id){
        Vistoria v = listV.get(id);
        getServico(trs, v);
    }
}