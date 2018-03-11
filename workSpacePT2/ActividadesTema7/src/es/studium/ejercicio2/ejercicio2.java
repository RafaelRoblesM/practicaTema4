package es.studium.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws IOException
	{
		int a, resultado;
		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("da un numero");
		a = Integer.parseInt(lectura.readLine());
		resultado = suma(a);
		System.out.println("el resultado es " + resultado);
	}
	public static int suma(int a)
	{
		int r;
		if(a==1)
		{
			r = 1;
		}
		else
		{
			r = a * a +suma(a-1);
		}
		return r;
	}	
}