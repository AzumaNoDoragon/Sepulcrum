package dominio;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vistoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVistoria, idCemiterio, idAdm;
	private String informacaoVistoria;
	private Calendar dataVistoria;
	private Boolean realizadoVistoria;
	
}