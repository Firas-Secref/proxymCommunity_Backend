package com.proxymcommunity.proxymCommunity.dto.notifications;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationLikeDto extends NotificationDto {
    private String notificationText;
}
