package fr.univbrest.dosi.spi.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.Greeting;
import fr.univbrest.dosi.spi.service.ExempleService;

/**
 * @author DOSI
 *
 */
@RestController
public class ExempleTraitementController {
	/**
	 *
	 */
	private static final String template = "Hello, %s!";
	/**
	 *
	 */
	private final AtomicLong counter = new AtomicLong();
	/**
	 *
	 */
	@Autowired
	private ExempleService exempleService;

	/**
	 *
	 * @param name
	 *            pour tester
	 * @return objet greeting
	 */
	@RequestMapping("/toto")
	public final Greeting greeting(@RequestParam(value = "name", defaultValue = "World") final String name) {

		exempleService.traitement();
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
