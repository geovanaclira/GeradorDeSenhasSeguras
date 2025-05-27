package br.com.geovana.gerenciador.repository;

import br.com.geovana.gerenciador.model.Credencial;
import java.util.List;

public interface CredencialRepository {
    void adicionar(Credencial credencial);
    boolean remover(String servico);
    Credencial buscar(String servico);
    List<Credencial> listarTodas();
    Credencial buscarPorUsuario(String usuario);
}
