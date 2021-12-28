package net.kunmc.lab.militarybows.command;

import dev.kotx.flylib.command.Command;
import java.util.List;
import net.kunmc.lab.configlib.command.ConfigCommand;
import org.jetbrains.annotations.NotNull;

public class Main extends Command {

  public Main(@NotNull CommandEnum commandEnum, List<ConfigCommand> configCommandList) {
    super(commandEnum.name().toLowerCase());
    children(new Give(CommandEnum.GIVE));

    for (ConfigCommand configCommand : configCommandList) {
      children(configCommand);
    }
  }
}
