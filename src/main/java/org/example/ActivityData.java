package org.example;

public class ActivityData {

    private String login;
    private String repo_url;

    public void showData(){
        System.out.println("A ultima acao do usuario: " + login + " foi no repositorio: " + repo_url);
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setURL(String url){
        this.repo_url = url;
    }
}
