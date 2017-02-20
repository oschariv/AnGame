
package Juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


// Extendemos aCanvas para ejecutar graficos.
    // Implementamos una nueva interfaz
public class Juego extends Canvas implements Runnable{
    //Identificador
    private static final long serialVersionUID = 1L;
    
    // Creamos la ventana.
    private static JFrame ventana;
    // Thread para ejecucion divida. Es decir nuevo hilo de ejecucion.
    private static Thread thread;
    
    // Dimensiones de la ventana: ANCHO y ALTO.
    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    
    // Booleano para controla si se esta ejecutando el juego o no.
        // La hacemos volatile para que no se ejecute en los dos threads a la vez.
    private static volatile boolean enFuncionamiento = false;
    
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
        // Para poder iniciar el juego usamos:
        juego.iniciar();;
    }
    
    // Para iniciar el segundo thread por el momento.
        // lo sincronizamos para que no puede editar valiables a la vez que detener.
    private synchronized void iniciar(){
        // True porque se esta ejecutando el juego.
        enFuncionamiento = true;
        // Iniciamos el thread. Parametro this es la propia clase a iniciar.
        // Parametro GRAFICOS es para diferenciar el hilo de ejecucion.
        thread = new Thread(this, "Graficos");
        // Ejecutamos el Thread.
        thread.start();
    }
    // Para detener el segundo thread por el momento.
        // lo sincronizamos para que no puede editar valiables a la vez que iniciar.
    private synchronized void detener(){
        // False porque no se esta ejecutando el juego.
        enFuncionamiento = false;
        
        try {
            // Para parar el thread.
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            // Si esta sentencia no funciona en ECLIPSE añade:
            //ex.printStackTrace();
        }
    }
    // Ejecuta el segundo thread o hilo de ejecucion.
    public void run() {
        while(enFuncionamiento){
            
        }
    }
    
}
