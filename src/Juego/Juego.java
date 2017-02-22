
package Juego;

import control.Teclado;
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
    // Implementamos la clase teclado.
    private static Teclado teclado;
    
    // Dimensiones de la ventana: ANCHO y ALTO.
    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    
    // Booleano para controla si se esta ejecutando el juego o no.
        // La hacemos volatile para que no se ejecute en los dos threads a la vez.
    private static volatile boolean enFuncionamiento = false;
    
    // Nombre de la Aplicacion a mostrar en la ventana.
    private static final String NOMBRE = "AnGame";
    // Variables a mostrar en la ventana del juego.
    private static int aps = 0;
    private static int fps = 0;
    
    
    // Contructor de la clase juego. La hacemos privada para que niguna otra 
    // pueda hacer intancias de juego.
    private Juego(){
        // Tamaño que nos gustaria para nuestra aplicacion.
        setPreferredSize(new Dimension(ANCHO, ALTO));
        
        // Iniciamos el teclado y el keyListener.
        teclado = new Teclado();
        // Detecta todas las teclas que se pulsen.
        addKeyListener(teclado);
        
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
    
    // Metodo para actualizar todas las variables del juego.
    // Vida, Objetos, FPS, ...
    private void actualizar(){
        // Actualizamos el teclado.
        teclado.actualizar();
        
        // Sentecias if para descubrir que tecla se ha pulsado.
        if (teclado.arriba){
            System.out.println("arriba");
        }
        if (teclado.abajo) {
            System.out.println("abajo");
        }
        if (teclado.izquierda) {
            System.out.println("izquierda");
        }
        if (teclado.derecha) {
            System.out.println("derecha");
        }
        
        // Se actualiza cada vez que se ejecuta el metodo.
        aps++;
    }
    
    // Metodo para ir redibujando los graficos.
    private void mostrar(){
        // Se actualiza cada vez que se ejecuta el metodo.
        fps++;
    }
    
    // Ejecuta el segundo thread o hilo de ejecucion.
    public void run() {
        // REFERENCIAS.
        // Equivalencia de cuantos NanoSegundos hay en un Segundo.
        final int NS_POR_SEGUNDO = 1000000000;
        // Actualizacion por Segundo a las que queremos llegar.
        final byte APS_OBJETIVO = 60;
        // da como resultado el total de nano segundos que tienen que pasar 
        // para obtener los aps objetivo.
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
        // Se atribulle a la variable una cantidad de nanosegundos en el 
        // momento de igualarla.
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        // FIN REFERENCIAS.
        
        
        double tiempoTranscurrido;
        // Variable de la cantidad de tiempo que ha transcurrido hasta que 
        // sucede una actualizacion de la pantalla.
        double delta = 0;
        
        // Hacemos que el teclado y raton aparezcan por defecto dentro del juego 
        requestFocus();
        
        
        while(enFuncionamiento){
            // toma un valor distinto al de referenciaActualizacion cada vez 
            // que se iguala.
            final long inicioBucle = System.nanoTime();
            // mide cuanto tiempo a pasada entre un momento y otro.
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            // se actualiza a inicioBucle para que las mediciones de espacios ç
            // entre tiempos sean exactas.
            referenciaActualizacion = inicioBucle;
            
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            // cuando delta sea uno o mas se actualiza el juego.
            while (delta >= 1){
                actualizar();
                delta--;
            }
            
            // Incluimos estos metodos para que se ejecuten mientras funcione el juego.
            mostrar();
            
            // El contador de FPS se actualiza cada segundo
            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
                // Cabezera de la ventana.
                ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS: " + fps);
                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }
    
}
