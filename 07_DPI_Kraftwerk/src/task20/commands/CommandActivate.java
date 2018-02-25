package task20.commands;

import task20.IEnergyGenerationStrategy;

public class CommandActivate implements ICommand {
    private IEnergyGenerationStrategy block;

    public CommandActivate(IEnergyGenerationStrategy b) {
        this.block = b;
    }

    @Override
    public void execute() {
        block.activate();
    }
}
