package com.practice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum School {
    CONVENT("convent"),
    DPS("dps"),
    INVALID("invalid");
    private String schoolName;

    private School(String schoolName) {
        this.schoolName = schoolName;
    }

    @JsonCreator
    static School fromValue(String schoolName) throws Exception {
        for (School s : School.values()) {
            if (s.getSchoolName().equals(schoolName))
                return s;
        }
        return School.INVALID;
    }
}
