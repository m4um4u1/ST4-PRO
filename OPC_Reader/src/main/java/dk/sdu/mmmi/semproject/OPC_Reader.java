package dk.sdu.mmmi.semproject;

import dk.sdu.mmmi.semproject.OPC_Common.CommandUA;
import dk.sdu.mmmi.semproject.OPC_Common.GetCommand;
import dk.sdu.mmmi.semproject.OPC_Services.IReadService;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OPC_Reader implements IReadService {


    private int maintenance;
    private float barley;
    private float hops;
    private float malt;
    private float wheat;
    private float yeast;

    CommandUA ca;
    GetCommand gc;

    @Override
    public void command(CommandUA ca, GetCommand gc) {
        this.ca = ca;
        this.gc = gc;
    }

    @GetMapping("http://127.0.0.1/api/get/mtData")
    public int getMaintenance() {
        try {
            NodeId nodeId = new NodeId(6, "::Program:Maintenance.Counter");
            DataValue dataValue = ca.client.readValue(0, TimestampsToReturn.Both, nodeId).get();
            Variant variant = dataValue.getValue();
            maintenance = Integer.parseUnsignedInt(String.valueOf(variant.getValue()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return maintenance;
    }

    @GetMapping("http://127.0.0.1/api/get/IngData")
    public JSONObject getIngredients() {
        barley = gc.getBarley();
        yeast = gc.getYeast();
        wheat = gc.getWheat();
        hops = gc.getHops();
        malt = gc.getMalt();
        JSONObject ingredients = new JSONObject();
        try {
            ingredients.put("barley", barley);
            ingredients.put("yeast", yeast);
            ingredients.put("wheat", wheat);
            ingredients.put("hops", hops);
            ingredients.put("malt", malt);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    @GetMapping("http://127.0.0.1/api/get/liveData")
    public JSONObject getLive() {
        JSONObject live = new JSONObject();
        try {
            live.put("batchid", gc.getBatchID());
            live.put("produced", gc.getProduced());
            live.put("accepted", gc.getAccepted());
            live.put("defective", gc.getDefective());
            live.put("machSpeed", gc.getMachSpeed());
            live.put("productType", gc.getProductType());
            live.put("amount", gc.getAmount());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return live;
    }
}
