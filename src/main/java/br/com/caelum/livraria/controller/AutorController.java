package br.com.caelum.livraria.controller;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AutorController {


    @Autowired
    private AutorDao autorDao;


    @GetMapping({"/admin/autor", "/admin/autor/{id}"})
    public ModelAndView form(@PathVariable("id") Optional<Integer> id, Autor autor) {

        ModelAndView modelAndView = new ModelAndView("autor/autor");

        if (id.isPresent()) {
            autor = autorDao.findOne(id.get());
        }

        modelAndView.addObject("autor", autor);

        return modelAndView;
    }


    @PostMapping("/admin/autor")
    @Transactional
    public ModelAndView salva(@Valid Autor autor, BindingResult result) {

        if (result.hasErrors()) {
            return form(Optional.ofNullable(autor.getId()), autor);
        }

        autorDao.save(autor);

        ModelAndView view = new ModelAndView("redirect:/admin/autores");

        return view;
    }


    @GetMapping(value = "/admin/autores")
    public ModelAndView lista() {

        ModelAndView modelAndView = new ModelAndView("autor/lista");

        modelAndView.addObject("autores", autorDao.findAll());

        return modelAndView;
    }

    @DeleteMapping("/admin/autor/{id}")
    @ResponseBody
    @Transactional
    public void delete(@PathVariable("id") Integer id) {
        autorDao.delete(id);
    }

}