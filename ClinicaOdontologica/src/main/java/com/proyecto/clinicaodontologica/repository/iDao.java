package com.proyecto.clinicaodontologica.repository;

import java.util.List;

public interface iDao<T> {
    T guardar(T t);
    T buscar(Integer id);
    T buscarPorString(String valor);
    void eliminar(Integer id);
    void actualizar(T t);
    List<T> buscarTodos();
}
