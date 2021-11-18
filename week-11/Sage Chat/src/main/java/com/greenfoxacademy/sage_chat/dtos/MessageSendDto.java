package com.greenfoxacademy.sage_chat.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageSendDto {

  private String content;
  private String channelId;
  private String channelSecret;
}
