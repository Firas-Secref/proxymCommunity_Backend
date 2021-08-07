package com.proxymcommunity.proxymCommunity.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proxymcommunity.proxymCommunity.dto.notifications.NotificationDto;
import com.proxymcommunity.proxymCommunity.dto.notifications.NotificationFollowDto;
import com.proxymcommunity.proxymCommunity.dto.notifications.NotificationLikeDto;
import com.proxymcommunity.proxymCommunity.dto.notifications.NotificationPostDto;
import com.proxymcommunity.proxymCommunity.entity.Developer;
import com.proxymcommunity.proxymCommunity.entity.Notification;
import com.proxymcommunity.proxymCommunity.repository.DeveloperRepository;
import com.proxymcommunity.proxymCommunity.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private DeveloperRepository developerRepository;

    public NotificationService(NotificationRepository repository, DeveloperRepository developerRepository) {
        this.repository = repository;
        this.developerRepository = developerRepository;
    }

    public List<Notification> getMyNotifications(Long id){
        return this.repository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream().filter(x-> x.getTo_userId() == id).collect(Collectors.toList());
    }

//    -------------------------------

    public Notification saveLikeNotification(String notification) throws JsonProcessingException {
        NotificationLikeDto notif = new ObjectMapper().readValue(notification, NotificationLikeDto.class);
        System.out.println("string"+notification);
        System.out.println("object object"+notif);
        Developer developer = this.developerRepository.findById(notif.getFrom_userId()).orElse(null);
        Notification newNotification = new Notification(developer, notif.getTo_firstname(), notif.getTo_lastname(), notif.getTo_userId(), notif.getAction(),notif.getTo_username(), notif.getNotificationText());
        return this.repository.save(newNotification);
    }

    public Notification savePostNotification(String notification) throws JsonProcessingException {
        NotificationPostDto notif = new ObjectMapper().readValue(notification, NotificationPostDto.class);
        System.out.println("string"+notification);
        System.out.println("object object"+notif);

        Developer developer = this.developerRepository.findById(notif.getFrom_userId()).orElse(null);
        Notification newNotification = new Notification(developer, notif.getTo_firstname(), notif.getTo_lastname(), notif.getTo_userId(), notif.getAction(),notif.getTo_username(), notif.getNotificationText());
        return this.repository.save(newNotification);
    }

    public Notification saveFollowNotification(String notification) throws JsonProcessingException {
        NotificationFollowDto notif = new ObjectMapper().readValue(notification, NotificationFollowDto.class);
        System.out.println("string"+notification);
        System.out.println("object object"+notif);

        Developer developer = this.developerRepository.findById(notif.getFrom_userId()).orElse(null);
        Notification newNotification = new Notification(developer, notif.getTo_firstname(), notif.getTo_lastname(), notif.getTo_userId(), notif.getAction(),notif.getTo_username(), notif.getNotificationText());
        return this.repository.save(newNotification);
    }


}
