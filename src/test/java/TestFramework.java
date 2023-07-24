import model.EventDao;
import model.FileModel;

import java.util.Collection;

public class TestFramework {
    public static EventDao getEvent(String name) {
        FileModel model = new FileModel();
        Collection<EventDao> events = model.getEvents();

        for(EventDao event: events) {
            if(event.getName().equals(name)) {
                return event;
            }
        }

        return null;
    }
}
