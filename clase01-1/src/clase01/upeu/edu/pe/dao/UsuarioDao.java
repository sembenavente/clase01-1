package clase01.upeu.edu.pe.dao;

import java.util.List;

import clase01.upeu.edu.pe.entity.Usuario;

public interface UsuarioDao {
 public void create(Usuario u);
 public void update(int index, Usuario u);
 public void delete(int index);
 public Usuario read(int index);
 public List<Usuario> readAll();
}
