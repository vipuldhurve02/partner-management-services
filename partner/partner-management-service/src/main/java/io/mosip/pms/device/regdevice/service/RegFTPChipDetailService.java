package io.mosip.pms.device.regdevice.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.mosip.pms.common.dto.PageResponseDto;
import io.mosip.pms.device.request.dto.DeviceSearchDto;
import io.mosip.pms.device.request.dto.FtpChipCertDownloadRequestDto;
import io.mosip.pms.device.request.dto.FtpChipCertificateRequestDto;
import io.mosip.pms.device.request.dto.FtpChipDetailDto;
import io.mosip.pms.device.request.dto.FtpChipDetailStatusDto;
import io.mosip.pms.device.request.dto.FtpChipDetailUpdateDto;
import io.mosip.pms.device.response.dto.FTPSearchResponseDto;
import io.mosip.pms.device.response.dto.FtpCertDownloadResponeDto;
import io.mosip.pms.device.response.dto.FtpCertificateResponseDto;
import io.mosip.pms.device.response.dto.IdDto;
import io.mosip.pms.partner.response.dto.PartnerCertDownloadResponeDto;
import io.mosip.pms.partner.response.dto.PartnerCertificateResponseDto;

@Service
public interface RegFTPChipDetailService {	
	
	/**
	 * Inserts the chip make and model into database
	 * @param chipDetails
	 * @return
	 */
	public IdDto createFtpChipDetails(FtpChipDetailDto chipDetails);

	/**
	 * Updated the chip make & mode details
	 * @param chipDetails
	 * @return
	 */
	public IdDto updateFtpChipDetails(FtpChipDetailUpdateDto chipDetails);
	
	/**
	 * Changes the chip status
	 * @param chipDetails
	 * @return
	 */
	public String updateFtpChipDetailStatus(FtpChipDetailStatusDto chipDetails);
	
	/**
     * Function to Upload Partner certificates
     * 
     * @param FtpChipCertificateRequestDto partnerCertResponseDto
     * @return {@link PartnerCertificateResponseDto} instance
     * @throws IOException 
     * @throws JsonProcessingException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
    */
    public FtpCertificateResponseDto uploadPartnerCertificate(FtpChipCertificateRequestDto ftpChipCertRequestDto) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException;

    /**
     * Function to Download Partner certificates
     * 
     * @param FtpChipCertDownloadRequestDto certDownloadRequestDto
     * @return {@link PartnerCertDownloadResponeDto} instance
     * @throws IOException 
     * @throws JsonProcessingException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
    */
    public FtpCertDownloadResponeDto getPartnerCertificate(FtpChipCertDownloadRequestDto certDownloadRequestDto) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException;
    
    /**
     * 
     * @param <E>
     * @param entity
     * @param dto
     * @return
     */
    public <E> PageResponseDto<FTPSearchResponseDto> searchFTPChipDetails(Class<E> entity, DeviceSearchDto dto);

}
