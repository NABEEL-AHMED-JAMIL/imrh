package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.dto.PartnerDto;
import com.etisalat.imrh.entity.Partner;
import com.etisalat.imrh.repository.*;
import com.etisalat.imrh.repository.query.EntityQuery;
import com.etisalat.imrh.service.PartnerService;
import com.etisalat.imrh.util.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartnerServiceImpl implements PartnerService {

    public Logger logger = LogManager.getLogger(PartnerServiceImpl.class);

    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private PartnerCountryProductRepository partnerCountryProductRepository;
    @Autowired
    private EntityQuery entityQuery;

    @Override
    public GenericResponseDto<Object> enableDisableMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                    HttpStatus.BAD_REQUEST.series().name(), "Partner id missing.");
        }
        Optional<Partner> partner = this.partnerRepository.findById(partnerDto.getPartnerId());
        if (partner.isPresent()) {
            partner.get().setEnabled(partnerDto.getEnable().name());
            this.partnerRepository.save(partner.get());
            return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(),
                    null, String.format("Partner update successfully with %d.", partnerDto.getPartnerId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Partner not found with %d.", partnerDto.getPartnerId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllMtoPartner(Enable enable) {
        return CommonUtils.getResponseWithData(this.partnerRepository
            .setAllPartnerStatus(enable.name()), HttpStatus.OK.series().name(),
        null, "All Partner update successfully.");
    }

    @Override
    public GenericResponseDto<Object> fetchAllMtoPartner() {
        return CommonUtils.getResponseWithData(this.partnerRepository.findAll()
            .stream().map(partner -> {
                PartnerDto partnerDto = new PartnerDto();
                partnerDto.setPartnerId(partner.getPartnerId());
                partnerDto.setPartnerName(partner.getPartnerName());
                partnerDto.setPreferenceOrder(partner.getPreferenceOrder());
                partnerDto.setForexMarginShare(partner.getForexMarginShare());
                partnerDto.setPartnerShare(partner.getPartnerShare());
                partnerDto.setTransferSpeed(partner.getTransferSpeed());
                partnerDto.setPartnerCategory(partner.getPartnerCategory());
                partnerDto.setPartnerTxtIdLabel(partner.getPartnerTxtIdLabel());
                partnerDto.setEnable(Enable.valueOf(partner.getEnabled()));
                return partnerDto;
            }).collect(Collectors.toList()),
            HttpStatus.OK.series().name(), null, String.format("Partner fetch successfully."));
    }

    @Override
    public GenericResponseDto<Object> findByMtoPartnerId(Long partnerId) {
        Optional<Partner> partner = this.partnerRepository.findById(partnerId);
        if (partner.isPresent()) {
            PartnerDto partnerDto = new PartnerDto();
            partnerDto.setPartnerId(partner.get().getPartnerId());
            partnerDto.setPartnerName(partner.get().getPartnerName());
            partnerDto.setPreferenceOrder(partner.get().getPreferenceOrder());
            partnerDto.setForexMarginShare(partner.get().getForexMarginShare());
            partnerDto.setPartnerShare(partner.get().getPartnerShare());
            partnerDto.setTransferSpeed(partner.get().getTransferSpeed());
            partnerDto.setPartnerCategory(partner.get().getPartnerCategory());
            partnerDto.setPartnerTxtIdLabel(partner.get().getPartnerTxtIdLabel());
            partnerDto.setEnable(Enable.valueOf(partner.get().getEnabled()));
            return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(), null,
                    String.format("Partner find successfully with %d.", partnerId));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Partner not found with %d.", partnerId));
    }

    @Override
    public GenericResponseDto<Object> updateMtoPartner(PartnerDto partnerDto) {
        if (CommonUtils.isNull(partnerDto.getPartnerId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Partner id missing.");
        } else if (CommonUtils.isNull(partnerDto.getPartnerName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Partner name missing.");
        } else if (CommonUtils.isNull(partnerDto.getPreferenceOrder())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Partner preferenceOrder missing.");
        } else if (CommonUtils.isNull(partnerDto.getForexMarginShare())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Partner forexMarginShare missing.");
        } else if (CommonUtils.isNull(partnerDto.getPartnerShare())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Partner partnerShare missing.");
        } else if (CommonUtils.isNull(partnerDto.getTransferSpeed())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Partner transferSpeed missing.");
        } else if (CommonUtils.isNull(partnerDto.getPartnerCategory())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Partner partnerCategory missing.");
        } else if (CommonUtils.isNull(partnerDto.getPartnerTxtIdLabel())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Partner partnerTxtIdLabel missing.");
        }
        Optional<Partner> partner = this.partnerRepository.findById(partnerDto.getPartnerId());
        if (partner.isPresent()) {
            partner.get().setPartnerName(partnerDto.getPartnerName());
            partner.get().setPreferenceOrder(partnerDto.getPreferenceOrder());
            partner.get().setForexMarginShare(partnerDto.getForexMarginShare());
            partner.get().setPartnerShare(partnerDto.getPartnerShare());
            partner.get().setTransferSpeed(partnerDto.getTransferSpeed());
            partner.get().setPartnerCategory(partnerDto.getPartnerCategory());
            partner.get().setPartnerTxtIdLabel(partnerDto.getPartnerTxtIdLabel());
            partner.get().setEnabled(partnerDto.getEnable().name());
            this.partnerRepository.save(partner.get());
            return CommonUtils.getResponseWithData(partnerDto, HttpStatus.OK.series().name(),
                    null, String.format("Partner update successfully with %d.", partnerDto.getPartnerId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Partner not found with %d.", partnerDto.getPartnerId()));
    }

    /**
     * All mapping will auto delete due to CascadeType-all
     * table effect after delete teh mto partner
     * will auto delete the (partner_country, partner_city, partner_wallet, partner_bank, partner_country_product)
     * */
    @Override
    public GenericResponseDto<Object> deleteMtoPartner(Long partnerId) {
        this.partnerRepository.deletePartnerCountryByPartnerId(partnerId);
        this.partnerRepository.deletePartnerCityByPartnerId(partnerId);
        this.partnerRepository.deletePartnerBankByPartnerId(partnerId);
        this.partnerRepository.deletePartnerWalletByPartnerId(partnerId);
        this.partnerCountryProductRepository.deleteByProductId(partnerId);
        this.partnerRepository.deleteById(partnerId);
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Partner delete successfully with %d.", partnerId));
    }

    @Override
    public GenericResponseDto<Object> updatePreferenceOrderForMtoPartner(List<PartnerDto> partnerDtoList) {
        this.entityQuery.executeUpdateQuery(this.entityQuery.changePreferenceOrder(partnerDtoList));
        return CommonUtils.getResponseWithData(partnerDtoList, HttpStatus.OK.series().name(),
                null, "Partner's preference order update successfully.");
    }
}
