package pe.com.empresa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import pe.com.modelo.Categoria;
import pe.com.modelo.Distrito;
import pe.com.service.CategoriaDao;
import pe.com.service.DAO;
import pe.com.service.DistritoDao;
import pe.com.service.DistritoDaoImpl;
import pe.com.service.LocalDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/SpringBean.xml"})

public class BDTest {

	@Autowired
	private JdbcTemplate jdbcTemp;
	@Autowired
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	@Autowired
	LocalDaoImpl localdaoimpl;
	@Autowired
	DistritoDaoImpl distritodaoimpl;
	
	@Test
	public void testListaLocales() {
		
		
		assertEquals(2, localdaoimpl.listar().size());
	}
	
	@Test
	public void testIngresarPersona() {
		
		
		int num=distritodaoimpl.listar().size();
		Distrito distrito= new Distrito();
		distrito.setNdistrito("Persona2");
		distritodaoimpl.agregar(distrito);
		
		assertEquals(num+1, distritodaoimpl.listar().size());
	}
}
