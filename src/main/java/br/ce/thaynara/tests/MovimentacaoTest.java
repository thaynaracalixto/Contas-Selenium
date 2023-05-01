package br.ce.thaynara.tests;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.thaynara.core.BaseTest;
import br.ce.thaynara.core.Propriedades;
import br.ce.thaynara.pages.MenuPage;
import br.ce.thaynara.pages.MovimentacaoPage;
import br.ce.thaynara.utils.DataUtils;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1_inserirMovimentacao() {
		menuPage.acessarPaginaMovimentação();
		movPage.informarDataMov(DataUtils.obterDataFormatada(new Date()));
		movPage.informarDataPag(DataUtils.obterDataFormatada(new Date()));
		movPage.descriçãoMov("Movimentacao Qualquer");
		movPage.informarInteressado("Alguem");
		movPage.informarValor("400");
		movPage.informarConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.informarSituacaoPago();
		movPage.salvar();
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMsgSucesso());		
	}
	
	@Test
	public void test2_regrasCamposObrigatoriosMovimentacao() {
		menuPage.acessarPaginaMovimentação();
		movPage.salvar();
		List<String> erros = movPage.obterMsgErros();
		//Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
		//Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));	
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório", 
						"Data do pagamento é obrigatório", "Descrição é obrigatório","Interessado é obrigatório",
						"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3_inserirMovimentacaoFutura() {
		menuPage.acessarPaginaMovimentação();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		//Date dataPassada = DataUtils.obterDataComDiferencaDias(-1);
		
		movPage.informarDataMov(DataUtils.obterDataFormatada(dataFutura));
		//movPage.informarDataMov(DataUtils.obterDataFormatada(dataPassada));
		movPage.informarDataPag(DataUtils.obterDataFormatada(dataFutura));
		movPage.descriçãoMov("Movimentacao tal");
		movPage.informarInteressado("Alguem");
		movPage.informarValor("200");
		movPage.informarConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.informarSituacaoPago();
		movPage.salvar();
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movPage.obterMsgErro());		
	}
	
}
