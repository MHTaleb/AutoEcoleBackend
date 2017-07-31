/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import entity.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

/**
 *
 * @author taleb
 */
public class ImageMetier extends ImageJpaController implements ImageMetierLocal{

    private static final long serialVersionUID = 7597493614796187107L;
    
    public ImageMetier() {
        super(Persistence.createEntityManagerFactory("USER_PU"));
    }

    @Override
    public Long enregistrer(String extension, byte[] image) {
        Image imagePersist = new Image();
        imagePersist.setExtension(extension);
        imagePersist.setImage(image);
            create(imagePersist);
        return imagePersist.getId();
    }

    @Override
    public Image lire(Long id) {
        return findImage(id);
    }

    @Override
    public Long midifier(Long id, String extension, byte[] image) {
        try {
            Image imageEdit = new Image();
            imageEdit.setExtension(extension);
            imageEdit.setId(id);
            imageEdit.setImage(image);
            edit(imageEdit);
            return imageEdit.getId();
        } catch (Exception ex) {
            Logger.getLogger(ImageMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Long.valueOf(-1);
    }

    @Override
    public boolean supprimer(Long id) {
        
        try {
            destroy(id);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ImageMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
