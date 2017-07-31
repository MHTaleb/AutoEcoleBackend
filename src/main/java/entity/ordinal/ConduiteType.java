/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.ordinal;

/**
 *
 * @author taleb
 */
public enum ConduiteType {
    Creno,Circuit,Amelioration;

    public static ConduiteType getAmelioration() {
        return Amelioration;
    }

    private ConduiteType() {
    }

    public static ConduiteType getCircuit() {
        return Circuit;
    }

    public static ConduiteType getCreno() {
        return Creno;
    }

   
    
}
