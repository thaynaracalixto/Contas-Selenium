package br.ce.thaynara.tests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import br.ce.thaynara.core.BaseTest;
import br.ce.thaynara.core.DriverFactory;
import br.ce.thaynara.pages.MenuPage;
import br.ce.thaynara.pages.ResumoPage;

public class DesafioResumoMensalVazio extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	
	@Test /*(expected=NoSuchElementException) - Essa exceção é generica é pode não funcionar para todos os casos*/
	//Verificando que de fato não há nenhum registro na Tabela Extrato
	public void deveVerificarResumoVazio() {
		menuPage.acessarResumoMensal();			
		
		try {
			DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"tabelaExtrato\"]/tbody/tr"));
			Assert.fail();
		}
		catch (NoSuchElementException e){
			
		}
	}

}
