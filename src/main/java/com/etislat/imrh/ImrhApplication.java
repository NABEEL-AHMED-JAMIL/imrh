package com.etislat.imrh;

import com.etislat.imrh.entity.*;
import com.etislat.imrh.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ImrhApplication implements ApplicationRunner {

	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private WalletRepository walletRepository;
	@Autowired
	private PartnerRepository partnerRepository;

	public static void main(String[] args) {
		SpringApplication.run(ImrhApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		this.savePartnerCity();
//		this.saveCountry();
//		this.saveCity();
//		this.saveBank();
//		this.saveWallet();
//		this.savePartner();
		//deleteCountry();
	}

	public void saveCountry() {
		Country country = new Country();
		country.setCountryName("Pakistan");
		country.setCountryCode("PAK");
		country.setCountryLegacyCode("PK");
		country.setEnabled("Y");
		this.countryRepository.save(country);
		Country country1 = new Country();
		country1.setCountryName("Indai");
		country1.setCountryCode("IND");
		country1.setCountryLegacyCode("IN");
		country1.setEnabled("Y");
		this.countryRepository.save(country1);
	}

	public void saveCity() {
		List<String> cityName = Arrays.asList("Karachi", "Lahore", "Faisalabad", "Rawalpindi", "Multan", "Gujranwala");
		Optional<Country> country = this.countryRepository.findById("PAK");
		cityName.forEach(name -> {
			City city = new City();
			city.setEnabled("Y");
			city.setCityName(name);
			city.setCountry(country.get());
			this.cityRepository.save(city);
		});
	}

	public void saveBank() {
		List<String> bankName = Arrays.asList("Askari Bank", "Allied Bank Limited", "Bank Alfalah", "Bank Al Habib", "Faysal Bank",
			"Habib Bank Limited", "Habib Metropolitan Bank", "JS Bank");
		Optional<Country> country = this.countryRepository.findById("PAK");
		bankName.forEach(name -> {
			Bank bank = new Bank();
			bank.setEnabled("Y");
			bank.setBankName(name);
			bank.setCountry(country.get());
			this.bankRepository.save(bank);
		});
	}

	public void saveWallet() {
		List<String> walletName = Arrays.asList("Keenu Wallet", "SimSim Wallet", "PayMax", "EasyPaisa", "JazzCash", "Final Word");
		Optional<Country> country = this.countryRepository.findById("PAK");
		walletName.forEach(name -> {
			Wallet wallet = new Wallet();
			wallet.setEnabled("Y");
			wallet.setWalletName(name);
			wallet.setCountry(country.get());
			this.walletRepository.save(wallet);
		});
	}

	public void savePartner() {
		List<String> partnerName = Arrays.asList("Moneygram","Master Card","Western Union");
		partnerName.forEach(name -> {
			Partner partner = new Partner();
			partner.setPartnerName(name);
			partner.setEnabled("Y");
			partner.setPreferenceOrder(1);
			partner.setForexMarginShare(14.55);
			partner.setPartnerShare(15.88);
			partner.setTransferSpeed("RealTime");
			partner.setPartnerCategory("MTO opt");
			partner.setPartnerTxtIdLabel("987456321");
			this.partnerRepository.save(partner);
		});
	}

	public void savePartnerCity() {
		Map<Long, List<Long>> partnerCity = new HashMap<>();
		partnerCity.put(1000L, Arrays.asList(1000L));
		partnerCity.put(1001L, Arrays.asList(1000L, 1001L));
		partnerCity.put(1002L, Arrays.asList(1000L, 1001L, 1002L));
		//
		Set<Map.Entry<Long, List<Long>>> keyValue = partnerCity.entrySet();
		keyValue.stream().forEach(longListEntry -> {
			Optional<Partner> partner = this.partnerRepository.findById(longListEntry.getKey());
			if (partner.isPresent()) {
				longListEntry.getValue().forEach(aLong -> {
					Optional<City> city = this.cityRepository.findById(aLong);
					if (city.isPresent()) {
						partner.get().getCities().add(city.get());
					}
				});
				this.partnerRepository.save(partner.get());
			}
		});

	}

}
