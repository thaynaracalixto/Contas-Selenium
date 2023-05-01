package br.ce.thaynara.pages;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePage extends BasePage {
	
	public String obterSaldoConta(String conta) {
		return obterCelula("Conta", conta, "Saldo", "tabelaSaldo").getText();

			
		}
	}
