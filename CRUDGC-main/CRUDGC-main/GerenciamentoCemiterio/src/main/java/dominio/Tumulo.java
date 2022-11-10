package dominio;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tumulo extends Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTumulo, idCemiterio, idDefunto, numero;
	private String quadra, rua;
	private Calendar ocupadoDesde;
	private Boolean permanete, ocupado;

}
