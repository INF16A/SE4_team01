package task20.commands;

import task20.IEnergyGeneration;

public class CommandDeactivate implements ICommand {
    private IEnergyGeneration block;

    public CommandDeactivate(IEnergyGeneration b) {
        this.block = b;
    }

    @Override
    public void execute() {
        block.deactivate();
    }
}
