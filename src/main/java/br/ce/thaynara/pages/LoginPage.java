package br.ce.thaynara.pages;
import org.openqa.selenium.By;
import br.ce.thaynara.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/logout");
	}
	
	public void setEmail(String email) {
		escreve("email", email);
	}
	
	public void setSenha(String senha) {
		escreve("senha", senha);
	}
	
	public void entrar() {
		clicarBotao(By.xpath("//button[.='Entrar']"));
	}
	
	public void logon(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
}
