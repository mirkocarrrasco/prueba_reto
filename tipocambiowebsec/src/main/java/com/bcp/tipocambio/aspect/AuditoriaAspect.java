package com.bcp.tipocambio.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcp.tipocambio.dao.entity.AuditoriaEntity;
import com.bcp.tipocambio.dao.entity.UsuarioEntity;
import com.bcp.tipocambio.dao.repository.AuditoriaRepository;
import java.util.Date;

@Aspect
@Component
public class AuditoriaAspect {

	@Autowired
	private AuditoriaRepository auditoriaRepository;
	
	@Pointcut("execution(* com.bcp.tipocambio.service.CambioService.calcularMonto(..))")
	public void serviceMethod() {
	}

	@Before("serviceMethod()")
	public void beforeLoginAdvice() {
		System.out.println("iniciado " + LocalDateTime.now());
	}

	@After("serviceMethod()")
	public void afterLoginAdvice() {
		System.out.println("finalizado " + LocalDateTime.now());
		AuditoriaEntity ae = new AuditoriaEntity();
		ae.setFechahora(new Date());
//		ae.setNomusuario("fito");
		ae.setNomusuario(UsuarioAspecto.nombreuser);
		ae.setOperacion("consulta cambio web");
		auditoriaRepository.save(ae);
	}

}
