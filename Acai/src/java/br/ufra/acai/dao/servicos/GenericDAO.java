/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufra.acai.dao.servicos;

import java.util.List;

/**
 *
 * @author fabricio correa brabo
 */
public interface GenericDAO<T> {
    
    public boolean criar(T o);
    public boolean atualizar(T o);
    public boolean excluir(T o);
    public T obter(Class<T> classe, Object id);
    public List<T> obterTodos(Class<T> classe);
}
