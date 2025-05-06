/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Persistencias;

import com.mycompany.Clases.Turno;
import com.mycompany.Clases.Vehiculo;
import com.mycompany.Persistencias.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Nicolay
 */
public class TurnoJpaController implements Serializable {

    public TurnoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_MavenPrueba_jar_1.0-SNAPSHOTPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            turno = em.merge(turno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = turno.getIdTurno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getIdTurno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Turno findTurno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public boolean existeTurnoMismoDia(String placa, String dia) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(t) FROM Turno t WHERE t.auto.placa = :placa AND t.dia = :dia", Long.class);
            query.setParameter("placa", placa);
            query.setParameter("dia", dia);
            return query.getSingleResult() > 0;
        } finally {
            em.close();
        }
    }

    public boolean existeTurnoMismoAnden(String placa, String anden) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(t) FROM Turno t WHERE t.auto.placa = :placa AND t.anden = :anden", Long.class);
            query.setParameter("placa", placa);
            query.setParameter("anden", anden);
            return query.getSingleResult() > 0;
        } finally {
            em.close();
        }
    }

    public List<Turno> buscarTurnosPorVehiculo(Vehiculo vehiculo) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT t FROM Turno t WHERE t.auto = :vehiculo", Turno.class)
                    .setParameter("vehiculo", vehiculo)
                    .getResultList(); 
        } finally {
            em.close();
        }
    }

    public boolean existeTurnoEnAnden(Vehiculo vehiculo, String anden) {
        EntityManager em = getEntityManager();
        try {
            Long count = em.createQuery("SELECT COUNT(t) FROM Turno t WHERE t.auto = :vehiculo AND t.anden = :anden", Long.class)
                    .setParameter("vehiculo", vehiculo)
                    .setParameter("anden", anden)
                    .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }

    public boolean existeTurnoEnDia(Vehiculo vehiculo, String dia) {
        EntityManager em = getEntityManager();
        try {
            Long count = em.createQuery("SELECT COUNT(t) FROM Turno t WHERE t.auto = :vehiculo AND t.dia = :dia", Long.class)
                    .setParameter("vehiculo", vehiculo)
                    .setParameter("dia", dia)
                    .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }

}
