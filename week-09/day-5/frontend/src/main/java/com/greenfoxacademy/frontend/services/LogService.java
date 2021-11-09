package com.greenfoxacademy.frontend.services;

import com.greenfoxacademy.frontend.models.DTO.LogDTO;
import com.greenfoxacademy.frontend.models.Log;
import com.greenfoxacademy.frontend.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LogService {

  LogRepository logRepository;

  @Autowired
  public LogService(LogRepository logRepository) {
    this.logRepository = logRepository;
  }

  public void saveLog(HttpServletRequest request) {
    Log log = new Log();
    log.setEndpoint(request.getServletPath());
    log.setData(request.getQueryString());
    log.setDate(new Date());
    logRepository.save(log);
  }

  public void saveLog2(HttpServletRequest request, String input) {
    Log log = new Log();
    log.setEndpoint(request.getServletPath());
    log.setData(input);
    log.setDate(new Date());
    logRepository.save(log);
  }

  public int countLogs() {
    return logRepository.countLogs();
  }

  public List<Log> getLogs() {
    return logRepository.listLogs();
  }

  public List<LogDTO> getLogsDTO() {
    List<LogDTO> logsDTO = new ArrayList<>();
    List<Log> logs = getLogs();
    for (Log log : logs) {
      LogDTO logDTO = new LogDTO();
      logDTO.setId(log.getId());
      logDTO.setEndpoint(log.getEndpoint());
      logDTO.setData(log.getData());
      logsDTO.add(logDTO);
    }
    return logsDTO;
  }



}
