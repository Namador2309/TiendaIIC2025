/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author natia
 */
@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    //en camelCase se llaman asi, pero en la bd no realmente, so what do we do?
    //nath de 10 minutos despues: ponemos los arrobas para que tengan las mismas propiedades que en mySQL
    private static final long serialVersionUID = 1L;//establecer a quien estamos mandando a base de datos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    @Column(name = "ruta_imagen")
    private String rutaImagen;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    public boolean isActivo() {
    return Boolean.TRUE.equals(this.activo);
}

    
    
    

}
