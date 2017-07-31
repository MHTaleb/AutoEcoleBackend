/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Image;

/**
 *
 * @author taleb
 */
public interface ImageMetierLocal {
    public Long enregistrer(String extension, byte[] image);
    public Long midifier(Long id, String extension, byte[] image);
    public Image lire(Long id);
    public boolean supprimer(Long id);
}
