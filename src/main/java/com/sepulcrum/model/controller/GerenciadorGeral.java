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
        System.out.println("Nome: " + trg.getJtfOne());
        System.out.println("Estado: " + trg.getJtfTwo());
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
        c.setCapacidadeMax(trg.getJtfSevenInt());

        listC.add(c);
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

        ListA.add(a);
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
            trg.getJtfFiveString(), // grauParentesco
            trg.getJtfSix(),        // email
            trg.getJtfSevenString() // telefone
        );

        ListFam.add(fam);
    }

    public void setFinado(TelaRegistroGeral trg){
        validarCampo(trg.getJtfOne(), "Nome");
        validarCampo(trg.getJtfTwo(), "Cpf");
        validarCampo(trg.getJtfFourDate(), "Data de Nascimento");
        validarCampo(trg.getJtfSix(), "Causa da Morte");
        validarCampo(trg.getJtfSevenString(), "Certidão de Óbito");
        validarCampo(trg.getJtfEight(), "Rua do Túmulo");
        validarCampo(trg.getJtfNine(), "Número do Túmulo");

        Finado fin = new Finado(
            trg.getJtfOne(),        // nome
            trg.getJtfTwo(),        // cpf
            trg.getJtfFourDate(),   // dataNascimento
            trg.getJtfSix(),        // causaMorte
            trg.getJtfEight(),      // tumRua
            trg.getJtfNine(),       // tumNumero
            trg.getJtfSevenString() // certidaoObito
        );

        fin.setNome(trg.getJtfOne());
        fin.setCpf(trg.getJtfTwo());
        fin.setRg(trg.getJtfThree());
        fin.setDataNascimento(trg.getJtfFourDate());
        fin.setCausaMorte(trg.getJtfSix());
        fin.setTumRua(trg.getJtfEight());
        fin.setTumRua(trg.getJtfNine());
        fin.setCertidaoObito(trg.getJtfSevenString());

        ListFin.add(fin);
    }

    public Cemiterio busca(int id) {
        for (Cemiterio c : listC) {
            if (c.getCnpj().equals(Integer.toString(id))) {
                return c;
            }
    }
        System.out.println("Nada encontrado");
        return null; // se não encontrar
    }

    public void Select(int seletor, int seletorCrud, int id){
        try{
            switch (seletor) {
                case 1:
                Cemiterio c = busca(id);
                System.out.println("Depois do switch");
                if (c == null) {
                    JOptionPane.showMessageDialog(null, "Cemitério com ID " + id + " não encontrado.");
                    new TelaGerenciadorGeral(seletor);
                } else {
                    TelaRegistroGeral trg = new TelaRegistroGeral(seletor, seletorCrud, id);
                    getCemiterio(trg, c);
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