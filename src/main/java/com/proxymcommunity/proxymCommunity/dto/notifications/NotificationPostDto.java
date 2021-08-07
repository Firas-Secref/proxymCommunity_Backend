package com.proxymcommunity.proxymCommunity.dto.notifications;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationPostDto extends NotificationDto {
    private String notificationTextForNewPost;
}
