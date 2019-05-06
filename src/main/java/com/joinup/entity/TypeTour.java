package com.joinup.entity;

public enum TypeTour {
    CRUISE("cruise"), SHOPPING("shopping"), RELAX("relax"), THERAPY("therapy"), EXCURSION("excursion");
    private String title;

    TypeTour(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
