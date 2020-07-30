package io.pivotal.pal.k8s;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry create (TimeEntry timeEntry);
    TimeEntry find (long timeEntryId);
    TimeEntry update (long timeEntryId, TimeEntry timeEntry);
    void delete (long timeEntryId);
    List<TimeEntry> list();
}
