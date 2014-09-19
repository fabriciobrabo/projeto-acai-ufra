/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao;

/**
 *
 * @author fabricio correa brabo
 */
public interface InterfaceUsuarioDAO<T> {

    public T obter(String acesso);
}
