package com.sepulcrum.model.controller;

public class GerenciadorGeral {
    /* 
    public void setCemiterio(Cemiterio c){
        c.setNome(trc.inicializarVariaveis());
        System.out.println("Digite o estado: ");
        c.setEstado(teclado.nextLine());
        System.out.println("Digite o cidade: ");
        c.setCidade(teclado.nextLine());
        System.out.println("Digite a rua: ");
        c.setRua(teclado.nextLine());
        System.out.println("Digite o número do lote: ");
        c.setNumero(teclado.nextInt());
        System.out.println("Digite o capacidade máxima: ");
        c.setCapacidadeMax(teclado.nextInt());
        System.out.println("Digite o telefone: ");
        c.setTelefone(teclado.nextLine());
        System.out.println("Digite o cep: ");
        c.setCep(teclado.nextLine());
    }
    
    public void getCemiterio(Cemiterio c){
        if(c != null){ 
            System.out.println("Nome do cemiterio: " + c.getNome());
            System.out.println("Estado: " + c.getEstado());
            System.out.println("Cidade: " + c.getCidade());
            System.out.println("Rua: " + c.getRua());
            System.out.println("Numero: " + c.getNumero());
            System.out.println("Capacidade máxima: " + c.getCapacidadeMax());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Cep: " + c.getCep());
        }
    }

    public void setAdm(Adm a){
        System.out.println("Digite seu nome: ");
        a.setNome(teclado.nextLine());
        System.out.println("Digite seu CPF: ");
        a.setCpf(teclado.nextLine());
        System.out.println("Digite seu RG: ");
        a.setRg(teclado.nextLine());
        System.out.println("Digite sua data de nascimento: ");
        a.setDataNascimento(teclado.nextLine());
        System.out.println("Digite seu e-mail: ");
        a.setEmail(teclado.nextLine());
        System.out.println("Digite seu telefone: ");
        a.setTelefone(teclado.nextLine());
        System.out.println("Digite seu cargo: ");
        a.setCargo(teclado.nextLine());
        System.out.println("Digite a data de contratação: ");
        a.setDataContratacao(teclado.nextLine());
    }

    public void getAdm(Adm a){
        if(a != null){
            System.out.println("Nome: " + a.getNome());
            System.out.println("CPF: " + a.getCpf());
            System.out.println("RG: " + a.getRg());
            System.out.println("Data de Contratação: " + a.getDataContratacao());
            System.out.println("Data de Nascimento: " + a.getDataNascimento());
            System.out.println("E-mail: " + a.getEmail());
            System.out.println("Telefone: " + a.getCargo());
            System.out.println("Data de Contratação: " + a.getDataContratacao());
        } else {
            msgIdInexistente();
        }
            public void setDefunto(Finado d){
    System.out.println("Digite o nome do Finado: ");
    d.setNome(teclado.nextLine());
    System.out.println("Digite o CPF: ");
    d.setCpf(teclado.nextLine());
    System.out.println("Digite o RG: ");
    d.setRg(teclado.nextLine());
    System.out.println("Digite a data de nascimento: ");
    d.setDataNascimento(teclado.nextLine());
    System.out.println("Digite a data de falecimento: ");
    d.setDataFalecimento(teclado.nextLine());
    System.out.println("Digite a causa da morte: ");
    d.setCausaMorte(teclado.nextLine());
    System.out.println("Digite o id do parente: ");
    d.setIdParente(teclado.nextInt());teclado.nextLine();
    System.out.println("Digite o id do tumulo: ");
    d.setIdTumulo(teclado.nextInt());teclado.nextLine();
}

public void getDefunto(Finado d){
    if(d != null){
        System.out.println("nome do Finado: " + d.getNome());
        System.out.println("CPF: " + d.getCpf());
        System.out.println("RG: " + d.getRg());
        System.out.println("Data de nascimento: " + d.getDataNascimento());
        System.out.println("Data de falecimento: " + d.getDataFalecimento());
        System.out.println("Causa da morte: " + d.getCausaMorte());
        System.out.println("Id do parente: " + d.getIdParente());
        System.out.println("Id do tumulo: " + d.getIdTumulo());
    } else {
        msgIdInexistente();
    }

    public int menu() {
    System.out.println("Menu de Parente: ");
    System.out.println("1 - Cadastrar Parente.");
    System.out.println("2 - Apresentar Parente.");
    System.out.println("3 - Listar Parente.");
    System.out.println("4 - Alterar Parente.");
    System.out.println("5 - Deletar Parente.");
    System.out.println("0 - Voltar");
    int opc = teclado.nextInt(); teclado.nextLine();

    return opc;
}

public void setParente(Parente p){
    System.out.println("Digite o nome do Parente Responsável: ");
    p.setNome(teclado.nextLine());
    System.out.println("Digite o CPF: ");
    p.setCpf(teclado.nextLine());
    System.out.println("Digite o RG: ");
    p.setRg(teclado.nextLine());
    System.out.println("Digite a data de nascimento: ");
    p.setDataNascimento(teclado.nextLine());
    System.out.println("Digite o telefone: ");
    p.setTelefone(teclado.nextLine());
    System.out.println("Digite o e-mail: ");
    p.setEmail(teclado.nextLine());
    System.out.println("Digite o grau de parentesco: ");
    p.setGrauParentesco(teclado.nextLine());
    System.out.println("Digite o id do Finado");
    p.setIdDefunto(teclado.nextInt()); teclado.nextLine();
}

public void getParente(Parente p){
    if(p != null){
        System.out.println("O nome é: " + p.getNome());
        System.out.println("O CPF é: " + p.getCpf());
        System.out.println("O Rg é: " + p.getRg());
        System.out.println("A data de nascimento é: " + p.getDataNascimento());
        System.out.println("O telefone é: " + p.getTelefone());
        System.out.println("O e-mail é: " + p.getEmail());
        System.out.println("O grau de parentesco é: " + p.getGrauParentesco());
        System.out.println("O id do parente é: " + p.getIdDefunto());
    } else {
        msgIdInexistente();
    }
        public int menu(){
        System.out.println("Menu do Túmulo: ");
        System.out.println("1 - Cadastrar Túmulo.");
        System.out.println("2 - Apresentar Túmulo.");
        System.out.println("3 - Listar Túmulo.");
        System.out.println("4 - Alterar Túmulo.");
        System.out.println("5 - Deletar Túmulo.");
        System.out.println("0 - Voltar");
        int opc = teclado.nextInt(); teclado.nextLine();

        return opc;
    }

    public void setTumulo(Tumulo t){
        System.out.println("Digite o tipo do tumulo: ");
        t.setTipo(teclado.nextLine());
        System.out.println("Digite a data de ocupação: ");
        t.setDataOcupacao(teclado.nextLine());
        System.out.println("Digite a situação: ");
        t.setSituacao(teclado.nextLine());
        System.out.println("Digite o id do cemiterio: ");
        t.setIdCemiterio(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o bloco do Tumulo: ");
        t.setRua(teclado.nextLine());
        System.out.println("Digite o número do Túmulo: ");
        t.setNumero(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do defunto: ");
        t.setIdDefunto(teclado.nextInt()); teclado.nextLine();
    }
    
    public void getTumulo(Tumulo t){
        if(t != null){
            System.out.println("Tipo do tumulo: " + t.getTipo());
            System.out.println("Data de ocupação: " + t.getDataOcupacao());
            System.out.println("Situação: " + t.getSituacao());
            System.out.println("Id do cemiterio: " + t.getIdCemiterio());
            System.out.println("Id do defunto: " + t.getIdDefunto());
        } else {
            msgIdInexistente();
        }
    */
}