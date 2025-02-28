package model;

import java.util.Objects;

public class Student {

    private final String name;

    private final StudentAttendanceHistory studentAttendanceHistory;

    public Student(String name, StudentAttendanceHistory studentAttendanceHistory) {
        this.name = name;
        this.studentAttendanceHistory = studentAttendanceHistory;
    }

    public boolean isSameName(String studentName) {
        return studentName.equals(name);
    }

    public void addTime(AttendanceDateTime attendanceDateTime) {
        studentAttendanceHistory.addTime(attendanceDateTime);
    }

    public AttendanceDateTime findSameDay(AttendanceDateTime wantToFindLocalDateTime) {
        return studentAttendanceHistory.findSameDay(wantToFindLocalDateTime);
    }

    public void modifyRecord(AttendanceDateTime wantToModifyLocalDateTime) {
        studentAttendanceHistory.modifyRecord(wantToModifyLocalDateTime);
    }

    public void updateNoInformationInFile(AttendanceDateTime todayDate) {
        studentAttendanceHistory.fillMissingAttendanceRecords(todayDate);
    }

    public void validateAlreadyAttendanceDate(TodayDate todayDate) {
        if (studentAttendanceHistory.isAlreadyAttendanceDate(todayDate)) {
            throw new IllegalArgumentException("[ERROR] 이미 출석한 요일입니다. 수정하고 싶으시면 수정 메뉴를 이용해 주세요.");
        }
    }

    public void sortStudentAttendanceHistory() {
        studentAttendanceHistory.sortHistoryBeforePrint();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return Objects.equals(name, that.name);
    }

    public String getName() {
        return name;
    }

    public StudentAttendanceHistory getStudentAttendanceHistory() {
        return studentAttendanceHistory;
    }
}