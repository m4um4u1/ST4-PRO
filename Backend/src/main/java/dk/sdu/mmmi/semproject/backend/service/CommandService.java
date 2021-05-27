package dk.sdu.mmmi.semproject.backend.service;

import dk.sdu.mmmi.semproject.backend.component.UaHandler;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    public void setCntrlCmd(int Commandval) {
        NodeId cntrlCommand = new NodeId(6, "::Program:Cube.Command.CntrlCmd");
        UaHandler.client.writeValue(cntrlCommand, DataValue.valueOnly(new Variant(Commandval)));
    }

    public void setCCR(boolean CmdChangeReq) {
        NodeId cmdChangeReq = new NodeId(6, "::Program:Cube.Command.CmdChangeRequest");
        UaHandler.client.writeValue(cmdChangeReq, DataValue.valueOnly(new Variant(CmdChangeReq)));
    }
}
