package net.kunmc.lab.militarybows.config;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import net.kunmc.lab.configlib.command.ConfigCommand;
import net.kunmc.lab.configlib.command.ConfigCommandBuilder;
import net.kunmc.lab.configlib.config.BaseConfig;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ConfigManager {
  private AssaultConfig assaultConfig;

  public ConfigManager(@NotNull Plugin plugin) {
    this.assaultConfig = new AssaultConfig(plugin);
  }

  public AssaultConfig assaultConfig() {
    return this.assaultConfig;
  }

  public List<ConfigCommand> configCommandList() {
    List<ConfigCommand> configManagerList = new ArrayList<>();
    try {
      for (Field field : ConfigManager.class.getDeclaredFields()) {
        Object config = field.get(this);
        if (config instanceof BaseConfig) {
          configManagerList.add(new ConfigCommandBuilder((BaseConfig) config).build());
        }
      }
    } catch (IllegalAccessException e) {
    }
    return configManagerList;
  }
}
