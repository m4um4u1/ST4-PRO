package dk.sdu.mmmi.semproject.backend.service;

import dk.sdu.mmmi.semproject.backend.component.UaHandler;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    private int state;

    public int getState() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Cube.Status.StateCurrent");
            DataValue dataValue = UaHandler.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            state = Integer.parseUnsignedInt(String.valueOf(variant.getValue()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return state;
    }
}
