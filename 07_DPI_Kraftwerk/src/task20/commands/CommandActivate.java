package task20.commands;

import task20.IEnergyGeneration;

public class CommandActivate implements ICommand {
    private IEnergyGeneration block;

    public CommandActivate(IEnergyGeneration b) {
        this.block = b;
    }

    @Override
    public void execute() {
        block.activate();
    }
}
