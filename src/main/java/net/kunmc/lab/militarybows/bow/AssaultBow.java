package net.kunmc.lab.militarybows.bow;

import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class AssaultBow implements Listener {
  private BowsMeta bowsMeta;

  public AssaultBow(BowsMeta bowsMeta) {
    this.bowsMeta = bowsMeta;
  }

  @EventHandler
  public void onEntityShootBow(EntityShootBowEvent event) {

    ItemStack bow = event.getBow();
    bow.getItemMeta().displayName();

    TextComponent textComponent = (TextComponent) bow.getItemMeta().displayName();

    if (textComponent.content().equals(this.bowsMeta.bowName())) {
      return;
    }

    TextComponent component = (TextComponent) bow.lore().get(0);
    int magazine = Integer.parseInt(component.content());

    List<Component> lore = new ArrayList<>();
    lore.add(Component.text(magazine - 1));
    bow.lore(lore);
  }
}