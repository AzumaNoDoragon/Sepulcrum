package com.sepulcrum.controller.servico;

import javax.swing.JOptionPane;
import com.sepulcrum.dao.servico.VistoriaDao;
import com.sepulcrum.model.servico.Vistoria;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.servico.VistoriaView;
import com.sepulcrum.view.servico.comum.TelaSelectServico;

public class VistoriaController {
    private VistoriaDao vDao = new VistoriaDao();
    private ValidarCampos vc = new ValidarCampos();

    public void validarCampo(VistoriaView vv){
        vc.validarCampo(vv.getJtfOne(), "tipo Servico");         // tipoServicoStr
        vc.validarCampo(vv.getJtfTwo(), "descrição");            // descricao
        vc.validarCampo(vv.getJtfThree(), "status Servico");     // statusServicoStr
        vc.validarCampo(vv.getJtfFour(), "data Serviço");        // dataServico
        vc.validarCampo(vv.getJtfFive(), "Rua do Tumulo");       // tumRua
        vc.validarCampo(vv.getJtfSix(), "Número do Tumulo");     // tumNumero
        vc.validarCampo(vv.getJtfSeven(), "CNPJ do Cemitério");  // cemCnpj
        vc.validarCampo(vv.getJtfEight(), "CPF do responsável"); // admCpf
    }

    public void setVistoria(VistoriaView vv){
        validarCampo(vv);

        Vistoria v = new Vistoria(
            vv.getJtfOne(),   // tipoServicoStr
            vv.getJtfTwo(),   // descricao
            vv.getJtfThree(), // statusServicoStr
            vv.getJtfFour(),  // dataServico
            vv.getJtfFive(),  // tumRua
            vv.getJtfSix(),   // tumNumero
            vv.getJtfSeven(), // cemCnpj
            vv.getJtfEight()  // admCpf
        );
        v.setInformacoesAdicionais(vv.getJtfNine());

        vDao.createVistoria(v);
    }
    
    public void selectVistoria(TelaSelectServico tss, int seletor, int seletorCrud, int id){
        Vistoria v = vDao.readVistoria(id);
        if(v == null){
            JOptionPane.showMessageDialog(null, "Vistoria com id " + id + " não encontrado.");
        } else {
            tss.dispose();
            VistoriaView vv = new VistoriaView(seletor, seletorCrud, id);
            getVistoria(vv, v);
        }
    }

    public void getVistoria(VistoriaView vv, Vistoria v){
        vv.setJtfOne(v.getTipoServico());
        vv.setJtfTwo(v.getDescricao());
        vv.setJtfThree(v.getStatusServico());
        vv.setJtfFour(v.getDataServico());
        vv.setJtfFive(v.getTumRua());
        vv.setJtfSix(v.getTumNumero());
        vv.setJtfSeven(v.getCemCnpj());
        vv.setJtfEight(v.getAdmCpf());
        vv.setJtfNine(v.getInformacoesAdicionais());
    }

    public void updateVistoria(VistoriaView vv, int id){
        validarCampo(vv);

        Vistoria v = vDao.readVistoria(id);

        v.setTipoServico(vv.getJtfOne());
        v.setDescricao(vv.getJtfTwo());
        v.setStatusServico(vv.getJtfThree());
        v.setDataServico(vv.getJtfFour());
        v.setTumRua(vv.getJtfFive());
        v.setTumNumero(vv.getJtfSix());
        v.setCemCnpj(vv.getJtfSeven());
        v.setAdmCpf(vv.getJtfEight());
        v.setInformacoesAdicionais(vv.getJtfNine());

        vDao.updateVistoria(v, id);
    }

    public void deleteVistoria(int id){
        vDao.readVistoria(id);
        vDao.deleteVistoria(id);
    }
}