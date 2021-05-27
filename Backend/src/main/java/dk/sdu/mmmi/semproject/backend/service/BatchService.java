package dk.sdu.mmmi.semproject.backend.service;

import dk.sdu.mmmi.semproject.backend.component.UaHandler;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.springframework.stereotype.Service;

@Service
public class BatchService {

    public void setBatchID(float batchIDval) {
        NodeId batchID = new NodeId(6, "::Program:Cube.Command.Parameter[0].Value");
        UaHandler.client.writeValue(batchID, DataValue.valueOnly(new Variant(batchIDval)));
    }

    public void setMachSpeed(float MachSpeedval) {
        NodeId machSpeed = new NodeId(6, "::Program:Cube.Command.MachSpeed");
        UaHandler.client.writeValue(machSpeed, DataValue.valueOnly(new Variant(MachSpeedval)));
    }

    public void setProductAmount(float PrdctAmountval) {
        NodeId prdctAmount = new NodeId(6, "::Program:Cube.Command.Parameter[2].Value");
        UaHandler.client.writeValue(prdctAmount, DataValue.valueOnly(new Variant(PrdctAmountval)));
    }

    public void setProductType(float PrdctTypeval) {
        NodeId productType = new NodeId(6, "::Program:Cube.Command.Parameter[1].Value");
        UaHandler.client.writeValue(productType, DataValue.valueOnly(new Variant(PrdctTypeval)));
    }

}
