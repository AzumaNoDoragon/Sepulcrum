package com.sepulcrum.model.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.sepulcrum.model.localidade.Cemiterio;
import com.sepulcrum.model.localidade.Tumulo;
import com.sepulcrum.model.localidade.utils.Localidade;
import com.sepulcrum.model.pessoas.Adm;
import com.sepulcrum.model.pessoas.Familiar;
import com.sepulcrum.model.pessoas.Finado;
import com.sepulcrum.model.pessoas.utils.Pessoas;
import com.sepulcrum.model.pessoas.utils.PessoasVivas;
import com.sepulcrum.model.view.TelaRegistroGeral;

public class GerenciadorGeral {
    private List<Cemiterio> listC = new ArrayList<>();
    private List<Tumulo> ListT = new ArrayList<>();
    private List<Adm> ListA = new ArrayList<>();
    private List<Familiar> ListFam = new ArrayList<>();
    private List<Finado> ListFin = new ArrayList<>();

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

    public void setLocalidade(TelaRegistroGeral trg, Localidade l){
        validarCampo(trg.getJtfFourString(), "Rua");
        validarCampo(trg.getJtfFiveString(), "Número");

        l.setRua(trg.getJtfFourString());
        l.setNumero(trg.getJtfFiveString());
    }

    public void setCemiterio(TelaRegistroGeral trg){
        Cemiterio c = new Cemiterio(
            trg.getJtfFourString(), // rua
            trg.getJtfFiveString(), // numero
            trg.getJtfNine(),       // cnpj
            trg.getJtfOne(),        // nome
            trg.getJtfTwo(),        // estado
            trg.getJtfThree(),      // cidade
            trg.getJtfEight(),      // telefone
            trg.getJtfSix(),        // cep
            trg.getJtfTen()         // admCpf
            );

        setLocalidade(trg, c);
        validarCampo(trg.getJtfNine(), "CNPJ");
        validarCampo(trg.getJtfOne(), "Nome");
        validarCampo(trg.getJtfTwo(), "Estado");
        validarCampo(trg.getJtfThree(), "Cidade");
        validarCampo(trg.getJtfEight(), "Telefone");
        validarCampo(trg.getJtfSix(), "Cep");
        validarCampo(trg.getJtfTen(), "Adiministrador");
        c.setCnpj(trg.getJtfNine());
        c.setNome(trg.getJtfOne());
        c.setEstado(trg.getJtfTwo());
        c.setCidade(trg.getJtfThree());
        c.setTelefone(trg.getJtfEight());
        c.setCep(trg.getJtfSix());
        c.setAdmCpf(trg.getJtfTen());
        c.setCapacidadeMax(trg.getJtfSevenInt());
        
        listC.add(c);
    }
    
    public void setTumulo(TelaRegistroGeral trg){
        Tumulo t = new Tumulo(
            trg.getJtfFourString(), // rua
            trg.getJtfFiveString(), // numero
            trg.getJtfOne(),        // tipo
            trg.getJtfTwo(),        // situacao
            trg.getJtfThree(),      // dataOcupacao
            trg.getJtfSix()         // cemCnpj
            );
            
        setLocalidade(trg, t);
        validarCampo(trg.getJtfOne(), "Tipo");
        validarCampo(trg.getJtfTwo(), "Situação");
        validarCampo(trg.getJtfThree(), "Data de Ocupação");
        validarCampo(trg.getJtfSix(), "CNPJ");
        t.setTipo(trg.getJtfOne());
        t.setSituacao(trg.getJtfTwo());
        t.setDataOcupacao(trg.getJtfThree());
        t.setCemCnpj(trg.getJtfSix());
        
        ListT.add(t);
    }

    public void setPessoa(TelaRegistroGeral trg, Pessoas p){
        validarCampo(trg.getJtfOne(), "Nome");
        validarCampo(trg.getJtfTwo(), "Cpf");
        validarCampo(trg.getJtfFourDate(), "Data de Nascimento");

        p.setNome(trg.getJtfOne());
        p.setCpf(trg.getJtfTwo());
        p.setRg(trg.getJtfThree());
        p.setDataNascimento(trg.getJtfFourDate());
    }

