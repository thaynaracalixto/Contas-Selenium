package br.ce.thaynara.pages;

public class MenuPage extends BasePage {
	
	public void acessarInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarListarContas() {
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void acessarPaginaMovimentação() {
		clicarLink("Criar Movimentação");
	}
	
	public void acessarResumoMensal() {
		clicarLink("Resumo Mensal");
	}

}
