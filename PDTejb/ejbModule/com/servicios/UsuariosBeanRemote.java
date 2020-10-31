package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Usuario;
import com.exception.ServiciosException;

@Remote
public interface UsuariosBeanRemote {

	void crearUsuario(Usuario usuario) throws ServiciosException;

	void actualizar(Usuario usuario) throws ServiciosException;

	void borrar(Long idUsuario) throws ServiciosException;

	List<Usuario> obtenerPorNombre(String filtro);

	List<Usuario> obtenerTodos();

	Usuario iniciarSesion(Usuario us);

	List<Usuario> obtenerPorApellido(String filtro);

	List<Usuario> obtenerPorNombreUsuario(String filtro);

	List<Usuario> obtenerPorNombreRol(String filtro);

}
