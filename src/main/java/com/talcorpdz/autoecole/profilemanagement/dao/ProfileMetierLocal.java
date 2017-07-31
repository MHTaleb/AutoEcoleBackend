/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talcorpdz.autoecole.profilemanagement.dao;

import entity.UserInfo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author taleb
 */
public interface ProfileMetierLocal {

    public Long creerProfile(String nom, String prenom, LocalDate dateNaissance, List telephones);

    public boolean lierCompteProfil(Long accountID, Long profilID);
    
    public boolean lierProfilImage(Long profilId, Long imageId);

    public boolean supprimer(Long id);
    
    public UserInfo rechercher(Long id);

    public boolean modifier(Long id, String nom, String prenom, LocalDate dtNaissance, List telephones);

   
}
