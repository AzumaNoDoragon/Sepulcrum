package classeServico;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exumacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idExumacao, idAdm, idTumulo, idDefunto;
	private String motivoExumacao, informacaoExumacao;
	private Calendar dataExumacao;

	
}