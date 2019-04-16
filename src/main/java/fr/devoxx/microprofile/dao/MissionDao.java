package fr.devoxx.microprofile.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import fr.devoxx.microprofile.entities.MissionEntity;


@RequestScoped
@Transactional
public class MissionDao {
	
    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;
    
    public Optional<MissionEntity> save(MissionEntity missionEntity){
    	em.persist(missionEntity);
    	em.flush();
    	System.err.println("save : " +missionEntity);
    	return Optional.ofNullable(missionEntity);
    }
	
    public Optional<MissionEntity> findById(Integer id){
    	return Optional.ofNullable(em.find(MissionEntity.class, id));
    }
    
    public List<MissionEntity> findAll(){
    	return em.createNamedQuery("Mission.findAll", MissionEntity.class).getResultList();
    }
    
    public List<MissionEntity> findStoneByName(String name){
    	return em.createNamedQuery("Mission.findByName", MissionEntity.class)
    			.setParameter("name", name)
    			.getResultList();
    }

}
