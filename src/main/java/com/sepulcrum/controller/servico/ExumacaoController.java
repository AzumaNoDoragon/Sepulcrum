package com.sepulcrum.controller.servico;

import javax.swing.JOptionPane;
import com.sepulcrum.dao.servico.ExumacaoDao;
import com.sepulcrum.model.servico.Exumacao;
import com.sepulcrum.utils.ValidadorCamposInterface;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.servico.ExumacaoView;
import com.sepulcrum.view.servico.comum.TelaSelectServico;

public class ExumacaoController {
    private ExumacaoDao eDao = new ExumacaoDao();
    private ValidadorCamposInterface vc = new ValidarCampos();

    public void validarCampo(ExumacaoView ev){
        vc.validarCampo(ev.getJtfOne(), "tipo Servico");        // tipoServicoStr
        vc.validarCampo(ev.getJtfTwo(), "descrição");           // descricao
        vc.validarCampo(ev.getJtfThree(), "status Servico");    // statusServicoStr
        vc.validarCampo(ev.getJtfFour(), "data Serviço");       // dataServico
        vc.validarCampo(ev.getJtfFive(), "Rua do Tumulo");      // tumRua
        vc.validarCampo(ev.getJtfSix(), "Número do Tumulo");    // tumNumero
        vc.validarCampo(ev.getJtfEight(), "CNPJ do Cemitério"); // cemCnpj
        vc.validarCampo(ev.getJtfNine(), "CPF do responsável"); // admCpf
    }

    public void setExumacao(ExumacaoView ev){
        validarCampo(ev);

        Exumacao ex = new Exumacao(
            ev.getJtfOne(),   // tipoServicoStr
            ev.getJtfTwo(),   // descricao
            ev.getJtfThree(), // statusServicoStr
            ev.getJtfFour(),  // dataServico
            ev.getJtfFive(),  // tumRua
            ev.getJtfSix(),   // tumNumero
            ev.getJtfSeven(), // cemCnpj
            ev.getJtfEight(), // admCpf
            ev.getJtfTen()    // finCertidaoObito
        );
        ex.setInformacoesAdicionais(ev.getJtfNine());

        eDao.createExumacao(ex);
    }

    public void selectExumacao(TelaSelectServico tss, int seletor, int seletorCrud, int id){
        Exumacao e = eDao.readExumacao(id);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Serviço com id " + id + " não encontrado.");
        } else {
            tss.dispose();
            ExumacaoView ev = new ExumacaoView(seletor, seletorCrud, id);
            getExumacao(ev, e);
        }
    }

    public void getExumacao(ExumacaoView ev, Exumacao e){
        ev.setJtfOne(e.getTipoServico());
        ev.setJtfTwo(e.getDescricao());
        ev.setJtfThree(e.getStatusServico());
        ev.setJtfFour(e.getDataServico());
        ev.setJtfFive(e.getTumRua());
        ev.setJtfSix(e.getTumNumero());
        ev.setJtfSeven(e.getCemCnpj());
        ev.setJtfEight(e.getAdmCpf());
        ev.setJtfNine(e.getInformacoesAdicionais());
        ev.setJtfTen(e.getFinCertidaoObito());
    }

    public void updateExumacao(ExumacaoView ev, int id){
        validarCampo(ev);

        Exumacao e = eDao.readExumacao(id);

        e.setTipoServico(ev.getJtfOne());
        e.setDescricao(ev.getJtfTwo());
        e.setStatusServico(ev.getJtfThree());
        e.setDataServico(ev.getJtfFour());
        e.setTumRua(ev.getJtfFive());
        e.setTumNumero(ev.getJtfSix());
        e.setCemCnpj(ev.getJtfSeven());
        e.setAdmCpf(ev.getJtfEight());
        e.setInformacoesAdicionais(ev.getJtfNine());
        e.setFinCertidaoObito(ev.getJtfTen());

        eDao.updateExumacao(e, id);
    }

    public void deleteExumacao(int id){
        eDao.readExumacao(id);
        eDao.deleteExumacao(id);
    }
}