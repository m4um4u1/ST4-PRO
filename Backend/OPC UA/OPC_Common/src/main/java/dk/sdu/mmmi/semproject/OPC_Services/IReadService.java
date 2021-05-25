package dk.sdu.mmmi.semproject.OPC_Services;

import dk.sdu.mmmi.semproject.OPC_Common.CommandUA;
import dk.sdu.mmmi.semproject.OPC_Common.GetCommand;

public interface IReadService {

    default void command(CommandUA ca, GetCommand gc) {

    }
}
