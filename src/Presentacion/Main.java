package Presentacion;

import java.awt.EventQueue;

public class Main {

/*El main crea una instancia de controlador y llama a la ventana con ella

El controlador SA. Llama a la funcion dar de baja del SA mandando el id. 

Esa funci�n de SA crea instancias de DAO. (si necesitase instancias de transfer las hago aqui).
LLama a la funcion dar de baja del DAO mandandole el id del mensaje.

La funcion dar de baja del DAO comprueba que el id existe, que esta activo 
y mira que no est� en ning�n autob�s accediendo a la base de datos.
Devuelve al controlador la informaci�n y actualiza.
*/
	
	public static void main(String[] args) {
		Controller ctrl=Controller.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
				}
			}
		});
	}

}