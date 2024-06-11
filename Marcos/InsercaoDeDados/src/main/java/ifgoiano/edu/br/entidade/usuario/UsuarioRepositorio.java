package ifgoiano.edu.br.entidade.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ifgoiano.edu.br.entidade.Usuario;

public class UsuarioRepositorio {

	private Connection conn;

	public UsuarioRepositorio() throws Exception {
		conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
	}

	public List<Usuario> listarUsuarios() {
	    List<Usuario> lstUsuario = new ArrayList<Usuario>();

	    String sql = "select id, nome, email, senha, data_nascimento from usuario";

	    try {
	        PreparedStatement pst = conn.prepareStatement(sql);

	        ResultSet resultSet = pst.executeQuery();
	        while (resultSet.next()) {
	            Usuario usuario = new Usuario();
	            usuario.setId(resultSet.getInt("id"));
	            usuario.setNome(resultSet.getString("nome"));
	            usuario.setEmail(resultSet.getString("email"));
	            usuario.setSenha(resultSet.getString("senha"));

	            lstUsuario.add(usuario);
	        }
	    } catch (Exception e) {
	        System.out.println("Erro no usuario!");
	        e.printStackTrace();
	    }
	    return lstUsuario;
	}
}
