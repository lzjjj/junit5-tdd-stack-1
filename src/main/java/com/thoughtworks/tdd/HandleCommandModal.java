package com.thoughtworks.tdd;

public class HandleCommandModal {
    private  String commandStr;

    public HandleCommandModal(String commandStr) {
        this.commandStr = commandStr;
    }



    public  String bulidResult() {
        if (commandStr.equals( "1" )){
            return "停车";
        }
        if (commandStr.equals("2")){
            return "取车";
        }
        return "非法指令，请查证后再输";
    }
}
