package br.com.caelum.livraria.controller;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.model.form.LivroForm;
import br.com.caelum.livraria.model.validacao.LivroValidacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LivroController {


    @Autowired
    private LivroDao livroDao;

    @Autowired
    private AutorDao autorDao;


    @GetMapping("/admin/livros-do-autor")
    public ModelAndView form(@RequestParam("autorId") Integer autorId) {

        ModelAndView modelAndView = new ModelAndView("livro/livros-por-autor");

        List<Livro> livros = livroDao.findAllByAutor(autorId);
        Autor autor = autorDao.findOne(autorId);
        modelAndView.addObject("livros", livros);
        modelAndView.addObject("autor", autor);

        return modelAndView;

    }

    @GetMapping("/admin/livro-novo-para-um-autor")
    public ModelAndView form(@RequestParam("autorId") Integer autorId, LivroForm livroForm) {

        ModelAndView modelAndView = new ModelAndView("livro/livro-novo-para-um-autor");
        Autor autor = autorDao.findOne(autorId);
        modelAndView.addObject("autor", autor);
        modelAndView.addObject("form", livroForm);
        return modelAndView;

    }

    @GetMapping("/livro-detalhe")
    public ModelAndView livroDetalhe(@RequestParam("livroId") Integer livroId) {

        ModelAndView modelAndView = new ModelAndView("livro/livro-detalhe");
        Livro livro = livroDao.findOne(livroId);
        modelAndView.addObject("livro", livro);
        return modelAndView;

    }


    @Transactional
    @PostMapping("/admin/livro-novo-para-um-autor")
    public ModelAndView salvar(@Valid LivroForm livroForm, BindingResult result) {

        if (result.hasErrors()) {
            return form(livroForm.getAutorId(), livroForm);
        }

        Livro livro = livroForm.toLivro(autorDao);

        List<Livro> livrosDoAutor = livroDao.findAllByAutor(livroForm.getAutorId());

        LivroValidacao livroValidacao = new LivroValidacao();

        if(livroValidacao.verificaSeJaExiste(livro, livrosDoAutor)) {

            //TODO: Para fins de teste, apenas fazer um System.out.println simulando o envio de email para o autor
            System.out.println("Enviado e-mail para "+livro.getAutor().getEmail()+ " com data de publicacao prevista "+ livro.getDataEstimadaPublicacao());
            livroDao.save(livro);

            ModelAndView modelAndView = new ModelAndView("redirect:/admin/livros-do-autor?autorId="+livroForm.getAutorId());

            return modelAndView;
        }

        return form(livroForm.getAutorId(), livroForm);


    }


    @GetMapping(value = "/home")
    public ModelAndView lista() {

        ModelAndView modelAndView = new ModelAndView("livro/livros-todos");

        modelAndView.addObject("livros", livroDao.findAll());

        modelAndView.addObject("livrosRecentes", livroDao.findTresMaisRecentes());

        return modelAndView;
    }

    @DeleteMapping("/admin/livro/{id}")
    @ResponseBody
    @Transactional
    public void delete(@PathVariable("id") Integer id) {
        livroDao.delete(id);
    }

}