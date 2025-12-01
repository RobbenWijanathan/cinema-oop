package repository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import model.Schedule;
import model.Studio;

public interface ScheduleRepository {
	public List<Schedule> getSchedules() throws SQLException;
	public Schedule getScheduleById(String id) throws SQLException;
	public List<Schedule> getScheduleByStudioId(String studioId) throws SQLException;
	public boolean createSchedule(Date time, String studioId) throws SQLException;
	public boolean updateSchedule(String id, Date time, String studioId) throws SQLException;
	public boolean deleteSchedule(String id) throws SQLException;
}
