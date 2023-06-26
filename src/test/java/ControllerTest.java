import com.bank.history.Controller.Controller;
import com.bank.history.DTO.HistoryDTO;
import com.bank.history.Service.HistoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    private HistoryService historyService;
    @InjectMocks
    private Controller controller;

    @Test
    public void testGetHistoryById() {
        HistoryDTO historyDTO = new HistoryDTO();
        when(historyService.getHistoryById(1L)).thenReturn(historyDTO);

        ResponseEntity<HistoryDTO> response = controller.getHistoryById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(id, response.getBody().getId());
    }
}
