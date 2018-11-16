package bibliotecaspring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaspring.dao.AlunoDAO;
import bibliotecaspring.models.Aluno;

@Controller
public class AlunoController {
	@RequestMapping("/aluno/form")
	public String form() {
		System.out.println("Chamou o form aluno");
		return "aluno/form";
	}

	@PostMapping("/aluno")
	public String adicionar(Aluno aluno) {
		System.out.println(aluno);
		AlunoDAO alunoDAO = new AlunoDAO();
		AlunoDAO.inserir(aluno);
		return "redirect:aluno";
	}

	@GetMapping("/aluno")
	public ModelAndView listar() {
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> lista = alunoDAO.getLista();
		ModelAndView model = new ModelAndView("aluno/lista");
		model.addObject("aluno", lista);
		return model;
	}

	@RequestMapping("/aluno/remover")
	public String remover(Aluno aluno) {
		System.out.println("Chamou o metodo remover aluno");
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.remover(aluno);
		return "redirect:../aluno/";
	}

}
