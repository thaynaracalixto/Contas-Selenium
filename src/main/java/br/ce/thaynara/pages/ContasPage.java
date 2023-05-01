package br.ce.thaynara.pages;

import org.openqa.selenium.By;

public class ContasPage extends BasePage {

	
	public void nomeConta (String conta) {
		escreve("nome", conta);
	}
	
	public void salvar () {
		clicarBotao(By.xpath("//button[.='Salvar']"));
	}
	
	public static String obterMsgSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public static String obterMsgErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}

	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
			.findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();
		
	}
	
	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
			.findElement(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
}
