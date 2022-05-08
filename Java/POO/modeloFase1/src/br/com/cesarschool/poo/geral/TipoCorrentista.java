package br.com.cesarschool.poo.geral;

/**
 * Pesquisar sobre "enum" em Java, ler sobre e se inteirar do assunto
 * para criar um enum TipoCorrentista na atividade continuada
 */
public enum TipoCorrentista {
	ATIVO(1, "ATIVO"), 
	ENCERRADO(2, "ENCERRADA"), 
	BLOQUEADA(3,"BLOQUEADA"); 
	
	private int codigo;
	private String descricao;
	
	private TipoCorrentista(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public static TipoCorrentista obterPorCodigo(int codigo) {
		for (TipoCorrentista tipoCorrentista : TipoCorrentista.values()) {
			if (tipoCorrentista.getCodigo() == codigo) {
				return tipoCorrentista;
			}
		}
		return null;
	}
}
