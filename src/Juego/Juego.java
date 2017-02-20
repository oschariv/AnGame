
package Juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


// Extendemos aCanvas para ejecutar graficos.
public class Juego extends Canvas{
    //Identificador
    private static final long serialVersionUID = 1L;
    
    // Creamos la ventana.
    private static JFrame ventana;
    
    // Dimensiones de la ventana: ANCHO y ALTO.
    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    
    // Nombre de la Aplicacion a mostrar en la ventana.
    private static final String NOMBRE = "AnGame";
    
    // Contructor de la clase juego. La hacemos privada para que niguna otra 
    // pueda hacer intancias de juego.
    private Juego(){
        // Tamaño que nos gustaria para nuestra aplicacion.
        setPreferredSize(new Dimension(ANCHO, ALTO));
        
        // Inicializamos el objeto ventana.
        ventana = new JFrame(NOMBRE);
        // Establecemos que al hacer click para cerrar la ventana se cierre.
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Opcion para no permitir cambiar el tamaño de la ventana.
        ventana.setResizable(false);
        // Añadimos un diseño para la vetana.
        ventana.setLayout(new BorderLayout());
        // Añadimos a la ventana el canvas.
        ventana.add(this, BorderLayout.CENTER);
        // Funcion para que todo se ajuste al tamaño de la pantalla.
        ventana.pack();
        // Posicion de la pantalla en el escritorio.
        ventana.setLocationRelativeTo(null);
        // Hacemos que la ventana sea visible.
        ventana.setVisible(true);
        
    }
    
    // Metodo main para que todo funcione. Debe ser siempre publico.
    public static void main(String[] args){
        Juego juego = new Juego();
    }
}
