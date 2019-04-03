package models;

import java.util.List;

public class Logger {

    private Long id;
    private List<Log> logs;

    public Logger(Long id, List<Log> logs) {
        this.id = id;
        this.logs = logs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    @Override
    public String toString() {
        return "Logger{" +
                "id=" + id +
                ", logs=" + logs +
                '}';
    }
}
