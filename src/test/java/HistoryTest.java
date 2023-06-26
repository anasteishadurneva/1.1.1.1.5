
import com.bank.history.Entity.History;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith( MockitoExtension.class )
public class HistoryTest {
    @Test
    public void testHistory() {
// Создаем объект History для тестирования
        History history = new History();

// Устанавливаем значения свойств объекта
        history.setTransfer_audit_id(1L);
        history.setProfile_audit_id(2L);
        history.setAccount_audit_id(3L);
        history.setAnti_fraud_audit_id(4L);
        history.setPublic_bank_audit_id(5L);
        history.setAuthorization_id(6L);

// Проверяем, что значения свойств установлены корректно
        assertEquals(1, history.getTransfer_audit_id());
        assertEquals(2, history.getProfile_audit_id());
        assertEquals(3, history.getAccount_audit_id());
        assertEquals(4, history.getAnti_fraud_audit_id());
        assertEquals(5, history.getPublic_bank_audit_id());
        assertEquals(6, history.getAuthorization_id());
    }
}

