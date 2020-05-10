package it.polito.ezgas.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import exception.GPSDataException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.InvalidUserException;
import exception.PriceException;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.service.GasStationService;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.converter.GasStationConverter;
import it.polito.ezgas.converter.UserConverter;
/**
 * Modified by Group48 on 10/5/2020.
 */
@Service
public class GasStationServiceimpl implements GasStationService {

	ArrayList<String> listGasolineTypes = new ArrayList<String>(Arrays.asList(String Diesel, String Gasoline, PremiumGasoline, LPG, Methane));
			
			
	@Override
	public GasStationDto getGasStationById(Integer gasStationId) throws InvalidGasStationException {
		if(gasStationId==null || gasStationId<0) 
			throw new InvalidGasStationException("Wrong gasStationId");
		
		else {
		GasStation gasStation = GasStationRepository.findOne(gasStationId);
		if (gasStation!=null) {
			return GasStationConverter.toGasStationDto(gasStation);
		}
		else
			return null;
		}
		// TODO check
	}

	@Override
	public GasStationDto saveGasStation(GasStationDto gasStationDto) throws PriceException, GPSDataException {
		GasStationDto current=null;

		if(gasStationDto.getPriceReportDtos() == null)
			throw new PriceException("Wrong PriceReport");

		if(Math.abs(gasStationDto.getLat()) >90.0  || Math.abs(gasStationDto.getLon()) >180.0 )
			throw new GPSDataException("Wrong GPSData");

		if (gasStationDto.getGasStationId() == null) {
			GasStation gasStations=GasStationConverter.toGasStation(gasStationDto);
			repositoryGasStation.save(gasStations);
			current=GasStationConverter.toGasStationDto(gasStations);
		}
		else {
			GasStation gasStations=repositoryGasStation.getOne(gasStationDto.getGasStationId());
			gasStations.setCarSharing(gasStationDto.getCarSharing());
			gasStations.setDieselPrice(gasStationDto.getDieselPrice());
			gasStations.setGasPrice(gasStationDto.getGasPrice());
			gasStations.setGasStationAddress(gasStationDto.getGasStationAddress());
			gasStations.setGasStationName(gasStationDto.getGasStationName());
			gasStations.setHasDiesel(gasStationDto.getHasDiesel());
			gasStations.setHasGas(gasStationDto.getHasGas());
			gasStations.setHasMethane(gasStationDto.getHasMethane());
			gasStations.setHasSuper(gasStationDto.getHasSuper());
			gasStations.setHasSuperPlus(gasStationDto.getHasSuperPlus());
			gasStations.setLat(gasStationDto.getLat());
			gasStations.setLon(gasStationDto.getLon());
			gasStations.setMethanePrice(gasStationDto.getMethanePrice());
			gasStations.setReportDependability(gasStationDto.getReportDependability());
			gasStations.setReportTimestamp(gasStationDto.getReportTimestamp());
			gasStations.setReportUser(gasStationDto.getReportUser());
			gasStations.setSuperPlusPrice(gasStationDto.getSuperPlusPrice());
			gasStations.setSuperPrice(gasStationDto.getSuperPrice());
			gasStations.setUser(UserConverter.toUser(gasStationDto.getUserDto()));

			GasStationRepository.save(gasStations);
			current = GasStationConverter.toGasStationDto(gasStations);
		}
		// TODO check
		return current;
	}

	@Override
	public List<GasStationDto> getAllGasStations() {
		List<GasStationDto> gasStations= new ArrayList<GasStationDto>();

		for (GasStation current : repositoryGasStation.findAll()) {
			gasStations.add(GasStationConverter.toGasStationDto(current));
		}
		// TODO Check
		return gasStations;
	}

	@Override
	public Boolean deleteGasStation(Integer gasStationId) throws InvalidGasStationException {
		if(gasStationId==null || gasStationId<0)
			throw new InvalidGasStationException("Wrong gasStationId");
		else {
		repositoryGasStation.delete(gasStationId);
		// TODO check
		return true;
		}
	}

