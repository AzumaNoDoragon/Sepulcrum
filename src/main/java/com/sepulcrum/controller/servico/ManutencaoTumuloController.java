package com.sepulcrum.controller.servico;

import javax.swing.JOptionPane;

import com.sepulcrum.dao.servico.ManutencaoTumuloDao;
import com.sepulcrum.model.servico.ManutencaoTumulo;
import com.sepulcrum.utils.ValidarCampos;
import com.sepulcrum.view.servico.ManutencaoTumuloView;
import com.sepulcrum.view.servico.comum.TelaSelectServico;

public class ManutencaoTumuloController {
    private ManutencaoTumuloDao mtDao = new ManutencaoTumuloDao();
    private ValidarCampos vc = new ValidarCampos();

    public void validarCampo(ManutencaoTumuloView mtv){
        vc.validarCampo(mtv.getJtfOne(), "tipo Servico");         // tipoServicoStr
        vc.validarCampo(mtv.getJtfTwo(), "descrição");            // descricao
        vc.validarCampo(mtv.getJtfThree(), "status Servico");     // statusServicoStr
        vc.validarCampo(mtv.getJtfFour(), "data Serviço");        // dataServico
        vc.validarCampo(mtv.getJtfFive(), "Rua do Tumulo");       // tumRua
        vc.validarCampo(mtv.getJtfSix(), "Número do Tumulo");     // tumNumero
        vc.validarCampo(mtv.getJtfSeven(), "CNPJ do Cemitério");  // cemCnpj
        vc.validarCampo(mtv.getJtfEight(), "CPF do responsável"); // admCpf
    }

    public void setManutencaoTumulo(ManutencaoTumuloView mtv){
        validarCampo(mtv);

        ManutencaoTumulo mt = new ManutencaoTumulo(
            mtv.getJtfOne(),   // tipoServicoStr
            mtv.getJtfTwo(),   // descricao
            mtv.getJtfThree(), // statusServicoStr
            mtv.getJtfFour(),  // dataServico
            mtv.getJtfFive(),  // tumRua
            mtv.getJtfSix(),   // tumNumero
            mtv.getJtfSeven(), // cemCnpj
            mtv.getJtfEight()  // admCpf
        );
        mt.setInformacoesAdicionais(mtv.getJtfNine()); // informacoesAdicionais

        mtDao.createManutencaoTumulo(mt);
    }

    public void selectManutencaoTumulo(TelaSelectServico tss, int seletor, int seletorCrud, int id){
        ManutencaoTumulo mt = mtDao.readManutencaoTumulo(id);
        if(mt == null){
            JOptionPane.showMessageDialog(null, "Manutenção Tumular com id " + id + " não encontrado.");
        } else {
            tss.dispose();
            ManutencaoTumuloView mtv = new ManutencaoTumuloView(seletor, seletorCrud, id);
            getManutencaoTumulo(mtv, mt);
        }
    }

    public void getManutencaoTumulo(ManutencaoTumuloView mtv, ManutencaoTumulo mt){
        mtv.setJtfOne(mt.getTipoServico());
        mtv.setJtfTwo(mt.getDescricao());
        mtv.setJtfThree(mt.getStatusServico());
        mtv.setJtfFour(mt.getDataServico());
        mtv.setJtfFive(mt.getTumRua());
        mtv.setJtfSix(mt.getTumNumero());
        mtv.setJtfSeven(mt.getCemCnpj());
        mtv.setJtfEight(mt.getAdmCpf());
        mtv.setJtfNine(mt.getInformacoesAdicionais());
    }

    public void updateManutencaoTumulo(ManutencaoTumuloView mtv, int id){
        validarCampo(mtv);

        ManutencaoTumulo mt = mtDao.readManutencaoTumulo(id);

        mt.setTipoServico(mtv.getJtfOne());
        mt.setDescricao(mtv.getJtfTwo());
        mt.setStatusServico(mtv.getJtfThree());
        mt.setDataServico(mtv.getJtfFour());
        mt.setTumRua(mtv.getJtfFive());
        mt.setTumNumero(mtv.getJtfSix());
        mt.setCemCnpj(mtv.getJtfSeven());
        mt.setAdmCpf(mtv.getJtfEight());
        mt.setInformacoesAdicionais(mtv.getJtfNine());

        mtDao.updateManutencaoTumulo(mt, id);
    }

    public void deleteManutencaoTumulo(int id){
        mtDao.readManutencaoTumulo(id);
        mtDao.deleteManutencaoTumulo(id);
    }
}