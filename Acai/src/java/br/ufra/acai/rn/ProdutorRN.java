package br.ufra.acai.rn;

import java.util.List;

/**
 *
 * @author ufrastic
 * @param <T>
 */
public interface ProdutorRN<T>{

    public List<T> obterTodosOrdenadoNome();
}
