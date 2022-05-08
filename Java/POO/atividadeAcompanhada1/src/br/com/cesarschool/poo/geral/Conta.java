package br.com.cesarschool.poo.geral;

class Conta {
	private long numero;
	private double saldo = 0;
	public TipoCorrentista Status;

	private double score;
	
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public TipoCorrentista getStatus() {
		return Status;
	}
	public void setStatus(TipoCorrentista status) {
		Status = status;
	}

	boolean codigoValido() {
		if (this.numero <= 0 ) {
			return false;
		}
		return true;
	}
	
	boolean precoValido() {
		return this.saldo > 0;
	}
	boolean tipoPreechido() {
		return Status != null;
	}
	
	public boolean creditar(double valor) {
		if(TipoCorrentista.ENCERRADO.equals(Status)) {
			return false;
		}else {
			this.saldo = this.saldo + valor;
			return true;
		}
	
	}
	
	public boolean debitar(double valor) {
		if ((this.saldo >= valor) && (TipoCorrentista.BLOQUEADA.equals(Status))) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
		
	
	}
	public void calculaEscore() {
		if (TipoCorrentista.BLOQUEADA.equals(TipoCorrentista.BLOQUEADA)) {
			System.out.println("Conta estar bloqueada, o escore não pode ser calculado");
		}else if(TipoCorrentista.ENCERRADO.equals(Status)) {
			System.out.println("Se a conta estar inativa, o escore é zero");
		}else {
			score = (saldo * 3);
			System.out.println("1-Ouro: " + score);	
			System.out.print("2-PRATA ");
		}
	}
}