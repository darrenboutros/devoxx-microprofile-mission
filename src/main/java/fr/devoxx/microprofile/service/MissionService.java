package fr.devoxx.microprofile.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import fr.devoxx.microprofile.dao.MissionDao;
import fr.devoxx.microprofile.entities.MissionEntity;
import fr.devoxx.microprofile.model.Mission;

@ApplicationScoped
public class MissionService {
	
	@Inject MissionDao missionDao;
	
    public Mission save(Mission mission) {
    	Optional<MissionEntity> missionEntity = missionDao.save(MissionMapper.ToMissionEntity.apply(Optional.of(mission)).get());
    	
    	return MissionMapper.ToMission.apply(missionEntity).get();
    }
	
	public Mission findById(Integer id) {
		return MissionMapper.ToMission.apply(missionDao.findById(id)).get();
	}

	public List<Mission> findAll(){
		return MissionMapper.ToMissions.apply(missionDao.findAll());
	}
	

}
