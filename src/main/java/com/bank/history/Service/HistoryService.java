package com.bank.history.Service;

import com.bank.history.DTO.HistoryDTO;


public interface HistoryService {
    HistoryDTO getHistoryById(Long id);
    HistoryDTO create(HistoryDTO historyDTO);

}
