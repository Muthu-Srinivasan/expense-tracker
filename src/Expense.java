import java.time.LocalDate;
import java.math.BigDecimal;
public record Expense(int id, BigDecimal amount, String category, LocalDate date){}
