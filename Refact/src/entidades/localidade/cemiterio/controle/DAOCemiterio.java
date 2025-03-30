package entidades.localidade.cemiterio.controle;
/* 
package entidades.localidade.cemiterio.gerenciador;

import entidades.localidade.cemiterio.Cemiterio;

public class DAOCemiterio {
    public void setCemiterio(Cemiterio c){
        System.out.println("Conectando...");
        String sql = "INSERT INTO cemiterio (id, rua, numero, nome, estado, cidade, capacidadeMax, telefone, cep) " +
                "VALUES (" +
                    c.getId() + ", '" +
                    c.getRua() + "', " +
                    c.getNumero() + ", '" +
                    c.getNome() + "', '" +
                    c.getEstado() + "', '" +
                    c.getCidade() + "', " +
                    c.getCapacidadeMax() + ", " +
                    c.getTelefone() + ", " +
                    c.getCep() + ")";
        System.out.println("SQL gerado: " + sql);
        System.out.println("Desconectando...");
    }

    public Cemiterio getCemiterio(int id){
        Cemiterio c = new Cemiterio("Rua Exemplo", 1, 100, "Cemitério dos Anjos", "PR", "Curitiba", 5000, 4199999999, 80000000);
        System.out.println("Conectando!");
        String sql = "SELECT * from cemiterio where id =" + id;
        System.out.println("Executando no banco: " + sql);
        System.out.println("Desconectando...");

        return c;
    }
}

*/