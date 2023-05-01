package br.ce.thaynara.pages;

import org.openqa.selenium.By;

import br.ce.thaynara.core.DriverFactory;

public class ResumoPage extends BasePage {
	
	public void excluirMovimentacao() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@class='glyphicon glyphicon-remove-circle']")).click();
	}
	
	public String obterMsgSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

}
