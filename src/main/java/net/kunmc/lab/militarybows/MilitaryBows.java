package net.kunmc.lab.militarybows;

import dev.kotx.flylib.FlyLib;
import net.kunmc.lab.configlib.config.BaseConfig;
import net.kunmc.lab.militarybows.bow.AssaultBow;
import net.kunmc.lab.militarybows.bow.BowsMeta;
import net.kunmc.lab.militarybows.command.CommandEnum;
import net.kunmc.lab.militarybows.command.Main;
import net.kunmc.lab.militarybows.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MilitaryBows extends JavaPlugin {

  public static MilitaryBows plugin;
  public static ConfigManager configManager;

  @Override
  public void onEnable() {
    plugin = this;
    configManager = new ConfigManager(plugin);

    FlyLib.create(this, builder -> {
        builder.command(new Main(CommandEnum.MBOWS, configManager.configCommandList()));
    });

    getServer().getPluginManager().registerEvents(new AssaultBow(BowsMeta.ASSAULT), this);
  }
}
