package br.ce.thaynara.tests;
import static br.ce.thaynara.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.thaynara.core.BaseTest;
import br.ce.thaynara.pages.MenuPage;
import br.ce.thaynara.pages.ResumoPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoMovTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resPage = new ResumoPage();

	@Test
	public void test1_excluirMovimentacaoTest() {
		menuPage.acessarResumoMensal();	
		resPage.excluirMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", resPage.obterMsgSucesso());
	}
	
	@Test
	public void test2_resumoMensalTest() {
		menuPage.acessarResumoMensal();	
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());		
	}
	
}
