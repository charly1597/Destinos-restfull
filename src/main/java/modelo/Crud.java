/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DAW-A
 */
public class Crud {
    public static int actualizaDestino(Destinos miDestino) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("miPersistencia");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Destinos p SET p.lugar = :lugar, p.zona = :zona "
                + "WHERE p.id = :id";
        Query q = manager.createQuery(sql, Destinos.class);
        q.setParameter("lugar", miDestino.getLugar());
        q.setParameter("zona", miDestino.getZona());
        q.setParameter("id", miDestino.getId());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();

        return filasAfectadas;
    }
    
    public static Destinos getDestino(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("miPersistencia");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT p FROM Destinos p WHERE p.id=" + id;
        Query q = manager.createQuery(sql, Destinos.class); //método para consultas en JPQL
        Destinos productosBD = (Destinos) q.getSingleResult();

        return productosBD;
    }
    
    public static List<Destinos> getDestinos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("miPersistencia");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM Destinos";
        Query q = manager.createNativeQuery(sql, Destinos.class); //método para consultas en SQL
        List<Destinos> destinosDB = q.getResultList();

        return destinosDB;
    }
    
    public static void insertaDestino(Destinos d) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("miPersistencia");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(d);
        manager.getTransaction().commit();
    }
    
    public static int destroyDestino(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("miPersistencia");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Destinos p WHERE p.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();

        return filasAfectadas;
    }
}
