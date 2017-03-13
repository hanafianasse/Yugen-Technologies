package fr.univbrest.dosi.spi.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.spi.bean.Question;
import fr.univbrest.dosi.spi.dao.QuestionRepository;

public class QuestionDAOStub implements QuestionRepository {
	
	private List<Question> donnees;
	Question Question;

	QuestionDAOStub() {
		this.setDonnees(Lists.newArrayList());
	}

	QuestionDAOStub(List<Question> setUpData) {
		this.setDonnees(Lists.newArrayList(setUpData));
	}


	@Override
	public Page<Question> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return getDonnees().size();
	}

	@Override
	public void delete(Long noQuestion) {
		for(Iterator<Question> iter = getDonnees().listIterator(); iter.hasNext();)
		{
			Question e = iter.next();
			
			if(e.getIdQuestion()==(noQuestion))
					iter.remove();
		}
	}

	@Override
	public void delete(Question arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Question> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public Iterable<Question> findAll() {
		return this.getDonnees();
	}

	

	@Override
	public Question findOne(Long noQuestion) {
		
		return this.getDonnees().get(0);
	}

	@Override
	public <S extends Question> S save(S entity) {
		this.getDonnees().add(entity);

		return entity;
	}

	@Override
	public <S extends Question> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Question> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<fr.univbrest.dosi.spi.bean.Question> findAll(
			Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getDonnees() {
		return donnees;
	}

	public void setDonnees(List<Question> donnees) {
		this.donnees = donnees;
	}

}
