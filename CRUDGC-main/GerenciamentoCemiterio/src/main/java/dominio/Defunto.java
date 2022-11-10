package dominio;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Defunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDefunto, idTumulo, idParente, certidaoObito, rg, cpf;
	private Boolean pessoaPublica;
	private String nome, causaMorte;
	private Calendar dataNascimento, dataObito;

}
