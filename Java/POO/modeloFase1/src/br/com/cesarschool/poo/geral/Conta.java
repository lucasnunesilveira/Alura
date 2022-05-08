package br.com.cesarschool.poo.geral;
public class Conta {
	public static final int SUCESSO = 0;
	public static final int NOME_NAO_INFORMADO = 1; 
	public static final int NOME_MUITO_CURTO = 2; 
	public static final int TAMANHO_MINIMO_NOME = 3;
	
	private long codigo;
	private String nome;
	private double preco;
	private TipoCorrentista tipo;
	
	public Conta(long codigo, String nome, double preco, TipoCorrentista tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public TipoCorrentista getTipo() {
		return tipo;
	}
	public void setTipo(TipoCorrentista tipo) {
		this.tipo = tipo;
	}

	boolean codigoValido() {
		if (this.codigo <= 0 ) {
			return false;
		}
		return true;
	}	
	boolean precoValido() {
		return this.preco > 0;
	}
	boolean tipoPreechido() {
		return tipo != null;
	}
}
