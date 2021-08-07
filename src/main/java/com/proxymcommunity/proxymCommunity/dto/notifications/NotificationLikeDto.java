package com.proxymcommunity.proxymCommunity.dto.notifications;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationLikeDto extends NotificationDto {
    private String notificationTextForNewLike;
}
