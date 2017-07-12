/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talcorpdz.autoecole.usermanagement.dao;

import entity.Account;
import java.util.List;

/**
 *
 * @author taleb
 */

public interface AccountMetierLocal {

    public Long ajouter(String username,String password);
    public Long modifier(Long id,String username,String password);
    public boolean suprimer(Long id);
    public Account rechercher(Long id);
    public List<Account> listerToutLesComptes();
    public Long connecter(String username,String password);
    
}
