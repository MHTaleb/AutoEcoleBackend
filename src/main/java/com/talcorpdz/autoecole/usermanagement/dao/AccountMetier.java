
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.talcorpdz.autoecole.usermanagement.dao;

import com.talcorpdz.autoecole.usermanagement.dao.exceptions.NonexistentEntityException;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import entity.Account;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taleb
 */
public class AccountMetier extends AccountJpaController implements AccountMetierLocal {
    private static final long serialVersionUID = -2478921792689770837L;

    public AccountMetier() {
        super("DEFAULT_PU");
    }

    public AccountMetier(EntityManagerFactory emf) {
        super(emf);
    }


    @Override
    public Long ajouter(String username, String password) {
        Account account = new Account();

        account.setPassword(password);
        account.setUsername(username);
        create(account);

        return account.getId();
    }

    @Override
    public Long connecter(String username, String password) {
        List<Account> resultList = emf.createEntityManager()
                             .createNamedQuery("Account.Connect",Account.class)
                             .setParameter("username", username)
                             .setParameter("password", password)
                             .getResultList();
        if (resultList != null ) {
            if (resultList.size()>0) {
                return  resultList.get(0).getId();
            }
        }
        
        return Long.valueOf(-1);
    }

    @Override
    public Long modifier(Long id, String username, String password) {
        Account account = findAccount(id);
        if (account != null) {
            try {
                account.setPassword(password);
                account.setUsername(username);
                edit(account);
                return id;
            } catch (Exception ex) {
                Logger.getLogger(AccountMetier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Long.valueOf(-1);
    }

    @Override
    public Account rechercher(Long id) {
        Account account = findAccount(id);
        return account;
    }

    @Override
    public boolean suprimer(Long id) {
        try {
            destroy(id);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AccountMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Account> listerToutLesComptes() {
        return findAccountEntities();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
