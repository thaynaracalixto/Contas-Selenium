package br.ce.thaynara.tests;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.thaynara.core.BaseTest;
import br.ce.thaynara.core.Propriedades;
import br.ce.thaynara.pages.ContasPage;
import br.ce.thaynara.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RemoverContaComMovTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private ContasPage telaConta = new ContasPage();
		
	@Test
	public void test1_ExcluirContaComMovimentacao() {
		menuPage.acessarListarContas();
		telaConta.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		Assert.assertEquals("Conta em uso na movimentações", ContasPage.obterMsgErro());
	}

}
