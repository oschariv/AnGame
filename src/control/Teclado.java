/*
 * Copyright (C) 2017 oscar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author oscar
 */
public final class Teclado implements KeyListener{

    // Numero de teclas de nuestro teclado.
    private final static int numeroTeclas = 120;
    // Array para guardar las teclas.
    private final boolean[] teclas = new boolean[numeroTeclas];
    
    // CONTROLES A USAR.
    // DEFINIMOS EL NOMBRE DE LAS TECLAS A USAR PARA LAS ACCIONES.
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    
    // FIN CONTROLES A USAR.
    
    // Metodo para actualizar.
    public void actualizar(){
        // La variable corresponde con la tecla marcada para pulsar.
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        izquierda = teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
    }
    
    // Traducion: Tecla presionada o pulsada.
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true; 
    }

    // Traducion: Tecla soltada o dejada de presionar.
    public void keyReleased(KeyEvent e) {
       teclas[e.getKeyCode()] = false;
    }
    
    // Traducion: Tecla tecleada o tipeada.
    public void keyTyped(KeyEvent e) {
        
    }
    
}
