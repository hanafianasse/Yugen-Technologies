package fr.univbrest.dosi.spi.controller;

/**
 * 
 * @author Red1
 *
 */

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.CgRefCode;
import fr.univbrest.dosi.spi.service.DomainesService;

@RestController
@RequestMapping(value = "/domaine")
@Api(value = "domaine", description = "Description de la ressource domaine.")
public class DomainesController
{

	@Autowired
	DomainesService domainesService;

	/**
	 * 
	 * @param rvDomain
	 * @return une liste de domaines
	 */

	@RequestMapping(value = "/{rvDomain}")
	public final List<CgRefCode> getDomainByRvDomain(
			@PathVariable(value = "rvDomain") final String rvDomain)
	{
		List<CgRefCode> domaines = domainesService
				.getDomainByRvDomain(rvDomain);
		return domaines;
	}
}
