package com.example.opc_control;

import dk.sdu.mmmi.semproject.OPC_Common.CommandUA;
import dk.sdu.mmmi.semproject.OPC_Common.SetCommand;
import dk.sdu.mmmi.semproject.OPC_Services.IOpcService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OPC_Control_Commands implements IOpcService {

    SetCommand sc;

    @Override
    public void command(CommandUA ca, SetCommand sc) {
        this.sc = sc;
    }

    @PostMapping("http://127.0.0.1/api/command")
    public void commandOPC(@RequestBody Integer i) {
// Valid input: 1-5 | Reset 1 | Start 2 | Stop 3 | Abort 4 | Clear 5|
        sc.setCntrlCmd(i);

        sc.setCCR(true);
    }

    @PostMapping("INSERT MAPPING")
    public void createBatch(@RequestBody float batchId, float productType, float machineSpeed, float productAmount) {

// Dependent on product ID | 0: 0 ≤ Value ≤ 600 | 1: 0 ≤ Value ≤ 300 | 2: 0 ≤ Value ≤ 150 | 3: 0 ≤ Value ≤ 200 | 4: 0 ≤ Value ≤ 100 | 5: 0 ≤ Value ≤ 125|
        sc.setMachSpeed(machineSpeed);

// Valid input: 0-5 | Pilsner 0 | Wheat 1 |  IPA 2 | Stout 3 | Ale 4 | Alcohol Free 5|
        sc.setProductType(productType);

// Corresponds with the Batch ID in the database
        sc.setBatchID(batchId);

// Valid input: 0≤65535
        sc.setProductAmount(productAmount);
    }
}




