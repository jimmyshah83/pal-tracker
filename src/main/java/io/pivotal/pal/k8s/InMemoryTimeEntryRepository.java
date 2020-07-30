package io.pivotal.pal.k8s;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntries;
    private long counter = 1;

    public InMemoryTimeEntryRepository() {
        timeEntries = new HashMap<>();
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(counter++);
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return timeEntries.get(timeEntryId);
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry timeEntry) {
        if (!timeEntries.containsKey(timeEntryId)) {
            return null;
        }
        timeEntry.setId(timeEntryId);
        timeEntries.put(timeEntryId, timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(long timeEntryId) {
        timeEntries.remove(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return timeEntries.values().stream().collect(Collectors.toList());
    }
}
