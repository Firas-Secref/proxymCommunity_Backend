package com.proxymcommunity.proxymCommunity.controller;

import com.proxymcommunity.proxymCommunity.converter.NotificationConverter;
import com.proxymcommunity.proxymCommunity.dto.notifications.NotificationDto;
import com.proxymcommunity.proxymCommunity.repository.DeveloperRepository;
import com.proxymcommunity.proxymCommunity.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationControler {

    @Autowired
    private NotificationService service;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private NotificationConverter converter;

    public NotificationControler(NotificationService service, DeveloperRepository developerRepository, NotificationConverter converter) {
        this.service = service;
        this.developerRepository = developerRepository;
        this.converter = converter;
    }

    @MessageMapping("/notificationForLike")
    @SendTo("/topic/newNotifLike")
    public NotificationDto sendNewLike(String notification) throws Exception {
        System.out.println(notification);
        return this.converter.entityToLikeDto(this.service.saveLikeNotification(notification));

    }

    @MessageMapping("/notificationForNewPost")
    @SendTo("/topic/newNotifPost")
    public String sendNewPost(String notification) throws Exception {

        System.out.println(notification);
        return "normal";
//        return this.converter.entityToDto(this.service.saveNotification(notification));

    }

    @MessageMapping("/notificationForNewFollow")
    @SendTo("/topic/newNotifFollow")
    public NotificationDto sendNewFollow(String notification) throws Exception {
        return this.converter.entityToFollowDto(this.service.saveFollowNotification(notification));
    }


    @GetMapping("/myNotifications/{id}")
    public List<NotificationDto> getMyNotifications(@PathVariable Long id){
        return this.converter.entityToBasicDto(this.service.getMyNotifications(id));
    }


}
