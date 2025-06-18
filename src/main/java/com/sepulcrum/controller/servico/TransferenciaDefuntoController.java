package com.sepulcrum.controller.servico;

import javax.swing.JOptionPane;

import com.sepulcrum.dao.servico.TransferenciaDefuntoDao;
import com.sepulcrum.model.servico.TransferenciaDefunto;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.servico.TransferenciaDefuntoView;
import com.sepulcrum.view.servico.comum.TelaSelectServico;

public class TransferenciaDefuntoController {
    TransferenciaDefuntoDao tdDao = new TransferenciaDefuntoDao();
    private ValidarCampos vc = new ValidarCampos();

    public void validarCampo(TransferenciaDefuntoView tdv){
        vc.validarCampo(tdv.getJtfOne(), "tipo Servico");                     // tipoServicoStr
        vc.validarCampo(tdv.getJtfTwo(), "descrição");                        // descricao
        vc.validarCampo(tdv.getJtfThree(), "status Servico");                 // statusServicoStr
        vc.validarCampo(tdv.getJtfFour(), "data Serviço");                    // dataServico
        vc.validarCampo(tdv.getJtfFive(), "Rua do Tumulo");                   // tumRua
        vc.validarCampo(tdv.getJtfSix(), "Número do Tumulo");                 // tumNumero
        vc.validarCampo(tdv.getJtfEight(), "CNPJ do Cemitério");              // cemCnpj
        vc.validarCampo(tdv.getJtfNine(), "CPF do responsável");              // admCpf
        vc.validarCampo(tdv.getJtfTen(), "Rua do Tumulo de Destino");         // tumRuaDestino
        vc.validarCampo(tdv.getJtfEleven(), "Número do Tumulo de Destino");   // tumNumeroDestino
        vc.validarCampo(tdv.getJtfTwelve(), "CNPF do Cemitério de Destino");  // cemCnpjDestino
        vc.validarCampo(tdv.getJtfThirteen(), "Certidão de Óbito do Finado"); // finCertidaoObito
    }

    public void setTransferenciaDefunto(TransferenciaDefuntoView tdv){
        validarCampo(tdv);

        TransferenciaDefunto td = new TransferenciaDefunto(
            tdv.getJtfOne(),     // tipoServicoStr
            tdv.getJtfTwo(),     // descricao
            tdv.getJtfThree(),   // statusServicoStr
            tdv.getJtfFour(),    // dataServico
            tdv.getJtfFive(),    // tumRua
            tdv.getJtfSix(),     // tumNumero
            tdv.getJtfSeven(),   // cemCnpj
            tdv.getJtfEight(),   // admCpf
            tdv.getJtfTen(),     // tumRuaDestino
            tdv.getJtfEleven(),  // tumNumeroDestino
            tdv.getJtfTwelve(),  // cemCnpjDestino
            tdv.getJtfThirteen() // finCertidaoObito
        );
        td.setInformacoesAdicionais(tdv.getJtfNine());

        tdDao.createTransferenciaDefunto(td);
    }

    public void selectTransferenciaDefunto(TelaSelectServico tss, int seletor, int seletorCrud, int id){
        TransferenciaDefunto td = tdDao.readTransferenciaDefunto(id);
        if(td == null){
            JOptionPane.showConfirmDialog(null, "Transferencia de Túmulo com id " + id + " não encontrado.");
        } else {
            tss.dispose();
            TransferenciaDefuntoView trv = new TransferenciaDefuntoView(seletor, seletorCrud, id);
            getTransferenciaDefunto(trv, td);
        }
    }

    public void getTransferenciaDefunto(TransferenciaDefuntoView trv, TransferenciaDefunto td){
        trv.setJtfOne(td.getTipoServico());
        trv.setJtfTwo(td.getDescricao());
        trv.setJtfThree(td.getStatusServico());
        trv.setJtfFour(td.getDataServico());
        trv.setJtfFive(td.getTumRua());
        trv.setJtfSix(td.getTumNumero());
        trv.setJtfSeven(td.getCemCnpj());
        trv.setJtfEight(td.getAdmCpf());
        trv.setJtfNine(td.getInformacoesAdicionais());
        trv.setJtfTen(td.getTumRuaDestino());
        trv.setJtfEleven(td.getTumNumeroDestino());
        trv.setJtfTwelve(td.getCemCnpjDestino());
        trv.setJtfThirteen(td.getFinCertidaoObito());
    }

    public void updateTransferenciaDefunto(TransferenciaDefuntoView trv, int id){
        validarCampo(trv);

        TransferenciaDefunto td = tdDao.readTransferenciaDefunto(id);

        td.setTipoServico(trv.getJtfOne());
        td.setDescricao(trv.getJtfTwo());
        td.setStatusServico(trv.getJtfThree());
        td.setDataServico(trv.getJtfFour());
        td.setTumRua(trv.getJtfFive());
        td.setTumNumero(trv.getJtfSix());
        td.setCemCnpj(trv.getJtfSeven());
        td.setAdmCpf(trv.getJtfEight());
        td.setInformacoesAdicionais(trv.getJtfNine());
        td.setTumRuaDestino(trv.getJtfTen());
        td.setTumNumeroDestino(trv.getJtfEleven());
        td.setCemCnpjDestino(trv.getJtfTwelve());
        td.setFinCertidaoObito(trv.getJtfThirteen());

        tdDao.updateTransferenciaDefunto(td, id);
    }

    public void deleteTransferenciaDefunto(int id){
        tdDao.readTransferenciaDefunto(id);
        tdDao.deleteTransferenciaDefunto(id);
    }
}