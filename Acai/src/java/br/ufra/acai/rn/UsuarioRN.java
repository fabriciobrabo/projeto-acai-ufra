package br.ufra.acai.rn;

/**
 *
 * @author ufrastic
 */
public interface UsuarioRN<T> extends GenericRN<T> {

    public T obter(String acesso);
}
