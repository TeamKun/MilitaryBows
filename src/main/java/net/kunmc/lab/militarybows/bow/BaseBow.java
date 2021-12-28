package net.kunmc.lab.militarybows.bow;

import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.inventory.ItemStack;

public abstract class BaseBow {
  private BowsMeta bowsMeta;

  public BaseBow(BowsMeta bowsMeta) {
    this.bowsMeta = bowsMeta;
  }

  protected boolean isMatchBowName(ItemStack bow) {
    TextComponent textComponent = (TextComponent) bow.getItemMeta().displayName();
    return textComponent.content().equals(this.bowsMeta.bowName());
  }

  protected int magazine(ItemStack bow) {
    TextComponent component = (TextComponent) bow.lore().get(0);
    return Integer.parseInt(component.content());
  }

  protected int shoot(ItemStack bow) {
    int magazine = magazine(bow) - 1;
    List<Component> lore = new ArrayList<>();
    lore.add(Component.text(magazine));
    bow.lore(lore);
    return magazine;
  }
}
