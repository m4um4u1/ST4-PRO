package dk.sdu.mmmi.semproject.OPC_Services;

import dk.sdu.mmmi.semproject.OPC_Common.CommandUA;
import dk.sdu.mmmi.semproject.OPC_Common.SetCommand;

public interface IOpcService {

    default void command(CommandUA ca, SetCommand sc) {

    }


}
