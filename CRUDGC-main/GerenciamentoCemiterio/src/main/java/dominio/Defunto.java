package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Defunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDefunto, idTumulo, idParente, certidaoObitoDefunto, rgDefunto, cpfDefunto;
	private Boolean pessoaPublicaDefunto;
	private String nomeDefunto, causaMorteDefunto;
	private Calendar dataNascimentoDefunto, dataObitoDefunto;
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
@Entity
public class adm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAdm, idCemiterio;
	private String nomeAdm, emailAdm, senhaAdm;
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
@Entity
public class parente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idParente, idDefunto, cpfParente, rgParente;
	private String nomeParente, emailParente, senhaParente;
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
@Entity
public class vistoriaEpidemica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVistoria, idCemiterio, idAdm;
	private String informacaoVistoria;
	private Calendar dataVistoria;
	private Boolean realizadoVistoria;
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
@Entity
public class Cemiterio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCemiterio, numeroCemiterio, telefoneCemiterio, cepCemiterio;
	private String nomeCemiterio, estadoCemiterio, cidadeCemiterio, bairroCemiterio, ruaCemiterio;
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
@Entity
public class manutencaoTumular implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idManutencao, idAdm, idTumulo, dataManutencao, horarioManutencao;
	private String informacaoManutencao;
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
@Entity
public class exumacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idExumacao, idAdm, idTumulo, idDefunto;
	private String motivoExumacao, informacaoExumacao;
	private Calendar dataExumacao;
}