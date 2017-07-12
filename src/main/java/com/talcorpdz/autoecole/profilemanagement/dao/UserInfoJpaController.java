/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talcorpdz.autoecole.profilemanagement.dao;

import com.talcorpdz.autoecole.usermanagement.dao.exceptions.NonexistentEntityException;
import entity.UserInfo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author taleb
 */
public class UserInfoJpaController implements Serializable {

    public UserInfoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UserInfo userInfo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(userInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UserInfo userInfo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            userInfo = em.merge(userInfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = userInfo.getId();
                if (findUserInfo(id) == null) {
                    throw new NonexistentEntityException("The userInfo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UserInfo userInfo;
            try {
                userInfo = em.getReference(UserInfo.class, id);
                userInfo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The userInfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(userInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UserInfo> findUserInfoEntities() {
        return findUserInfoEntities(true, -1, -1);
    }

    public List<UserInfo> findUserInfoEntities(int maxResults, int firstResult) {
        return findUserInfoEntities(false, maxResults, firstResult);
    }

    private List<UserInfo> findUserInfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from UserInfo as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public UserInfo findUserInfo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UserInfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserInfoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from UserInfo as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
