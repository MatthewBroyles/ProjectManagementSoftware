package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate dueDate;
    private List<Employee> teamMembers = new ArrayList<Employee>();

    public Project(String name, String description, int daysTillStart, int daysToDo) {
        this.name = name;
        this.description = description;
        this.startDate = LocalDate.now().plusDays(daysTillStart);
        this.dueDate = LocalDate.now().plusDays(daysTillStart + daysToDo);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
