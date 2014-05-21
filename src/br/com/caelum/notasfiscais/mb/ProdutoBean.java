package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
@RequestScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = -7306878774186871984L;

	private Produto produto = new Produto();
	
	private List<Produto> produtos;
	
	@Inject
	private ProdutoDao produtoDao;
	
	public ProdutoBean() {
	}
	
	public void grava() {
		if (produto.getId() == null) {
			produtoDao.adiciona(produto);
		} else {
			produtoDao.atualiza(produto);
		}
		limpaFormulario();
	}

	public List<Produto> getProdutos() {
		if (this.produtos == null) {
			this.produtos = produtoDao.listaTodos();
		}
		return produtos;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void remove(Produto produto) {
		produtoDao.remove(produto);
		limpaFormulario();
	}
	
	private void limpaFormulario() {
		this.produto = new Produto();
		this.produtos = null;
	}
	
}
