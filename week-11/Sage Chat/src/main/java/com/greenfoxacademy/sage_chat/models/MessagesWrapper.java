package com.greenfoxacademy.sage_chat.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class MessagesWrapper {

  private List<Message> messages;
}
