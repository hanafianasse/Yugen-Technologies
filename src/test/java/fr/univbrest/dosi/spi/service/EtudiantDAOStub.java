package fr.univbrest.dosi.spi.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.dao.EtudiantRepository;

public class EtudiantDAOStub implements EtudiantRepository {

	private List<Etudiant> donnees;
	Etudiant etudiant;

	EtudiantDAOStub() {
		this.donnees = Lists.newArrayList();
	}

	EtudiantDAOStub(List<Etudiant> setUpData) {
		this.donnees = Lists.newArrayList(setUpData);
	}


	@Override
	public Page<Etudiant> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return donnees.size();
	}

	@Override
	public void delete(String noEtudiant) {
		for(Iterator<Etudiant> iter = donnees.listIterator(); iter.hasNext();)
		{
			Etudiant e = iter.next();
			
			if(e.getNoEtudiant().equals(noEtudiant))
					iter.remove();
		}
	}

	@Override
	public void delete(Etudiant arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Etudiant> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Etudiant> findAll() {
		return this.donnees;
	}

	@Override
	public Iterable<Etudiant> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant findOne(String noEtudiant) {
		
		return this.donnees.get(0);
	}

	@Override
	public <S extends Etudiant> S save(S entity) {
		this.donnees.add(entity);

		return entity;
	}

	@Override
	public <S extends Etudiant> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Etudiant> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
