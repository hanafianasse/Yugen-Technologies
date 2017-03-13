package fr.univbrest.dosi.spi.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import fr.univbrest.dosi.spi.bean.Qualificatif;
import fr.univbrest.dosi.spi.dao.QualificatifRepository;

/**
 * 
 */

/**
 * @author Chobaz
 *
 * 10 mars 2017
 */
public class QualificatifDAOStub implements QualificatifRepository
{
	public List<Qualificatif> donnees;
	
	public QualificatifDAOStub()
	{
		donnees = new ArrayList<Qualificatif>();
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)
	 */
	@Override
	public Iterable<Qualificatif> findAll(Sort arg0)
	{
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Qualificatif> findAll(Pageable arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	@Override
	public long count()
	{
		return donnees.size();
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Long idQualificatif)
	{
		for(Iterator<Qualificatif> iter = donnees.listIterator(); iter.hasNext();)
		{
			Qualificatif q = iter.next();
			
			if(q.getIdQualificatif() == idQualificatif)
				iter.remove();
		}
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Qualificatif arg0)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<? extends Qualificatif> arg0)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	@Override
	public void deleteAll()
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#exists(java.io.Serializable)
	 */
	@Override
	public boolean exists(Long idQualificatif)
	{
		return this.findOne(idQualificatif) != null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	@Override
	public Iterable<Qualificatif> findAll()
	{
		return donnees;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
	 */
	@Override
	public Iterable<Qualificatif> findAll(Iterable<Long> arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	@Override
	public Qualificatif findOne(Long idQualificatif)
	{
		for(Qualificatif q: donnees)
		{
			if(q.getIdQualificatif() == idQualificatif)
				return q;
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@Override
	public <S extends Qualificatif> S save(S entity)
	{
		this.donnees.add(entity);
		
		return entity;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Iterable)
	 */
	@Override
	public <S extends Qualificatif> Iterable<S> save(Iterable<S> arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
