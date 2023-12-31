package com.bank.history.Service;

import com.bank.history.DTO.HistoryDTO;
import com.bank.history.Entity.History;
import com.bank.history.Exceptions.HistoryNotFoundException;
import com.bank.history.Mapper.HistoryMapper;
import com.bank.history.Repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    @Override
    public HistoryDTO getHistoryById(Long id) {
        History history = historyRepository.findById(id).orElseThrow(
                () -> {
                    log.error("History with id = " + id + " is not found!");
                    return new HistoryNotFoundException("History with id = " + id + " is not found!");
                });
        log.info("history with id= " + id + "found in database");
        return HistoryMapper.INSTANCE.toDTO(history);
    }
    @Override
    public HistoryDTO create(HistoryDTO historyDTO) {
        History history = HistoryMapper.INSTANCE. toEntity(historyDTO);
        historyRepository.save(history);
        log.info("history with id= " + history.getId() + "created in database");
        return HistoryMapper.INSTANCE.toDTO(history);
    }
}
