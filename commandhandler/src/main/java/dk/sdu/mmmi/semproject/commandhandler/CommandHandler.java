package dk.sdu.mmmi.semproject.commandhandler;


public class CommandHandler{

    SetCommand sc = new SetCommand();

    public void start() {
        sc.setProductAmount(10);
        sc.setBatchID(200); // testing purposes
        sc.setCntrlCmd(2);
        sc.setCCR(true);
        System.out.println("Started!");
    }

    public void stop() {
        sc.setCntrlCmd(3);
        sc.setCCR(true);
        System.out.println("Stopped!");
    }

    public void reset() {
        sc.setCntrlCmd(1);
        sc.setCCR(true);
    }

    public void abort() {
        sc.setCntrlCmd(4);
        sc.setCCR(true);
        System.out.println("Aborted!");
    }

    public void clear() {
        sc.setCntrlCmd(5);
        sc.setCCR(true);
        System.out.println("Cleared");
    }

}
