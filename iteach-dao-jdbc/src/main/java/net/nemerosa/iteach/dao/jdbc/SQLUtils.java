package net.nemerosa.iteach.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public final class SQLUtils {

    private SQLUtils() {
    }

    public static ZonedDateTime now() {
        return ZonedDateTime.now();
    }

    public static Timestamp toTimestamp(ZonedDateTime dateTime) {
        return new Timestamp(dateTime.toInstant().getEpochSecond() * 1000L);
    }

    public static <E extends Enum<E>> E getEnum(Class<E> enumClass, ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if (value == null) {
            return null;
        } else {
            return Enum.valueOf(enumClass, value);
        }
    }

    public static ZonedDateTime fromTimestamp(ResultSet rs, String column) throws SQLException {
        Timestamp timestamp = rs.getTimestamp(column);
        return getDateTime(timestamp);
    }

    public static ZonedDateTime getDateTime(Timestamp timestamp) {
        return timestamp != null ? ZonedDateTime.ofInstant(Instant.ofEpochMilli(timestamp.getTime()), ZoneOffset.UTC) : null;
    }
}