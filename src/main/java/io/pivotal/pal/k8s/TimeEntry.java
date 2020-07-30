package io.pivotal.pal.k8s;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TimeEntry {

    public TimeEntry () {
        id = counter++;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this(counter++, projectId, userId, date, hours);
    }

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;
    private static long counter = 1;
}
