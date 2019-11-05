package hello;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;
import net.fortuna.ical4j.validate.ValidationException;

@RestController
public class GreetingController {

    @RequestMapping("/get_month")
    public Object greeting(@RequestParam(value="month", defaultValue="default") String parameter) throws ValidationException, IOException {
    	


    	net.fortuna.ical4j.model.Calendar cal = new net.fortuna.ical4j.model.Calendar();
    	
    	FileOutputStream fout = new FileOutputStream("mycalendar.ics");

    	CalendarOutputter outputter = new CalendarOutputter();
    	outputter.output(cal, fout);
    	String contents = new String(Files.readAllBytes(Paths.get("mycalendar.ics")));
    	return contents;
    	
    }
}
