package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import JUnit.Junit09_Geometria.dto.Geometria;

class GeometriaTest {

	private Geometria geo;

	@BeforeEach
	public void creatObject() {
		this.geo = new Geometria();
	}

	@Test
	public void testAreaCuadrado() {
		int resultado = geo.areacuadrado(4);
		int valor_esperado = 16;
		assertEquals(resultado, valor_esperado);
	}

	@Test
	public void testAreaCirculo() {
		double resultado = geo.areaCirculo(1);
		double valor_esperado = 3.14;
		double delta = 0.01;
		assertEquals(resultado, valor_esperado, delta);
	}

	@Test
	public void testAreaTriangulo() {
		double resultado = geo.areatriangulo(2, 2);
		double valor_esperado = 2;
		assertEquals(resultado, valor_esperado);
	}

	@Test
	public void testAreaRectangulo() {
		double resultado = geo.arearectangulo(2, 2);
		double valor_esperado = 4;
		assertEquals(resultado, valor_esperado);
	}

	@Test
	public void testAreaPentagono() {
		double resultado = geo.areapentagono(2, 2);
		double valor_esperado = 2;
		assertEquals(resultado, valor_esperado);
	}

	@Test
	public void testAreaRombo() {
		double resultado = geo.arearombo(2, 2);
		double valor_esperado = 2;
		assertEquals(resultado, valor_esperado);
	}

	@Test
	public void testAreaRomboide() {
		double resultado = geo.arearomboide(2, 2);
		double valor_esperado = 4;
		assertEquals(resultado, valor_esperado);
	}

	@Test
	public void testAreaTrapecio() {
		double resultado = geo.areatrapecio(2, 2, 4);
		double valor_esperado = 8;
		assertEquals(resultado, valor_esperado);
	}

	// Stream of data for
	private static Stream<Arguments> getFiCode() {
		return Stream.of(Arguments.of(0, "Default"), Arguments.of(1, "cuadrado"), Arguments.of(2, "Circulo"),
				Arguments.of(3, "Triangulo"), Arguments.of(4, "Rectangulo"), Arguments.of(5, "Pentagono"),
				Arguments.of(6, "Rombo"), Arguments.of(7, "Romboide"), Arguments.of(8, "Trapecio"),
				Arguments.of(9, "Default"));
	}

	@ParameterizedTest
	@MethodSource("getFiCode")
	public void testFigura(int input, String output) {
		String result = this.geo.figura(input);
		assertEquals(result, output);
	}

	@Test
	public void testDefaultConstructor() {
		assertEquals(this.geo.getId(), 9);
		assertEquals(this.geo.getNom(), "Default");
	}

	@ParameterizedTest
	@MethodSource("getFiCode")
	public void testConstructorWithParameters(int input, String output) {
		this.geo = new Geometria(input);
		assertEquals(this.geo.getNom(), output);
	}
	
	@Test
	public void testSetId() {
		this.geo.setId(5);
		assertEquals(this.geo.getId(), 5);
	}
	
	@Test
	public void testSetNom() {
		String value = "Romboide";
		this.geo.setNom(value);
		assertEquals(this.geo.getNom(), value);
	}
	
	@Test
	public void testSetArea() {
		double value = 2.0;
		this.geo.setArea(value);
		double delta = 0.01;
		assertEquals(this.geo.getArea(), value, delta);
	}
	

	@Test
	public void testToString() {
		Double area = 2.0;
		int id = 0;
		String nom = "Default";
		this.geo.setArea(area);
		this.geo.setId(id);
		this.geo.setNom(nom);
		String result = "Geometria [id=" + id + ", nom=" + nom + ", area=" + area + "]";
		assertEquals(this.geo.toString(), result);
	}
	
}
