package br.ce.thaynara.core;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import br.ce.thaynara.pages.LoginPage;

public class BaseTest {
	
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		page.setEmail("thaynara-calixto@outlook.com");
		page.setSenha("16082018");
		page.entrar();
	}
	
	@After
	public void FecharBrowser() {
		//TakesScreenshot scrensh = (TakesScreenshot) getDriver();
		//File arquivo = scrensh.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(arquivo, new File(testName.getMethodName() + ".jpg"));
		
		
		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
			}
	}
}

