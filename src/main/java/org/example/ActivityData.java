package org.example;

public class ActivityData {

    private String login;
    private String repo_url;
    private String date;

    public void showData(){
        System.out.println("The last activity from user: " + login + " was at repository: " + repo_url + " at "+ date);
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setURL(String url){
        this.repo_url = url;
    }

    public void setDate(String date){
        this.date = date;
    }
}
