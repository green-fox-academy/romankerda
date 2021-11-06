package com.greenfoxacademy.frontend.models.DTO;

import com.greenfoxacademy.frontend.models.Log;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.juli.logging.LogFactory;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogsDTO {

  private List<LogDTO> entries;
  private int entry_count;

}
