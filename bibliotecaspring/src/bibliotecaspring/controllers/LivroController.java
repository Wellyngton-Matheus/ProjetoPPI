package bibliotecaspring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaspring.dao.LivroDAO;
import bibliotecaspring.models.Livro;

@RequestMapping("/Livro")
@Controller
public class LivroController {

	@RequestMapping("/pag")
	public String form() {
		System.out.println("Chamou o formulário livro");
		return "Livro/pag";
	}

	@PostMapping("/executarCadastro")
	public String adicionar(Livro livro) {
		System.out.println(livro);
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.inserir(livro);
		return "Livro/LivroCadastrado";
	}

	@GetMapping("/ListarLivro")
	public ModelAndView listar() {
		LivroDAO livroDAO = new LivroDAO();
		List<Livro> lista = livroDAO.getLista();
		ModelAndView model = new ModelAndView("Livro/ListarLivro");
		model.addObject("livro", lista);
		return model;
	}

	@RequestMapping("/Livro/remover")
	public String remover(Livro livro) {
		System.out.println("Chamou o metodo remover Livro");
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.remover(livro);
		return "redirect:../Livro/";
	}

}