    public void setPessoasVivas(TelaRegistroGeral trg, PessoasVivas pv){
        validarCampo(trg.getJtfSix(), "Email");
        validarCampo(trg.getJtfSevenString(), "Telefone");

        pv.setEmail(trg.getJtfSix());
        pv.setTelefone(trg.getJtfSevenString());
    }
    
    public void setAdm(TelaRegistroGeral trg){
        Adm a = new Adm(
            trg.getJtfOne(),         // nome
            trg.getJtfTwo(),         // cpf
            trg.getJtfFourDate(),    // dataNascimento
            trg.getJtfSix(),         // email
            trg.getJtfSevenString(), // telefone
            trg.getJtfEight(),       // cargo
            trg.getJtfNine(),        // cemCnpj
            trg.getJtfFiveDate()     // dataContratacao
        );

        setPessoa(trg, a);
        setPessoasVivas(trg, a);
        validarCampo(trg.getJtfEight(), "Cargo");
        validarCampo(trg.getJtfNine(), "CNPJ");
        validarCampo(trg.getJtfFiveDate(), "Data de Contratação");
        a.setCargo(trg.getJtfEight());
        a.setCemCnpj(trg.getJtfNine());
        a.setDataContratacao(trg.getJtfFiveDate());

        ListA.add(a);
    }

    public void setFamiliar(TelaRegistroGeral trg){
        Familiar fam = new Familiar(
            trg.getJtfOne(),         // nome
            trg.getJtfTwo(),         // cpf
            trg.getJtfFourDate(),    // dataNascimento
            trg.getJtfSix(),         // email
            trg.getJtfSevenString(), // telefone
            trg.getJtfFiveString()   // grauParentesco
        );

        setPessoa(trg, fam);
        setPessoasVivas(trg, fam);
        validarCampo(trg.getJtfFiveString(), "Grau de Parentesco");
        validarCampo(trg.getJtfEight(), "Certidão de Óbito");
        fam.setGrauParentesco(trg.getJtfFiveString());
        fam.setCertidaoObito(trg.getJtfEight());

        ListFam.add(fam);
    }

    public void setFinado(TelaRegistroGeral trg){
        Finado fin = new Finado(
            trg.getJtfOne(),        // nome
            trg.getJtfTwo(),        // cpf
            trg.getJtfFourDate(),   // dataNascimento
            trg.getJtfSix(),        // causaMorte
            trg.getJtfEight(),      // tumRua
            trg.getJtfNine(),       // tumNumero
            trg.getJtfSevenString() // certidaoObito
        );

        setPessoa(trg, fin);
        validarCampo(trg.getJtfSix(), "Causa da Morte");
        validarCampo(trg.getJtfEight(), "Rua do Túmulo");
        validarCampo(trg.getJtfNine(), "Número do Túmulo");
        validarCampo(trg.getJtfSevenString(), "Certidão de Óbito");
        fin.setCausaMorte(trg.getJtfSix());
        fin.setTumRua(trg.getJtfEight());
        fin.setTumRua(trg.getJtfNine());
        fin.setCertidaoObito(trg.getJtfSevenString());

        ListFin.add(fin);
    }

    public void getLocalidade(TelaRegistroGeral trg, Localidade l){
        trg.setJtfFour(l.getRua());
        trg.setJtfFive(l.getNumero());
    }

    public void getCemiterio(TelaRegistroGeral trg, Cemiterio c){
        getLocalidade(trg, c);
        trg.setJtfNine(c.getCnpj());
        trg.setJtfOne(c.getNome());
        trg.setJtfTwo(c.getEstado());
        trg.setJtfThree(c.getCidade());
        trg.setJtfEight(c.getTelefone());
        trg.setJtfSix(c.getCep());
        trg.setJtfTen(c.getAdmCpf());
        trg.setJtfSeven(Integer.toString(c.getCapacidadeMax()));
    }
    
    public void getTumulo(){
        
    }

    public void getPessoa(){
        
    }

    public void getPessoasVivas(){
        
    }

    public void getAdm(){
        
    }

    public void getFamiliar(){

    }

    public void getFinado(){
        
    }
}