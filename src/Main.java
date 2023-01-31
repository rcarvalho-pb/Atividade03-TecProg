import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Main {
  public static void main(String[] args) {
    Locale localeBR = new Locale("pt", "BR");
    Locale.setDefault(localeBR);
    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    var data = LocalDate.parse("28/01/2023", df);
    int mesesVacina = 3;

    LocalDate now = LocalDate.now();

    java.time.DayOfWeek dayOfWeek = now.getDayOfWeek();
    System.out.println(dayOfWeek);
    System.out.println(Locale.getDefault());

    System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()));
    // System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("pt","BR" )));

    // for (int i = 0; i < mesesVacina; i++) {
    //   System.out.println("%sª Dose: %s - %s.".formatted(i+1, isWeekend(data.plusMonths(i*3)).format(df), isWeekend(data.plusMonths(i*3)).getDayOfWeek()));
    // }

  }

  public static LocalDate isWeekend(LocalDate data){
    if (data.getDayOfWeek() == DayOfWeek.SATURDAY) return data.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
    if (data.getDayOfWeek() == DayOfWeek.SUNDAY) return data.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    return data;
  }

  // public static String diaDaSemana(LocalDate data) {
  //   switch(data.getDayOfWeek()){
  //     case DayOfWeek.MONDAY -> return "Segunda";
  //     default -> throw new IllegalArgumentException("Unexpected value: " + data.getDayOfWeek());
      
  //   }
  // }
}
