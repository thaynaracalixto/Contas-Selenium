package br.ce.thaynara.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.thaynara.core.DriverFactory;

public class MovimentacaoPage extends BasePage {
	
	public void informarDataMov(String data) {
		escreve("data_transacao", data);
	}
	
	public void informarDataPag(String data) {
		escreve("data_pagamento", data);
	}
	
	public void descriçãoMov(String texto) {
		escreve("descricao", texto);
	}
	
	public void informarInteressado(String interessado) {
		escreve("interessado", interessado);
	}
	
	public void informarValor(String valor) {
		escreve("valor", valor);
	}
	
	public void informarConta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void informarSituacaoPago() {
		clicarRadio("status_pago");
	}
	
	public void informarSituacaoPendente() {
		clicarRadio("status_pendente");
	}
	
	public void salvar() {
		clicarBotao(By.xpath("//button[@class='btn btn-primary']"));
	}
	
	public String obterMsgSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMsgErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public List<String> obterMsgErros() {
		List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> listaRetorno = new ArrayList<String>();
		for (WebElement erro: erros) {
			listaRetorno.add(erro.getText());			
		}
		return listaRetorno;
		
		
	}

}
