package com.restesting.restesting.setupTools;


import java.util.HashMap;
import java.util.Map;

public class GlobalSetup {



    private  Map<String,String> globalParams;
    private static GlobalSetup instace;

    private GlobalSetup() {
        this.globalParams= new HashMap<>();
    }


    public static GlobalSetup getInstace(){
        if(instace==null){
            instace= new GlobalSetup();
        }
        return instace;
    }




    public void addParameter(String key,String value){
        globalParams.put(key,value);
    }

    public String getParameter(String key){
        return globalParams.get(key);
    }




}
