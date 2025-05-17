package com.sepulcrum.model.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.sepulcrum.model.localidade.Cemiterio;
import com.sepulcrum.model.localidade.Tumulo;
import com.sepulcrum.model.localidade.utils.Localidade;
import com.sepulcrum.model.pessoas.Adm;
import com.sepulcrum.model.pessoas.Familiar;
import com.sepulcrum.model.pessoas.Finado;
import com.sepulcrum.model.pessoas.utils.Pessoas;
import com.sepulcrum.model.pessoas.utils.PessoasVivas;
import com.sepulcrum.model.view.TelaGerenciadorGeral;
import com.sepulcrum.model.view.TelaRegistroGeral;

public class GerenciadorGeral {
    private static List<Cemiterio> listC = new ArrayList<>();
    private static List<Tumulo> ListT = new ArrayList<>();
    private static List<Adm> ListA = new ArrayList<>();
    private static List<Familiar> ListFam = new ArrayList<>();
    private static List<Finado> ListFin = new ArrayList<>();

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
    
    public void setCemiterio(TelaRegistroGeral trg){
        validarCampo(trg.getJtfOne(), "Nome");
        validarCampo(trg.getJtfTwo(), "Estado");
        validarCampo(trg.getJtfThree(), "Cidade");
        validarCampo(trg.getJtfFourString(), "Rua");
        validarCampo(trg.getJtfFiveString(), "Número");
        validarCampo(trg.getJtfSix(), "Cep");
        validarCampo(trg.getJtfEight(), "Telefone");
        validarCampo(trg.getJtfNine(), "CNPJ");
        validarCampo(trg.getJtfTen(), "Adiministrador");

        Cemiterio c = new Cemiterio(
            trg.getJtfOne(),        // nome
            trg.getJtfTwo(),        // estado
            trg.getJtfThree(),      // cidade
            trg.getJtfFourString(), // rua
            trg.getJtfFiveString(), // numero
            trg.getJtfSix(),        // cep
            trg.getJtfEight(),      // telefone
            trg.getJtfNine(),       // cnpj
            trg.getJtfTen()         // admCpf
        );
        c.setCapacidadeMax(trg.getJtfSevenInt()); // Capacidade Max

        listC.add(c);
    }
    
    public void setAdm(TelaRegistroGeral trg){
        validarCampo(trg.getJtfOne(), "Nome");
        validarCampo(trg.getJtfTwo(), "Cpf");
        validarCampo(trg.getJtfFourDate(), "Data de Nascimento");
        validarCampo(trg.getJtfFiveDate(), "Data de Contratação");
        validarCampo(trg.getJtfSix(), "Email");
        validarCampo(trg.getJtfSevenString(), "Telefone");
        validarCampo(trg.getJtfEight(), "Cargo");
        validarCampo(trg.getJtfNine(), "CNPJ");

        Adm a = new Adm(
            trg.getJtfOne(),         // nome
            trg.getJtfTwo(),         // cpf
            trg.getJtfFourDate(),    // dataNascimento
            trg.getJtfFiveDate(),    // dataContratacao
            trg.getJtfSix(),         // email
            trg.getJtfSevenString(), // telefone
            trg.getJtfEight(),       // cargo
            trg.getJtfNine()         // cemCnpj
        );

        a.setRg(trg.getJtfThree()); // RG

        ListA.add(a);
    }
    
    public void setTumulo(TelaRegistroGeral trg){
        validarCampo(trg.getJtfOne(), "Tipo");
        validarCampo(trg.getJtfTwo(), "Situação");
        validarCampo(trg.getJtfThree(), "Data de Ocupação");
        validarCampo(trg.getJtfFourString(), "Rua");
        validarCampo(trg.getJtfFiveString(), "Número");
        validarCampo(trg.getJtfSix(), "CNPJ");

        Tumulo t = new Tumulo(
            trg.getJtfOne(),        // tipo
            trg.getJtfTwo(),        // situacao
            trg.getJtfThree(),      // dataOcupacao
            trg.getJtfFourString(), // rua
            trg.getJtfFiveString(), // numero
            trg.getJtfSix()         // cemCnpj
        );
        
        ListT.add(t);
    }
    
    public void setFinado(TelaRegistroGeral trg){
        validarCampo(trg.getJtfFiveDate(), "Data Falecimento");
        validarCampo(trg.getJtfSix(), "Causa da Morte");
        validarCampo(trg.getJtfSevenString(), "Certidão de Óbito");
        validarCampo(trg.getJtfEight(), "Rua do Túmulo");
        validarCampo(trg.getJtfNine(), "Número do Túmulo");

        Finado fin = new Finado(
            trg.getJtfOne(),         // nome
            trg.getJtfTwo(),         // cpf
            trg.getJtfFourDate(),    // dataNascimento
            trg.getJtfFiveDate(),    // dataFalecimento
            trg.getJtfSevenString(), // certidaoObito
            trg.getJtfSix(),         // causaMorte
            trg.getJtfEight(),       // tumRua
            trg.getJtfNine()         // tumNumero
        );

        fin.setRg(trg.getJtfThree()); // Rg

        ListFin.add(fin);
    }

