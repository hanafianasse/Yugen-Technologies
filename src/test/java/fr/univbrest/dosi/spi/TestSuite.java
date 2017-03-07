package fr.univbrest.dosi.spi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univbrest.dosi.spi.controller.EnseignantControllerTest;
import fr.univbrest.dosi.spi.service.EnseignantServiceTests;

/**
 * @author DOSI
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ EnseignantControllerTest.class, EnseignantServiceTests.class })
public class TestSuite {

	/**
	 *
	 */
	public TestSuite() {
	}

}
