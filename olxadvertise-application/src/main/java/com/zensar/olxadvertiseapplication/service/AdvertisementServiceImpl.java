package com.zensar.olxadvertiseapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxadvertiseapplication.dto.AdvertisementDto;
import com.zensar.olxadvertiseapplication.entity.Advertisement;
import com.zensar.olxadvertiseapplication.exception.InvalidAdvertiseIdException;
import com.zensar.olxadvertiseapplication.repository.AdvertisementRepository;




@Service
public class AdvertisementServiceImpl implements AdvertisementService {
	
	@Autowired
	private AdvertisementRepository advertisementRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	/*static List<Advertisement> ListOfAdvertisement = new ArrayList();
	
	static {
		
			ListOfAdvertisement.add(new Advertisement(1, "laptopSale", 54000, "Electronics Goods", "Intel Core 3 Sony Vaio", "anand",
				1996, 2020, "OPEN"));
			ListOfAdvertisement.add(new Advertisement(2, "ComputerSale", 30000, "Computer Goods", "Intel Core 9 Razor Gaming", "anand",
					1998, 2022, "OPEN"));
		}*/
	

	public AdvertisementDto createNewAdvertise(AdvertisementDto advertiseDto, String token) {
		
		Advertisement newAdvertise=modelMapper.map(advertiseDto, Advertisement.class);
		if (token.equals("ry66540")) {
			Advertisement save = advertisementRepository.save(newAdvertise);
			return modelMapper.map(save,AdvertisementDto.class);

			
			//Advertisement advertise1=advertisementRepository.save(advertisedto);
			//ListOfAdvertisement.add(advertise);
			//return advertise1;
		} else {
			return null;
		}
	}

	public AdvertisementDto getAdvertise(long id) throws InvalidAdvertiseIdException {
		//Optional<Stock> optStock = stockRepository.findById(stockId);
		Optional<Advertisement> optAdvertise=advertisementRepository.findById(id);
		
		if(optAdvertise.isPresent()) {
			Advertisement advertise=optAdvertise.get();
			 return modelMapper.map(advertise,AdvertisementDto.class);
		}else {
			throw new InvalidAdvertiseIdException("Advertisement is not present of given id "+id);
		}
	}
	/*	Optional<Advertisement> advertise1 = ListOfAdvertisement.stream().filter(advertise -> advertise.getId() == id)
				.findAny();

		if (advertise1.isPresent()) {
			return advertise1.get();
		}

		return advertise1.orElseGet(() -> {
			return new Advertisement();
		});
	}*/

	public AdvertisementDto updateAdvertisement(long id, Advertisement advertise, String token) throws InvalidAdvertiseIdException {
		AdvertisementDto advertiseDto = getAdvertise(id);
		
		Advertisement advertise2=modelMapper.map(advertiseDto, Advertisement.class);
		
		if(advertise2!=null) {
			
			advertise2.setTitle(advertise.getTitle());
			advertise2.setPrice(advertise.getPrice());
			advertise2.setDescription(advertise.getDescription());
			advertise2.setUserName(advertise.getUserName());
			advertise2.setCreatedDate(advertise.getCreatedDate());
			
			Advertisement advertise3 = advertisementRepository.save(advertise2);
			return modelMapper.map(advertise3, AdvertisementDto.class);
		}
		
		return null;
	}
		/*if (token.equals("ry66540")) {

			Advertisement availableadvertise = getAdvertise(id);
			availableadvertise.setTitle(advertise.getTitle());
			availableadvertise.setCategory(advertise.getCategory());
			availableadvertise.setDescription(advertise.getDescription());
			return availableadvertise;
		} else {
			return new Advertisement();
		}
	}*/

	public List<AdvertisementDto> getAllAdvertisements(String token) {
		List<Advertisement> advertise=advertisementRepository.findAll();
		
		 List<AdvertisementDto> advertiseDtos = new ArrayList<>();
		if (token.equals("ry66540")) {
			 for(Advertisement advertisement:advertise) {
					
				 AdvertisementDto newAdvertise=modelMapper.map(advertisement,AdvertisementDto.class);
				 advertiseDtos.add(newAdvertise);
					 }return advertiseDtos;

			
		} else {
			return null;

		}
	}

	public boolean deleteAdvertisement(String token, long id) {
		
		if(token.equals("ry66540")) {
			advertisementRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
		/*for (Advertisement advertise : ListOfAdvertisement) {

			if (token.equals("ry66540") && advertise.getId() == id) {

				ListOfAdvertisement.remove(advertise);
				return true;

			} else {
				return false;

			}

		}

		return false;
	}*/

	@Override
	public Advertisement filterBasedSearchAdvertise() {
		String filterText = "OPEN";
		return null;
		//advertisementRepository.findBy();
	}
		/*Optional<Advertisement> findAnyAdvertise = ListOfAdvertisement.stream().filter(criteria -> criteria.toString().toLowerCase().contains(filterText)).findAny();
		if(findAnyAdvertise.isPresent())

			return findAnyAdvertise.get();
		}
		else
		{
			return null;
		}
	}*/

	@Override
	public Advertisement searchBasedSearchtextAdvertise() {
		String filterText = "CLOSED";
		return null;
	}
		/*<Advertisement> findAnyAdvertise = ListOfAdvertisement.stream().filter(criteria -> criteria.toString().toLowerCase().contains(filterText)).findAny();
		if(findAnyAdvertise.isPresent())
		{
			return findAnyAdvertise.get();
		}
		else
		{
			return null;
		}
	}*/
	
	public AdvertisementDto getAdvertisedetails(Advertisement advertiseDetails,long id, String token) {
		
		if (token.equals("ry66540")) {
			Advertisement advertise=advertisementRepository.getById(id);
			
		return modelMapper.map(advertise,AdvertisementDto.class);
			//return maadvertisementRepository.getById(id);
		}
			/*postedBy=advertiseDetails.getUserName();
			 System.out.println(postedBy);
			 return advertiseDetails;*/
		 else {
			return null;
		}
	
	}
}



