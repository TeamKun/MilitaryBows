package net.kunmc.lab.militarybows.config;

import net.kunmc.lab.configlib.config.BaseConfig;
import net.kunmc.lab.configlib.value.IntegerValue;
import net.kunmc.lab.configlib.value.StringValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class AssaultConfig extends BaseConfig {
  public StringValue name = new StringValue("AssaultBow");
  public IntegerValue magazineCapacity = new IntegerValue(30);

  public AssaultConfig(@NotNull Plugin plugin) {
    super(plugin, "assault");
  }
}
