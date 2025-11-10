package org.Aston_study.Lesson_6.task_2;

import java.util.*;

public class PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        this.directory = new HashMap<>();
    }

    public List<String> get(String lastName) {
        List<String> phones = directory.get(lastName);
        if (phones == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(phones);
    }

    public void add(String lastName, String phoneNumber) {
        if (!directory.containsKey(lastName)) {
            directory.put(lastName, new ArrayList<>());
        }
        directory.get(lastName).add(phoneNumber);
    }
}
