package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	
	public void grava() {
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.adiciona(produto);
		limpaFormulario();
	}

	private void limpaFormulario() {
		this.produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
}
