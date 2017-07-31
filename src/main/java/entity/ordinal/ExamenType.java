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
public enum ExamenType {
    Code,Creno,Circuit;

    private ExamenType() {
    }

    public static ExamenType getCircuit() {
        return Circuit;
    }

    public static ExamenType getCode() {
        return Code;
    }

    public static ExamenType getCreno() {
        return Creno;
    }
    
}
