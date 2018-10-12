package br.com.caelum.livraria.model.validacao;

import br.com.caelum.livraria.model.Livro;

import java.util.List;

public class LivroValidacao {

    public boolean verificaSeJaExiste(Livro livroNovo, List<Livro> livros) {

        return livros.stream().noneMatch(livroExistente -> temConflito(livroNovo, livroExistente));

    }

    private boolean temConflito(Livro livroNovo, Livro livroExistente) {

        //TODO: Essa verificao de conflito poderia ser feita no Banco de Dados com uma unica consulta
        if (livroNovo.getTitulo().equals(livroExistente.getTitulo())) {
            return true;
        }
        return false;
    }
}
