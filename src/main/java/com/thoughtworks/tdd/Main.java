package com.thoughtworks.tdd;

public class Main {
        public static void main(String[] args) throws Exception {
        System.out.print("1. 停车\n" +
                "2. 取车 \n" +
                "请输入您要进行的操作：");
        ScannerStr scannerStr = new ScannerStr();
        HandleCommandModal handleCommandModal = new HandleCommandModal( scannerStr.getStr() );
        System.out.print( handleCommandModal.bulidResult() );

    }
}
