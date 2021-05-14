package dk.sdu.mmmi.semproject.commandhandler;

import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;

public class SetCommand {

    public static void setBatchID(float batchIDval) {
        NodeId batchID = new NodeId(6, "::Program:Cube.Command.Parameter[0].Value");
        CommandUA.client.writeValue(batchID, DataValue.valueOnly(new Variant(batchIDval)));
    }

    public void setMachSpeed(float MachSpeedval) {
        NodeId machSpeed = new NodeId(6, "::Program:Cube.Command.MachSpeed");
        CommandUA.client.writeValue(machSpeed, DataValue.valueOnly(new Variant(MachSpeedval)));
    }

    public void setProductAmount(float PrdctAmountval) {
        NodeId prdctAmount = new NodeId(6, "::Program:Cube.Command.Parameter[2].Value");
        CommandUA.client.writeValue(prdctAmount, DataValue.valueOnly(new Variant(PrdctAmountval)));
    }

    public void setProductType(float PrdctTypeval) {
        NodeId productType = new NodeId(6, "::Program:Cube.Command.Parameter[1].Value");
        CommandUA.client.writeValue(productType, DataValue.valueOnly(new Variant(PrdctTypeval)));
    }

    public void setCntrlCmd(int Commandval) {
        NodeId cntrlCommand = new NodeId(6, "::Program:Cube.Command.CntrlCmd");
        CommandUA.client.writeValue(cntrlCommand, DataValue.valueOnly(new Variant(Commandval)));
    }

    public void setCCR(boolean CmdChangeReq) {
        NodeId cmdChangeReq = new NodeId(6, "::Program:Cube.Command.CmdChangeRequest");
        CommandUA.client.writeValue(cmdChangeReq, DataValue.valueOnly(new Variant(CmdChangeReq)));
    }

}
