package com.bcp.tipocambio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bcp.tipocambio.dao.entity.UsuarioEntity;
import com.bcp.tipocambio.dao.repository.UsuarioRepositorio;

@SpringBootTest
class TipocambiowebsecApplicationTests {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	//Spring implementa este algoritmo para cifrar las claves:
	@Autowired
	private BCryptPasswordEncoder codificador;
	
	//-------------------------------------------------------
	//Vamos a crear una prueba unitaria para poder registrar 
	//un usuario con una contraseña cifrada.
	//-------------------------------------------------------
	@Test	
	void insertarUsuario() {
		
		UsuarioEntity ue = new UsuarioEntity();
//		ue.setUsuario("fito");
//		ue.setClave(codificador.encode("123"));
//		ue.setNombreCompleto("Fito Carrasco");
		
//		ue.setUsuario("simba");
//		ue.setClave(codificador.encode("123"));
//		ue.setNombreCompleto("Admistrador del Sistema");
		
		ue.setUsuario("maricela");
		ue.setClave(codificador.encode("123"));
		ue.setNombreCompleto("Admistrador del Sistema");
		
		UsuarioEntity ueInsertado = usuarioRepositorio.save(ue);
		
		Assertions.assertNotNull(ueInsertado);
	}
	
//	//-------------------------------------------------------
//	//Vamos a crear una prueba unitaria para poder registrar 
//	//un usuario con una contraseña sin cifrar.
//	//-------------------------------------------------------
//	@Test
//	@Disabled
//	void insertarUsuario2() {
//		
//		UsuarioEntity ue = new UsuarioEntity();
//		ue.setUsuario("simba");
//		ue.setClave("123");
//		ue.setNombreCompleto("Simba Carrasco");
//		
//		UsuarioEntity ueInsertado = usuarioRepositorio.save(ue);
//		
//		Assertions.assertNotNull(ueInsertado);
//	}

}

