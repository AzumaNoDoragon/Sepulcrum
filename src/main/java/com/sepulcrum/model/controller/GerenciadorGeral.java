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

    private void validarCampo(Integer campo, String nomeCampo){
        if(campo == null || campo == 0){
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
        validarCampo(trg.getJtfSixString(), "Email");
        validarCampo(trg.getJtfSevenString(), "Telefone");

        pv.setEmail(trg.getJtfSixString());
        pv.setTelefone(trg.getJtfSevenString());
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
            trg.getJtfSixString(),  // cep
            trg.getJtfTen()         // admCpf
        );

        setLocalidade(trg, c);


    }

    public void setTumulo(TelaRegistroGeral trg){
        Tumulo t = new Tumulo(
            null,
            null,
            null,
            null,
            null,
            0
        );

        setLocalidade(trg, t);

    }

    public void setAdm(TelaRegistroGeral trg){
        Adm a = new Adm(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );

        setPessoa(trg, a);
        setPessoasVivas(trg, a);

    }

    public void setFamiliar(TelaRegistroGeral trg){
        Familiar fam = new Familiar(null,
            null,
            null,
            null,
            null,
            null
        );

        setPessoa(trg, fam);
        setPessoasVivas(trg, fam);

    }

    public void setFinado(TelaRegistroGeral trg){
        Finado fin = new Finado(null,
            null,
            null,
            null,
            null,
            null,
            null
        );

        setPessoa(trg, fin);
    }
}