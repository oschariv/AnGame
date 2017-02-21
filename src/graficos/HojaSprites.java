/*
 * Copyright (C) 2017 Oschariv
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

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class HojaSprites {
    // Declaramos las varibles del constructor.
    private final int ancho;
    private final int alto;
    
    // Arrya de enteros para guardar los colores de pixeles a usar.
    public final int[] pixeles;
    
    
    // Constructor para la clase HojaSprite.
    public HojaSprites(final String ruta, final int ancho, final int alto){
        // Inicializamos todas las varibles.
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho * alto];
        
       
        BufferedImage imagen;
        try {
            // Almacena la imagen obtenida a traves de la ruta
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            // Para obtener los valores de colores que tiene la hoja de sprites??
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException ex) {
            Logger.getLogger(HojaSprites.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
