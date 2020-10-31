package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entities.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class UsuariosBean
 */
@Stateless
public class UsuariosBean implements UsuariosBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public UsuariosBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crearUsuario(Usuario usuario) throws ServiciosException {
		try {
			em.persist(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear la carrera");
		}
	}

	@Override
	public void actualizar(Usuario usuario) throws ServiciosException {
		try {
			em.merge(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la materia");
		}
	}

	@Override
	public void borrar(Long idUsuario) throws ServiciosException {
		try {
			Usuario usuario = em.find(Usuario.class, idUsuario);
			em.remove(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar la materia");
		}

	}

	@Override
	public List<Usuario> obtenerTodos() {
		TypedQuery<Usuario> query = em.createQuery("SELECT m FROM Usuario m", Usuario.class);
		return query.getResultList();
	}

	@Override
	public List<Usuario> obtenerPorNombre(String filtro) {
		TypedQuery<Usuario> query = em.createQuery("SELECT m FROM Usuario m WHERE m.nombre LIKE :nombre", Usuario.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}

	@Override
	public List<Usuario> obtenerPorApellido(String filtro) {
		TypedQuery<Usuario> query = em
				.createQuery("SELECT m FROM Usuario m WHERE m.apellido LIKE :apellido", Usuario.class)
				.setParameter("apellido", filtro);
		return query.getResultList();
	}

	@Override
	public List<Usuario> obtenerPorNombreUsuario(String filtro) {
		TypedQuery<Usuario> query = em
				.createQuery("SELECT m FROM Usuario m WHERE m.nombreUsuario LIKE :nombreUsuario", Usuario.class)
				.setParameter("nombreUsuario", filtro);
		return query.getResultList();
	}

	@Override

	public List<Usuario> obtenerPorNombreRol(String filtro) {
		TypedQuery<Usuario> query = em.createQuery("SELECT m FROM Usuario m WHERE m.rol LIKE :rol", Usuario.class)
				.setParameter("rol", filtro);
		return query.getResultList();
	}

	@Override
	public Usuario iniciarSesion(Usuario us) {
		Usuario usuario = null;
		String consulta;
		try {
			consulta = "SELECT u FROM Usuario u.usuario = 1? and u.contrasena = 2?";
			Query query = em.createQuery(consulta);
			query.setParameter(1, us.getNombreUsuario());
			query.setParameter(2, us.getContrasena());
			List<Usuario> lista = query.getResultList();
			if (!lista.isEmpty()) {
				usuario = lista.get(0);
			}
		} catch (PersistenceException e) {
			throw e;
		}
		return usuario;
	}

}
