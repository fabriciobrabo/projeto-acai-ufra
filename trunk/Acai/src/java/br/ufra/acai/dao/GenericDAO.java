package br.ufra.acai.dao;

import java.util.List;

/**
 *
 * @author fabricio correa brabo
 * Interface de DAO que irá especificar os metodos comuns(pois neste classo é
 * uma classe genérica) * a serem implementados pelas classes concretas.
 *
 */
public interface GenericDAO<T> {

    public boolean criar(T o);
    public boolean atualizar(T o);
    public boolean excluir(T o);
    public T obter(Class<T> classe, Object id);
    public List<T> obterTodos(Class<T> classe);
}
