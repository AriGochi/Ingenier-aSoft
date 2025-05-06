package mx.unam.aragon.ico.is.computadoraApi;

import mx.unam.aragon.ico.is.computadoraApi.entitys.Computadora;
import mx.unam.aragon.ico.is.computadoraApi.repositories.ComputadoraRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComputadoraApiApplicationTests {

	@Autowired
	private ComputadoraRepository computadoraRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void insertaComputadora() {
		Computadora computadora = new Computadora(0, "HP", "pavillion 3000",null,13000.0f);
		computadoraRepository.save(computadora); //insert into
		System.out.println(computadora);
	}

	@Test
	void leerComputadoraPorClave() {
		Long claveTmp = 2L; // pavillion
		Computadora tmp =  computadoraRepository.findComputadoraByClave(claveTmp);
		System.out.println(tmp);
	}

	@Test
	public void eliminarComputadora() {
		Long claveTmp = 2l;
		computadoraRepository.deleteById(claveTmp);
		System.out.println(computadoraRepository.findComputadoraByClave(claveTmp));
	}

	@Test
	public void actualizarComputadora() {
		Long claveTmp = 4l;
		Computadora tmp =  computadoraRepository.findComputadoraByClave(claveTmp);
		tmp.setModelo("patito 3000");
		computadoraRepository.save(computadoraRepository.findComputadoraByClave(claveTmp));
	}

}
