package task20;

import task20.commands.CommandActivate;
import task20.commands.CommandDeactivate;
import task20.commands.ICommand;

import java.util.ArrayList;
import java.util.List;

public class Kraftwerk {
    private List<IEnergyGeneration> blocks = new ArrayList<>();
    private List<ICommand> blockActivates = new ArrayList<>();
    private List<ICommand> blockDeactivates = new ArrayList<>();

    public Kraftwerk() {
        // da die Blocktypen sich nur in ihrer Bezeichnung und nicht ihrer Funktion unterscheiden,
        // muss man dafür auch keine unterschiedlichen Klassen anlegen
        blocks.add(new BlockAdapter("Wasser"));
        blocks.add(new BlockAdapter("Solar"));
        blocks.add(new BlockAdapter("Solar"));
        blocks.add(new BlockAdapter("Atom"));
        blocks.add(new BlockAdapter("Atom"));

        for (IEnergyGeneration b : blocks) {
            blockActivates.add(new CommandActivate(b));
            blockDeactivates.add(new CommandDeactivate(b));
        }

        blockActivates.get(0).execute();
        blockActivates.get(1).execute();
        blockActivates.get(3).execute();
        blocks.get(0).generateNormalizedEnergy();
    }
}
