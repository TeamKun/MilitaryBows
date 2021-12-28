package net.kunmc.lab.militarybows.bow;

import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class AssaultBow extends BaseBow implements Listener {
  public AssaultBow(BowsMeta bowsMeta) {
    super(bowsMeta);
  }

  @EventHandler
  public void onEntityShootBow(EntityShootBowEvent event) {
    ItemStack bow = event.getBow();
    if (!isMatchBowName(bow)) {
      return;
    }

    int magazine = magazine(bow);

    if (magazine == 0) {
      event.setCancelled(true);
      return;
    }
    magazine = shoot(bow);

    if (magazine != 0) {
      return;
    }

  }
}