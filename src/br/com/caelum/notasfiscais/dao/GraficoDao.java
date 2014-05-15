package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.notasfiscais.modelo.QuantidadePorProduto;

public class GraficoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public List<QuantidadePorProduto> relatorioQuantidadePorProduto() {
		return manager.createQuery(
			  "select new br.com.caelum.notasfiscais.modelo.QuantidadePorProduto(sum(i.quantidade), i.produto) "
			+ " from Item i group by i.produto" , QuantidadePorProduto.class).getResultList();
	}
}