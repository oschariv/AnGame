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
package graficos;

/**
 *
 * @author oscar
 */
public final class Pantalla {
    // Tamaño de la pantalla.
    private final int ancho;
    private final int alto;
    
    public final int[] pixeles;
    
    public Pantalla(final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        pixeles = new int[ancho * alto];
    }
    
    // Se encarga de limpiar pantalla en negro cada vez de que se redibuje completamente.
    public void limpiar(){
       for (int i = 0; i < pixeles.length; i++){
           pixeles[i] = 0;
       } 
    }
    
    // Se encarga de dibujar la pantalla.
    public void mostrar(final int compensacionX, final int compensacionY){
        // Doble bucle for para dibujar todas las lineas de la pantalla.
        for (int y = 0; y < alto; y++){
            // Posicion exacta a dibujar.
            int posicionY = y + compensacionY;
            // Sentencia para cerrar el bucle para evitar salirnos del mapa.
            if (posicionY < 0 || posicionY >= alto){
                continue;
            }
            for (int x = 0; x < ancho; x++) {
                // Posicion exacta a dibujar.
                int posicionX = x + compensacionX;
                // Sentencia para cerrar el bucle para evitar salirnos del mapa.
                if (posicionX < 0 || posicionX >= alto){
                    continue;
                }
                
                // Codigo para redibujar la pantalla.
            }
        }
    }
}
