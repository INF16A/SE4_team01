package task20.commands;

import task20.IEnergyGenerationStrategy;

public class CommandDeactivate implements ICommand {
    private IEnergyGenerationStrategy block;

    public CommandDeactivate(IEnergyGenerationStrategy b) {
        this.block = b;
    }

    @Override
    public void execute() {
        block.deactivate();
    }
}
