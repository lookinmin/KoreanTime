package com.example.koreantime;

class tmpClass {
    String groupName;
    String groupDate;
    String groupPeople;

    tmpClass(String name, String date, String people) {
        this.groupName = name;
        this.groupDate = date;
        this.groupPeople = people;
    }

    public String getGroupDate() {
        return groupDate;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupPeople() {
        return groupPeople;
    }

}
