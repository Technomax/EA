import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class BillingServiceImpl implements BillingService {

    @Scheduled(cron="0/7 * * * * *")
    public void printBills() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        String currenttime = timeFormatter.format(date);
        System.out.println(currenttime + "    printing bills");
    }

    @Override
    @Scheduled(cron="0/10 * * * * *")
    public void generateBillingReport() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        String currenttime = timeFormatter.format(date);
        System.out.println(currenttime + "    generating billing report");
    }

}
