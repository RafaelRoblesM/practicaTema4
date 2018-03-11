package es.studium.ejercicio1;

import java.io.IOException;

public class ejercicio1 {
	public static void main(String[] args) throws IOException
	{
		int resultado;
		resultado = suma(100);
		System.out.println("vamos a contar " + resultado);
	}
	public static int suma(int n)
	{
		int r;
		if(n==1)
		{
			r = 1;
		}
		else
		{
			r = n +suma(n-1);
		}
		return r;
	}	
}