	@Override
	public List<GasStationDto> getGasStationsByGasolineType(String gasolinetype) throws InvalidGasTypeException {
		List<String> gasolineTypes = new ArrayList<String>();
		
		if(!listGasolineTypes.contains(gasolinetype))
			throw new InvalidGasTypeException("Wrong gasolinetype");

		List<GasStationDto> gasStations= new ArrayList<GasStationDto>();

		for (GasStation current : repositoryGasStation.findAll()) {
			ArrayList<String> listGasolineType = getListGasolineTypes(current);
			if(listGasolineType.contains(gasolinetype))
				gasStations.add(GasStationConverter.toGasStationDto(current));
		}
		// TODO Check
		return gasStations;
	}
	
	
	private static ArrayList<String> getListGasolineTypes(GasStation gasStation){
		ArrayList<String> listGasolineType = new ArrayList<String>();
		if(gasStation.getHasDiesel())
			listGasolineType.add("Diesel");
		if(gasStation.getHasMethane())
			listGasolineType.add("Methane");
		if(gasStation.getHasGas())
			listGasolineType.add("LPG");
		if(gasStation.getHasSuper())
			listGasolineType.add("Gasoline");
		if(gasStation.getHasSuperPlus())
			listGasolineType.add("PremiumGasoline");
		return listGasolineType;
	}
	
	
	@Override
	public List<GasStationDto> getGasStationsByProximity(double lat, double lon) throws GPSDataException {
		if(Math.abs(lat) >90.0  || Math.abs(lon) >180.0 )
			throw new GPSDataException("Wrong GPSData");
		
		List<GasStationDto> gasStations= new ArrayList<GasStationDto>();
		
		for (GasStation current : repositoryGasStation.findAll()) {
			double distance = distance(lat, lon, current.getLat(), current.getLon());
			if(distance <= 1)
				gasStations.add(GasStationConverter.toGasStationDto(current));
		}
		
		// TODO checked
		return gasStations;
	}
	
	private static double distance(double lat1, double lon1, double lat2, double lon2) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			dist = dist * 1.609344;
			
			return (dist);
		}
	}
	
	@Override
	public List<GasStationDto> getGasStationsWithCoordinates(double lat, double lon, String gasolinetype,
			String carsharing) throws InvalidGasTypeException, GPSDataException {
		
		if(Math.abs(lat) >90.0  || Math.abs(lon) >180.0 )
			throw new GPSDataException("Wrong GPSData");
		
		if(!listGasolineTypes.contains(gasolinetype))
			throw new InvalidGasTypeException("Wrong gasolinetype");
		
		List<GasStationDto> gasStations= new ArrayList<GasStationDto>();
		
		for (GasStation current : repositoryGasStation.findAll()) {
			double distance = distance(lat, lon, current.getLat(), current.getLon());
			if(distance <= 1 && getListGasolineTypes(current).contains(gasolinetype) && current.getCarSharing() == carsharing) //Check 3 statements
				gasStations.add(GasStationConverter.toGasStationDto(current));
		}
		// TODO checked
		return gasStations;
	}

	@Override
	public List<GasStationDto> getGasStationsWithoutCoordinates(String gasolinetype, String carsharing)
			throws InvalidGasTypeException {
		
		if(!listGasolineTypes.contains(gasolinetype))
			throw new InvalidGasTypeException("Wrong gasolinetype");
		
		List<GasStationDto> gasStations= new ArrayList<GasStationDto>();
		
		for (GasStation current : repositoryGasStation.findAll()) {
			if(getListGasolineTypes(current).contains(gasolinetype) && current.getCarSharing() == carsharing) //Check 2 statements
				gasStations.add(GasStationConverter.toGasStationDto(current));
		}
		// TODO checked
		return gasStations;
	}

	@Override
	public void setReport(Integer gasStationId, double dieselPrice, double superPrice, double superPlusPrice,
			double gasPrice, double methanePrice, Integer userId)
			throws InvalidGasStationException, PriceException, InvalidUserException {
		
		if(gasStationId==null || gasStationId<0) 
			throw new InvalidGasStationException("Wrong gasStationId");
		
		if(userId==null || gasStationId<0) 
			throw new InvalidUserException("Wrong userId");
		
		if(dieselPrice < 0 || superPrice < 0 || superPlusPrice < 0 || gasPrice < 0 || methanePrice < 0)
			throw new PriceException("Wrong Price");
		
		GasStation gasStation = GasStationRepository.findOne(gasStationId);
		
		gasStation.setDieselPrice(dieselPrice);
		gasStation.setGasPrice(gasPrice);
		gasStation.setSuperPrice(superPrice);
		gasStation.setSuperPlusPrice(superPlusPrice);
		gasStation.setMethanePrice(methanePrice);
		gasStation.setUser(UserRepository.findOne(userId));
		
		return;
			
		// TODO checked

	}

	@Override
	public List<GasStationDto> getGasStationByCarSharing(String carSharing) {
		
		List<GasStationDto> gasStations= new ArrayList<GasStationDto>();
		
		for (GasStation current : repositoryGasStation.findAll()) {
			if(current.getCarSharing() == carSharing)
				gasStations.add(GasStationConverter.toGasStationDto(current));
		}
		// TODO checked
		return gasStations;
	}






}
