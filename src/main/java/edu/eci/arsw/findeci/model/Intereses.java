/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.model;

import java.util.ArrayList;

public class Intereses {

    private Genero sexoInteres;
    private TipoRelacion tipoR;
    private ArrayList<String> aspectosImportantes;

    public Genero getSexoInteres() {
        return sexoInteres;
    }

    public void setSexoInteres(Genero sexoInteres) {
        this.sexoInteres = sexoInteres;
    }

    public TipoRelacion getTipoR() {
        return tipoR;
    }

    public void setTipoR(TipoRelacion tipoR) {
        this.tipoR = tipoR;
    }

    public ArrayList<String> getAspectosImportantes() {
        return aspectosImportantes;
    }

    public void setAspectosImportantes(ArrayList<String> aspectosImportantes) {
        this.aspectosImportantes = aspectosImportantes;
    }
    
    
}
