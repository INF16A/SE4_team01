package task20;

import task20.commands.CommandActivate;
import task20.commands.CommandDeactivate;
import task20.commands.ICommand;

import java.util.ArrayList;
import java.util.List;

class PowerPlant {
    private List<IEnergyGenerationStrategy> blocks = new ArrayList<>();
    private List<ICommand> blockActivates = new ArrayList<>();
    private List<ICommand> blockDeactivates = new ArrayList<>();

    PowerPlant(EnergyCollectionPoint energyCollectionPoint) {
        // da die Blocktypen sich nur in ihrer Bezeichnung und nicht ihrer Funktion unterscheiden,
        // muss man dafür auch keine unterschiedlichen Klassen anlegen
        blocks.add(new BlockAdapter("Wasser", energyCollectionPoint));
        blocks.add(new BlockAdapter("Solar", energyCollectionPoint));
        blocks.add(new BlockAdapter("Solar", energyCollectionPoint));
        blocks.add(new BlockAdapter("Atom", energyCollectionPoint));
        blocks.add(new BlockAdapter("Atom", energyCollectionPoint));

        for (IEnergyGenerationStrategy b : blocks) {
            blockActivates.add(new CommandActivate(b));
            blockDeactivates.add(new CommandDeactivate(b));
        }
    }

    void activateBlock(int blockId) {
        blockActivates.get(blockId).execute();
    }

    void deactivateBlock(int blockId) {
        blockDeactivates.get(blockId).execute();
    }

    void tick() {
        for (IEnergyGenerationStrategy block : blocks) {
            if (block.isActivated()) {
                block.generateNormalizedEnergy();
            }
        }
    }
}
