package com.thoughtworks.tdd;

public class MianController {
    private Response response;

    public MianController(Response response) {
        this.response = response;
    }

    public void showStartMsg(){
        response.send( "1.停车服务\n" +
                "2.停车场管理\n" +
                "请输入您要进入的页面：" );
    }
    public void showInvalidMsg(){
        response.send( "非法指令，请查证后再输" );
    }
}
