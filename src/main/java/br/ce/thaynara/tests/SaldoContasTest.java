package br.ce.thaynara.tests;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.thaynara.core.BaseTest;
import br.ce.thaynara.core.Propriedades;
import br.ce.thaynara.pages.HomePage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaldoContasTest extends BaseTest{
	
	private HomePage homePage = new HomePage();
	
	@Test
	public void test1_ConsultarSaldoContas() {
	Assert.assertEquals("400.00", homePage.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));		
	}

}