    public void setFamiliar(TelaRegistroGeral trg){
        validarCampo(trg.getJtfOne(), "Nome");
        validarCampo(trg.getJtfTwo(), "Cpf");
        validarCampo(trg.getJtfFourDate(), "Data de Nascimento");
        validarCampo(trg.getJtfFiveString(), "Grau de Parentesco");
        validarCampo(trg.getJtfSix(), "Email");
        validarCampo(trg.getJtfSevenString(), "Telefone");
        validarCampo(trg.getJtfEight(), "Certidão de Óbito");
        
        Familiar fam = new Familiar(
            trg.getJtfOne(),        // nome
            trg.getJtfTwo(),        // cpf
            trg.getJtfFourDate(),   // dataNascimento
            trg.getJtfSix(),        // email
            trg.getJtfSevenString() // telefone
        );

        fam.setRg(trg.getJtfThree());                  // RG
        fam.setGrauParentesco(trg.getJtfFiveString()); // grauParentesco
        fam.setCertidaoObito(trg.getJtfEight());       // certidaoObito

        ListFam.add(fam);
    }

    public Cemiterio buscaCemiterio(int id) {
        for (Cemiterio c : listC) {
            if (c.getCnpj().equals(Integer.toString(id))) {
                return c;
            }
        }
        return null;
    }

    public Adm buscaAdm(int id) {
        for (Adm a : ListA) {
            if (a.getCpf().equals(Integer.toString(id))) {
                return a;
            }
        }
        return null;
    }

    public Tumulo buscaTumulo(int id) {
        for (Tumulo t : ListT) {
            if (t.getNumero().equals(Integer.toString(id))) {
                return t;
            }
        }
        return null;
    }

    public Finado buscaFinado(int id) {
        for (Finado fin : ListFin) {
            if (fin.getCertidaoObito().equals(Integer.toString(id))) {
                return fin;
            }
        }
        return null;
    }

    public Familiar buscaFamiliar(int id) {
        for (Familiar fam : ListFam) {
            if (fam.getCpf().equals(Integer.toString(id))) {
                return fam;
            }
        }
        return null;
    }

    public void Select(int seletor, int seletorCrud, int id){
        try{
            switch (seletor) {
                case 1:
                    Cemiterio c = buscaCemiterio(id);
                    if (c == null) {
                        JOptionPane.showMessageDialog(null, "Cemitério com CNPJ " + id + " não encontrado.");
                        new TelaGerenciadorGeral(seletor);
                    } else {
                        TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
                        getCemiterio(trg, c);
                    }
                    break;
                case 2:
                    Adm a = buscaAdm(id);
                    if (a == null) {
                        JOptionPane.showMessageDialog(null, "Coveiro com CPF " + id + " não encontrado.");
                        new TelaGerenciadorGeral(seletor);
                    } else {
                        TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
                        getAdm(trg, a);
                    }
                    break;
                case 3:
                    Tumulo t = buscaTumulo(id);
                    if (t == null) {
                        JOptionPane.showMessageDialog(null, "Túmulo de código " + id + " não encontrado.");
                        new TelaGerenciadorGeral(seletor);
                    } else {
                        TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
                        getTumulo(trg, t);
                    }
                    break;
                case 4:
                    Finado fin = buscaFinado(id);
                    if (fin == null) {
                        JOptionPane.showMessageDialog(null, "Finado com Certidão de Óbito " + id + " não encontrado.");
                        new TelaGerenciadorGeral(seletor);
                    } else {
                        TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
                        getFinado(trg, fin);
                    }
                    break;
                case 5:
                    Familiar fam = buscaFamiliar(id);
                    if (fam == null) {
                        JOptionPane.showMessageDialog(null, "Familiar com CPF " + id + " não encontrado.");
                        new TelaGerenciadorGeral(seletor);
                    } else {
                        TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
                        getFamiliar(trg, fam);
                    }
                    break;                    
                default:
                    break;
            }
        } catch(Exception e){
            System.out.println("Erro");
            e.printStackTrace(); // Mostra o erro real
        }
    }

    public void getLocalidade(TelaRegistroGeral trg, Localidade l){
        trg.setJtfFour(l.getRua());
        trg.setJtfFive(l.getNumero());
    }

    public void getCemiterio(TelaRegistroGeral trg, Cemiterio c){
        getLocalidade(trg, c);
        trg.setJtfOne(c.getNome());
        trg.setJtfTwo(c.getEstado());
        trg.setJtfThree(c.getCidade());
        trg.setJtfSix(c.getCep());
        trg.setJtfSeven(Integer.toString(c.getCapacidadeMax()));
        trg.setJtfEight(c.getTelefone());
        trg.setJtfNine(c.getCnpj());
        trg.setJtfTen(c.getAdmCpf());
    }
    
    public void getTumulo(TelaRegistroGeral trg, Tumulo t){
        getLocalidade(trg, t);
        trg.setJtfOne(t.getTipo());
        trg.setJtfTwo(t.getSituacao());
        trg.setJtfThree(t.getDataOcupacao());
        trg.setJtfSix(t.getCemCnpj());
    }

    public void getPessoa(TelaRegistroGeral trg, Pessoas p){
        p.getNome();
        p.getCpf();
        p.getRg();
        p.getDataNascimento();
    }

    public void getPessoasVivas(TelaRegistroGeral trg, PessoasVivas pv){
        getPessoa(trg, pv);
        pv.getEmail();
        pv.getTelefone();
    }

    public void getAdm(TelaRegistroGeral trg, Adm a){
        getPessoasVivas(trg, a);
        a.getCargo();
        a.getCemCnpj();
        a.getDataContratacao();
    }

    public void getFamiliar(TelaRegistroGeral trg, Familiar fam){
        getPessoasVivas(trg, fam);
        fam.getGrauParentesco();
        fam.getCertidaoObito();
    }

    public void getFinado(TelaRegistroGeral trg, Finado fin){
        getPessoa(trg, fin);
        fin.getCausaMorte();
        fin.getTumRua();
        fin.getTumNumero();
        fin.getCertidaoObito();
        fin.getDataFalecimento();
    }
}