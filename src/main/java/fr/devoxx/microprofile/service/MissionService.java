package fr.devoxx.microprofile.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import fr.devoxx.microprofile.dao.MissionDao;
import fr.devoxx.microprofile.entities.MissionEntity;
import fr.devoxx.microprofile.model.Mission;
import fr.devoxx.microprofile.service.client.StoneClient;

@ApplicationScoped
public class MissionService {

	@Inject MissionDao missionDao;

	public Mission save(Mission mission) throws URISyntaxException {


		if (!checkIftheirExistingStone(mission.getStoneId()))
			return null;

		Optional<MissionEntity> missionEntity = missionDao.
				save(MissionMapper.ToMissionEntity.apply(Optional.of(mission)).get());

		return MissionMapper.ToMission.apply(missionEntity).get();
	}

	public Mission findById(Integer id) {
		return MissionMapper.ToMission.apply(missionDao.findById(id)).get();
	}

	public List<Mission> findAll(){
		return MissionMapper.ToMissions.apply(missionDao.findAll());
	}


	private Boolean checkIftheirExistingStone(Integer stoneId) throws URISyntaxException {

		String baseUri = "http://localhost:9080/InfinityWar/";
		URI apiUri = URI.create(baseUri);
		StoneClient stoneClient = RestClientBuilder.newBuilder()
				.baseUri(apiUri)
				.build(StoneClient.class);

		if (stoneClient.getStone(stoneId).getId()== stoneId)
			return true;

		return false;
	}
}
