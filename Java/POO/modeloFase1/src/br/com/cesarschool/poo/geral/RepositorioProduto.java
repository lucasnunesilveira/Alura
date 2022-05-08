package br.com.cesarschool.poo.geral;

/**
 * @author An�nimo
 *
 * Implementa��o prim�ria para efeito did�tico.
 * Ser� enormemente melhorada!!!
 */
public class RepositorioProduto {

	private static final int TAMANHO_MAX_PRODUTOS = 1000;
	
	private Conta[] cadastroProduto = new Conta[TAMANHO_MAX_PRODUTOS];
	private int tamanhoAtual = 0;
	
	public boolean incluir(Conta produto) {
		if (buscarIndice(produto.getCodigo()) != -1) {
			return false;
		} else if (tamanhoAtual == TAMANHO_MAX_PRODUTOS - 1) {
			return false;
		} else {
			for (int i = 0; i < cadastroProduto.length; i++) {
				if (cadastroProduto[i] == null) {
					cadastroProduto[i] = produto;
					break;
				}
			}
			tamanhoAtual++; 
			return true; 
		}
	}
	public boolean alterar(Conta produto) {
		int indice = buscarIndice(produto.getCodigo()); 
		if (indice == -1) {
			return false;
		} else {
			cadastroProduto[indice] = produto;
			return true; 
		}
	}
	
	public Conta buscar(long codigo) {
		int indice = buscarIndice(codigo);
		if (indice == -1) {
			return null;
		} else {
			return cadastroProduto[indice];
		}
	}
	
	public boolean excluir(long codigo) {
		int indice = buscarIndice(codigo);
		if (indice == -1) {
			return false;
		} else {
			cadastroProduto[indice] = null;
			tamanhoAtual--;
			return true;
		}		
	}
	
	private int buscarIndice(long codigo) {		
		for (int i = 0; i < cadastroProduto.length; i++) {
			Conta conta = cadastroProduto[i];
			if (conta != null && conta.getCodigo() == codigo) {
				return i; 				
			}
		}
		return -1;
	}
}
