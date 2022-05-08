package br.com.cesarschool.poo.geral;
import java.util.Scanner;

public class TelaCadastro {

	private static final int CODIGO_DESCONHECIDO = -1;
	private static final Scanner ENTRADA = new Scanner(System.in);
	private RepositorioConta repositorioProduto = new RepositorioConta();
	private long codigo;

	public void executaTela() {
		while (true) {
			long numero = CODIGO_DESCONHECIDO;
			imprimeMenuPrincipal();
			int opcao = ENTRADA.nextInt();
			if (opcao == 1) {
				processaInclusao();
			} else if (opcao == 2) {
				numero = processaBusca();
				if (numero != CODIGO_DESCONHECIDO) {
					processaAlteracao(numero);
				}
			} else if (opcao == 3) {
				numero = processaBusca();
				if (numero != CODIGO_DESCONHECIDO) {
					processaExclusao(numero);
				}
			} else if (opcao == 4) {
				processaBusca();
			} else if (opcao == 5) {
				System.out.println("Qual valor vc deseja depositar: ");
				double depositar = ENTRADA.nextDouble();				
				//Conta.creditar(depositar);
			} else if (opcao == 6) {
				System.out.println("Qual valor vc deseja sacar: ");
				double sacar = ENTRADA.nextDouble();	
				//Conta.debitar(sacar);
			} else if (opcao == 7) {
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
		Conta conta = capturaConta(CODIGO_DESCONHECIDO);
		String retornoValidacao = validar(conta);
		if (retornoValidacao == null) {
			boolean retornoRepositorio = repositorioProduto.incluir(conta);
			if (retornoRepositorio) {
				System.out.println("Conta cadastrada  com sucesso!");
			} else {
				System.out.println("Erro na inclusao de produto!");
			}
		} else {
			System.out.println(retornoValidacao);
		}
	}

	private void processaAlteracao(long numero) {
		Conta conta = capturaConta(numero);
		String retornoValidacao = validar(conta);
		if (retornoValidacao == null) {
			boolean retornoRepositorio = repositorioProduto.alterar(conta);
			if (retornoRepositorio) {
				System.out.println("Produto alterado com sucesso!");
			} else {
				System.out.println("Erro na alteracao na conta !");
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
			System.out.println("Numero: " + produto.getNumero());
			System.out.println("saldo: " + produto.getSaldo());
			System.out.println("Status: " + produto.getStatus());
			return codigo;
		}
	}

	private void processaExclusao(long codigo) {
		boolean retornoRepositorio = repositorioProduto.excluir(codigo);
		if (retornoRepositorio) {
			System.out.println("Conta excluida com sucesso!");
		} else {
			System.out.println("Erro na exclusao de conta!");
		}
	}

	private Conta capturaConta(long codigoDaAlteracao) {
		if (codigoDaAlteracao == CODIGO_DESCONHECIDO) {
			System.out.print("Digite o numero da conta: ");
			codigo = ENTRADA.nextLong();
		} else {
			codigo = codigoDaAlteracao;
		}
		System.out.print("Digite o saldo: ");
		double saldo = ENTRADA.nextDouble();
		System.out.print("Digite o Status da conta (1-ativada, 2-inexistente ou 3-bloquada): ");
		int codigoStatus = ENTRADA.nextInt();
		TipoCorrentista tipo = TipoCorrentista.obterPorCodigo(codigoStatus);
		return new Conta();
	}
	private String validar(Conta conta) {
		if (!conta.codigoValido()) {
			return "Codigo invalido!";
		} else if (!conta.precoValido()) {
			return "Saldo invalido!";
		} else if (!conta.tipoPreechido()) {
			return "Tipo nao preenchido!";
		} else {
			return null;
		}
	}
}
