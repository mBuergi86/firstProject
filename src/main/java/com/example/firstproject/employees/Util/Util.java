package com.example.firstproject.employees.Util;

import com.example.firstproject.employees.Model.Employees;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;

public class Util {
    private static final Logger logger = LoggerFactory.getLogger(Util.class);
    public void UpdateFields(Employees employee, Map<String, Object> changes) {
        for (Map.Entry<String, Object> entry : changes.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();

            // Verwenden Sie Reflektion, um das entsprechende Feld zu aktualisieren
            try {
                Field field = Employees.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(employee, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Hier sollten Sie entsprechende Fehlerbehandlung hinzufügen
                logger.error("An error occurred while processing the request", e);
            }
        }
    }
}
