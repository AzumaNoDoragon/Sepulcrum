package classePessoa;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Defunto extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDefunto, idTumulo, idParente, certidaoObito, rgPessoa, cpfPessoa;
	private Boolean pessoaPublicaDefunto;
	private String nomePessoa, causaMorteDefunto;
	private Calendar dataNascimentoDefunto, dataObitoDefunto;

}
