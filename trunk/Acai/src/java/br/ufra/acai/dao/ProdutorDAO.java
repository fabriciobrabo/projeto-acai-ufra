package br.ufra.acai.dao;

import java.util.List;

/**
 *
 * @author ufrastic
 * @param <T>
 */
public interface ProdutorDAO<T> extends GenericDAO<T> {

    public List<T> obterTodosOrdenado(Class<T> classe, String param);
}
