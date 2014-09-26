/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.rn;

import java.util.List;

/**
 *
 * @author ufrastic
 * @param <T>
 */
public interface GenericRN<T> {

    public boolean salvar(T t);
    public boolean remover(T t);
    public T obter(Class<T> classe, Object id);
    public List<T> obterTodos(Class<T> classe);
}
