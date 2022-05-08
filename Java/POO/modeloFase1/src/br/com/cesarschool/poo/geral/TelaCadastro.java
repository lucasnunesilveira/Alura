package br.com.cesarschool.poo.geral;
import java.util.Scanner;

public class TelaCadastro {
	
	private static final int CODIGO_DESCONHECIDO = -1;
	private static final Scanner ENTRADA = new Scanner(System.in);
	private RepositorioProduto repositorioProduto = new RepositorioProduto();
	
	public void executaTela() {
		while(true) {
			long codigo = CODIGO_DESCONHECIDO;
			imprimeMenuPrincipal();
			int opcao = ENTRADA.nextInt();
			if (opcao == 1) {
				processaInclusao();
			} else if (opcao == 2) {
				codigo = processaBusca();
				if (codigo != CODIGO_DESCONHECIDO) {
					processaAlteracao(codigo);
				} 
			} else if (opcao == 3) {
				codigo = processaBusca();
				if (codigo != CODIGO_DESCONHECIDO) {
					processaExclusao(codigo);
				}			
			} else if (opcao == 4) {
				processaBusca();
			}else if (opcao == 5) {
				System.out.println("Opção foi 5><><<>");
			}else if (opcao == 6) {
				System.out.println("Opção foi 6><><<>");
			} 
			else if (opcao == 7) {
				System.out.println("Saindo do cadastro de contas");
				System.exit(0);
			} else {
				System.out.println("Opcao invalida!!");
			}
		} 
	}
	
	private void imprimeMenuPrincipal() {		
		System.out.println("1- Criar Conta");
		System.out.println("2- Alterar Contar");
		System.out.println("3- Excluir Contar");
		System.out.println("4- Buscar Conta");
		System.out.println("5- Creditar");
		System.out.println("6- Debitar");
		System.out.println("7- Sair");
		System.out.print("Digite a opcao: ");
	}	
	
	private void processaInclusao() {
		Conta produto = capturaProduto(CODIGO_DESCONHECIDO);
		String retornoValidacao = validar(produto);
		if (retornoValidacao == null) {
			boolean retornoRepositorio = repositorioProduto.incluir(produto);
			if (retornoRepositorio) {
				System.out.println("Produto inclu�do com sucesso!");
			} else {
				System.out.println("Erro na inclus�o de produto!");
			}
		} else {
			System.out.println(retornoValidacao);
		}		
	}
	
	private void processaAlteracao(long codigo) {
		Conta produto = capturaProduto(codigo);
		String retornoValidacao = validar(produto);
		if (retornoValidacao == null) {
			boolean retornoRepositorio = repositorioProduto.alterar(produto);
			if (retornoRepositorio) {
				System.out.println("Produto alterado com sucesso!");
			} else {
				System.out.println("Erro na altera��o de produto!");
			}
		} else {
			System.out.println(retornoValidacao);
		}		
	}
	
	private long processaBusca() {
		System.out.print("Digite o c�digo: ");
		long codigo = ENTRADA.nextLong();
		Conta produto = repositorioProduto.buscar(codigo);
		if (produto == null) {
			System.out.println("Produto n�o encontrado!");
			return CODIGO_DESCONHECIDO;
		} else {
			System.out.println("C�digo: " + produto.getCodigo());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Pre�o: " + produto.getPreco());
			System.out.println("Tipo: " + produto.getTipo().getDescricao());
			return codigo;
		}
	}
	
	private void processaExclusao(long codigo) {
		boolean retornoRepositorio = repositorioProduto.excluir(codigo);
		if (retornoRepositorio) {
			System.out.println("Produto exclu�do com sucesso!");
		} else {
			System.out.println("Erro na exclus�o de produto!");
		}
	}
	
	private Conta capturaProduto(long codigoDaAlteracao) {
		long codigo; 
		if (codigoDaAlteracao == CODIGO_DESCONHECIDO) {
			System.out.print("Digite o numero da conta: ");
			codigo = ENTRADA.nextLong();			
		} else {
			codigo = codigoDaAlteracao;
		}
		System.out.print("Digite o saldo: ");
		double preco = ENTRADA.nextDouble();
		System.out.print("Digite o Status da conta (1-ativada, 2-inexistente ou 3-bloquada): ");
		int codigoTipo = ENTRADA.nextInt();
		TipoCorrentista tipo = TipoCorrentista.obterPorCodigo(codigoTipo);
		return new Conta(codigo, null, preco, tipo);
	}
	
	private String validar(Conta conta) {
		if (!conta.codigoValido()) {
			return "Codigo invalido!";
		}else if (!conta.precoValido()) {
			return "Saldo invalido!";
		} else if (!conta.tipoPreechido()) {
			return "Tipo nao preenchido!";
		} else {
			return null;
		}
	}
}


