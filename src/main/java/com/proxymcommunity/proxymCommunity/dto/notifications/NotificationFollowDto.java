package com.proxymcommunity.proxymCommunity.dto.notifications;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationFollowDto extends NotificationDto {
    private String notificationTextForNewFollow;
}
