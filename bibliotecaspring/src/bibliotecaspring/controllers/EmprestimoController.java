package bibliotecaspring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaspring.dao.AlunoDAO;
import bibliotecaspring.dao.EmprestimoDAO;
import bibliotecaspring.dao.LivroDAO;
import bibliotecaspring.models.Aluno;
import bibliotecaspring.models.Emprestimo;
import bibliotecaspring.models.Livro;

@Controller

public class EmprestimoController {
	@RequestMapping("/Emprestimo/formEmp")
	public ModelAndView form() {
		System.out.println("Chamou método form");
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> listaAluno = alunoDAO.getLista();
		LivroDAO livroDAO = new LivroDAO();
		List<Livro> listaLivro = livroDAO.getLista();
		ModelAndView model = new ModelAndView("Emprestimo/formEmp");
		model.addObject("aluno", listaAluno);
		model.addObject("livro", listaLivro);
		return model;

	}
	
	@PostMapping("/Emprestimo/formEmp")
	public String AdicionarEmprestimo(Emprestimo emprestimo) {
		System.out.println(emprestimo);
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
				emprestimoDAO.inserir(emprestimo);
		return "Emprestimo/EmprestimoCadastrado";
	}


	@GetMapping("/Emprestimo/ListarEmp")
	public ModelAndView listar() {
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> listaEmprestimo = emprestimoDAO.getLista();
		ModelAndView model = new ModelAndView("Emprestimo/ListarEmp");
		model.addObject("Emprestimo", listaEmprestimo);
		return model;
	}


	@RequestMapping("/Emprestimo/devolucao")
	public String devolucao(Emprestimo emprestimo) {
		System.out.println("Chamou o método devolução");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		System.out.println(emprestimo);
		emprestimoDAO.devolucao(emprestimo);
		
		return "redirect:../Emprestimo/ListarEmp";

	}
}
