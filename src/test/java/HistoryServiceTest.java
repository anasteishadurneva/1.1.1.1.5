import com.bank.history.DTO.HistoryDTO;
import com.bank.history.Entity.History;
import com.bank.history.Exceptions.HistoryNotFoundException;
import com.bank.history.Mapper.HistoryMapper;
import com.bank.history.Repository.HistoryRepository;
import com.bank.history.Service.HistoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


@ExtendWith( MockitoExtension.class )
public class HistoryServiceTest {
    @Mock
    private HistoryRepository historyRepository;

    @InjectMocks
    private HistoryServiceImpl historyService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        // Arrange
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setTransferAuditId(1L);

        History history = HistoryMapper.INSTANCE.toEntity(historyDTO);

        // Act
        HistoryDTO result = historyService.create(historyDTO);

        // Assert
        assertEquals(historyDTO.getTransferAuditId(), result.getTransferAuditId());
    }

    @Test
    public void testGetHistoryByIdNotFoundException() {
        Long id = 1L;
        when(historyRepository.findById(id)).thenReturn( Optional.empty());
        assertThrows(HistoryNotFoundException.class, () -> {
            historyService.getHistoryById(id);
        });
    }
}
