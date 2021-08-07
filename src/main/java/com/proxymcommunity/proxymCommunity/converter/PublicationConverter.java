package com.proxymcommunity.proxymCommunity.converter;

import com.proxymcommunity.proxymCommunity.dto.PublicationsDTO;
import com.proxymcommunity.proxymCommunity.entity.Publication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PublicationConverter {

    public PublicationsDTO entityToDto(Publication pub){
        PublicationsDTO dto = new PublicationsDTO();
        dto.setId(pub.getId());
        dto.setText(pub.getText());
        dto.setImage1(pub.getImage1());
        dto.setCategorie(pub.getCategorie());
        dto.setUserImage(pub.getDeveloper().getProfileImage());
        dto.setLikesNb(pub.getLikesNb());
        dto.setILikeIt(pub.isILikeIt());
        dto.setUsername(pub.getDeveloper().getUsername());
        dto.setProfileUser(pub.getDeveloper().getProfile());
        dto.setUserDepartment(pub.getDeveloper().getDepartement());
        dto.setFirstName(pub.getDeveloper().getFirstName());
        dto.setLastName(pub.getDeveloper().getLastName());
        dto.setUserId(pub.getDeveloper().getId());
        return dto;
    }

    public List<PublicationsDTO> entityToDto(List<Publication> publications){
        return publications.stream().map(
                x -> entityToDto(x)).collect(Collectors.toList());
    }

}
