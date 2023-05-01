package br.ce.thaynara.Suites;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.thaynara.core.DriverFactory;
import br.ce.thaynara.tests.ContaTest;
import br.ce.thaynara.tests.MovimentacaoTest;
import br.ce.thaynara.tests.RemoverContaComMovTest;
import br.ce.thaynara.tests.ResumoMovTest;
import br.ce.thaynara.tests.SaldoContasTest;


	@RunWith(Suite.class)
	@SuiteClasses ({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverContaComMovTest.class,
	SaldoContasTest.class,
	ResumoMovTest.class,	
	})
	
	public class SuiteTests {
		
		@AfterClass
		public static void finalizar() {
			DriverFactory.killDriver();
		}
		
}	
