package br.ce.thaynara.tests;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.thaynara.core.BaseTest;
import br.ce.thaynara.pages.MenuPage;
import br.ce.thaynara.pages.MovimentacaoPage;

public class RegrasMovTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void regraMovUm() {
		menuPage.acessarPaginaMovimentação();
		movPage.informarDataMov("13/04/2023");
		movPage.salvar();
		List<String> erros = movPage.obterMsgErros();	
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data do pagamento é obrigatório", "Descrição é obrigatório",
						"Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(5, erros.size());
	}
	
	@Test
	public void regraMovDois() {
		menuPage.acessarPaginaMovimentação();
		movPage.informarDataMov("13/04/2023");
		movPage.informarDataPag("12/04/2023");
		movPage.salvar();
		List<String> erros = movPage.obterMsgErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList("Descrição é obrigatório",
						"Interessado é obrigatório","Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(4, erros.size());
	}
	
	@Test
	public void regraMovTres() {
		menuPage.acessarPaginaMovimentação();
		movPage.informarDataMov("13/04/2023");
		movPage.informarDataPag("12/04/2023");
		movPage.descriçãoMov("Movimentacao tal");
		movPage.salvar();
		List<String> erros = movPage.obterMsgErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList("Interessado é obrigatório",
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(3, erros.size());
	}
	
	@Test
	public void regraMovQuatro() {
		menuPage.acessarPaginaMovimentação();
		movPage.informarDataMov("13/04/2023");
		movPage.informarDataPag("12/04/2023");
		movPage.descriçãoMov("Movimentacao tal");
		movPage.informarInteressado("Alguem");
		movPage.salvar();
		List<String> erros = movPage.obterMsgErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList("Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(2, erros.size());
	}
	
	@Test
	public void regraMovCinco() {
		menuPage.acessarPaginaMovimentação();
		movPage.informarDataMov("13/04/2023");
		movPage.informarDataPag("12/04/2023");
		movPage.descriçãoMov("Movimentacao tal");
		movPage.informarInteressado("Alguem");
		movPage.informarValor("Cem Reais");
		movPage.salvar();
		List<String> erros = movPage.obterMsgErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList("Valor deve ser um número")));
		Assert.assertEquals(1, erros.size());
	}

}
