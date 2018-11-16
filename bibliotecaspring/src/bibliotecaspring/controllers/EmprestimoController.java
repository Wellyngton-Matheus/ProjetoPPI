package bibliotecaspring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaspring.dao.EmprestimoDAO;
import bibliotecaspring.models.Emprestimo;
import bibliotecaspring.models.Relatorio;

@Controller
public class EmprestimoController {

	@RequestMapping("/emprestimo/form")
	public String form() {
		System.out.println("Chamou o form emprestimo");
		return "emprestimo/form";
	}

	@PostMapping("/emprestimo")
	public String adicionar(Emprestimo emprestimo) {
		System.out.println(emprestimo);
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		EmprestimoDAO.inserir(emprestimo);
		return "contatos/contatoOk";
	}

	@GetMapping("/emprestimo")
	public ModelAndView listar() {
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Relatorio> lista = emprestimoDAO.emprestimos();
		ModelAndView model = new ModelAndView("emprestimo/lista");
		model.addObject("emprestimo", lista);
		return model;
	}

}
