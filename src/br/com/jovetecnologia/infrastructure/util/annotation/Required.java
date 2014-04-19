package br.com.jovetecnologia.infrastructure.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
	
	/**
	 * Mínimo de caracteres obrigatórios
	 * @return <b>int</b>
	 */
	public int minimo();
	
	/**
	 * Label do campo (atributo) na tela
	 * @return <b>String</b>
	 */
	public String label();
}