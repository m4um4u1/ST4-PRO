package com.example.opc_control;

import dk.sdu.mmmi.semproject.OPC_Common.CommandUA;
import dk.sdu.mmmi.semproject.OPC_Common.SetCommand;
import dk.sdu.mmmi.semproject.OPC_Services.IOpcService;

public class OPC_Control_Commands implements IOpcService {




SetCommand sc;

    @Override
    public void command(CommandUA ca, SetCommand sc) {
        this.sc = sc;

    }

    public void start() {
        sc.setCntrlCmd(2);
        sc.setCCR(true);
    }


    public void stop() {
        sc.setCntrlCmd(3);
        sc.setCCR(true);
    }

    public void reset() {
        sc.setCntrlCmd(1);
        sc.setCCR(true);
    }

    public void abort() {
        sc.setCntrlCmd(4);
        sc.setCCR(true);
    }

    public void clear() {
        sc.setCntrlCmd(5);
        sc.setCCR(true);
    }

    public void setSpeed(float msVal) {
        sc.setMachSpeed(msVal);
    }

    public void setProductType(float ptVal) {
        sc.setProductType(ptVal);
    }

    public void setBatchID(float btVal) {
        sc.setBatchID(btVal);
    }

    public void setProductQuantity(float pqVal) {
        sc.setProductAmount(pqVal);
    }


}




