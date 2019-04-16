package fr.devoxx.microprofile.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import fr.devoxx.microprofile.entities.MissionEntity;
import fr.devoxx.microprofile.model.Mission;

public final class  MissionMapper {


	private MissionMapper() {
		super();
	}

	public static Function<Optional<MissionEntity>, Optional<Mission>> ToMission = (missionEntity) ->{

		if (missionEntity.isEmpty()) 
			return Optional.empty();

		MissionEntity missionEntityTmp = missionEntity.get();
		Mission mission = new Mission();
		mission.setId(missionEntityTmp.getId());
		mission.setName(missionEntityTmp.getName());
		mission.setKeeper(missionEntityTmp.getKeeper());
		mission.setPlanet(missionEntityTmp.getPlanet());
		mission.setStoneId(missionEntityTmp.getStoneId());
		return Optional.of( mission);


	};

	public static Function<List<MissionEntity>, List<Mission>> ToMissions = (missionEntities) ->{
		return missionEntities.stream().map(me -> MissionMapper.ToMission.apply(Optional.of(me)).get()).collect(Collectors.toList());
	};

	public static  Function<Optional<Mission>, Optional<MissionEntity>> ToMissionEntity = (mission) ->{

		if (mission.isEmpty()) 
			return Optional.empty();

		Mission missionTmp = mission.get();
		MissionEntity missionEntity = new MissionEntity();
		missionEntity.setId(missionTmp.getId());
		missionEntity.setKeeper(missionTmp.getKeeper());
		missionEntity.setName(missionTmp.getName());
		missionEntity.setPlanet(missionTmp.getPlanet());
		missionEntity.setStoneId(missionTmp.getStoneId());
		return Optional.of(missionEntity) ;


	};

	public static Function<List<Mission>, List<MissionEntity>> ToMissionEntities = (missions) ->{
		return missions.stream().map(m -> MissionMapper.ToMissionEntity.apply(Optional.of(m)).get()).collect(Collectors.toList());
	};

}
