import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Main {
  public static final int index = 1;
  public static final String mensagem = "%sª Dose - Data: %s - %s.";
  public static void main(String[] args) {

    Locale localeBR = new Locale("pt", "BR");
    Locale.setDefault(localeBR);
    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    var data = LocalDate.parse("29/01/2023", df);
    int mesesVacina = 3;

    for (int i = index; i < (mesesVacina + index); i++) {
      int parametroParaFuncaoFimDeSemana = (i - index) * 3;
      System.out.println(mensagem.formatted((i), eFimDeSemana(data.plusMonths(parametroParaFuncaoFimDeSemana)).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()), eFimDeSemana(data.plusMonths(parametroParaFuncaoFimDeSemana)).format(df)));
    }

  }

  public static LocalDate eFimDeSemana(LocalDate data){
    if (data.getDayOfWeek() == DayOfWeek.SATURDAY) return data.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
    if (data.getDayOfWeek() == DayOfWeek.SUNDAY) return data.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    return data;
  }

  
}
