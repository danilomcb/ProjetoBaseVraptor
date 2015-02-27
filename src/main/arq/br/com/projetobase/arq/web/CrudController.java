package br.com.projetobase.arq.web;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.Validator;
import br.com.projetobase.arq.dao.Dao;
import br.com.projetobase.arq.dominio.AbstractEntity;

public abstract class CrudController<T extends AbstractEntity> extends AbstractController {

	@Inject
	Validator validator;
	
	abstract protected Dao<T> getRepository();
	
	protected void validate(final T entidade) {}

	public void form() {
		
	}
	
	public void save(T entidade) {
		validator.validate(entidade);
		validate(entidade);
		validator.onErrorUsePageOf(this).form();
		
		getRepository().save(entidade);
		result.redirectTo(this).list();
	}

	public T show(T entidade) {
		T entity = getRepository().find(entidade.getId());
		return entity;
	}

	public void list() {
		result.include("entidadeList", getRepository().all());
	}

}