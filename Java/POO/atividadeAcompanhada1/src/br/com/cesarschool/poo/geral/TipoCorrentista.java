package br.com.cesarschool.poo.geral;

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

	
	public static TipoCorrentista obterPorCodigo(int numero) {
		for (TipoCorrentista tipoCorrentista : TipoCorrentista.values()) {
			if (tipoCorrentista.getCodigo() == numero) {
				return tipoCorrentista;
			}
		}
		return null;
	}
}
