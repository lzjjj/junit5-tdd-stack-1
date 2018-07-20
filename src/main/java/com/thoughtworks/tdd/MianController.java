package com.thoughtworks.tdd;

public class MianController implements BaseController{
    private Response response;

    public MianController(Response response) {
        this.response = response;
    }

    @Override
    public String process() {
        response.send( "1.停车服务\n" +
                "2.停车场管理\n" +
                "请输入您要进入的页面：" );
        return "";
    }
}
