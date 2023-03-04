package Commands.myCommands;

import Classes.Colors;
import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

public class UpdateIdCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            Long id = Long.parseLong(CommandEater.getSplit()[1]);
            if (!HumanBeingCollection.getHumanBeings().isEmpty()) {
                for (HumanBeing humanBeing : HumanBeingCollection.getHumanBeings()) {
                    if (humanBeing.getId().equals(id)) {
                       //бла-бла-бла
                        System.out.printf(Colors.WHITE + "   !!!АБОБА!!!   \n" + Colors.BLUE + "   !!!АБОБА!!!   \n" + Colors.RED + "   !!!АБОБА!!!   \n" + Colors.RESET);
                    }
                }
            }
        }
    }
}
