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
public final class Sprite {
    
    // Tamaño del lado de un sprite individual.
    private final int lado;
    // Ejes para las coordenadas
    private int x;
    private int y;
    
    // Array para guardar la collecion de colores del sprite.
    public int[] pixeles;
    
    private final HojaSprites hoja;
    
    public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja){
        this.lado = lado;
        pixeles = new int[lado * lado];
        
        // Coordenadas de los sprites.
        this.x = columna * lado;
        this.y = fila * lado;
        
        this.hoja = hoja;
        
        // Bucle para extraer el sprite de la hoja de sprites.
        // Se accede de izquierda a derecha y de arriba hacia abajo.
        for (int y = 0; y < lado; y++){
            for (int x = 0; x < lado; x++){
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
        }
}
