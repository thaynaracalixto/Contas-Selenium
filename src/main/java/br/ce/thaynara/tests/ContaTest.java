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
public class ContaTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ContasPage telaConta = new ContasPage();
	
	
	@Test
	public void test1_InserirConta() {
		menuPage.acessarInserirConta();
		telaConta.nomeConta("Conta Teste");
		telaConta.salvar();	
		Assert.assertEquals("Conta adicionada com sucesso!", ContasPage.obterMsgSucesso());
	}
	
	@Test
	public void test2_AlterarConta() {
		menuPage.acessarListarContas();
		telaConta.clicarAlterarConta("Conta Teste");
		telaConta.nomeConta(Propriedades.NOME_CONTA_ALTERADA);
		telaConta.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", ContasPage.obterMsgSucesso());
	}
	
	@Test
	public void test3_InserirContaComNomeIgual() {
		menuPage.acessarInserirConta();
		telaConta.nomeConta(Propriedades.NOME_CONTA_ALTERADA);
		telaConta.salvar();	
		Assert.assertEquals("Já existe uma conta com esse nome!", ContasPage.obterMsgErro());		
	}

}
