package com.birthday.service;

import com.birthday.util.FileReadUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayService {
    public List<String> findBirthDaysPersons() {
        List<String> personList = new ArrayList<>();
        personList = FileReadUtil.getFileLineList("C:\\Users\\Administrator.PC-20170908VIYI\\IdeaProjects\\Condee\\src\\main\\resources\\employee_records.txt");

        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd"));

        List<String> birthDayPersonList = personList.stream().filter((item) -> {
            return item.contains(today);
        }).collect(Collectors.toList());

        return birthDayPersonList;
    }

    public void blessBirthDay() {
        List<String> birthDaysPersons = findBirthDaysPersons();
        List<String> collect = birthDaysPersons.stream().peek((item) -> {
            System.out.println("Happy birthday, Dear " + item.split(",")[1]);
        }).collect(Collectors.toList());
    }
}
