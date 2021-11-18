package com.greenfoxacademy.sage_chat.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Channel {

  private String channelId;
  private String channelSecret;
  private int count;


}
