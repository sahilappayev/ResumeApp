package com.mycompany.resume.config;

public class Config {
    private static Config config;
    private String username;
    private String password;

    public Config() {
    }

    private Config(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Config createConfig(){
        if(config == null){
         config = new Config();
        }
        return config;
    }

    public static Config createConfig(String username, String password){
        if(config == null){
            config = new Config(username, password);
        }
        return config;
    }
}
