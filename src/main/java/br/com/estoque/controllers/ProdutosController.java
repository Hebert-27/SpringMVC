package br.com.estoque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.estoque.daos.ProdutoDAO;
import br.com.estoque.models.Produto;
import br.com.estoque.models.TipoPreco;

@Controller
@RequestMapping("produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
		public String salvar(Produto produto) {
			System.out.println(produto);
			produtoDao.gravar(produto);
			return "produtos/ok";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/listar");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
		
	}
}