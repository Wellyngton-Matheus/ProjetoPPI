package bibliotecaspring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaspring.dao.AlunoDAO;
import bibliotecaspring.models.Aluno;

@RequestMapping("/Aluno")
@Controller
public class AlunoController {
	@RequestMapping("/form")
	public String form() {
		System.out.println("Chamou o formulario do adicionar o aluno");
		return "Aluno/form";
	}

	@PostMapping("/executarCadastro")
	public String adicionar(Aluno aluno) {
		System.out.println(aluno);
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.inserir(aluno);
		return "Aluno/AlunoCadastrado";
	}

	@GetMapping("/ListarAluno")
	public ModelAndView listar() {
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> lista = alunoDAO.getLista();
		ModelAndView model = new ModelAndView("Aluno/ListarAluno");
		model.addObject("aluno", lista);
		return model;
	}

	@RequestMapping("remover")
	public ModelAndView remover(Aluno aluno) {
		System.out.println("Chamou o metodo remover aluno");
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.remover(aluno);
		return listar();
	}

}
