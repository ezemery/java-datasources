package com.example.ezemery.repository;

import com.example.ezemery.entity.Delivery;
import com.example.ezemery.entity.RecipientAndPrice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepositoryImpl  implements DeliveryRepository{
    @PersistenceContext
    EntityManager entityManager;

    private static final String GET_RECIPIENT_AND_PRICE =
            "select new com.example.ezemery.entity.RecipientAndPrice(p.name, p.price) " +
                    "from Plant p " +
                    "where p.id = :id";

    public void persist(Delivery delivery){
        entityManager.persist(delivery);
        delivery.setCompleted(true);
    }

    public Delivery find(Long id){
        Delivery d = entityManager.find(Delivery.class, id);
        return d;
    }

    public Delivery merge(Delivery delivery){
        delivery.setAddress("Mufutau Ayodeji Street");
        Delivery d = entityManager.merge(delivery);
        return d;
    }

    public void delete(Long id){
        Delivery d = entityManager.find(Delivery.class, id);
        entityManager.remove(d);
    }

    List<Delivery> findDeliveryByName(String name){
        TypedQuery<Delivery> query = entityManager.createQuery("Delivery.getDeliveryByName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    // One possible way to solve this - query a list of Plants with deliveryId matching
    // the one provided and sum their prices.
   public RecipientAndPrice getBill(Long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> criteria = cb.createQuery(RecipientAndPrice.class);
        Root<RecipientAndPrice> root = criteria.from(RecipientAndPrice.class);
        criteria.select(
                cb.construct(
                        RecipientAndPrice.class,
                        root.get("delivery").get("name"),
                        cb.sum(root.get("price"))
                )
        ).where(cb.equal(root.get("delivery").get("id"), id));
        return entityManager.createQuery(criteria).getSingleResult();
    }
}
