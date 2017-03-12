package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.dao.PromotionRepository;

public class PromotionDAOStub implements PromotionRepository {

	private List<Promotion> data;

	public PromotionDAOStub() {
		this.data = Lists.newArrayList();
	}

	PromotionDAOStub(List<Promotion> setUpData) {
		this.data = Lists.newArrayList(setUpData);
	}

	@Override
	public Iterable<Promotion> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Promotion> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
	return data.size();
	}

	@Override
	public void delete(PromotionPK arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Promotion arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Promotion> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(PromotionPK arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Promotion> findAll() {
		return this.data;
	}

	@Override
	public Iterable<Promotion> findAll(Iterable<PromotionPK> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion findOne(PromotionPK arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Promotion> S save(S entity) {
		this.data.add(entity);
		return entity;
	}

	@Override
	public <S extends Promotion> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promotion> findByNoEnseignant(Integer noEnseignant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promotion> findByFormation(Formation f) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
