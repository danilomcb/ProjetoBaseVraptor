package br.com.projetobase.arq.web;

import java.util.Collection;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
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
	
	@Get
	@Path("/form/{entidade.id}")
	public void form(T entidade) {
		T entidadePersistida = getRepository().find(entidade.getId());
		result.include("entidade", entidadePersistida);
	}
	
	@Transactional
	public void salvar(T entidade) {
		validator.validate(entidade);
		validate(entidade);
		validator.onErrorUsePageOf(this).form();
		
		if (entidade.getId() != null && entidade.getId() != 0) {
			getRepository().update(entidade);
		} else {
			getRepository().save(entidade);
		}
		result.redirectTo(this).list();
	}
	
	public T show(T entidade) {
		T entity = getRepository().find(entidade.getId());
		return entity;
	}
	
	@Get
	@Path("/remover/{entidade.id}")
	@Transactional
	public void remover(T entidade) {
		getRepository().remove(entidade);
		result.redirectTo(this).list();
	}
	
	public void list() {
		Collection<T> entidadesCadastradas = getRepository().all();
		result.include("entidades", entidadesCadastradas);
	}

}