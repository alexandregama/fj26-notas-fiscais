package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	
	private List<Produto> produtos;
	
	public void grava() {
		ProdutoDao produtoDao = new ProdutoDao();
		if (produto.getId() == null) {
			produtoDao.adiciona(produto);
		} else {
			produtoDao.atualiza(produto);
		}
		limpaFormulario();
	}

	public List<Produto> getProdutos() {
		if (this.produtos == null) {
			this.produtos = new ProdutoDao().listaTodos();
		}
		return produtos;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	private void limpaFormulario() {
		this.produto = new Produto();
		this.produtos = null;
	}

	public void remove(Produto produto) {
		new ProdutoDao().remove(produto);
		limpaFormulario();
	}
}
