package com.sepulcrum.controller.servico;

import javax.swing.JOptionPane;
import com.sepulcrum.dao.servico.ReservaTumuloDao;
import com.sepulcrum.model.servico.ReservaTumulo;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.servico.ReservaTumuloView;
import com.sepulcrum.view.servico.comum.TelaSelectServico;

public class ReservaTumuloController {
    private ReservaTumuloDao rtDao = new ReservaTumuloDao();
    private ValidarCampos vc = new ValidarCampos();

    public void validarCampo(ReservaTumuloView rtv){
        vc.validarCampo(rtv.getJtfOne(), "tipo Servico");        // tipoServicoStr
        vc.validarCampo(rtv.getJtfTwo(), "descrição");           // descricao
        vc.validarCampo(rtv.getJtfThree(), "status Servico");    // statusServicoStr
        vc.validarCampo(rtv.getJtfFour(), "data Serviço");       // dataServico
        vc.validarCampo(rtv.getJtfFive(), "Rua do Tumulo");      // tumRua
        vc.validarCampo(rtv.getJtfSix(), "Número do Tumulo");    // tumNumero
        vc.validarCampo(rtv.getJtfEight(), "CNPJ do Cemitério"); // cemCnpj
        vc.validarCampo(rtv.getJtfNine(), "CPF do responsável"); // admCpf
    }

    public void setReservaTumulo(ReservaTumuloView rtv){
        validarCampo(rtv);

        ReservaTumulo rt = new ReservaTumulo(
            rtv.getJtfOne(),   // tipoServicoStr
            rtv.getJtfTwo(),   // descricao
            rtv.getJtfThree(), // statusServicoStr
            rtv.getJtfFour(),  // dataServico
            rtv.getJtfFive(),  // tumRua
            rtv.getJtfSix(),   // tumNumero
            rtv.getJtfSeven(), // cemCnpj
            rtv.getJtfEight(), // admCpf
            rtv.getJtfTen()    // cpfPessoa
        );
        rt.setInformacoesAdicionais(rtv.getJtfNine());

        rtDao.createReservaTumulo(rt);
    }

    public void selectReservaTumulo(TelaSelectServico tss,int seletor, int seletorCrud, int id){
        ReservaTumulo rt = rtDao.readReservaTumulo(id);
        if(rt == null){
            JOptionPane.showMessageDialog(null, "Reserva de Tumulo com id " + id + " não encontrado.");
        } else {
            tss.dispose();
            ReservaTumuloView rtv = new ReservaTumuloView(seletor, seletorCrud, id);
            getReservaTumulo(rtv, rt);
        }
    }

    public void getReservaTumulo(ReservaTumuloView rtv, ReservaTumulo rt){
        rtv.setJtfOne(rt.getTipoServico());
        rtv.setJtfTwo(rt.getDescricao());
        rtv.setJtfThree(rt.getStatusServico());
        rtv.setJtfFour(rt.getDataServico());
        rtv.setJtfFive(rt.getTumRua());
        rtv.setJtfSix(rt.getTumNumero());
        rtv.setJtfSeven(rt.getCemCnpj());
        rtv.setJtfEight(rt.getAdmCpf());
        rtv.setJtfNine(rt.getInformacoesAdicionais());
    }

    public void updateReservaTumulo(ReservaTumuloView rtv, int id){
        validarCampo(rtv);

        ReservaTumulo rt = rtDao.readReservaTumulo(id);

        rt.setTipoServico(rtv.getJtfOne());
        rt.setDescricao(rtv.getJtfTwo());
        rt.setStatusServico(rtv.getJtfThree());
        rt.setDataServico(rtv.getJtfFour());
        rt.setTumRua(rtv.getJtfFive());
        rt.setTumNumero(rtv.getJtfSix());
        rt.setCemCnpj(rtv.getJtfSeven());
        rt.setAdmCpf(rtv.getJtfEight());
        rt.setInformacoesAdicionais(rtv.getJtfNine());

        rtDao.updateReservaTumulo(rt, id);
    }

    public void deleteReservaTumulo(int id){
        rtDao.readReservaTumulo(id);
        rtDao.deleteReservaTumulo(id);
    }
}