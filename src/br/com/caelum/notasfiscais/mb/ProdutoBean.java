package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = -7306878774186871984L;

	private Produto produto = new Produto();
	
	private List<Produto> produtos;
	
	public ProdutoBean() {
	}
	
	public void grava() {
		if (produto.getId() == null) {
			new ProdutoDao().adiciona(produto);
		} else {
			new ProdutoDao().atualiza(produto);
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

	public void remove(Produto produto) {
		new ProdutoDao().remove(produto);
		limpaFormulario();
	}
	
	private void limpaFormulario() {
		this.produto = new Produto();
		this.produtos = null;
	}
	
}
