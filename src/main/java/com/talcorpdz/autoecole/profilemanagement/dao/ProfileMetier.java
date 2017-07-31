/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talcorpdz.autoecole.profilemanagement.dao;

import com.talcorpdz.autoecole.usermanagement.dao.AccountMetier;
import com.talcorpdz.autoecole.usermanagement.dao.exceptions.NonexistentEntityException;
import dao.ImageMetier;
import dao.ImageMetierLocal;
import entity.Account;
import entity.Image;
import entity.UserInfo;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

/**
 *
 * @author taleb
 */
public class ProfileMetier extends UserInfoJpaController implements ProfileMetierLocal {

    private static final long serialVersionUID = 4406610944866579553L;

    public ProfileMetier(String PersistenceUnitName) {
        super(Persistence.createEntityManagerFactory(PersistenceUnitName));
    }
    
    public ProfileMetier() {
        super(Persistence.createEntityManagerFactory("USER_PU"));
    }

    @Override
    public Long creerProfile(String nom, String prenom, LocalDate dateNaissance, List telephones) {
        UserInfo userInfo = new UserInfo();
        userInfo.setDateNaissance(dateNaissance);
        userInfo.setNom(nom);
        userInfo.setPrenom(prenom);
        userInfo.setTelephones(telephones);
        create(userInfo);
        return userInfo.getId();
    }

    @Override
    public boolean lierCompteProfil(Long accountID, Long profilID) {
      
        AccountMetier am = new AccountMetier();
        Account account = am.rechercher(accountID);
        if (account != null) {
            UserInfo userInfo = rechercher(profilID);
            if (userInfo != null) {
                account.setUserInfo(userInfo);
                try {
                   am.edit(account);
                    
                } catch (Exception ex) {
                    Logger.getLogger(ProfileMetier.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean supprimer(Long id) {
        try {
            destroy(id);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProfileMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean modifier(Long id, String nom, String prenom, LocalDate dtNaissance, List telephones) {
        UserInfo userInfo = findUserInfo(id);
        userInfo.setDateNaissance(dtNaissance);
        userInfo.setNom(nom);
        userInfo.setPrenom(prenom);
        userInfo.setTelephones(telephones);
        return false;
    }

    @Override
    public UserInfo rechercher(Long id) {
        return findUserInfo(id);
    }

    @Override
    public boolean lierProfilImage(Long profilId, Long imageId) {
        ImageMetierLocal iml = new ImageMetier();
        Image image = iml.lire(imageId);
        if (image != null) {
            ProfileMetierLocal pml = new ProfileMetier();
            UserInfo info = pml.rechercher(profilId);
            if (info != null) {
                info.setImage(image);
                try {
                    modifier(info);
                    return true;
                } catch (Exception ex) {
                    Logger.getLogger(ProfileMetier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    
    private void modifier(UserInfo info) throws Exception {
        edit(info);
    }
    
}
